import java.util.*;

class myExption extends Exception {
    public myExption() {
    }

    public myExption(String message) {
        super(message);
    }
};

public class Convert {

    public static void main(String[] args) {
        try {
            if (args[0].substring(0, 3).equals("[-u")) {
                if (!args[0].substring(args[0].length() - 1).equals("]")) {
                    throw new myExption("There is Syntax Eror");
                }
            }
            int temp;
            boolean chk=false;
            char change = args[0].charAt(3);
            for (int i = 1; i < args.length; i++) {
                for (int j = 0; j < args[i].length(); j++) {
                    chk=true;
                    if (args[i].charAt(j) == change) {
                        temp = args[i].charAt(j);
                        temp = temp - 32;
                        char a = (char) temp;
                        char arr[] = args[i].toCharArray();
                        arr[j] = a;
                        String s = new String(arr);
                        args[i] = s;
                    }
                }
            }

            for (int i = 1; i < args.length; i++) {
                System.out.print(args[i]);
                System.out.print(" ");
            }

if(!chk) {
    if (!args[0].substring(0, 3).equals("[-o")) {
        throw new myExption("Syntax eror");
    } else if (!args[0].substring(0, 3).equals("[-u")) {
        throw new myExption("Syntax eror");
    }
}
        } catch (myExption ex) {
            System.out.print("Error occur ");
        }
    }
}