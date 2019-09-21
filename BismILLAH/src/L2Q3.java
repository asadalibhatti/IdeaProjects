import java.util.ArrayList;
import java.util.List;

class Customer {
    String name,address;
    float number;

    public Customer(String name, String address, float number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }
}
class Discount{
    float discountRate;

    public Discount(float discountRate) {
        this.discountRate = discountRate;
    }
}
class VisitRecord{
    List<Visit> visitList;
    public VisitRecord(){
        visitList=new ArrayList<>();
    }

    public void addRecord(Visit v){
        visitList.add(v);
    }
    public void showRecords(){
        System.out.println( "Name :   Total:   Discounted :   DiscountRate : ");
        for (Visit v:visitList
             ) {
           System.out.println( v.c.name+" , "+v.Total+ " , "+ v.discounted+ " , "+ v.disRate);

        }
        //System.out.println(visitList.toString());
    }
}
//calculalte bill
class DiscountRate{
    public static float calculateBill(float orgAmount,float disc){
        return orgAmount-orgAmount*disc/100;
    }
}
class Visit{
    Customer c;
    float Total;
    float discounted;
    float disRate;

    public Visit(Customer c, float Total,float disRate) {
        this.c = c;
        this.Total = Total;
        this.discounted = DiscountRate.calculateBill(Total,disRate);
        this.disRate=disRate;
    }
}
public class L2Q3 {
    public static void main(String args[]) {
        Customer c1 = new Customer("Shazad", "Nava khoo", 1);
        Customer c2 = new Customer("asd", "Nava khoo", 2);
        Customer c3 = new Customer("ali", "Nava khoo", 3);
        Customer c4 = new Customer("taimoor", "Nava khoo", 4);

        Visit v1=new Visit(c1,200,0);
        Visit v2=new Visit(c1,100,04);
        Visit v3=new Visit(c2,1200,10);
        Visit v4=new Visit(c3,2100,40);
        Visit v5=new Visit(c4,2010,100);

        VisitRecord v = new VisitRecord();
        v.addRecord(v1);
        v.addRecord(v2);
        v.addRecord(v3);
        v.addRecord(v4);
        v.addRecord(v5);
        v.showRecords();
    }



}
