package algorithm.recursion;

public class BinaryPrint {

    public static void main(String[] args) {
        printBinary(3, "");
    }

    public static void printBinary(int digit, String prefix) {
        if (digit == 0) {
            System.out.println(prefix);
        } else {
            printBinary(digit - 1, prefix+"0");
            printBinary(digit - 1, prefix+"1");
        }
    }
}
