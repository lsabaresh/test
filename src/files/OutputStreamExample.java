package files;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

    private static final String OUTPUT_FILE = "/Users/sabaresh/Documents/work/tmp/11.txt";

    public static void main(String[] args) {

        String content = "Hello Java Code Geeks";

        byte[] bytes = content.getBytes();

        try (OutputStream out = new FileOutputStream(OUTPUT_FILE);
             DataOutputStream dos = new DataOutputStream(out);) {
             // write a byte sequence
            out.write(bytes);

            // write a single byte
            out.write(bytes[0]);

            // write sub sequence of the byte array
            out.write(bytes,4,10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
