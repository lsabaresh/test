package leet.w56;

public class Bit {

    public static void main(String[] args) {
        Bit b = new Bit();
        System.out.println(b.isOneBitCharacter(new int[] {1,0,0}) == true);
        System.out.println(b.isOneBitCharacter(new int[] {1,1,1,0}) == false);
        System.out.println(b.isOneBitCharacter(new int[] {0,1,0}) == false);
        System.out.println(b.isOneBitCharacter(new int[] {1,1,0}) == true);
    }

    public boolean isOneBitCharacter(int[] bits) {
        boolean isOneBitCharacter = true;
        for (int i=0; i<bits.length;i++) {
            if(bits[i]==1) {
                isOneBitCharacter=false;
                i++;
            } else {
                isOneBitCharacter=true;
            }
        }
        return isOneBitCharacter;
    }
}
