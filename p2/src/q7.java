 class q77 {
    public q77() {
    }
    void f() throws e1 {
        try{
            g();
        }
        catch (e1 exp){
            throw new e1("2nd ero");
        }
    }
    void g() throws e1 {
        throw new e1("er msg");
    }

}
class q7{
    public static void main(String []agr) throws e1 {
        q77 obj=new q77();
        try {


            obj.f();
        }
        catch (e1 e){
            

        }
    }
}