public class SwitchStatement {

    public static void main(String... args) {

        // Without break statement in each branch executes
        // all of the branches in the found order including default
        int animal = 3;
        switch(animal) {
            case 1,2: System.out.print("Lion");
            case 3:   System.out.print("Tiger");
            // Notice putting a break statement it cuts execution
            case 4:   System.out.print("Cat"); break;
            default:   System.out.print("Leopard");
        }
        System.out.println("");
        
        // Before java 14 combining case values are like 
        // this, (still compiling)
        switch(animal) {
            case 1: case 2: System.out.print("Lion");
            case 3:         System.out.print("Tiger");
            case 4:         System.out.print("Cat");
            default:        System.out.print("Leopard");

        }

        // Values supported by switch statements:
        // int, Integer, byte, Byte, short, Short,
        // char, Character, String, enum values,
        // var (only valid for preceding types)
        System.out.print(1%2);
    }


}