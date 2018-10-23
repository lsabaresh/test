package leet.w56;

import java.util.ArrayList;

public class StringCompression {

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.compress(new char[] {'a'}) == 1);
        System.out.println(s.compress(new char[] {'a','a','b','b','c','c','c'}) == 6);
        System.out.println(s.compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}) == 4);
        System.out.println(s.compress(new char[] {'a','b','c'}) == 3);
        System.out.println(s.compress(new char[] {'a','a'}) == 2);
    }

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        char p=1;
        int counter = 0,  uCounter=0;
        boolean reset = false;

        for (int i=0; i < chars.length;i++) {
            char c = chars[i];
            if (c != p && i !=0) {
                reset = true;
            } else  if (i == chars.length-1) {
                reset = true;
                counter++;
            }
            if (reset && counter > 0) {
                chars[uCounter]=p;
                char[] counterCharArray = (counter + "").toCharArray();
                if ( ! (counterCharArray.length == 1 && Integer.parseInt(counterCharArray[0]+"") == 1)) {
                    for (int j=0; j< counterCharArray.length;j++) {
                        chars[++uCounter] = counterCharArray[j];
                    }
                }
                if (c != p && i == chars.length-1) {
                    chars[++uCounter] = c;
                }

                counter = 0;
                reset = false;
                uCounter++;
            }
            counter++;
            p=chars[i];
        }
        return uCounter;
    }
}
