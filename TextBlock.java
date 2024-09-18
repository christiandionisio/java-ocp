public class TextBlock {

    public static void main(String... args) {

        // String pyramid = """
        //   *\s\sasd
        //  * *    \
        // * * *
        // """;

        // int variable = 0;
        // String value = """
        //     Hola + variable +
        //     #variable
        // """;


        // int sheep = 1;
        // int zzz = 1;
        // int sleep = zzz<10 ? sheep++ : zzz++;
        // System.out.println(sheep + "," + zzz);
        // System.out.println(sleep);

        // boolean canine = true;
        // boolean wolf = true;
        // canine = (wolf = false);
        // System.out.println(canine + " " + wolf);

        // {
        //     var pooh = """
        //         "Oh, bother." -Pooh
        //         """.indent(1);
        //     System.out.print(pooh);
        // }

        {
            var s1 = "Java";
            var s2 = "Java";
            var s3 = s1.indent(1).strip();
            var s4 = s3.intern();
            var sb1 = new StringBuilder();
            sb1.append("Ja").append("va");
            
            System.out.println(s1 == s2);
            System.out.println(s1.equals(s2));
            System.out.println(s1 == s3);
            System.out.println(s1 == s4);
            System.out.println(sb1.toString() == s1);
            System.out.println(sb1.toString().equals(s1));
            System.out.println(s1.indent(1).strip());
        }

    }
}

/**
 * 
 * \s: son espacios en textBlock
 * \: escapa los saltos de linea en TextBlock
 */