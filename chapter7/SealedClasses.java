
public sealed class Animal permits Dog, ArrayHandling {
    public static void main(String ...args) {
        System.out.println("Hello sealed class");
    }
}

public non-sealed class Dog extends Animal {

}