package leet.Week21;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sabaresh on 2/25/17.
 */
public class ContinuousSubarraySum {

    public static void main(String[] args) {

        ContinuousSubarraySum c = new ContinuousSubarraySum();

        int[] nums = null;
        int target = 0;

//        nums = new int[]{23, 2, 4, 6, 8};
        nums = new int[]{23, 1};
        target = 6;

        System.out.println(c.checkSubarraySum(nums, target));
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> runningSumMap = new HashMap<>();
        runningSumMap.put(0,-1);
        int runningTotal = 0;

        for(int i = 0; i < nums.length; i++) {

            runningTotal += nums[i];
            runningTotal %= k;

            if(runningSumMap.containsKey(runningTotal)) {
                    if( ( i - runningSumMap.get(runningTotal)) > 1 ) return true;
            } else {
                runningSumMap.put(runningTotal, i);
            }
        }

        return false;

    }
}
