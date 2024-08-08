public class VarArgsHandling {

    /**
     * Rules for Creating a Method with a Varargs Parameter 
     * 1) A method can have at most one varargs parameter. 
     * 2) If a method contains a varargs parameter, 
     * it must be the last parameter in the list.
     **/

    public static void main(String ...args) {
        // Calling methods with varargs
        /** 
         * You can pass in an array, 
         * or you can list the elements of the array and 
         * let Java create it for you.
        */

        // Pass an array
        int[] data = new int[] {1, 2, 3};
        walk1(data);
        
        // Pass a list of values
        walk1(1,2,3);

    }

    public static void walk1(int... steps) {
        int[] step2 = steps; // Not necessary, but shows steps is of type int[]
        System.out.print(step2.length);
    }
    public void walk2(int start, int... steps) {}
    // public void walk3(int… steps, int start) {}    // DOES NOT COMPILE
    // public void walk4(int… start, int… steps) {}   // DOES NOT COMPILE

}