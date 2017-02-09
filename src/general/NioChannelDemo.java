package general;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioChannelDemo {
    public static void main(String[] args) throws Exception {

        try(
            RandomAccessFile fromFile = new RandomAccessFile("F://fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();) {

            RandomAccessFile toFile = new RandomAccessFile("F://toFile.txt", "rw");
            FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count    = fromChannel.size();

            toChannel.transferFrom(fromChannel, position, count);

            Path path = Paths.get("c:\\data\\myfile.txt");



        }catch(Exception e) {

            // if any I/O error occurs
            e.printStackTrace();
        }

    }
}