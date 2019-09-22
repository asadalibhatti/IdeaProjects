import java.io.*;
import java.util.Scanner;

public class q5 {
    static void writeStringUsingBufferedWritter()
            throws IOException {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter User1 : ");
        String user1 = myObj.nextLine();  // Read user input
        BufferedWriter writer = new BufferedWriter(new FileWriter("user1.txt"));
        writer.write(user1);
        writer.close();

        System.out.println("Enter User2 : ");
        String user2 = myObj.nextLine();  // Read user input
        writer = new BufferedWriter(new FileWriter("user2.txt"));
        writer.write(user2);
        writer.close();


        File file1 = new File("user1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String st,st2;


        File file2 = new File("user2.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));




        while (true) {
            st = br2.readLine();
            st2 = br.readLine();
            if(st == null || st2==null){
                if (st2 == st) {
                    System.out.println("Matched");
                    break;
                }
                System.out.println(" not Matched");
            }


            if (st2 != st) {
                System.out.println("not Matched");
                break;

            }

            System.out.println(st);
        }
    }

    public static void main(String []args) {
        try {
            writeStringUsingBufferedWritter();
        } catch (IOException ioe) {
            System.out.println("Eror : "+ioe.getMessage());
        }
    }
}


