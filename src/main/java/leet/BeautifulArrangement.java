package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabaresh on 2/19/17.
 */
public class BeautifulArrangement {

    public static void main(String[] args) {
        BeautifulArrangement  b = new BeautifulArrangement();


        System.out.println(b.countArrangement(3));
    }

    int res;
    public int countArrangement(int N) {
        res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) list.add(i);
        helper(list, 1, N);
        return res;
    }

    private void helper(List<Integer> list, int id, int n) {
        System.out.println(list + ", id "+id+", n : "+n);
        if (id > n) {
            res++;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) %id == 0 || id % list.get(i) == 0){
                int temp = list.remove(i);
                helper(list, id+1, n);
                list.add(i, temp);
            }
        }
    }
}
