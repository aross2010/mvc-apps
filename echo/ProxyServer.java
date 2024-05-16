package echo;

import java.io.IOException;
import java.net.Socket;

public class ProxyServer extends Server {

    String peerHost;
    int peerPort;

    public ProxyServer(int myPort, String service, int peerPort, String peerHost) {
        super(myPort,service);
        this.peerHost = peerHost;
        this.peerPort = peerPort;
    }

    public RequestHandler makeHandler(Socket s) throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        // make a proxy handler and call initPeer w/ peer host and peer port
        RequestHandler handler = super.makeHandler(s);
        ((ProxyHandler)handler).initPeer(peerHost, peerPort);
        return handler;
    }

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int port = 6001;
        int peerPort = 6000;
        String peerHost = "localhost";
        String service = "echo.HitCount";

        if (1 <= args.length) {
            service = args[0];
        }
        if (2 <= args.length) {
            peerPort = Integer.parseInt(args[1]);
        }
        if (3 <= args.length) {
            port = Integer.parseInt(args[2]);
        }
        if (4 <= args.length) {
            peerHost = args[3];
        }
        Server server = new ProxyServer(port, service, peerPort, peerHost);
        server.listen();

    }

}

// For the second instance -> echo.SecurityProxy 6001 6002
