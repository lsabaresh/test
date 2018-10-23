package general;

public class BitTest {

    public static void main(String[] args) {

        System.out.println(" Bitwise value " + (5 << 2)); // Multiplication -> 5 * 2^2
        System.out.println(" Bitwise value " + (8 >> 2)); // Division -> 8 / 2^2
        System.out.println(((100 & 1) == 0) ? "Even " : "Odd"); // To decide odd or even

        int i = 37;
        int i1 = ~37 + 1; // Negative number of i
        System.out.println(i + " " + Integer.toBinaryString(i));
        System.out.println(i + " " + Integer.toString(i, 2));
        System.out.println(i1 + " " + Integer.toBinaryString(i1));

        Integer v1 = 2;

        System.out.println(v1 & 2);

        System.out.println(0 & 2);
    }

}
