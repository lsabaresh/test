package collections;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sabaresh on 5/20/2016.
 */
public class TestSorting {

    public static void main(String args[]){
        List<String> names = new ArrayList<String>();

        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add("Vikas");
        names.add("Deepak");

        System.out.println(names);
        Collections.sort(names);

        names.add(null);
        //System.out.println(names); //java.lang.NullPointerException

        Ordering ordering=   Ordering.natural();
        Collections.sort(names,ordering.nullsFirst() );
        System.out.println(names);
        Collections.sort(names,ordering.nullsLast() );
        System.out.println(names);

        HashMap<TestKey, String> map = new HashMap<>();

        TestKey a = new TestKey();
        TestKey b = new TestKey();
        map.put(a, "hello");
        System.out.println(map.get(a)+", hashCode : "+a.hashCode());
        map.put(b, "saba");
        System.out.println(map.get(b)+", hashCode : "+b.hashCode());
    }
}

class TestKey {

}
