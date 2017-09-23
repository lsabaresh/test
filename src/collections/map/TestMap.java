package collections.map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {


    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>() {
            {
                put("1", "v1");

            }
        };
    }
}


class TestMap1 {

    {
        put();
    }

    private void put() {

    }
}