public class OverloadingPractice {

    public static void main(String ...args) {

        // {
        //     class TestClass {
        //         public void method(Object o) {
        //             System.out.println("Object Version");
        //         }
        //         public void method(java.io.FileNotFoundException s) {
        //             System.out.println("java.io.FileNotFoundException Version");
        //         }
        //         public void method(java.io.IOException s) {
        //             System.out.println("IOException Version");
        //         }
        //     }

        //     TestClass tc = new TestClass();
        //     tc.method(null);
        //     /** 
        //      * this will call method(java.io.FileNotFoundException s)
        //      * since null can be passed to al the three methods but FileNotFoundException
        //      * is more especific since Object -> IOException -> FileNotFoundException
        //      * if it had there been two most specific methods it would not compile
        //      * example String, and StringBuilder implementations
        //     */
        // }

        {
            class Baap {
                public int h = 4;
                public int getH() {
                    System.out.println("Baap " + h);
                    return h;
                }
            }

            class Beta extends Baap {
                public int h = 44;
                public int getH() {
                    System.out.println("Beta " + h);
                    return h;
                }
            }

            Baap b = new Beta();
            System.out.println(b.h + " " + ((Baap)b).getH());
            Beta bb = (Beta) b;
            System.out.println(bb.h + " " + bb.getH()); 
        }

    }

}