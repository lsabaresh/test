package leet;

public class GrumpyBookstoreOwner_1052 {

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }

    public static int maxSatisfiedOriginal(int[] customers, int[] grumpy, int X) {
        int customerLength = customers.length;
        int result = 0;
        for (int i = 0; i < customerLength; i++) {
            int noOfCustomers = 0;
            if (i + X <= customerLength) {
                for (int j = 0; j < customerLength; j++) {
                    if (grumpy[j] == 0 || (j >= i && j < i + X)) {
                        noOfCustomers += customers[j];
                    }
                }
            }
            result = Math.max(result, noOfCustomers);
        }
        return result;
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfy = 0, max = 0;
        for (int i = 0, win = 0; i < grumpy.length; ++i) {
            satisfy += grumpy[i] == 0 ? customers[i] : 0;
            win += grumpy[i] == 1 ? customers[i] : 0;
            if (i >= X) {
                win -= grumpy[i - X] == 1 ? customers[i - X] : 0;
            }
            max = Math.max(win, max);
        }
        return satisfy + max;
    }
}
