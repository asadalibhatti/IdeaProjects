import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Server {
    List<String> urlList;

    public Server(List<String> urlList) {
        this.urlList = urlList;
    }

    public Server() {
        this.urlList = new ArrayList<String>();
    }


    //PRINT ON CONSOLE
    public void getUrlList() throws IOException {
        for (String str : urlList
        ) {

            System.out.println(str);

        }
    }

    public void addUrl(String[] url) throws IOException {

        for (String str : url
        ) {

            if (str.substring(0, 3).equals("www") || str.substring(0, 3).equals("WWW") || str.substring(0, 8).equals("https://") || str.substring(0, 8).equals("HTTPS://"))
                if (duplicate(str)) {
                    System.out.println(str + " Not added because duplicate not added");
                } else
                    urlList.add(str);
           else
                System.out.println(str + " Not added because without www not added");

        }




    }



    boolean duplicate(String str) {
        for (String s : urlList
        ) {
            if (str.equals(s))
                return true;
        }
        return false;
    }
}

class Archive extends Server {
    public Archive(List<String> urlList) {
        super(urlList);
    }

    public Archive() {
        super();
    }


    @Override
    //PRINTING INTO FILE
    public void getUrlList() throws IOException {
        //writing to output.txt
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        for (String str : urlList
        ) {
            writer.write(str + "\n");


        }
        writer.close();
    }


    @Override
    //FROM INPUT.TXT
    public void addUrl(String[] url) throws IOException {

        //reading from input.txt
        File file1 = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String st;


        while (true) {
            st = br.readLine();
            //st2 = br.readLine();
            if (st != null) {
                if (st.substring(0, 3).equals("www") || st.substring(0, 3).equals("WWW") || st.substring(0, 8).equals("https://") || st.substring(0, 8).equals("HTTPS://"))
                    if (duplicate(st)) {
                        System.out.println(st + " Not added because duplicate not added");
                    } else
                        urlList.add(st);

                else
                    System.out.println(st + " Not added because without www not added");
            } else
                break;
        }
        br.close();
    }
}

public class i170312 {
    static public void main(String arg[]) throws IOException {
       // String arg[] = {"www.asad.com", "google.com", "WWW.facebook.com", "www.asad.com", "www.yes.net", "nu.edu.pk"};

      try{


        Server server1 = new Server();
        //setting server
        System.out.println("\n\nseting url in server from CMD Arguments: ");
        //setter of server
        server1.addUrl(arg);

        System.out.println("\n\nPrinting url of server on console using getter:");
        //getter of server
        server1.getUrlList();


        Archive archive1 = new Archive();
        System.out.println("\n\nadding url into Archive from file input.txt using addUrl of Archive:");
        //setter of archive
        archive1.addUrl(arg);

        System.out.println("\n\noutputing into OUTPUT.txt file by Caling getr of Archive :");
        //getter of archive
        archive1.getUrlList();



    }
      catch (StringIndexOutOfBoundsException ex){
          System.out.println(ex.getMessage());
      }
}}
