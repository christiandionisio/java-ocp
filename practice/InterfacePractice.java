import java.io.*;
import java.sql.*;

public class InterfacePractice {

    public static void main(String ...args) {

        {
            interface Measurement {
                // public int getLength() {    // must be default or private to implement a body
                public default int getLength() {
                    return 0;
                }
            }

            interface Size extends Measurement {
                public int getLength();     // this is valid, subclasses can default methods as abstract
            }
        }
        {
            interface Measurement {
                public default int getLength() {
                    return 0;
                }
                public static int getBreadth() {return 0;}
            }

            interface Size extends Measurement {
                public static final int UNIT = 100;
                // private final int STEP = 10;    // not allowed, private or protected fields are not allowed
                
                // public static int getLength() {return 10;}  // not allowed to override default to static method
                public default int getLength() {return 10;}  // allowed
                // public static int getBreadth() {return 10;} // allowed
                public default int getBreadth() {return 10;} // allowed, static can ve overriden to default
            }
        }

        {
            interface I1{   void m1() throws IOException;}
            interface I2{   void m1() throws SQLException;}
            class TestClass implements I1, I2 {
                public void m1() {
                    System.out.println("Hi there");
                }
            }

            TestClass tc = new TestClass();
            tc.m1();    // No needs to throws exception

            I1 i1 = tc;
            I1 i1 = (I1)tc;     // casting also valid
            i1.m1();    // needs to throw IOException or higher

            I2 i2 = tc;
            i2.m1();    // needs to thrwo SQLException or higher
        }

    }

}