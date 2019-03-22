package general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        String patternStr = "(\\d\\d\\d)\\1";

        Pattern pattern = Pattern.compile(patternStr);

        Matcher matcher = pattern.matcher("123123435");

        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.groupCount());
        }

    }
}
