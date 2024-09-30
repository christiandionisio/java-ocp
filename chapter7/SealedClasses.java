
public sealed class Animal permits Dog {
    public static void main(String ...args) {
        System.out.println("Hello sealed class");
    }
}

public non-sealed class Dog extends Animal {

}

interface TestInterface {}
class TestClass {}
sealed interface Readable permits SubReadable, ClassA, Record1 {}
non-sealed interface SubReadable extends Readable {}
final class ClassA implements Readable {}
public record Record1() implements Readable, TestInterface {}