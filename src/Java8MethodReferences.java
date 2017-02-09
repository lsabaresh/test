
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import stream.Person;

/**
 * Created by Sabaresh on 5/10/2016.
 */
public class Java8MethodReferences {

    public static final void main(String []args) {

        System.out.println("------Constructor-------");
        final Car car = Car.create( Car::new, "Car 1" );
        final Car car2 = Car.create( Car::new, "Car 2" );

        System.out.println("------Static Method reference-------");
        final List< Car > cars = Arrays.asList( car, car2 );
        cars.forEach( Car::collide );
        cars.forEach( x->Car.collide(x) );

        System.out.println("------Instance Method reference-------");
        final Consumer<Car> consumer = Car::repair;
        cars.forEach( Car::repair );
        cars.forEach( x-> x.repair() );

        System.out.println("------Method reference on Object-------");
        final Car police = Car.create( Car::new, "New Car" );
        final Consumer<Car> consumer1 = police::follow;
        cars.forEach( police::follow );
        cars.forEach( consumer1 );
        cars.forEach( x -> police.follow(x) );

        //System.out.println(cars.size());

        System.out.println("-------------");

        PersonFactory<Person> p1 = ((name, age) -> new Person(name,age));
        System.out.println(p1.create("t1",20));

        PersonFactory<Person> p2 = Person::new;
        System.out.println(p2.create("t2",20));

       // Car car1 = Car::new;
    }
}

class Car {

    String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public static Car create(final Function<String, Car> function, String carName ) {
        return function.apply(carName);
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.carName);
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.carName +" on "+this.carName  );
    }

    public void follow() {
        System.out.println( "Following the on "+this.carName  );
    }

    public void repair() {
        System.out.println( "Repaired " + carName );
    }

    public void repair(Car car) {
        System.out.println( "Repaired with arg " + car.carName );
    }

    public static void print(Function<String, String> function, String s) {
        System.out.println(function.apply(s));
    }
}

interface PersonFactory<P extends Person> {
    P create(String name, int age);
}