public class StringHandling {

    public static void main(String ...args) {

        // Getting a single character
        var name = "animals";
        System.out.println(name.charAt(0)); // a
        System.out.println(name.charAt(6)); // s
        // System.out.println(name.charAt(7)); // throws exception but still compile

        // Finding an index
        System.out.println("Finding an index");
        System.out.println(name.indexOf('a'));       // 0
        System.out.println(name.indexOf("al"));      // 4
        System.out.println(name.indexOf('a', 3));    // 4
        System.out.println(name.indexOf("al", 5));   // -1 occurs when s not found


        // Getting a substring
        System.out.println("Getting a substring");
        System.out.println(name.substring(3));                 // mals
        System.out.println(name.substring(name.indexOf('m'))); // mals
        System.out.println(name.substring(3, 4));              // m
        System.out.println(name.substring(3, 7));              // mals
        System.out.println(name.substring(3, 3)); // empty string
        // System.out.println(name.substring(3, 2)); // exception
        // System.out.println(name.substring(3, 8));              // throws exception but still compile


        // Replacing values
        System.out.println("Replacing values");
        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc
        // System.out.println("abcabc".replace('a', "A")); // throws exception 'cause both parameter need to be the same type


        // Removing whitespaces
        System.out.println("Removing whitespaces");
        System.out.println("abc".strip());                 // abc
        System.out.println("\t   a b c\n".strip());        // a b c
        
        String text = " abc\t ";
        System.out.println(text.trim().length());          // 3
        System.out.println(text.strip().length());         // 3
        System.out.println(text.stripLeading().length());  // 5 erases whitespaces only for the begining
        System.out.println(text.stripTrailing().length()); // 4 erases whitespaces only for the ending

        // Working with indentation
        var block = """
                    a
                     b
                    c""";
        var concat = " a\n"
                   + "  b\n"
                   + " c";
        System.out.println("Working with indentation");
        System.out.println(block.length());                 // 6
        System.out.println(concat.length());                // 9
        System.out.println(block.indent(1).length());       // 10
        System.out.println(concat.indent(-1).length());     // 7
        System.out.println(concat.indent(-4).length());     // 6
        System.out.println(concat.stripIndent().length());  // 6

        
        // Translate escapes
        System.out.println("Working with indentation");
        var str = "1\\t2";
        System.out.println(str);                    // 1\t2
        System.out.println(str.translateEscapes()); // 1    2


        // Checking for empty or blank strings
        System.out.println("Checking for empty or blank strings");
        System.out.println("  ".isEmpty()); // false
        System.out.println("".isEmpty());  // true
        System.out.println("  ".isBlank()); // true
        System.out.println("".isBlank());  // true

        

        // Formatting values
        System.out.println("Formatting values");
        var name2 = "Kate";
        var orderId = 5;
        // All print: Hello Kate, order 5 is ready
        System.out.println("Hello "+name2+", order "+orderId+" is ready");
        System.out.println(String.format("Hello %s, order %d is ready", 
        name2, orderId));
        System.out.println("Hello %s, order %d is ready"
        .formatted(name2, orderId));
        /** 
         * %s Applies to any type, commonly String values 
         * %d Applies to integer values like int and long 
         * %f Applies to floating-point values like float and double 
         * %n Inserts a line break using the system-dependent line separator
        */
        var pi = 3.14159265359;
        System.out.format("[%f]",pi);      // [3.141593] by default %f shows 6 digits past the decimal
        System.out.format("[%12.8f]",pi);  // [  3.14159265]
        System.out.format("[%012f]",pi);   // [00003.141593]
        System.out.format("[%12.2f]",pi);  // [        3.14]
        System.out.format("[%.3f]",pi);    // [3.142]


        // String pool
        System.out.println("");
        System.out.println("String pool");
        var x = "Hello World";
        var y = new String("Hello World");
        System.out.println(x == y); // false

        var name4 = "Hello World";
        var name3 = new String("Hello World").intern();
        // with intern() you indicate to use the value of 
        // String from String pool, so both variable points
        // to the same object
        System.out.println(name4 == name3); // true

        var first = "rat" + 1; // compile time constant gets placed in the string pool
        var second = "r" + "a" + "t" + "1"; // compile time constant gets placed in the string pool
        var third = "r" + "a" + "t" + new String("1"); // no compile time constant
        System.out.println(first == second);    // true
        System.out.println(first == second.intern()); // true
        System.out.println(first == third); // false
        System.out.println(first == third.intern()); // true


    }


}