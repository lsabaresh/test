
import java.util.Optional;
import java.util.stream.Stream;

public class Java8Optional {
    public static void main(String args[]){

        Java8Optional java8Tester = new Java8Optional();
        Integer value1 = null;
        Integer value2 = Integer.valueOf(10);

        System.out.println("null - > "+ Optional.ofNullable(2).map(x -> x).orElse(null));

        System.out.println("Optional.empty().isPresent() : "+Optional.empty().isPresent());



        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a,b));

        System.out.println("------Flat Map-----------");

        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);

        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();

        String password = "password";
        Optional<String> passOpt = Optional.of(password);
        System.out.println("filter "+passOpt.filter(
                pass -> pass.equals("password")).isPresent());

        passOpt = Optional.ofNullable(null);
        System.out.println("filter null "+passOpt.filter(
                pass -> pass.equals("password")).isPresent());

        String s = null;

        System.out.println("value 1 "+Stream.of(1, 2).filter(v -> v == 2).findFirst().map(v -> String.valueOf(v)).orElse("not found"));
        System.out.println("value 2 "+Stream.of(1, 2).filter(v -> v == 3).findFirst().map(v -> String.valueOf(v)).orElse("not found"));

        System.out.printf("string s "+Optional.ofNullable(s).map( v -> Integer.valueOf(v)).orElse(-1)+"");


        String t = null;
        System.out.println("null : "+Optional.ofNullable(t).filter(x -> x.length() > 0).isPresent());
        System.out.println("empty : "+Optional.ofNullable("").filter(x -> x.length() > 0).isPresent());
        System.out.println("value : "+Optional.ofNullable("a").filter(x -> x.length() > 0).isPresent());

    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(Integer.valueOf(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}