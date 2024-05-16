package echo;
import java.util.*;

class SafeList {
    private Set<String> bannedRequests = new HashSet<String>();
    synchronized public Boolean isBlocked(String request) {
        return bannedRequests.contains(request);
    }

    synchronized void ban(String request) {
        bannedRequests.add(request);
    }

    synchronized void unban(String request) {
        bannedRequests.remove(request);
    }

}
public class FirewallHandler extends ProxyHandler {
    static private SafeList bannedRequests = new SafeList();
    public String response(String request) throws Exception {
        if (bannedRequests.isBlocked(request))
            return "Sorry, your request is blocked";
        else
            return super.response(request);
    }
}
