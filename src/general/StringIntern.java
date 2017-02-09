package general;

/**
 * Created by Sabaresh on 5/22/2016.
 */
public class StringIntern {

    public static final void main(String []args) {

        String s3 = new String("Test");
        final String s4 = s3.intern();

        String s1 = "Test";
        String s2 = "Test";

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
//        System.out.println(s1.equals(s2));
//        System.out.println(s2.equals(s3));
//        System.out.println(s3.equals(s4));
//        System.out.println(s1.equals(s4));
//        System.out.println(s1.equals(s3));
    }
}
