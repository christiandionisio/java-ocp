public class PatternMatching {

    static void printOnlyIntegers(Number number) { 
        if (!(number instanceof Integer data))
            return;
        System.out.print(data.intValue());
    }

    public static void main(String ...args) {
        printOnlyIntegers(200);

    }
    
}