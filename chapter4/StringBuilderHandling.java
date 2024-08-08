public class StringBuilderHandling {

    public static void main(String ...args) {

        // Mutability an chaining
        System.out.println("Mutability an chaining");
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        // both a and b points to the same object and
        // StringBuilder is mutable, so the answer for
        // both variables are the same: abcdefg.


        // Inserting data
        System.out.println("Inserting data");
        var sb = new StringBuilder("animals");
        sb.insert(7, "-");                  // sb = animals-
        sb.insert(0, "-");                  // sb = -animals-
        sb.insert(4, "-");                  // sb = -ani-mals-
        System.out.println(sb);


        // Delete contents
        System.out.println("Delete contents");
        var sb2 = new StringBuilder("abcdef");
        sb2.delete(1, 3);                   // sb = adef
        // sb2.deleteCharAt(5);                // exception because index 5 doesn't exist
        var sb3 = new StringBuilder("abcdef");
        sb3.delete(1, 100);                  // sb = a
        // delete with second parameters that is past the end of StringBuilder
        // still compiles.

        // Replaciong portions
        System.out.println("Replaciong portions");
        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        System.out.println(builder);  // pigsty dirty



    }

}