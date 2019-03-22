package algorithm;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        System.out.println(lscs(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    //Largest Sum Contiguous Sub array
    public static int lscs(int []a) {
        int l = a.length;
        int max = a[0], current_max = a[0];
        for (int i=1; i < l; i++) {
            current_max = Math.max(a[i], a[i]+ current_max);
            max = Math.max(current_max, max);
        }
        return max;
    }
}
