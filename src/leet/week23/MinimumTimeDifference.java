package leet.week23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sabaresh on 3/11/17.
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {

        MinimumTimeDifference m = new MinimumTimeDifference();

        List<String> l = new ArrayList<>(Arrays.asList("23:59","00:00"));

        System.out.println(m.findMinDifference(l));
        System.out.println(m.findMinDifference(new ArrayList<>(Arrays.asList("01:01","02:01","03:00"))));
        System.out.println(m.findMinDifference(new ArrayList<>(Arrays.asList("12:01","23:59"))));
        System.out.println(m.findMinDifference(new ArrayList<>(Arrays.asList("12:12","00:13"))));
        System.out.println(m.findMinDifference(new ArrayList<>(Arrays.asList("05:31","22:08","00:35"))));
    }

    public int findMinDifference(List<String> timePoints) {

        List<Integer> minutes = new ArrayList<>();

        for (String t : timePoints) {
            int timeInMin = (Integer.valueOf(t.substring(0, 2)) * 60) + Integer.valueOf(t.substring(3));
            if (minutes.contains(timeInMin)) {
                return 0;
            }
            minutes.add(timeInMin);
        }

        minutes.sort(null);

        int mDiff = 0;
        for (int i = 0; i < minutes.size() - 1; i++) {
            int m = minutes.get(i + 1) - minutes.get(i);
            if (m <= mDiff || mDiff == 0) {
                mDiff = m;
            }
        }

        int mDiff1 = minutes.get(0) + ( 1440-minutes.get(minutes.size()-1));

        return Math.min(mDiff, mDiff1);

    }
}
