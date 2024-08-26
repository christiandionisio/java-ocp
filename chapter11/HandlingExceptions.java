public class HandlingExceptions {

    public static void main(String ...args) {

        // Order of operations
        {
            try (MyFileClass bookReader = new MyFileClass(1);
                MyFileClass movieReader = new MyFileClass(2)) {
                    System.out.println("Try Block");
                    throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Catch Block");
            } finally {
                System.out.println("Finally Block");
            }
        }

        // Applying effectively final
        {
            final var bookReader = new MyFileClass(4);
            // variables can be declare before bout must be
            // effectively final
            MyFileClass movieReader = new MyFileClass(5);
            try (bookReader;
                var tvReader = new MyFileClass(6);
                movieReader) {
                System.out.println("Try Block");
            } finally {
                System.out.println("Finally Block");
            }
        }

    }


    // Automatic resource management only aplies with classes
    // that impleements AutoCloseable
    public static class MyFileClass implements AutoCloseable {
        private final int num;
        public MyFileClass(int num) { this.num = num; }
        @Override public void close() {
            System.out.println("Closing: " + num);
        } 
    }

}