public class InstanceOfPractice {

    public static void main(String ...args) {

        // Pattenn variable
        {

            class A {
                void a() {System.out.println("a");}
            }
            class B extends A {
                void b() {System.out.println("b");}
            }
            class C extends B {
                void c() {System.out.println("c");}
            }

            B b = new C();
            A a = b;

            if(a instanceof B b1) b1.a();   // instanceof takes the object initialized
            if(a instanceof C c1) c1.c();   // with pattern variable instanceof must be sub class
            // if(a instanceof A a1) a1.a();   // this not compiles
            if(!(a instanceof B b3)) ;
            else { b3.a();}

            if(a instanceof B b1) {
                b1.b();
                if(b1 instanceof C c1) {
                    c1.c();
                }
            }

        }
        
    }


}