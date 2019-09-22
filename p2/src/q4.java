
import java.util.Arrays;
public class q4
{

    static boolean differWith1(int i,int k){
        int res=i-k;

        if(res<0)
            res=res*(-1);

        if(res==1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{ 49, 1, 3, 200, 2, 4, 70, 5,14,15,16,17,18,19,20};
        Arrays.sort(arr);
        int realCount=0;int cCount=0;
        for(int i=0;i<arr.length-1;i++){
            if(differWith1(arr[i],arr[i+1])){
                cCount++;
            }
            else{
                if(cCount>realCount){
                    realCount=cCount;
                }
                cCount=0;
            }

            if(cCount>realCount){
                realCount=cCount;
            }
        }
        realCount++;
        System.out.println("Longest Seq lenght : "+ realCount);
    }
}
