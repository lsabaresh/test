package leet.week22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sabaresh on 3/5/17.
 */
public class BlackPixel {

    public static void main(String[] args) {
        BlackPixel b = new BlackPixel();

        char[][] picture = new char[][] {
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'W', 'B', 'W', 'B', 'W'}
        };

        System.out.println(b.findBlackPixel(picture, 3));
    }

    public int findBlackPixel(char[][] picture, int N) {
        int blackPixel = 0;

        int []rows = new int [picture.length];
        int []columns = new int [picture[0].length];

        ArrayList<String> rowList = new ArrayList<>();

        for(int row = 0; row < picture.length; row++) {
            char []colArray = picture[row];
            String rowString = "";
            for(int col = 0; col < colArray.length; col++) {
                if(colArray[col] == 'B') {
                    rows[row]++;columns[col]++;
                }
                rowString = rowString+String.valueOf(colArray[col]);
            }
            rowList.add(rowString);
        }

        System.out.println(rowList);

        ArrayList<Integer> resultList = new ArrayList<>();
//
//        Map<Integer, Integer> m = new HashMap<>();
//
//        m.getOrDefault()



        for(int row = 0; row < picture.length; row++) {
            char []colArray = picture[row];
            for(int col = 0; col < colArray.length; col++) {
                int blackRowCount=0;
                if(colArray[col] == 'B' && rows[row] == N && columns[col] == N && !resultList.contains(col)) {
                    blackRowCount++;
                    if(N == 1) {
                        blackPixel+=N;
                        resultList.add(col);
                        break;
                    }
                    for(int j = row+1; j < picture.length; j++) {
                        if(picture[j][col] == 'B' && rowList.get(row).equals(rowList.get(j))) {
                            blackRowCount++;
                            if(blackRowCount == N) {
                                blackPixel+=N;
                                resultList.add(col);
                                break;
                            }
                        }
                    }
                }


            }


        }


        return blackPixel;
    }
}
