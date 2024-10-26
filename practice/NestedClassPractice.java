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

        // // Inner class in methods
        // {
        //     class InnerA {
        //         int a;
        //         public void someMethod() {
        //             a = 7;
        //             System.out.println("InnerA, someMethod");
        //             int b = 1;
        //             // b = 4;  // will not compile because local variable must be final or effectively final
        //             class InnerB {
        //                 private void someMethodB() {
        //                     InnerA.this.a = 10;
        //                     System.out.println("InnerB someMethodB");
        //                     System.out.println("InnerA " + InnerA.this.a);      // compiles
        //                     System.out.println("InnerA " + a);
        //                     System.out.println("InnerB " + b);
        //                 }
        //             }
        //             InnerB ib = new InnerB();
        //             ib.someMethodB();
        //             System.out.println("End someMethod InnerA");
        //         }
        //     }

        //     InnerA ia = new InnerA();
        //     ia.someMethod();
        // }


        // // Instantiating InnerClass
        // {
        //     class TestOuter {
        //         public void myOuterMethod() {
        //             new TestInner();
        //             this.new TestInner();
        //             new TestOuter().new TestInner();

        //             new TestStaticInner();
        //             new TestOuter.TestStaticInner();
        //             // this.TestStaticInner();     // invalid for static nested class
        //         }

        //         public class TestInner {}
        //         public static class TestStaticInner {}
        //     }

        //     var to = new TestOuter();
        //     to.new TestInner();
        //     new TestOuter(). new TestInner();

        //     // to.TestStaticInner();   // Invalid
        //     new TestOuter.TestStaticInner();
        // }


        {
            class TestClass {
                static int val = 10;
                int b = 10;
                public static int reduce(int val) {
                    class Inner {
                        public int reduce(int mval) {
                            // return mval-val--;
                            return mval-TestClass.val;
                        }
                    }
                    // val--;
                    return new Inner().reduce(val);
                }
            }

            System.out.println(TestClass.reduce(5));
            System.out.println(TestClass.val);
        }

    }



}