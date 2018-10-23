package algorithm;

import java.util.stream.IntStream;

public class MinNoOfCoins {


    public static void main(String[] args) {
        System.out.println("Recursive {25, 10, 5} - 2 (25+5): "+findMinNoOfCoins(new int[]{25, 10, 5}, 30));
        System.out.println("Recursive {9, 6, 5, 1} - 2 (6+5): "+findMinNoOfCoins(new int[]{9, 6, 5, 1}, 11));

        System.out.println("Iterative {25, 10, 5} - 2 (25+5): "+findMinNoOfCoinsByIterative(new int[]{25, 10, 5}, 30));
        System.out.println("Iterative {9, 6, 5, 1} - 2 (6+5): "+findMinNoOfCoinsByIterative(new int[]{9, 6, 5, 1}, 11));
    }


    public static int findMinNoOfCoinsByIterative(int[] coins, int v) {
        if (v==0) return 0;
        int min[] = new int[v+1];
        min[0] = 0;

        IntStream.range(1, v+1).forEach( i -> min[i] = Integer.MAX_VALUE);

        for (int i = 1; i <= v; i++) {
            for (int j=0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    int sub_res = min[i - coins[j]];
                    if (sub_res !=  Integer.MAX_VALUE && sub_res + 1 < min[i]) {
                        min [i] = sub_res + 1;
                    }
                }
            }
        }

        return min[v];
    }


    public static int findMinNoOfCoins(int[] coins, int v) {
        if (v <= 0) return 0;
        int r = Integer.MAX_VALUE;
        for (int i=0; i < coins.length; i++) {
            if (coins[i] <= v) {
                int n = findMinNoOfCoins(coins, v - coins[i]);
                if ( n != Integer.MAX_VALUE && (n + 1) < r) {
                    r = n + 1;
                }
            }
        }
        return r;
    }

}
