package general;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sabaresh on 3/21/17.
 */
public class FileExtension {

    public static void main(String[] args) {
        FileExtension f = new FileExtension();
        Set<String> fileExtensionList = new HashSet<>();
        f.getFileExtensions("", fileExtensionList);
        System.out.println(fileExtensionList);
    }

    public void getFileExtensions(String path, Set<String> fileExtensionList) {
        File f = new File(path);
        System.out.println(f);
        if(f.exists()) {
            if(f.isFile()) {
                fileExtensionList.add(f.getName().substring(f.getName().lastIndexOf(".")));
            } else if(f.isDirectory() && f.list().length > 0) {
                for (String content : f.list()) {
                    getFileExtensions(path+"/"+content, fileExtensionList);
                }
            }
        }
    }

}
