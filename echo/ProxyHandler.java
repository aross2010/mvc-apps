package echo;

import java.net.Socket;

public class ProxyHandler extends RequestHandler {

    protected Correspondent peer;

    public ProxyHandler(Socket s) { super(s); }
    public ProxyHandler() { super();}

    // set up peer
    public void initPeer(String host, int port) {
        peer = new Correspondent();
        peer.requestConnection(host, port);
    }

    public void shutDown() {
        super.shutDown(); // sets active to false, etc.
        peer.send("quit");
    }

    @Override
    protected String response(String request) throws Exception {
        // forward the request to the peer
        peer.send(request);
        // recieve the response back from the peer
        String response = peer.receive();
        if (response.equals("quit")) { super.shutDown(); }
        return response;
    }

}
