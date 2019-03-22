package general;

public class TypeCast {

    public static void main(String[] args) {

        A a = new B();
        B b = (B)a;

        A a1 = new A();
        B b1 = (B)a1;

    }


}

class A {

}

class B extends A {

}