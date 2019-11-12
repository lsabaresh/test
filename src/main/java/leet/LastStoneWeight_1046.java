package leet;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight_1046 {

    public static void main(String[] args) {
        LastStoneWeight_1046 l = new LastStoneWeight_1046();

        System.out.println(l.lastStoneWeight(new int[]{7,6,7,6,9}));
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());

        pQueue.addAll(list);

        while(pQueue.size() > 1) {
            pQueue.add(pQueue.poll() - pQueue.poll()); //since we already know the first poped out is not smaller, it is not necessary to use Math.abs().
        }

        return pQueue.poll();
    }
}
