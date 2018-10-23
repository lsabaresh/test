package leet.w52;

public class RepeatedStringMatch {

//  Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
//
//  For example, with A = "abcd" and B = "cdabcdab".
//
//  Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
    public static void main(String[] args) {
        RepeatedStringMatch r = new RepeatedStringMatch();
        System.out.println(r.repeatedStringMatch("abcd", "cdabcdab") == 3);
        System.out.println(r.repeatedStringMatch("aa", "a") == 1);
        System.out.println(r.repeatedStringMatch("aa", "z") == -1);
        System.out.println(r.repeatedStringMatch("a", "aa") == 2);
        System.out.println(r.repeatedStringMatch("bb", "bbbbbbb") == 4);
        System.out.println(r.repeatedStringMatch("abababaaba", "aabaaba") == 2);

    }

    public int repeatedStringMatch(String A, String B) {
//        if ( (A.length() > B.length() && !A.contains(B))  || (B.length() > A.length() && !B.contains(A))) {
//            return -1;
//        }
        int total = 0;
        String tmp = "";
        do {
            total++;
            tmp+=A;
            if ( tmp.length() > 20000) {
                return -1;
            }
        } while (!tmp.contains(B));
        return total;
    }
}
