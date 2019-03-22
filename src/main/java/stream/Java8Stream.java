package stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Sabaresh on 5/10/2016.
 */
public class Java8Stream {

    public static void main(String args[]){

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

//        Stream.of(strings).reduce(Function.identity(), Function::andThen);

        System.out.println(strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()));
        System.out.println(strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", ")));

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

       //get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        numbers.stream().map( i -> i*i).forEach(System.out::println);
        System.out.println("Squares List: " + squaresList);


        IntSummaryStatistics stats = numbers.stream().mapToInt(x-> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        Random random = new Random();

        random.ints().limit(10).sorted().forEach(System.out::println);

        veriableArgs();

        veriableArgs("s");



    }

    public void test(Function<String, String>... filters) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        Function<String, String> filter =  Stream.of(filters).reduce(Function.identity(), Function::andThen);
    }

    public static void veriableArgs(String... s) {
        System.out.println(Stream.of(s).collect(Collectors.toSet()));
    }
}
