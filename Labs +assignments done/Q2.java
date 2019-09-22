import java.io.*;

public class q2 {
    static int arr1[] = new int[]{2, 10, 4, -10, 6,10};


    static boolean check() {
        int res=0;
        for (int i : arr1
        ) {
            if (i== 10) {
                res+=i;
            }
        }
       if(res==30)
           return true;
       return false;
    }



    public static void main(String args[]) {
        System.out.println(check());
    }
}
