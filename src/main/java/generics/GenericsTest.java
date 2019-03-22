package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericsTest {

    public static void main(String[] args) {
        GenericsTest g = new GenericsTest();


        System.out.println(g.badCast(new Integer(10), new String("hi") ));

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());

        //Not allowed
//        List<String>[] lsa = new List<String>[10];

        List<?>[] lsa = new List<?>[10]; // Allowed

        Object[] strings = new String[2];
        strings[0] = "hi";   // OK
        strings[1] = 100;    // An ArrayStoreException is thrown.



    }

    public <T> T badCast(T t, Object o) {
        System.out.println("T : "+t);
        return (T) o;
    }


}


