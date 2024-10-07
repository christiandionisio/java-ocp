public class InterfaceHandling {

    public static void main(String ...args) {

        IHello hello = new TestClass();
        hello.methodDefault();
        IHello2.print();
        System.out.println(IHello.parameter);
        // TestClass.print();
    }

}

interface IHello {
    // public static final Integer parameter = null;  // by default is static and final
    // private Integer parameter = 0;  // cannot be private
     Integer parameter = 0; 
    // static {  // Not allowed
    //     parameter = 3;
    // }

    public int hello(int x, int y);
    public long hello(long x, long y);

    // default cannot be static or final, and only can be public
    default void methodDefault() {System.out.println("methodDefault");}
    default CharSequence methodDefault(int x) {
        System.out.println("methodDefault2");
        return "methodDefault2";
    }
}

interface IHello2 extends IHello {
    // private static void print() {System.out.println("print hello2 static");}  // this can be private
    public static void print() {System.out.println("print hello2 static");}
}

class TestClass implements IHello, IHello2 {
    public int hello(int x, int y) {return 0;}
    public long hello(long x, long y){return 0L;}
    public void methodDefault() {System.out.println("TestClass methodDefault");}
    // public static void print() {System.out.println("static method class");}

}