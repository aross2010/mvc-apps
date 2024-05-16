package container_demo;

import java.lang.reflect.*;
import java.util.*;

class Component {
    Container container = null;

    Object invoke(String methodName, String msg) throws InvocationTargetException, IllegalAccessException {
        return container.invoke(this, methodName, msg);
    }
}

class Container {
    List<Component> components = new ArrayList<Component>();

    void add(Component c) {
        components.add(c);
        c.container = this;
    }

    Object invoke(Component sender, String methodName, String msg) throws InvocationTargetException, IllegalAccessException {
        Object response = null;
        for (Component c: components) {
            if (c.equals(sender)) continue;
            Class<?> comp = c.getClass();
            Method[] methods = comp.getMethods();
            for (Method m: methods) {
                if (m.getName().equals(methodName)) {
                    response = m.invoke(c, msg);
                }
            }
        }
        // find a component other than sender with the required method and invoke it
        // i.e. use reflection to call component.methodName(msg)
        // hint: String.class is the instance of Class that represents String
        return response;
    }
}


//==================
// Demo
//==================

// checks if a string is a palindrome
class PalindromeChecker extends Component {
    Boolean isPalindrome(String s) throws InvocationTargetException, IllegalAccessException {
        String r = (String) invoke("reverse", s); // I need someone to reverse s
        return r.equals(s);
    }
}

// reverses strings
class StringReverser extends Component {
    public String reverse(String s) {
        String result = "";
        for (int i = (s.length()) - 1; 0 <= i; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

public class ContainerDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Container container = new Container();
        StringReverser rev = new StringReverser();
        PalindromeChecker pal = new PalindromeChecker();
        container.add(rev);
        container.add(pal);
        System.out.println("rotator is pal = " + pal.isPalindrome("rotator")); // = true
        System.out.println("tomato is pal = " + pal.isPalindrome("tomato"));   // = false
    }
}
