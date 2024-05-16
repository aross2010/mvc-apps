package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Correspondent {
    protected Socket sock;
    protected BufferedReader sockIn;
    protected PrintWriter sockOut;

    public Correspondent() {
    } // init fields later

    public Correspondent(Socket s) {
        sock = s;
        initStreams();
    }

    public void setSocket(Socket socket) {
        this.sock = socket;
        initStreams();
    }

    protected void initStreams() {
        try {
            sockIn =
                    new BufferedReader(
                            new InputStreamReader(
                                    sock.getInputStream()));
            sockOut = new PrintWriter(
                    sock.getOutputStream(), true);
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Inititialized" + sock + sockIn + sockOut);
    }

    protected void close() {
        try {
            sock.close();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void requestConnection(String host, int port) {
        try {
            sock = new Socket(host, port);
            initStreams();
        } catch(UnknownHostException uhe) {
            System.err.println("unknown host " + uhe);
            System.exit(1);
        } catch(IOException ioe) {
            System.err.println("failed to create streams " + ioe);
            System.exit(1);
        }
    }

    public void send(String request) {
        if (Server.DEBUG) sockOut.println(request);
    }

    public String receive() {
        String msg = null;
        try {
            msg = sockIn.readLine();
        } catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return msg;
    }
}