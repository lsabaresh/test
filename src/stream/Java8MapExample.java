package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toList;
/**
 * Created by Sabaresh on 5/14/2016.
 */
public class Java8MapExample {
    public static void main(String args[]) {
        List<String> cities = Arrays.asList("London", "HongKong", "Paris", "NewYork");
        System.out.println("Original list : " + cities);
        System.out.println("list transformed using Java 8 :" + transform(cities));
        System.out.println("list transformed using loop before Java 8 : " + beforeJava8(cities));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> squares = numbers.stream().map( i -> i*i).collect(toList());


        //numbers.forEach(i-> System.out.println(i*i));
        System.out.println("squares : " + squares);

        Stream.of("A,B,C".split(",")).limit(2).forEach(x-> System.out.println(x));
        System.out.println("Find Present : "+Stream.of("A","B","C").findAny().get());

        String[] array = new String[]{"1", "2"};
        Stream.of(array).forEach(x-> System.out.println(x));

//        Stream.of(1, 2, 3).sorted()
        //Stream.of(numbers,numbers).forEach(x-> System.out.println(x));

        Stream.generate(()-> {return Math.random();}).limit(10).forEach(x-> System.out.println(x));
        Stream.iterate(0, i -> i+1 ).limit(3).forEach(System.out::println);

        Stream.builder().add(numbers).add(numbers).build().forEach(System.out::println);

        System.out.println("-------Collectors.toList()-------");
        Stream.of(numbers, numbers).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------");
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average().ifPresent(System.out::println);

        System.out.println("--------------");
        IntStream.builder().add(10).add(20).build().forEach(System.out::println);

        System.out.println("--------------");
        Stream.of("d2", "a2", "b1", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("--------------");

        System.out.println("noneMatch A : "+Stream.of("d2", "a2", "b1", "b3", "c")
                .noneMatch(s-> s.startsWith("A")));

        System.out.println("noneMatch a : "+Stream.of("d2", "a2", "b1", "b3", "c")
                .noneMatch(s-> s.startsWith("a")));

        System.out.println("-------Reusing the supplier -------");

        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

        System.out.println("-----Flat Map---------");
        System.out.println(Stream.of(numbers, numbers).flatMap(v -> v.stream()).collect(Collectors.toList()));

        System.out.println("----peek---------");
        List<String> strings = Stream.of("Badgers", "finals", "four")
                .filter(s -> { System.out.println("Filter : "+s);
                    return  s.length() >= 4;}).peek(s -> System.out.println("peek :"+s))
                .map(s -> {System.out.println("map :"+s); return s.toUpperCase();}).collect(Collectors.toList());
        System.out.println("strings "+strings);
    }

    public static List<String> beforeJava8(List<String> listOfString) {
        List<String> coll = new ArrayList<>();
        for (String str : listOfString) {
            coll.add(str.toUpperCase());
        }
        return coll;
    }

    public static List<String> transform(List<String> listOfString) {
        return listOfString.stream() // Convert list to Stream
               .map(String::toUpperCase) // Convert each element to upper case
               .collect(toList()); // Collect results into a new list
    }




}
