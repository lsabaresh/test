package leet.w51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame b = new BaseballGame();
        System.out.println(b.calPoints(new String[] {"5","2","C","D","+"}) == 30);
        System.out.println(b.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}) == 27);
        System.out.println(b.calPoints(new String[] {"-60","D","-36","30","13","C","C","-33","53","79"}) == 27);
    }

    public int calPoints(String[] ops) {
        int total = 0;
        List<String> pOps = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equalsIgnoreCase("C") && i > 0) {
                pOps.remove(pOps.size()-1);
            } else {
                pOps.add(ops[i]);
            }
        }
        for (int i = 0; i < pOps.size(); i++) {
            int roundScore = 0;
            if (i > 0 && pOps.get(i).equalsIgnoreCase("D")) {
                roundScore = Integer.parseInt(pOps.get(i - 1)) * 2;
                pOps.set(i, roundScore+"");
            } else  if (i > 1 && pOps.get(i).equalsIgnoreCase("+")) {
                roundScore = Integer.parseInt(pOps.get(i - 2)) + Integer.parseInt(pOps.get(i - 1));
                pOps.set(i, roundScore+"");
            } else {
                roundScore = Integer.parseInt(pOps.get(i));
            }
            total += roundScore;
        }
        return total;
    }
}
