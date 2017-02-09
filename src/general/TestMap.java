package general;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * Created by Sabaresh on 5/12/2016.
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, String> aMap = new TreeMap<String, String>();
        aMap.put("2", "Tuesday");
        aMap.put("5", "Fri");
        aMap.put("1", "Monday");
        aMap.put("3", "Wednesday");
        aMap.put("4", "Thursday");
        aMap.put("6", "Sat");

        String str1 = aMap.get("1");  // No need downcast
        System.out.println(str1);
        String str2 = aMap.get("2");
        System.out.println(str2);
        String str3 = aMap.get("3");
        System.out.println(str3);

//        Set<String> keys = aMap.keySet();
//        for (String str : keys) {
//            System.out.print(str);
//            System.out.print(":");
//            System.out.println(aMap.get(str));
//        }

        Set<Map.Entry<String, String>> entries = aMap.entrySet();

        for(Map.Entry<String, String> entry : entries ) {
            System.out.println(" Key "+entry.getKey()+", Value : "+entry.getValue());
        }

        aMap.forEach((key, value)-> System.out.println(" Key "+key+", Value : "+value));

        @NotNull String s = null;

        Collections.emptyList();

    }
}
