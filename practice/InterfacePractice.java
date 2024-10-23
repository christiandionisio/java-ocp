import java.io.*;
import java.sql.*;

public class InterfacePractice {

    public static void main(String ...args) {

        // {
        //     interface Measurement {
        //         // public int getLength() {    // must be default or private to implement a body
        //         public default int getLength() {
        //             return 0;
        //         }
        //     }

        //     interface Size extends Measurement {
        //         public int getLength();     // this is valid, subclasses can default methods as abstract
        //     }
        // }
        // {
        //     interface Measurement {
        //         public default int getLength() {
        //             return 0;
        //         }
        //         public static int getBreadth() {return 0;}
        //     }

        //     interface Size extends Measurement {
        //         public static final int UNIT = 100;
        //         // private final int STEP = 10;    // not allowed, private or protected fields are not allowed
                
        //         // public static int getLength() {return 10;}  // not allowed to override default to static method
        //         public default int getLength() {return 10;}  // allowed
        //         // public static int getBreadth() {return 10;} // allowed
        //         public default int getBreadth() {return 10;} // allowed, static can ve overriden to default
        //     }
        // }

        // {
        //     interface I1{   void m1() throws IOException;}
        //     interface I2{   void m1() throws SQLException;}
        //     class TestClass implements I1, I2 {
        //         public void m1() {
        //             System.out.println("Hi there");
        //         }
        //     }

        //     TestClass tc = new TestClass();
        //     tc.m1();    // No needs to throws exception

        //     I1 i1 = tc;
        //     I1 i1 = (I1)tc;     // casting also valid
        //     i1.m1();    // needs to throw IOException or higher

        //     I2 i2 = tc;
        //     i2.m1();    // needs to thrwo SQLException or higher
        // }

        // // Collision of two methods definition
        // {
        //     interface Bar {
        //         int STATIC_VALUE = 20;
        //         // static {System.out.println("static initializer");}  // not allowed in interfaces
        //         void bar();
        //     }

        //     abstract class FooBase {
        //         static int STATIC_VALUE = 80;
        //         // public static void bar() {  // will not compile, collision with interface in Foo class
        //         public void bar() {
        //             System.out.println("In static bar");
        //         }
        //     }

        //     class Foo extends FooBase implements Bar {
        //         public void bar() {
        //             System.out.println("In FooBase class");
        //         }
        //     }

        //     Bar b = new Foo();
        //     b.bar();
        //     System.out.println(Bar.STATIC_VALUE);
        //     System.out.println(b.STATIC_VALUE);
        //     System.out.println(((FooBase)b).STATIC_VALUE);
        // }

        // // STATIC initializer
        // {
        //     class Super {
        //         static {System.out.print("super ");}
        //     }
        //     class One {
        //         static {System.out.print("one ");}
        //     }
        //     class Two extends Super {
        //         static {System.out.print("two ");}
        //     }

        //     One o = null;   // this will not execute static initializer
        //     Two t = new Two();
        // }


        {
            interface Eatable {
                int types = 10;
            }

            class Food implements Eatable {
                public static int types = 20;
            }

            class Fruit extends Food implements Eatable {
                void printTypes() {
                    // super.types = 30;    // valid
                    ((Food)this).types = 30;    // valid
                    // ((Eatable)this).types = 30;    // invalid
                    System.out.println(((Eatable)this).types);
                }
            }

            Fruit f = new Fruit();
            f.printTypes();
        }

    }

}