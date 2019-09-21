/*
import java.util.*;

class Customer {
    private int id;
    private String name, address;
    private double currentBalance;
    private Date openDate;//date;


    Customer() {


    }

    Customer(String name, String address, double cb, long date) {
        this.id = id;
        this.name =new String(name);// name;
        this.address =new String( address);
        if(cb<0){
            cb=0;
        }
        this.currentBalance = cb;
        //date;
        this.openDate = new Date(12062001);

    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setOpenDate(long openDate) {
        this.openDate=new Date(openDate);
    }
}

public class BankAccount {
    static int id=1;
    private List<Customer> customerList = new ArrayList<Customer>();
    private String bankName;

    public BankAccount(String name) {
        this.bankName = new String(name);
    }

    public void createAccount(Customer c) {

        c.setId(id);
        id++;
        customerList.add(c);
        System.out.println("Account creadted");
    }

    public void depositAmount(int id, double amount) {
        if(amount<0)
            return;
        Customer c = new Customer();
        for (int i = 0; i < customerList.size(); i++) {
            c = customerList.get(i);
            if (c.getId() == id) {
                c.setCurrentBalance(c.getCurrentBalance()+amount);//+amount;
                customerList.set(i, c);
                System.out.println("Account deposited");
                return;
            }
        }
        System.out.println("customer not found ");
    }

    public void withDraw(int id, double amount) {
        Customer c = new Customer();
        for (int i = 0; i < customerList.size(); i++) {
            c = customerList.get(i);
            if (c.getId() == id) {
                if (c.getCurrentBalance() >= amount) {
                    c.setCurrentBalance(c.getCurrentBalance() - amount);//+amount;
                    customerList.set(i, c);
                    System.out.println("withdrawd ");
                    return;
                } else {
                    System.out.println("not enough amount ");
                }
            }
        }
        System.out.println("customer not found ");
    }
    public void printBalance(int id) {
        Customer c = new Customer();
        for (int i = 0; i < customerList.size(); i++) {
            c = customerList.get(i);
            if (c.getId() == id) {
                System.out.println(c.getCurrentBalance());
                return;
            }
        }

        System.out.println("customer not found ");
    }

    public double interest(int id, double rate) {
        Customer c = new Customer();
        for (int i = 0; i < customerList.size(); i++) {
            c = customerList.get(i);
            if (c.getId() == id) {
                return (c.getCurrentBalance() * rate) / (365.0);
            }
        }
        System.out.println("customer not found ");
        return 0;
    }
    public  static void main(String args[]){
        BankAccount b1=new BankAccount("HBL");
        Customer c1=new Customer("asad","Lahore",0,19022001);
        Customer c2=new Customer("rasad","Lahore",0,20022001);
        Customer c3=new Customer("saad","islamabad",110,12022001);
        Customer c4=new Customer("sraaj","skp",0,02022001);
        b1.createAccount(c1);
        b1.createAccount(c2);
        b1.createAccount(c3);
        b1.createAccount(c4);
        b1.depositAmount(1,10);
        b1.depositAmount(2,120);
        b1.depositAmount(3,110);
        b1.depositAmount(4,-10);
//        b1.depositAmount(1,10);
        b1.printBalance(1);
        b1.printBalance(2);
        b1.printBalance(3);
        b1.printBalance(4);
        System.out.println(b1.interest(1,34));
       // b1.


    }

}
*/
