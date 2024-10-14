public class NestedClassPractice {

    public static void main(String ...args) {

        class Onion {
            private String data = "skin";

            private class Layer extends Onion {
                String data = "thegoodpart";
                public String getData() {
                    return data;
                }
            }

            public String getData() {
                return new Layer().getData();
            }
        }

        var o = new Onion();
        System.out.println(o.getData());

    }

}