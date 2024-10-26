import java.util.*;

public class RecordsPractice {

    public static void main(String ...args) {
        
        // {
        //     record Student(int id, String ...subjects) {
        //         public Student {
        //             if(id<0) throw new IllegalArgumentException();
        //             if(subjects == null || subjects.length == 0) {
        //                 subjects = new String[] {"english"};
        //             }
        //         }
        //     }

        //     Student s = new Student(123, null);
        //     System.out.println(s);
        //     System.out.println(Arrays.toString(s.subjects));
        // }


        {
            // record Student(String ...subjects, int id) {    // this will not compile
            record Student(int id, String ...subjects) {
                static int rank;
                public int getRank() {
                    return rank;
                }

                static {    // allowed
                    rank = 10;
                }

                // { id = 10;} // instance initializer not allowe

                public Student {}
            }

            Student s = new Student(123, new String[]{"math" , "science"});
            System.out.println(s);
        }
    }

}