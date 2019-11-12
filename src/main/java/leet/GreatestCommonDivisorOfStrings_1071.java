package leet;

public class GreatestCommonDivisorOfStrings_1071 {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "AB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();

        int length = Math.min(str1Len, str2Len);

        for (int i=length; i > 0; i--) {

            if (str1Len%i != 0 || str2Len%i != 0) {
                continue;
            }

            String ls = str1.substring(0, i);

            int counter = Math.max(str1Len, str2Len) / i;

            boolean allMatched = true;

            for (int j=0; j < counter; j++) {

                int startIndex = j*i;
                int endIndex = startIndex + i;

                if (str1Len >= endIndex && !str1.substring(startIndex, endIndex).equals(ls)) {
                    allMatched = false;
                    break;
                }

                if (str2Len >= endIndex && !str2.substring(startIndex, endIndex).equals(ls)) {
                    allMatched = false;
                    break;
                }

            }

            if (allMatched) {
                return ls;
            }

        }

        return "";
    }
}
