package leet;

/**
 * Created by sabaresh on 2/18/17.
 */
public class DetectCapital {

    public static void main(String[] args) {

        DetectCapital d = new DetectCapital();
        System.out.println(d.detectCapitalUse("USA"));
        System.out.println(d.detectCapitalUse("leet"));
        System.out.println(d.detectCapitalUse("Flag"));
        System.out.println(d.detectCapitalUse("FlaG"));
    }

    public boolean detectCapitalUse(String word) {
        if(word == null) return  false;

//        if(word.toLowerCase().equals(word) || word.toUpperCase().equals(word))
//            return true;
//        else {
//            char []chars = word.toCharArray();
//            for(int c=1; c< chars.length;c++) {
//                if(Character.isUpperCase(chars[c])) return false;
//            }
//        }
        return word.matches("[A-Z]+") || word.matches("[a-z]+") || word.matches("[A-Z][a-z]*");

    }
}

