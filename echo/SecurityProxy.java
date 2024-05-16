package echo;

public class SecurityProxy extends ProxyHandler {

    static SafeTable users;
    protected boolean loggedIn = false;

    public SecurityProxy() {
        if (users == null) users = new SafeTable();
    }

    public String response(String request) throws Exception {

        // split when one or more white space characters
        String[] cmmd = request.split("\\s+");

        String command = "", username = "", password = "";

        // check if they all exist
        if (cmmd.length >= 3) {
            command = cmmd[0];
            username = cmmd[1];
            password = cmmd[2];
        } else {
            return "Not enough arguments for valid command.";
        }

        if (command.equalsIgnoreCase("new")) {
            if (users.get(username) != null) return "User already exists with that name. Try another.";
            if (username == null) return "Enter a username.";
            if (password == null) return "Enter a password";
            else {
                users.put(username, password);
                return "New account success!";
            }
        } else if (command.equalsIgnoreCase("login")) {
            System.out.println(command + "  " + username + "  " + password);
            if (username == null) return "Invalid user name.";
             else {
                String userPassword = users.get(username);
                if (userPassword == null) return "User does not exist.";
                System.out.println("Password: " + userPassword);
                if (password.equals(userPassword)) {
                    loggedIn = true;
                    return "Login success!";
                } else return "Invalid Password";
            }
        } else {
            // forward to next guy in chain if logged in
            if (loggedIn) return super.response(request);
            else return "Invalid Command. Must login or create a new account to continue.";
        }


    }

}
