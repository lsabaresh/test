import java.util.function.Consumer;

/**
 * Created by Sabaresh on 5/10/2016.
 */
public class LambdaTest {

    public static final void main(String []args) {
        System.out.println("testing ");

        MathOperation mathOperation = (int a, int b) -> a+b;

        System.out.println(" sum "+mathOperation.operation(1,2));

//        Consumer<>


    }
}

@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}