import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class IOSerializationPractice {

    public static void main(String ...args) throws IOException, ClassNotFoundException {
        

        // // constructor or any instance blocks is not executed during deserialization
        // {
        //     // class Boo implements Serializable {  // with this any constructor of child class will not execute during deserialization
        //     class Boo {
        //         static {System.out.println("Boo static initializer");}
        //         public Boo() {System.out.println("In Boo");}
        //     }

        //     class BooBoo extends Boo {
        //         public BooBoo() {System.out.println("In BooBoo");}  // if this clas had implemented Serializable 
        //         // this will not executed during deserialization
        //     }

        //     class Moo extends BooBoo implements Serializable {
        //         int moo = 10; 
        //         {System.out.println("moo set to 10");}  // this is not executed when deserailization is made
        //         static {System.out.println("moo static initializer");}  // this will execute when deserializarion is trigger
        //         public Moo() {System.out.println("In Moo");}  // constructors of Serailizable not executes in deserialization, but 
        //         //constructors of parents class that haven't implement Serializable will executed in deserialization
        //     }

        //     {
        //         Moo moo = new Moo();
        //         moo.moo = 20;

        //         FileOutputStream fos = new FileOutputStream("./moo1.ser");  // FileNotFoundException
        //         ObjectOutputStream os = new ObjectOutputStream(fos);    // IOException
        //         os.writeObject(moo);    // IOException
        //         os.close();             // IOException
        //     }

        //     {
        //         FileInputStream fis = new FileInputStream("moo1.ser");
        //         ObjectInputStream is = new ObjectInputStream(fis);
        //         Moo moo = (Moo)is.readObject();    // ClassNotFoundException, 
        //         // deserialization occurs here

        //         is.close();
        //         System.out.println(moo.moo);
        //     }
        // }

        // // DyrectoryStream  iterates files
        // {
        //     Path dir = Paths.get("./");

        //     try {
        //         DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.{java,ser}");
        //         for(Path p: ds) {
        //             System.out.println(p);
        //         }
        //     } catch(Exception e) {
        //         e.printStackTrace();
        //     }
        // }

        // // Files.move(p1,p2)
        // {
        //     Path p1 = Paths.get("./temp/src/foo.bar/module-info.java");     // for moving this file must exist
        //     Path p2 = Paths.get("./temp/out/foo.bar/module-info.java");  // if destiny exists by default this will be thrown FileAlreadyExistsException
        //     // Files.move(p1, p2);  // if the target exists this will throw FileAlreadyExistsException
        //     Files.move(p1, p2, StandardCopyOption.REPLACE_EXISTING);    // fills the folder if its empty, otherwise this will throw an exception
        // }


        // // RandomAccessFile
        // {
        //     var raf = new RandomAccessFile("./test.txt", "rwd");
        //     raf.writeChars("hello world");
        //     raf.close();
        // }


        // // PrintWriter
        // {
        //     try (OutputStream os = new FileOutputStream("./printwriter.txt")) {
        //         var pw = new PrintWriter(os);
        //         pw.write("hola");
        //         pw.println("hola");
        //         pw.flush();     // this is necessary
        //     }

        // }


        // // Deserializaton
        // {
        //     class Boo {
        //         int boo = 10;
        //         public Boo(int k) {System.out.println("In Boo k = " + k); boo = k;}
        //         // public Boo() {}     // not necesary
        //     }

        //     class BooBoo extends Boo {
        //         public BooBoo(int k) {super(k); System.out.println("In BooBoo k = " + k);}
        //         // public BooBoo() {super(5);} // necesary only in parent of Serializable class for deserialization
        //     }

        //     class Moo extends BooBoo implements Serializable {
        //         int moo = 10;
        //         public Moo() {super(5); System.out.println("In Moo");}
        //     }

        //     var moo = new Moo();
        //     var fos = new FileOutputStream("./moo2.ser");
        //     var os = new ObjectOutputStream(fos);
        //     os.writeObject(moo);
        //     os.close();

        //     var fis = new FileInputStream("./moo2.ser");
        //     var is = new ObjectInputStream(fis);
        //     moo = (Moo) is.readObject();
        //     is.close();
        // }


        // // subpath
        // {
        //     Path p1 = Paths.get("/finance/data/reports/daily/pnl.txt");
        //     System.out.println(p1.subpath(0,2));

        // }

        // // Serialization static and transient
        // {
        //     class Boo implements Serializable {
        //         transient int ti = 10;
        //         static int si = 20;     // this dont save in serailizaton STATIC
        //     }

        //     Boo boo = new Boo();
        //     boo.si++;
        //     System.out.println(boo.ti + " " + boo.si);

        //     var fos = new FileOutputStream("./boo.ser");
        //     var os = new ObjectOutputStream(fos);
        //     os.writeObject(boo);
        //     os.close();

        //     boo.si += 20; 

        //     var fis = new FileInputStream("./boo.ser");
        //     var is = new ObjectInputStream(fis);
        //     boo = (Boo) is.readObject();
        //     is.close();
        //     System.out.println(boo.ti + " " + boo.si);
        // }


        // // Path
        // {
        //     System.out.println(Path.of("/Users/christiandionisio/Desktop/javaOCP/practice/boo.ser"));
        //     System.out.println(Path.of("/Users/christiandionisio/Desktop/javaOCP/practice/boo.ser").getFileName());
        //     System.out.println(Path.of("/Users/christiandionisio/Desktop/javaOCP/practice").getFileName());
        //     System.out.println(Path.of("./asds").getFileName());


        //     System.out.println(Path.of("./boo.ser").toAbsolutePath());
        //     System.out.println(Path.of("asdsdsa").toAbsolutePath());
        // }



        {
            class FileCopier {
                public static void copy(String records1, String records2) throws IOException {
                    try(InputStream is = new FileInputStream(records1);
                        OutputStream os = new FileOutputStream(records2);) {
                        
                        var buffer = new byte[1024];
                        var bytesRead = 0;
                        while((bytesRead = is.read(buffer)) != -1) {
                            os.write(buffer, 0, bytesRead);
                        }
                        
                    } catch(FileNotFoundException | java.io.InvalidClassException e) {
                        e.printStackTrace();
                    }
                }
            }

            FileCopier.copy("./test1.txt", "./test2.txt");
        }




    }

}