public class GenericsPractice {

    public static void main(String ...args) {

        // {
        //     class Counter<T> {
        //         T[] arr;
        //         T t;
        //         // public <T> int count(T[] ta, T t) {     // <T> makes parameter independent of the class
        //         public int count(T[] ta, T t) {
        //             this.t = t;
        //             int count = 0;
        //             for(T x : ta) {
        //                 count = x == t ? count+1: count;
        //             }
        //             return count;
        //         }
        //     }
        // }

        {
            class TestClass<T> {
                T t;

                public void someMethod(T t) {}  // expected T type of class definition
                public T someMethod2(T t) {return this.t;}  // expects T type of class definition
                public <T> T someMethod3(T[] t) {return t[0];}  // expects any kind of Object
            }

            // class ChildClass<U> extends TestClass<U> {  // compiles
            // class ChildClass<String> extends TestClass<String> {  // compiles
            // class ChildClass extends TestClass<int> {  // not compile
            class ChildClass extends TestClass<String> {  // not compile
                @Override
                public void someMethod(String s) {}
                // @Override   // not valid, must be the same type of the class generic
                public void someMethod(int s) {}    // this is an overload
                @Override
                public <Long> Long someMethod3(Long[] l) {return l[0];} // must have <Long> to override
            }

            TestClass<String> testClass = new TestClass<>();
            String t = "hello";
            Integer v = 5;
            Integer arr[] = new Integer[]{0,1,2};
            String arrStr[] = new String[]{"a", "b", "c"};
            testClass.someMethod(t);
            // testClass.someMethod(v);    // not compile
            testClass.someMethod2(t);
            // testClass.someMethod2(v);       // not compile
            testClass.someMethod3(arr);
            testClass.someMethod3(arrStr);
        }

    }

}