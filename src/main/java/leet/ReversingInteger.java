package leet;

public class ReversingInteger {

    public static void main(String[] args) {
//        System.out.println(reverseInteger(1));
//        System.out.println(reverseInteger(10));
        System.out.println(reverseInteger(155));
    }

    public  static String reverseIntegerSimple(int i) {

        String s = i+"";

        String result = "";
        for (int len = s.length(); len > 0; len--) {
            result += s.charAt(len-1);
        }

        return result;
    }

    public static int reverseInteger(int x) {

        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
//            if (INT_MAX / 10 < res || (INT_MAX - x % 10) < res * 10) {
//                return 0;
//            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return sign * res;
    }
}
