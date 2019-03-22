package general;

import java.io.Closeable;

public class AutoClosableExample {
    public static void main(String[] args) throws Exception {
        try {
            try (AutoClosableA a = new AutoClosableA();
                 AutoClosableB b = new AutoClosableB();) {
                throw new Exception("sdfds");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("completed");
    }
}

class AutoClosableA implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("A Closed");
    }
}

class AutoClosableB implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("B Closed");
    }
}