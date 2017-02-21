package leet;

/**
 * Created by sabaresh on 2/19/17.
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.*
 *
 */
public class SuperWashingMachine {

    public static void main(String[] args) {

        SuperWashingMachine s = new SuperWashingMachine();

        int [] input = new int[] {1,0,5};
//        System.out.println(s.findMinMoves(input));
//        input = new int[] {0,0,11,5};
        System.out.println(s.findMinMoves(input));


    }

    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
            System.out.println("load-avg : "+(load-avg)+", cnt : "+cnt+", max : "+max);
        }
        return max;
    }
}
