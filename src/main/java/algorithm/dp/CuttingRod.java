package algorithm.dp;

public class CuttingRod {

    public static void main(String[] args) {

        CuttingRod cr =new CuttingRod();
        int[] price = {1,5,8,9,10,17,17,20};
        long t1 = System.currentTimeMillis();
//        int r = cr.recursiveMaxValue(price,8);
        int r = cr.cutRod(price, price.length);
        long t2 = System.currentTimeMillis();
        System.out.println(r);
        System.out.println(t2 - t1);
    }

    public int cutRod(int price[],int n){

        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        for(int i=0; i < val.length; i++) {
            System.out.print(val[i]+" ");
        }
        System.out.println();

        return val[n];

    }
}
