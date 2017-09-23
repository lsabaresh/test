package leet.week35;

/**
 * Created by sabaresh on 6/3/17.
 */
public class Flowerbed {

    public static void main(String[] args) {
        Flowerbed f = new Flowerbed();
        int i [] = new int[]{1,0,0,0,1};
        System.out.println(f.canPlaceFlowers(i, 1));
        System.out.println(f.canPlaceFlowers(i, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int zeros = 0, ones = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==1) ones++;
        }

//        int noOf

        return (flowerbed.length / 2) == (ones + n) ;
    }
}
