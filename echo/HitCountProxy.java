package echo;

public class HitCountProxy extends ProxyHandler {

    protected static int count = 0;

    public HitCountProxy() {
        super();
        // each time a new instance of a handler is created, increment count by one
        count++;
    }

    public String response(String request) throws Exception {
        // split when one or more white space characters
        String[] cmmd = request.split("\\s+");

        if (cmmd.length == 1 && cmmd[0].equalsIgnoreCase("hits")) {
            return "hit count = " + count;
        } else {
            return super.response(request);
        }

    }



}
