public class SwitchExpression {

    public static void main(String... args) {

        // Notice with switch expression is not necesary 
        // break statement to cut the flow, indeed break 
        // is not allowed in switch expressions
        int animal = 3;
        var result = switch(animal) {
            case 1,2 -> "Lion";
            case 3 ->   "Tiger";
            case 4 ->   "Cat";
            // default necesary only for cases of assigning value
            default ->  "Leopard";
        };
        // ";" is necessay only when you're assigning the 
        // result of switch to a variable
        System.out.print(result);

        // Notice that yield is equivalent to return statement
        int fish = 5;
        int length = 12;
        var name = switch(fish) {
            // yield isn't used when there isn't {}
            case 1 -> "Goldfish";
            // yield is necesary when {} is used
            case 2 -> {yield "Trout";}
            // yield is necesary in all branches
            case 3 -> {
                if(length > 10) yield "Blobfish";
                else yield "Green";
            }
            default -> "Swordfish";
        };
        System.out.println();
        System.out.println(name);


        {
            char number = 1;
            switch(number) {
                case 1 -> {
                    System.out.println("case 1");
                    // redundant in swtich expression without return value
                    break;
                }
                case 2 -> System.out.println("case 2");
                case '3' -> System.out.println("case 3");
                case 3 -> System.out.println("case 3 int");
                // default is not necesary
            // semicolon is not necesary and reduntant in switch expresssion without retuned value
            }
        }


    }


}