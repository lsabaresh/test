package leet.w76;

import java.util.Arrays;

public class MinimumSwaps {


//    We have two integer sequences A and B of the same non-zero length.
//
//    We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
//
//    At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
//
//    Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
//
//            Example:
//    Input: A = [1,3,5,4], B = [1,2,3,7]
//    Output: 1
//    Explanation:
//    Swap A[3] and B[3].  Then the sequences are:
//    A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
//    which are both strictly increasing.


    public static void main(String[] args) {
//        System.out.println(minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7})==1);
        System.out.println(minSwap(new int[]{0,4,4,5,9}
                                  ,new int[]{0,1,6,8,10})==1);
    }

    public static int minSwap(int[] A, int[] B) {
        int swaps = 0;
        for (int i=1; i < A.length; i++) {
            if ( A[i] <= A[i-1] || B[i] <= B[i-1]) {
                System.out.println(i + " "+A[i] +" "+B[i]);
                int t = A[i];
                A[i] = B[i];
                B[i] = t;
                swaps++;

            }
        }
        Arrays.stream(A).forEach( i -> System.out.print(i +" "));
        System.out.print(" , ");
        Arrays.stream(B).forEach( i -> System.out.print(i +" "));
        System.out.print(" : "+ swaps+ " ");
        return swaps;
    }
}
