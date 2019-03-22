package leet.week23;

/**
 * Created by sabaresh on 3/11/17.
 */
public class ReverseString2 {

    public static void main(String[] args) {

        ReverseString2 r = new ReverseString2();

        System.out.println(r.reverseStr("abcdefg", 2));
        System.out.println(r.reverseStr("a", 2));
    }

    public String reverseStr(String s, int k) {

        String result = "";
        int len = 2 * k;
        int counter = (s.length()/len) + ((s.length() % len) > 0 ? 1 : 0 );

        for(int i = 0; i < counter; i++ ) {
            int start = i*len;
            int end = (start + len) ;

            if(end > s.length()) {
                end = s.length();
            }
//            System.out.println(start +" "+end+" "+s.substring(start, end));
//            System.out.println(reverse(s.substring(start, end), k));
            result += reverse(s.substring(start, end), k);
        }
        return result;
    }

    public String reverse(String s, int k) {
        return s.length() > k ? new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k) : new StringBuilder(s).reverse().toString();
    }
}
