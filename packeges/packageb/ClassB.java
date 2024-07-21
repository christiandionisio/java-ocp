package packageb;

import packagea.ClassA;
public class ClassB {
   public static void main(String[] args) {
      ClassA a;
      System.out.println("Got it");
   }
}

// Para compilar los .class en otro directorio se puede usar "-d"
// javac -d classes packagea/ClassA.java packageb/ClassB.java