package algorithm.recursion;

public class DicePrint {

    public static void main(String[] args) {
        printBinary(2, "");
    }

    public static void printBinary(int digit, String prefix) {
        if (digit == 0) {
            System.out.println(prefix);
        } else {
            printBinary(digit - 1, prefix+"1");
            printBinary(digit - 1, prefix+"2");
            printBinary(digit - 1, prefix+"3");
            printBinary(digit - 1, prefix+"4");
            printBinary(digit - 1, prefix+"5");
            printBinary(digit - 1, prefix+"6");
        }
    }
}
