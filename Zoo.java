public class Zoo {
    // public static void main(String[] args) {
    //     System.out.println("Hello world");
    // }

    // public static void main(String args[]) {
    //     System.out.println("Hello world2");
    // }

    // public static void main(String... args) {
    //     System.out.println("Hello world 3");
    // }

    // modifiers final son opcionales
    // public final static void main(final String... args) {
    //     System.out.println("Hello world 4");
    // }

    // java Zoo "San Diego" Zoo -> enviar dos parametros en el comando
    public final static void main(final String... args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}

// class Animal {}