public class PassObjectMethods {

    public static void main(String ...args) {

        // The variable assigmennt is only to the method 
        // parameter and doesn't affect the caller
        {
            int num = 4;
            newNumber(num);
            System.out.println(num);     // 4
        }

        // Here inside of speak() is calling a method on the
        // parameter, it doesn't reassing 's' to a different object 
        {
            var name = new StringBuilder("Webby");
            speak(name);
            System.out.println(name); // WebbyGeorgette
        }
    }

    public static void newNumber(int num) {
        num = 8;
    }

    public static void speak(StringBuilder s) {
      s.append("Georgette");
   }

}