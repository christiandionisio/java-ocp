public class ExceptionHandling {

    public static void main(String ...args) throws Exception {

        // {
        //     System.out.println(parseFloat("1F"));
        // }

        // // Order of catch Exceptions
        // {

        //     class MyException extends Throwable {}
        //     class MyException1 extends MyException {}
        //     class MyExceptio2 extends MyException {}
        //     class MyException3 extends MyExceptio2 {}

        //     class ExceptionTest {
        //         void myMethod() throws MyException {
        //             throw new MyException3();
        //         }
        //     }

        //     ExceptionTest et = new ExceptionTest();

        //     try {
        //         et.myMethod();
        //     } catch(MyException me) {
        //         System.out.println("MyException thrown");
        //     } catch(MyException3 me3) {     // this must be first to compile from more specific to generic
        //         System.out.println("MyException3 thrown");
        //     } finally {
        //         System.out.println(" Done");
        //     }

        // }

        // // throw null
        // {
        //     try {
        //         // RuntimeException re;        // not compile
        //         RuntimeException re = null;
        //         throw re;       // when this is null then NullpointerException will be thorwn
        //     } catch(Exception e) {
        //         System.out.println(e);
        //     }
        // }


        // // Order of catch        
        // {
        //     class E1 extends Exception {}
        //     class E2 extends E1 {}
            
        //     try {
        //         throw new E2();
        //     } catch (E1 e) {
        //         System.out.println("E1");
        //         // throw new Exception();  // not compile until is declared in throws, finally will execute in any way
        //     } catch (Exception e) {
        //         System.out.println("E");
        //     } finally {
        //         System.out.println("Finally");
        //     }
        // }
        

        // {
        //     // String s1 = "junk";
        //     // String s1 = "" + Float.NEGATIVE_INFINITY;
        //     // String s1 = "-Infinity";
        //     String s1 = "NaN";
        //     try {
        //         System.out.println(Float.parseFloat(s1));
        //     } catch (NumberFormatException e ) {
        //         System.out.println(0.0f);
        //     } catch(IllegalArgumentException e) {
        //         System.out.println(Float.NaN);
        //     }
        // }



        // {
        //     class TestClass {
        //         public static int m1() throws Exception {
        //             throw new Exception("Some Exception");
        //         }
        //     }

        //     int [] a = null;
        //     int i =  a[5] + TestClass.m1();
        // }


        // {
        //     class DatabaseWrapper {
        //         static String url = "urlblablabla";
        //         static DatabaseWrapper getDatabase() {
        //             System.out.println("Getting DB");
        //             return null;
        //         }
        //     }

        //     System.out.println(DatabaseWrapper.getDatabase().url);
        // }


        //Getting suppresedExceptions
        {
            class TestClass {
                public static void m1() throws Exception {
                    throw new Exception("Exception from m1");
                }

                public static void m2() throws Exception {
                    try {
                        m1();
                    } catch(Exception e) {
                        throw e;
                    } finally {
                        throw new RuntimeException("Exception from finally");
                    }
                }
            }

            try {
                TestClass.m2();
            } catch(Exception e) {
                Throwable [] ta = e.getSuppressed();
                for(Throwable t: ta) {
                    System.out.println(t.getMessage());
                }
            }
        }

    }


    public static float parseFloat(String s) {
        float f = 0.0f;
        try {
            f = Float.valueOf(s).floatValue();
            return f;
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException");
            f = Float.NaN;
            throw nfe;
        } finally {
            f = 10.0f;
            return f;
        }
    }


}