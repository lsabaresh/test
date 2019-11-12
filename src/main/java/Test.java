import com.google.common.collect.MinMaxPriorityQueue;
import general.CloneTest;
import org.apache.commons.lang3.BooleanUtils;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sabaresh on 2/9/17.
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Test t = new Test();

//        forEachNullTest();

//        setToArray();

//        testEmptySet1();

//        invalidFile();





        String[] a = "".split("/");

        System.out.println("a.length = " + a.length);

        System.out.println(-10 - -3);

        Function<String, Integer> f1 = String::length;

        Function<String, Integer> f2 = c -> c.length();

        Function f = t.getFunction(String::length);

        t.getFunction((String s) -> s.length());

//        System.out.println(f.apply(""));


    }

    public <T, R> Function getFunction(Function<T, R> f) {
        return f;
    }

    private void integerComparison() {

        Integer i = null;

        Integer i1 = 1;

        if(i1.equals(i)){
            System.out.println("equal ");
        } else System.out.println("not equal");
    }

    private static void forEachNullTest() {

        Set<String> s = null;

        for (String s1 : s) {

        }

    }

    private Boolean getValue() {
        return null;
    }

    private static void setToArray() {

        System.out.println("setToArray started ");
        Set<String> strings = new HashSet<>(Arrays.asList("1", "2"));

        Stream.of(strings.toArray(new String[0])).forEach(System.out::println);
        System.out.println("setToArray ended ");
    }

    private static void testEmptySet() {

        Set<String> sets = Collections.EMPTY_SET;
        System.out.println("testEmptySet started ");
        for (String s : sets) {

        }
        System.out.println("testEmptySet started ");

    }

    private static void testEmptySet1() {

        Set<String> sets = Stream.of("1", "2").filter(v -> v.equals("1")).collect(Collectors.toSet());
        System.out.println("testEmptySet started ");
        for (String s : sets) {
            System.out.println(s);
        }
        System.out.println("testEmptySet started ");
    }

    private static void invalidFile() {

        File file = new File("/Users/sabaresh/Documents/work/workspace/apple_git/gdpr-services/src/main/resources/META-INF/com.yml");

        System.out.println(file.exists());
    }


}
