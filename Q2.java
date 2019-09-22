import java.*;

class DigitSum {
    private int number;
    private int Dsum;
    public DigitSum(int n,int ds) { number=n;
    Dsum=ds;
    }
    public int GetDigitSum() {
        int Dsum=0;
    while(number>0)
    {int m = number % 10;
        Dsum =Dsum + m;
    number/=10;
    }
    return Dsum;
    }


}

public class Q2 {
    public static void main(String[]ar)
    {
        int ds=0;

        DigitSum d1 =new DigitSum(801,ds);


        int r=d1.GetDigitSum();

        if(r %2 ==0 )
        { System.out.println(r + " Is an Even number");
        }else
        { System.out.println(r + " Is an Odd number");
        }


    }
}
