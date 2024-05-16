package echo;

public class CacheProxy extends ProxyHandler {

    // table of request and responses
   protected static SafeTable cache;

   public CacheProxy() {
       if (cache == null) cache = new SafeTable();
   }

   public String response (String request) throws InterruptedException {

       if (cache.get(request) != null) {
           // cache hit
           System.out.println("Found! Response: " + cache.get(request));
           return cache.get((request));
       } else {
           // if not cache hit, foward request to peer
           peer.send(request);
           // response recieved from peer
           String response = peer.receive();
           if (response.equals("quit"))  super.shutDown();
           // put the request, response in cache for later use
           cache.put(request, response);
           return response;
       }
   }


}
