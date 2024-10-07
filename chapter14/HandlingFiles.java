import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.stream.*;
import java.util.*;

public class HandlingFiles {
    public static void main(String ...args) throws IOException, ClassNotFoundException {

        // // Creating a File
        // {
        //     File zooFile1 = new File("./stripes.txt");
        //     System.out.println(zooFile1.exists());
        // }

        // // Creating a Path
        // {
        //     Path zooPath1 = Path.of("./stripes.txt");
        //     Path zooPath2 = Paths.get("./stripes.txt");
        //     System.out.println(Files.exists(zooPath1));
        // }

        // // Switching between File and Path
        // {
        //     File file = new File("rabbit");
        //     Path nowPath = file.toPath();
        //     File backToFile = nowPath.toFile();
        // }

        // // Obtaining a Path from the FileSystems Class
        // {
        //     Path zooPath1 = FileSystems.getDefault()
        //         .getPath("./stripes.txt");
        //     Path zooPath2 = FileSystems.getDefault()
        //         .getPath("./", "stripes.txt");
        //     System.out.println(Files.exists(zooPath2));
        // }

        // {
        //     // io();
        //     nio();
        // }


        // // Viewing a Path
        // {
        //     Path path = Paths.get("/land/hippo/harry.happy");
        //     System.out.println("The Path Name is: " + path);
        //     for(int i=0; i<path.getNameCount(); i++)
        //         System.out.println("   Element " + i + " is: " + path.getName(i));
        // }


        // // Creating part of the path
        // {
        //     var p = Paths.get("/mammal/omnivore/raccoon.image");
        //     System.out.println("Path is: " + p);
        //     for (int i = 0; i < p.getNameCount(); i++) {
        //         System.out.println("   Element " + i + " is: " + p.getName(i));
        //     }
        //     System.out.println();
        //     System.out.println("subpath(0,3): " + p.subpath(0, 3));
        //     System.out.println("subpath(1,2): " + p.subpath(1, 2));
        //     System.out.println("subpath(1,3): " + p.subpath(1, 3));

        //     // var q = p.subpath(0, 4); // IllegalArgumentException
        //     // var x = p.subpath(1, 1); // IllegalArgumentException
        // }


        // // Accessing Path Elements
        // {
        //     printPathInformation(Path.of("zoo"));
        //     printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
        //     printPathInformation(Path.of("./armadillo/../shells.txt"));
        // }


        // // Resolving paths
        // {
        //     Path path1 = Path.of("/cats/../panther");
        //     Path path2 = Path.of("food"); // if this don't have the abosulute path, it concatenates path 1 with path 2
        //     System.out.println(path1.resolve(path2));

        //     Path path3 = Path.of("/turkey/food");
        //     System.out.println(path3.resolve("/tiger/cage")); // if this have root path it will return only the given path
        // }

        
        // // Relativizing a path
        // {
        //     var path1 = Path.of("./fish.txt");
        //     var path2 = Path.of("friendly/birds.txt");
        //     System.out.println(path1.relativize(path2));
        //     System.out.println(path2.relativize(path1));

        //     Path path3 = Paths.get("/habitat");
        //     Path path4 = Paths.get("/sanctuary/raven/poe.txt");
        //     System.out.println(path3.relativize(path4));
        //     System.out.println(path4.relativize(path3));

        //     // Path path1 = Paths.get("/primate/chimpanzee");
        //     // Path path2 = Paths.get("bananas.txt");
        //     // path1.relativize(path2); // IllegalArgumentException

        //     Path path5 = Paths.get("/habitat/room/../bed");
        //     Path path6 = Paths.get("/sanctuary/raven/poe.txt");
        //     System.out.println(path5.relativize(path6));
        //     System.out.println(path6.relativize(path5));

        //     // this method only works for both paths whether both are relatives
        //     // or both are absolutes, both must be the same type of path
        //     // or there will be an IllegalArgumentException
        // }


        // // Normalizing path
        // {
        //     var p1 = Path.of("./armadillo/../shells.txt");
        //     p1 = Path.of("./armadillo/../shells.txt");
        //     System.out.println(p1.normalize()); // shells.txt
            
        //     var p2 = Path.of("/cats/../panther/food");
        //     System.out.println(p2.normalize()); // /panther/food
            
        //     var p3 = Path.of("../../fish.txt");
        //     System.out.println(p3.normalize()); // ../../fish.txt
        // }
        // {
        //     var p1 = Paths.get("/pony/../weather.txt");
        //     var p2 = Paths.get("/weather.txt");
        //     System.out.println(p1.equals(p2)); // false
        //     System.out.println(p1.normalize().equals(p2.normalize())); // true
        // }


        // // Real file system path
        // {
        //    System.out.println(Paths.get(".").toRealPath());
        // }


        // // Create directory
        // {
        //     Files.createDirectory(Path.of("./bison/field")); // Exception when the predirectory is nort created
        //     // Files.createDirectories(Path.of("./bison/field/pasture/green"));
        // }

        // // Reading files
        // {
        //     Files.readAllLines(Paths.get("./stripes.txt")).forEach(System.out::println); // return List<String>
        //     Files.lines(Paths.get("./stripes.txt")).forEach(System.out::println); // return Stream<String>
        // }


        // // Copy data
        // {
        //     copyPath(Paths.get("./stripes.txt"), Paths.get("./copy.txt"));
        // }


        // {
        //     try (var in = new FileInputStream("zoo.txt")) {
        //         System.out.println("Found file!");
        //     } catch (FileNotFoundException e) {
        //         System.err.println("File not found!");
        //     }
        // }
        // {
        //     var reader = new BufferedReader(new InputStreamReader(System.in));
        //     String userInput = reader.readLine();
        //     System.out.println("You entered: " + userInput);

        // }
        // {
        //     try (var out = System.out) {}
        //     System.out.println("Hello"); // Prints nothing
        // }
        // {
        //     try (var err = System.err) {}
        //     System.err.println("Hello"); // Prints nothing
        // }
        // {
        //     var reader = new BufferedReader(new InputStreamReader(System.in));
        //     try (reader) {}
        //     String data = reader.readLine(); // IOException
        // }


        // {
        //     Console console = System.console();
        //     if (console == null) {
        //         throw new RuntimeException("Console not available");
        //     } else {
        //         console.writer().println("Welcome to Our Zoo!");
        //         console.format("It has %d animals and employs %d people", 391, 25);
        //         console.writer().println();
        //         console.printf("The zoo spans %5.1f acres", 128.91);
        //     }
        // }
        // {
        //     Console console = System.console();
        //     if (console == null) {
        //         throw new RuntimeException("Console not available");
        //     } else {
        //         String name = console.readLine("Please enter your name: ");
        //         console.writer().format("Hi %s", name);
        //         console.writer().println();
                
        //         console.format("What is your address? ");
        //         String address = console.readLine();
                
        //         char[] password = console.readPassword("Enter a password "
        //             + "between %d and %d characters: ", 5, 10);
        //         char[] verify = console.readPassword("Enter the password again: ");
        //         console.printf("Passwords "
        //             + (Arrays.equals(password, verify) ? "match" : "do not match"));
        //     }
        // }


        // // Retrieving attributes
        // {
        //     var path = Paths.get("./stripes.txt");
        //     BasicFileAttributes data = Files.readAttributes(path,
        //         BasicFileAttributes.class);
            
        //     System.out.println("Is a directory? " + data.isDirectory());
        //     System.out.println("Is a regular file? " + data.isRegularFile());
        //     System.out.println("Is a symbolic link? " + data.isSymbolicLink());
        //     System.out.println("Size (in bytes): " + data.size());
        //     System.out.println("Last modified: " + data.lastModifiedTime());
        // }

        // // Modifying Attributes
        // {
        //     // Read file attributes
        //     var path = Paths.get("./stripes.txt");
        //     BasicFileAttributeView view = Files.getFileAttributeView(path,
        //         BasicFileAttributeView.class);
        //     BasicFileAttributes attributes = view.readAttributes();
            
        //     // Modify file last modified time
        //     FileTime lastModifiedTime = FileTime.fromMillis(
        //         attributes.lastModifiedTime().toMillis() + 10_000);
        //     view.setTimes(lastModifiedTime, null, null);
        // }


        // // Walking a Directory
        // {
        //     var size = getPathSize(Path.of("/Users/christiandionisio/Desktop/javaOCP"));
        //     System.out.format("Total Size: %.2f megabytes", (size/1000000.0));
        // }



        // // Searching a directory
        // {
        //     Path path = Paths.get("/Users/christiandionisio/Desktop/javaOCP");
        //     long minSize = 1_000;
        //     try (var s = Files.find(path, 10,
        //         (p, a) -> a.isRegularFile()
        //             && p.toString().endsWith(".java")
        //             && a.size() > minSize)) {
        //     s.forEach(System.out::println);
        //     }
        // }

        // { 
        //     RandomAccessFile raf = new RandomAccessFile("file.txt", "rw"); 
        //     // raf.seek( raf.length() ); 
        //     // raf.writeChars("FINAL TEXT");
        //     System.out.println(raf.readLine());
        //     System.out.println(raf.readLine());
        // }

        // {
        //     Path p1  = Paths.get("/../temp/./test.txt");
        //     System.out.println(p1.normalize());             // /temp/test.txt
        //     System.out.println(p1.normalize().toUri());     // file:///temp/test.txt
        // }


        // {
        //     var bfr = new BufferedReader(new FileReader("./a.txt"));
        //     // var bfw = new BufferedWriter(new FileWriter("./b.txt", true));   // true continues to write file without overriding
        //     var bfw = new BufferedWriter(new FileWriter("./b.txt", true));

        //     String line = null;
        //     while((line = bfr.readLine()) != null) {
        //         bfw.append(line);
        //     }

        //     // bfw.flush();    // makes the content in buffer writes to the file
        //     bfw.close();    // makes a flush automatically before closing the buffer
        //     bfw.close();
        // }

        {
            class Person implements Serializable {
                String name;
                Person(String name) {
                    this.name = name;
                }
            }

            class Student extends Person {
                // String school;
                transient String school;
                public Student(String name, String school) {
                    super(name);
                    this.school = school;
                }

                public String toString() {
                    return name + " " + school;
                }

                private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
                    stream.defaultReadObject();
                    school = "LALALALALALA";
                }
            }

            Person p = new Student("Bob Dylan", "NYU");
            try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"))) {
                    oos.writeObject(p);
                    oos.flush();
                    System.out.println((Student) ois.readObject());     // ClassNotFoundException and IOExceeption could be thrown
            }
        }

    }

    public static void io() {
       var file = new File("./stripes.txt");
       if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println("   " + subfile.getName());
                } 
            } 
        } 
    }

    public static void nio() throws IOException {
        var path = Path.of("./stripes.txt");
        if (Files.exists(path)) {
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: " 
                    + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println("   " + p.getFileName()));
                } 
            } 
        } 
    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("   Root is: " + path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null)
            System.out.println("   Current parent is: " + currentParent);
        System.out.println();
    }

    private static void copyPath(Path input, Path output) throws IOException {
        try (var reader = Files.newBufferedReader(input);
            var writer = Files.newBufferedWriter(output)) {
        
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } 
    }

    // private long getSize(Path p) {
    //     try {
    //         return  Files.size(p);
    //     } catch (IOException e) {
    //         throw new UncheckedIOException(e);
    //     }
    // }
    
    // public long getPathSize(Path source) throws IOException {
    //     try (var s = Files.walk(source)) {
    //         return s.parallel()
    //                 .filter(p -> !Files.isDirectory(p))
    //                 .mapToLong(this::getSize)
    //                 .sum();
    //     }
    // }
}