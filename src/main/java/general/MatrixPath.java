package general;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Sabaresh on 5/21/2016.
 */
public class MatrixPath {

    public static void main(String args[]) {

        MatrixPath path = new MatrixPath();

        List<String> pathList = new ArrayList<>();
        System.out.println(path.numberOfPaths(3,3, "", pathList));
        System.out.println("pathList : "+pathList);

    }

    public int numberOfPaths(int m, int n, String path, List<String> pathList)
    {

        path += String.format("(%d,%d)", m ,n);

        // If either given row number is first or given column number is first
        if (m == 1 || n == 1) {
            pathList.add(path);
            return 1;
        }

        int result = numberOfPaths(m-1, n, path, pathList) + numberOfPaths(m, n-1, path, pathList);

        System.out.println("m : "+m+", n : "+n+", result : "+result);
        // If diagonal movements are allowed then the last addition
        // is required.
        return  result;
        // + numberOfPaths(m-1,n-1);
    }
}
