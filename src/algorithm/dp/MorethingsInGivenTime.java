package algorithm.dp;

import java.util.Arrays;

/**
 * Being a very busy person, you have exactly T time to do some interesting things and you want to do maximum such things.
 */
public class MorethingsInGivenTime {

    public static void main(String[] args) {
        MorethingsInGivenTime m = new MorethingsInGivenTime();
        int[] time = new int[] {1, 4, 2, 3, 5};
        int noOfThings = m.findMaxNoOfThingsToDo(6, time);
        System.out.println("Maximum no of things can be done for Given Time "+ noOfThings);
    }

    private int findMaxNoOfThingsToDo(int givenTime, int[] time) {
        int noOfThings =0, currentTime = 0;
        Arrays.sort(time);
        for (int i = 0; i < time.length; i++) {
            currentTime += time[i];
            if (currentTime > givenTime) {
                break;
            }
            noOfThings++;
        }
        return noOfThings;
    }
}
