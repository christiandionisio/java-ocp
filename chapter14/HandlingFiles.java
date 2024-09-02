import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.util.stream.*;

public class HandlingFiles {
    public static void main(String ...args) throws Exception {

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


        // Viewing a Path
        // {
        //     Path path = Paths.get("/land/hippo/harry.happy");
        //     System.out.println("The Path Name is: " + path);
        //     for(int i=0; i<path.getNameCount(); i++)
        //         System.out.println("   Element " + i + " is: " + path.getName(i));
        // }


        // Creating part of the path
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


        // Accessing Path Elements
        // {
        //     printPathInformation(Path.of("zoo"));
        //     printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
        //     printPathInformation(Path.of("./armadillo/../shells.txt"));
        // }


        // Resolving paths
        // {
        //     Path path1 = Path.of("/cats/../panther");
        //     Path path2 = Path.of("food");
        //     System.out.println(path1.resolve(path2));

        //     Path path3 = Path.of("/turkey/food");
        //     System.out.println(path3.resolve("/tiger/cage"));
        // }

        
        // Relativizing a path
        // {
        //     var path1 = Path.of("fish.txt");
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
        // }


        // Normalizing path
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


        // Real file system path
        {
           System.out.println(Paths.get(".").toRealPath());
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
}