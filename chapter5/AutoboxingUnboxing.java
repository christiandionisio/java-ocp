public class AutoboxingUnboxing {


    public static void main(String ...args) {

        Short tail = 8;                        // Autoboxing
        Character p = Character.valueOf('p');
        char paw = p;                          // Unboxing
        Boolean nose = true;                   // Autoboxing
        Integer e = Integer.valueOf(9);
        long ears = e;                         // Unboxing, then implicit casting


        // Limits of autoboxing and numeric promotion
        // Long badGorilla = 8; // DOES NOT COMPILE

    }

}