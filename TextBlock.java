public class TextBlock {

    public static void main(String... args) {

        String pyramid = """
          *\s\sasd
         * *    \
        * * *
        """;

        int variable = 0;
        String value = """
            Hola + variable +
            #variable
        """;


        int sheep = 1;
        int zzz = 1;
        int sleep = zzz<10 ? sheep++ : zzz++;
        System.out.println(sheep + "," + zzz);
        System.out.println(sleep);

        boolean canine = true;
        boolean wolf = true;
        canine = (wolf = false);
        System.out.println(canine + " " + wolf);

    }
}

/**
 * 
 * \s: son espacios en textBlock
 * \: escapa los saltos de linea en TextBlock
 */