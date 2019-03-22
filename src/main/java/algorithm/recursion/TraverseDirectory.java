package algorithm.recursion;

import java.io.File;

public class TraverseDirectory {

    public static void main(String[] args) {
        traverse(new File("./src"));
    }

    public static void traverse(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if ( f.isFile()) {
                System.out.println(f.getAbsolutePath());
            } else {
                traverse(f);
            }
        }
    }
}
