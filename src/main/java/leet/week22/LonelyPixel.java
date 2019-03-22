package leet.week22;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sabaresh on 3/4/17.
 */
public class LonelyPixel {

    public static void main(String[] args) {

        LonelyPixel l = new LonelyPixel();

        char[][] input = new char[][]  {{'W', 'W', 'B'},
                                        {'W', 'B', 'W'},
                                        {'B', 'W', 'W'}};

       input = new char[][]  {{'B', 'B', 'B'}};

        System.out.println(l.findLonelyPixel(input));
    }

    public int findLonelyPixel(char[][] picture) {

        int []rows = new int [picture.length];
        int []columns = new int [picture[0].length];

        for(int row = 0; row < picture.length; row++) {
            char []colArray = picture[row];
            for(int col = 0; col < colArray.length; col++) {
                if(colArray[col] == 'B') {
                   rows[row]++;columns[col]++;
                }
            }
        }

        int  lonelyPair = 0;

        for(int row = 0; row < picture.length; row++) {
            char []colArray = picture[row];
            for(int col = 0; col < colArray.length && rows[row] > 0; col++) {
                if(colArray[col] == 'B' && rows[row] == 1 && columns[col] ==1) {
                    lonelyPair++;
                }
            }
        }

        return lonelyPair;
    }
}
