public class ExceptionHandling {

    public static void main(String ...args) {

        // {
        //     System.out.println(parseFloat("1F"));
        // }

        // Order of catch Exceptions
        {

            class MyException extends Throwable {}
            class MyException1 extends MyException {}
            class MyExceptio2 extends MyException {}
            class MyException3 extends MyExceptio2 {}

            class ExceptionTest {
                void myMethod() throws MyException {
                    throw new MyException3();
                }
            }

            ExceptionTest et = new ExceptionTest();

            try {
                et.myMethod();
            } catch(MyException me) {
                System.out.println("MyException thrown");
            } catch(MyException3 me3) {     // this must be first to compile from more specific to generic
                System.out.println("MyException3 thrown");
            } finally {
                System.out.println(" Done");
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