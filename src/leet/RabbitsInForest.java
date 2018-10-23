package leet;


//Week 71 - 2

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 * Return the minimum number of rabbits that could be in the forest.
 */
public class RabbitsInForest {

    public static void main(String[] args) {

        RabbitsInForest r = new RabbitsInForest();

        System.out.println(Math.floorMod(-3, 2));
        System.out.println(Math.floorMod(3, -2));

        int[] answers1 = new int[] {10, 10, 10};
        System.out.println("Set 1 : "+ (r.numRabbits(answers1) == 11) );

        int[] answers2 = new int[] {1, 1, 2};
        System.out.println("Set 2 : "+ (r.numRabbits(answers2) == 5) );

        int[] answers3 = new int[] {0, 0, 1, 1, 1};
        System.out.println("Set 3 : "+ (r.numRabbits(answers3) == 6) );

        int[] answers4 = new int[] {1, 0, 1, 0, 0};
        System.out.println("Set 4 : "+ (r.numRabbits(answers4) == 5) );


    }

    public int numRabbits(int[] answers) {
        int numRabbits = 0, counter = 0;
        Arrays.sort(answers);

        List<Object> objects = Arrays.asList();


//        ArrayList

//        InputStreamReader

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == counter) {
                numRabbits += answers[i] + 1;
                counter = 0;
            } else if (i == answers.length-1){
                numRabbits += answers[i] + 1;
            } else {
                counter++;
            }
        }
        System.out.println(numRabbits);
        return numRabbits;
    }

    public int numRabbits1(int[] answers) {

        Map<Integer, Long> groupedResult = Arrays.stream(answers).mapToObj(i -> new Integer(i)).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );

        System.out.println(groupedResult);


        int numRabbits = 0;

//        groupedResult.forEach((k,v) ->
//                {
//                    if (v < k) {
//                        numRabbits = k + 1;
//                    }
//                }
//        );

        Set<Map.Entry<Integer, Long>> entries = groupedResult.entrySet();

        for (Map.Entry<Integer, Long> entry : entries) {
            Integer answer = entry.getKey();
            Long countOfSameAnswer = entry.getValue();

            if (countOfSameAnswer < answer) {
                numRabbits += answer + 1;
            } else {
                numRabbits += countOfSameAnswer + (answer != 0 && (countOfSameAnswer / answer) != 0 ? 1 : 0);
            }
        }

        System.out.println(numRabbits);
        return numRabbits;
    }
}



