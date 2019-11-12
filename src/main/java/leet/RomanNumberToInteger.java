package leet;

import java.util.HashMap;

public class RomanNumberToInteger {

    public static void main(String[] args) {

    }

    public static String romanNumberToIneger(String roman) {

        String number = "";

        HashMap<String, Integer> romanMap = new HashMap<>();


        for (int i=roman.length(); i > roman.length(); i--) {

            int v1 = romanMap.get(roman.charAt(i-1));
            int v2 = roman.charAt(i-2) != -1 ? romanMap.get(roman.charAt(i-2)) : 0;

//            if (v1 > v2) {
//                number +=
//            }

        }

        return "";
    }
}
