package collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {


    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>() {
            {
                put("1", "v1");

            }
        };

        String[][] s = new String[][]{{"s1", "s2"}, {"s3"}};

        Arrays.stream(s).forEach(System.out::println);
    }
}


class TestMap1 {

    {
        put();
    }

    private void put() {

    }
}