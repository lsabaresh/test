package general;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) throws Exception {
        InputStream is = null;
        BufferedInputStream bis = null;
        try{
            // new input stream created
            is = new FileInputStream("F://test.txt");

             bis = new BufferedInputStream(is);

            // read and print characters one by one
            System.out.println("Char 1 : "+(char)bis.read());
            System.out.println("Char 2 : "+(char)bis.read());
            System.out.println("Char 3 : "+(char)bis.read());

            // mark is set on the input stream
            bis.mark(1);

            System.out.println("Char 4 : "+(char)bis.read());
            System.out.println("Char 5 : "+(char)bis.read());

            System.out.println("bis.markSupported() : "+bis.markSupported());

            if(bis.markSupported())
            {
                // reset invoked if mark() is supported
                bis.reset();
                System.out.println("Char 6 : "+(char)bis.read());
                System.out.println("Char 7 : "+(char)bis.read());
            }

        }catch(Exception e){

            // if any I/O error occurs
            e.printStackTrace();
        }finally{

            if(bis!=null)
                bis.close();
            // releases system resources associated with this stream
            if(is!=null)
                is.close();
        }
    }
}