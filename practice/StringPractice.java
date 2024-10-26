public class StringPractice {

    public static void main(String ...args) {

        // {
        //     String myStr = "good";
        //     char[] myCharArr = {'g', 'o', 'o', 'd'};

        //     String newStr = null;
        //     for(char ch: myCharArr) {
        //         newStr = newStr + ch;
        //     }

        //     System.out.println(newStr + " " + myStr);
        //     System.out.println((newStr == myStr) + " " + (newStr.equals(myStr)));
        // }

        // // StingBuilder setLength
        // {
        //     StringBuilder sb = new StringBuilder("12345678");
        //     sb.setLength(5);
        //     System.out.println(sb);
        //     sb.setLength(10);
        //     System.out.println(sb);
        //     System.out.println(sb.length());
        //     sb.append("h");
        //     System.out.println(sb);

        // }

        // // StringBuilder replace method
        // {
        //     StringBuilder sb = new StringBuilder("hello world");
        //     // sb.replace(5,14," java ");  // compiles
        //     sb.replace(5,6," java ");
        //     System.out.println(sb);
        // }

        
        // String chars
        {
            String s = "hello world";
            // s.chars().forEach(i -> System.out.println((char)i));
            s.codePoints().forEach(i -> System.out.println((char)i));
        }

    }

}