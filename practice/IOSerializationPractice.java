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

        // DyrectoryStream  iterates files
        {
            Path dir = Paths.get("./");

            try {
                DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.{java,ser}");
                for(Path p: ds) {
                    System.out.println(p);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }


    }

}