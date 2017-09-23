package leet.week47;

public class NonDecreasingArray {

    public static void main(String[] args) {
        NonDecreasingArray n = new NonDecreasingArray();
//        int i [] = new int[]{4,2,3};
//        System.out.println(n.checkPossibility(new int[]{4,2,3}) == true);
//        System.out.println(n.checkPossibility(new int[]{4,2,1}) == false);
//        System.out.println(n.checkPossibility(new int[]{3,4,2,3}) == false);
//        System.out.println(n.checkPossibility(new int[]{-1,4,2,3}) == true);

        System.out.println((String)null);

    }

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        } else if (nums.length ==1) {
            return true;
        }
        int counter = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if ( ! (i != (nums.length -1) && nums[i] <= nums[i+1])) {
                counter++;
                if( i == 0  || (i > 1 && nums[i-1] <= nums[i=1]) ) {
                    nums[i] = nums[i];
                } else {
                    return false;
                }
            }

            max = Integer.max(max, nums[i]);

            if (counter > 1) {
                return false;
            }
        }
        return counter <= 1 ;
    }



}
