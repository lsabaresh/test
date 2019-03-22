package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sabaresh on 2/18/17.
 */
public class ContiguousArray {
    public static void main(String[] args) {
        ContiguousArray c = new ContiguousArray();
        int [] a = new int[] {0,1,0};
//        System.out.println(c.findMaxLength(a));
//        a = new int[] {0,1};
//        System.out.println(c.findMaxLength(a));
        a = new int[] {0,0,1,0,0,0,1,1,1};
        System.out.println(c.findMaxLength(a));
//        a = new int[] {1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1};
//        System.out.println(c.findMaxLength(a)); // 94
    }

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            System.out.println("i "+i+", val "+nums[i]+", sum "+sum);
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
                System.out.println("sum : "+sum+",max : "+max);
            }
            else {
                sumToIndex.put(sum, i);
            }
            System.out.println("sumToIndex "+sumToIndex);
        }



        return max;
    }

    public int findMaxLength1(int[] nums) {
        //if(nums == null || nums.length ==0) return 0;

        System.out.println("size : "+nums.length);

        int count = nums.length;
        int result = 0;

        for (int i=0; i < count; i++) {
            if(result > (count-i)) break;

            for (int j=(i+result+1); j < count; j++) {
                if(result > (j-i)) continue;
                int size = searchSubArray(Arrays.copyOfRange(nums, i, j+1));
                if(result < size) result = size;
            }
        }

//        for (int i=count-1; i >= 0; i--) {
//            for (int j=i-1; j >= 0; j--) {
//                System.out.println("i "+i +", j : "+j);
//                result += searchSubArray(Arrays.copyOfRange(nums, j, i+1));
//            }
//        }


        return result;
    }

    public int searchSubArray(int[] nums) {
        int count = nums.length;

//        System.out.println(Arrays.toString(nums));
        if((nums.length%2) != 0 ) return 0;

        int cntOf1= 0;
        int cntOf0= 0;

        for (int startPos=0; startPos < count; startPos++) {
            if(nums[startPos]==0)
                cntOf0++;
            else
                cntOf1++;
        }
        return  cntOf0 == cntOf1 ? nums.length : 0;
    }
}
