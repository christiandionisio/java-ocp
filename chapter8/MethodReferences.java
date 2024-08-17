import java.lang.Math;

public class MethodReferences {

    public static void main(String ...args) {

        // Calling static methods
        {
            Converter methodRef = Math::min;
            // Values are assigning in the order that they are declared
            Converter lambda = (a,b) -> Math.min(a,b); 
            System.out.println(methodRef.calculateMin(100, 200));
        }

        // Calling instance methods on a particular object
        {
            var str = "";
            StringChecker methodRef = str::isEmpty;
            StringChecker lambda = () -> str.isEmpty();
            System.out.println(methodRef.check());
        }

        // Calling instance methods on a parameter
        {
            StringSubstringChecker methodRef = String::substring;
            StringSubstringChecker lambda = (str, init, end) -> str.substring(init, end);
            System.out.println(methodRef.checkSubstring("01234", 0, 2));
        }

        // Calling constructors
        {
            AnimalCreator methodRef = Animal::new;
            AnimalCreator lambda = (name, canHop, legsNumber) -> new Animal(name, canHop, legsNumber);
            methodRef.createAnimal("dog", false, 4);
        }



    }


}

// @FunctionalInterface     // Is optional
interface Converter {
    long calculateMin(long a, long b);
    // void someFunction();    // DOES NOT COMPILE
}

interface StringChecker {
    boolean check();
}

interface StringSubstringChecker {
    String checkSubstring(String str, int init, int end);
}

class Animal {
    String name;
    boolean canHop;
    int legsNumber;

    public Animal(String name, boolean canHop, int legsNumber) {
        this.name = name;
        this.canHop = canHop;
        this.legsNumber = legsNumber;
        System.out.println("Animal name: " + name + " canHop: " + canHop + " legsNumber: " + legsNumber);
    }
}

interface AnimalCreator {
    Animal createAnimal(String name, boolean canHop, int legsNumber);
}