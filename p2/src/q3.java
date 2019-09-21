import java.io.*;

public class q3 {           //         -   -   -
    static int arr1[] = new int[]{20, 20, 30,20,21, 40, 30,50,51, 50, 50};

    //will insert -999 at dupliate
    static boolean findDup() {
        boolean ret =false;
        for(int i=0;i<arr1.length-1;i++){
            for(int j=i+1;j<arr1.length;j++){
                if(arr1[i]==arr1[j] && arr1[i]!=-999){
                    arr1[j]=-999;
                    ret=true;
                }
            }
        }
        return ret;
    }
    static int remove(){
       int i;
        for(i=0;i<arr1.length && arr1[i]!=-9999;i++){

                if(arr1[i]==-999){

                    shiftRight(i);
                }
        }
        return i-1;
    }

    static void shiftRight(int i) {
        for(;i<arr1.length-1;i++){
            arr1[i]=arr1[i+1];

        }
        arr1[i]=-9999;
    }


    static int remDupReturnLen() {

      if( findDup()){
          return remove();
      }
      else
          return arr1.length;
    }

    public static void main(String args[]) {
      System.out.println( remDupReturnLen());
    }
}
