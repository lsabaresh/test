package leet.w51;

import java.util.*;

public class NextClosestTime {

    public static void main(String[] args) {
        NextClosestTime n = new NextClosestTime();
        System.out.println(n.nextClosestTime("19:34").equalsIgnoreCase("19:39"));
        System.out.println(n.nextClosestTime("23:59").equalsIgnoreCase("22:22"));
    }

    public String nextClosestTime(String time) {
        String output = "";

        char[] chars = time.toCharArray();

//        LinkedList<Integer> list = new LinkedList<>();
//
////        list.removeLast()

        int hour = Integer.valueOf(time.substring(0, 2));
        int min = Integer.valueOf(time.substring(3));

        Set<Integer> hourDigits = new HashSet<>();
        Set<Integer> minDigits = new HashSet<>();
        for(char c : chars) {
            int num = Character.getNumericValue(c);
            if (num < 3) {
                hourDigits.add(num);
            }
            minDigits.add(num);
        }

        if (hour < 10) {
            if(hourDigits.contains(0)){
                output += "0";
            }
        }
        else if (hour > 9 && hour <20 ) {
            if(hourDigits.contains(1)){
                output += "1";
            } else if(hourDigits.contains(2)){
                output += "2";
            }
        }



        return output;
    }
}
