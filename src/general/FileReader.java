package general;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Created by Sabaresh on 5/11/2016.
 */
public class FileReader {

    public static final void main(String []args) {

        try {
            File file = new File("F:\\summary.txt");



            InputStream inputStream = new FileInputStream(file);

            long length = file.length();

            System.out.println("length " + length);


            byte[] chunk = new byte[1024];
            int chunkLen = 0;
            StringBuffer stringBuffer = new StringBuffer();


            while ((chunkLen = inputStream.read(chunk)) != -1) {

//            stringBuffer.append(chunk.t);
//                System.out.print(chunk[0]);

//                System.out.print(Arrays.toString(chunk));
                System.out.print(new String(chunk));
//                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                chunk = new byte[1024];
            }

//        System.out.print(stringBuffer.toString());
        } catch (FileNotFoundException fnfE) {
            // file not found, handle case
        } catch (IOException ioE) {
            // problem reading, handle case
        }
    }
}
