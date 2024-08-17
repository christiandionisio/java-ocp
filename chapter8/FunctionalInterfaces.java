
@FunctionalInterface
public interface Sprint {
   public void sprint(int speed);
   // public void walk(); // DOES NOT COMPILE
   /** 
    * Functional interfaces only allows to to contain exactly
    * one abstract method is known as Single Abstract Method (SAM)
   */
}
 
public class Tiger implements Sprint {
   public void sprint(int speed) {
      System.out.println("Animal is sprinting fast! " + speed);
   }
}