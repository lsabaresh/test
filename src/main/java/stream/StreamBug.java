package stream;

import java.util.stream.Stream;

public class StreamBug {

    private static <T> T process(T input) {
        System.out.println("Processing... :"+input);
        return input;
    }

    public static void main(String[] argd) {

        Stream.of(1)
                .flatMap(i -> Stream.generate(() -> 42))
                .map(i -> process(i))
                .findAny()
                .ifPresent(System.out::println);
    }
}