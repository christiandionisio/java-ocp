import java.util.*;

public class RecordsPractice {

    public static void main(String ...args) {
        
        {
            record Student(int id, String ...subjects) {
                public Student {
                    if(id<0) throw new IllegalArgumentException();
                    if(subjects == null || subjects.length == 0) {
                        subjects = new String[] {"english"};
                    }
                }
            }

            Student s = new Student(123, null);
            System.out.println(s);
            System.out.println(Arrays.toString(s.subjects));
        }
    }

}