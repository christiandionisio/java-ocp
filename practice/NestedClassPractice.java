public class NestedClassPractice {

    public static void main(String ...args) {

        // {
        //     class Onion {
        //         private String data = "skin";

        //         private class Layer extends Onion {
        //             String data = "thegoodpart";
        //             public String getData() {
        //                 return data;
        //             }
        //         }

        //         public String getData() {
        //             return new Layer().getData();
        //         }
        //     }

        //     var o = new Onion();
        //     System.out.println(o.getData());
        // }

        // Inner class in methods
        {
            class InnerA {
                int a;
                public void someMethod() {
                    a = 7;
                    System.out.println("InnerA, someMethod");
                    int b = 1;
                    // b = 4;  // will not compile because local variable must be final or effectively final
                    class InnerB {
                        private void someMethodB() {
                            InnerA.this.a = 10;
                            System.out.println("InnerB someMethodB");
                            System.out.println("InnerA " + InnerA.this.a);      // compiles
                            System.out.println("InnerA " + a);
                            System.out.println("InnerB " + b);
                        }
                    }
                    InnerB ib = new InnerB();
                    ib.someMethodB();
                    System.out.println("End someMethod InnerA");
                }
            }

            InnerA ia = new InnerA();
            ia.someMethod();
        }

    }



}