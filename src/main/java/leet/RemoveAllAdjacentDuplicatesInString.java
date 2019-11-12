package leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("aaaaaaaa"));
        System.out.println(removeDuplicates("bbabaaaaaa"));


    }

    public static String removeDuplicates(String input) {
        Deque<Character> res = new ArrayDeque<>();
        for (Character c : input.toCharArray()) {
            if (!res.isEmpty() && res.peekLast() == c) {
                res.pollLast();
            } else {
                res.offer(c);
            }
        }
        return res.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String removeDuplicatesOriginal(String S) {
        char[] chars = S.toCharArray();

        ArrayList<Character> l = new ArrayList<>();

        for (int i=0; i < chars.length; i++) {
            l.add(chars[i]);
            int size = 0;
            while (i < chars.length-1 && (size = l.size()) > 0 && (l.get(size-1) == chars[i+1])) {
                l.remove(size-1);
                i++;
            }
        }

        return  l.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String removeDuplicatesAlternate(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
