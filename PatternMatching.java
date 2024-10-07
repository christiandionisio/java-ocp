public class PatternMatching {

    static void printOnlyIntegers(Number number) { 
        if (!(number instanceof Integer data))
            return;
        System.out.println(data.intValue());
    }

    public static void main(String ...args) {
        printOnlyIntegers(200);

        Integer value = 123;
        if(value instanceof Integer) {
            System.out.println("true");
        }
        // para data el valor value debe ser un subtipo de integer por eso no compila
        // if(value instanceof Integer data) {}  // DOES NOT COMPILE

    }
    
}