package echo;

import java.util.HashMap;

 public class SafeTable {

    protected static HashMap<String, String> safeTable;

    public SafeTable() {
        safeTable = new HashMap<>();
    }

    public synchronized String get(String request) throws InterruptedException {
        String msg = safeTable.get(request);
        return msg;
    }

    public synchronized void put(String request, String response) {
        safeTable.put(request, response);
    }

}
