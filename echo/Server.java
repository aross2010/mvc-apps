package echo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // Client -> Security Proxy -> Cache Proxy (if cache it, send back in chain) -> Server -> Math Handler
    // Security proxy is the first proxy to recieve request. It can control if the request goes down the chain
    // Cache Proxy recieves the request after security proxy. It just checks if the request is in the cache.
    // If the request is in the cache, it can relay the response of the request back up the chain. If it's not
    // in the cache, it sends the request down to the server. The server creates a handler (based on the service)
    // that then handles the request, sending the response up the chain back to the Simple Client.

    protected ServerSocket mySocket;
    protected int myPort;
    public static boolean DEBUG = true;
    protected Class<?> handlerType;

    public Server(int port, String handlerType) {
        try {
            myPort = port;
            mySocket = new ServerSocket(myPort);
            this.handlerType = (Class.forName(handlerType));
        } catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }


    public void listen() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Server listing on port " + myPort + "...");
        while(true) {
            Socket socket = mySocket.accept();
            if (socket != null) {
                System.out.println("New client connected: " + socket);
                Thread clientThread = new Thread(() -> {
                    try {
                        RequestHandler handler = makeHandler(socket);
                        handler.run();
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                });
                clientThread.start();
            }

        }
    }

    public RequestHandler makeHandler(Socket s) throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        try {
            RequestHandler handler = (RequestHandler)handlerType.getDeclaredConstructor().newInstance();
            handler.setSocket(s);
            return handler;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int port = 6000;
        String service = "echo_math.MathHandler";
        if (1 <= args.length) {
            service = args[0];
        }
        if (2 <= args.length) {
            port = Integer.parseInt(args[1]);
        }
        System.out.println("Service: " + service);
        Server server = new Server(port, service);
        server.listen();
    }
}

// run configurrations in simple client allow multiple instances