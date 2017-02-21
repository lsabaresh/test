/**
 * Created by sabaresh on 2/9/17.
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();

        t.integerComparison();
    }

    private void integerComparison() {

        Integer i = null;

        Integer i1 = 1;

        if(i1.equals(i)){
            System.out.println("equal ");
        } else System.out.println("not equal");
    }
}
