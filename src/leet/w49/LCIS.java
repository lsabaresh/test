package leet.w49;

public class LCIS {


    public static void main(String[] args) {

        LCIS l = new LCIS();

        int[] nums = null;
        int target = 0;

        nums = new int[]{23, 2, 4, 6, 8};
//        nums = new int[]{23, 1};

        System.out.println(l.findLengthOfLCIS(nums));
        System.out.println(l.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(l.findLengthOfLCIS(new int[]{2,2,2,2}));

    }

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 1, currentSubSequenceLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                currentSubSequenceLength++;
            } else {
                currentSubSequenceLength = 1;
            }
            maxLength = Integer.max(maxLength, currentSubSequenceLength);
        }
        return maxLength;
    }


}
