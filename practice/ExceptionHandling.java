public class ExceptionHandling {

    public static void main(String ...args) {

        {
            System.out.println(parseFloat("1F"));
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