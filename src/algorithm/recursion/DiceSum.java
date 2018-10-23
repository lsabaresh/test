package algorithm.recursion;

public class DiceSum {

    public static void main(String[] args) {
        dice(2, 7, 0, "");
    }

    public static int dice(int level, int sum, int runningSum, String prefix) {
        if (level <= 0) {
            System.out.println("level "+level+", prefix : "+prefix);
            if (sum == runningSum) {
                System.out.println(prefix);
            }
            return runningSum;
        } else {
            for (int i=1; i <= 6; i++) {
                int temp = dice(level-1, sum, runningSum+i, prefix+" "+i);
                if (temp >= sum ) {
                    break;
                }
            }
        }
        return runningSum;
    }
}
