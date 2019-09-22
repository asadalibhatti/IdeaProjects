class e1 extends Exception{
    String str1;

    e1(String str2) {
        str1=str2;
    }
    public String toString(){
        return ("Userdefine exception Occurred: "+str1) ;
    }
}

class q6{
    public static void main(String args[]){
        try{
            throw new e1(" My error Message");
        }
        catch(e1 exp){
            System.out.println("handing user definde exeption") ;
            System.out.println(exp) ;
        }
    }
}