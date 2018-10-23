package general;

public class EnumTest {

    public static void main(String[] args) {


        System.out.println(Status.valueOf("ACTIVE"));
    }


    enum Status {
        active,
        inactive
    }
}
