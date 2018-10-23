package Guava;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetTest {

    public static void main(String[] args) {

        // ####################### Guava - order and the size of the list cannot change from source

        Set<String> x = new HashSet<>();
        x.add("foo");

        Set<String> guava = ImmutableSet.copyOf(x);
        Set<String> builtIn = Collections.unmodifiableSet(x);

        x.add("bar");

        System.out.println(guava.size()); // Prints 1
        System.out.println(builtIn.size()); // Prints 2


        // ####################### Objects in both, are immutable - Neither of these will prevent you from changing an object in a list,

        HashSet<Foo> foos = new HashSet<>(Arrays.asList(new Foo("a")));

        Set<Foo> guava1 = ImmutableSet.copyOf(foos);
        Set<Foo> builtIn1 = Collections.unmodifiableSet(foos);

        guava1.iterator().next().setA("b");
        System.out.println(foos.iterator().next().getA()); // changed from a to b

        builtIn1.iterator().next().setA("c");
        System.out.println(foos.iterator().next().getA()); // changed from b to c

    }

    static class Foo {
        String a;
        Foo (String a) {
            this.a = a;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
