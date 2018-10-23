package collections;

import java.util.EnumSet;

public class EnumSetTest {

    public static void main(String[] args) {

        EnumSet<GFG> e_set = EnumSet.allOf(GFG.class);

        // Displaying the initial EnumSet
        System.out.println("The first set is: " + e_set);

        // Creating another empty set
        EnumSet<GFG> other_set = EnumSet.noneOf(GFG.class);

        other_set.add(GFG.Geeks);
        other_set.add(GFG.Geeks);

        // Displaying the new set
        System.out.println("The other set is: " + other_set);


//        EnumSet<GFG> range = EnumSet.range(GFG.World, GFG.Welcome);  //  java.lang.IllegalArgumentException: World > Welcome
        EnumSet<GFG> range = EnumSet.range(GFG.Welcome, GFG.World);
        System.out.println("The range set is: " + range);

        EnumSet<GFG> complementOf = EnumSet.complementOf(range);

        System.out.println("The complementOf set is: " + complementOf);


    }


}


enum GFG {
    Welcome,
    To,
    The,
    World,
    of,
    Geeks
}