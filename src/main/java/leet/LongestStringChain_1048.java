package leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LongestStringChain_1048 {

    public static void main(String[] args) {

        System.out.println(isPredecessor("a", "ab"));
        System.out.println(isPredecessor("ba", "bca"));
        System.out.println(isPredecessor("grukmj", "grukkmj"));
        System.out.println(isPredecessor("ksqvsq", "ksqsq"));

        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));

        System.out.println(longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
    }

    public static int longestStrChain(String[] words) {
        int[] maxLen = new int[words.length];

//        Comparator<String> comparator = (a, b) -> a.length() - b.length();

        Arrays.sort(words, Comparator.comparing(String::length));

//        System.out.println(Arrays.stream(words).collect(Collectors.toList()));

        int res = 0;
        for (int i=0; i < words.length; i++) {
            int max = 0;

            for (int j=0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    max = Math.max(max, maxLen[j]);
                }
            }

            maxLen[i] = max + 1;
            res = Math.max(res, maxLen[i]);
        }

        return res;
    }

    public static boolean isPredecessor(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length()+1 != word2.length()) {
            return false;
        }
//        if (word1 == null || word2 == null || (word1.length()+1 != word2.length() && word1.length() != word2.length()+1)) {
//            return false;
//        }

//        if (word1.length() > word2.length()) {
//            String tmp = word1;
//            word1 = word2;
//            word2 = tmp;
//        }

//        char[] chars1 = word1.toCharArray();
//        char[] chars2 = word2.toCharArray();
//
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//
//        word1 = String.copyValueOf(chars1);

//
//        for (Character c : chars2) {
//            if (!word1.contains(String.valueOf(c))) {
//                return word1.equals(word2.replace(c+"", ""));
//            }
//        }

        for (Character c : word1.toCharArray()) {
            word2 = word2.replaceFirst(c+"", "");
        }

        return word2.length() == 1;
    }
}
