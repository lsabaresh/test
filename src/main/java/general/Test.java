package general;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by sabaresh on 2/18/17.
 */
public class Test {

    Pattern staticResourcePattern = Pattern.compile(".*(\\.(?i)(jpg|js|png|woff|css))$");

    public static void main(String[] args) {
        Test t = new Test();
//        t.fileExtensionTest();
//        t.patternTest();
//        instanceOfTest();
//        dateTime();
//        integerTest();
//        subStringTest();
        entrySetTest();
    }


    public void fileExtensionTest() {
        System.out.println(checkFileExtension("")==false);
        System.out.println(checkFileExtension(null)==false);
        System.out.println(checkFileExtension("/")==false);
        System.out.println(checkFileExtension("/frontend/node_modules/can/dist/amd/can/view/mustache.js"));
        System.out.println(checkFileExtension("/frontend/node_modules/can/dist/amd/can/view/mustache.JS"));
        System.out.println(checkFileExtension("/a.js"));
        System.out.println(checkFileExtension("/frontend/node_modules/idms-web-components/assets/generated-icons/shared-icons.woff"));
        System.out.println(checkFileExtension("/frontend/assets/images/app_icons@2x.jpg"));
        System.out.println(checkFileExtension("/bin/cb4152743870/images/countryFooterFlags/22x22/USAflag.png"));
        System.out.println(checkFileExtension("/frontend/tmp_dev/landing.web.css"));
        System.out.println(checkFileExtension("/frontend/node_modules/can/dist/amd/can/viewjs")==false);
    }

    public boolean checkFileExtension(String value) {
        String pattern = ".+(\\.(?i)(jpg|js|png|woff|css))$";
        return value != null && value.matches(pattern);
    }

    public void patternTest() {
        System.out.println(matches("")==false);
        System.out.println(matches(null)==false);
        System.out.println(matches("/")==false);
        System.out.println(matches("/frontend/node_modules/can/dist/amd/can/view")==false);
        System.out.println(matches("/frontend/node_modules/can/dist/amd/can/view/")==false);
        System.out.println(matches("/frontend/node_modules/can/dist/amd/can/view/mustache.js"));
        System.out.println(matches("/frontend/node_modules/can/dist/amd/can/view/mustache.JS"));
        System.out.println(matches("/.js"));
        System.out.println(matches("/frontend/node_modules/idms-web-components/assets/generated-icons/shared-icons.woff"));
        System.out.println(matches("/frontend/assets/images/app_icons@2x.jpg"));
        System.out.println(matches("/bin/cb4152743870/images/countryFooterFlags/22x22/USAflag.png"));
        System.out.println(matches("/frontend/tmp_dev/landing.web.css"));
        System.out.println(matches("/frontend/node_modules/can/dist/amd/can/viewjs")==false);
    }

    public boolean matches(String value) {
        return value != null && staticResourcePattern.matcher(value).matches();
    }

    public static void instanceOfTest() {

        String s = "";

        System.out.println(s instanceof String);
    }


    public static void dateTime() {
        DateTime d = DateTime.now();
        System.out.println(d);
        System.out.println(d.plusDays(7));
        System.out.println(d.plusDays(7));
    }

    private static void integerTest() {

        Integer i = null;

        int v = i;

        System.out.println(v);
    }

    private static void entrySetTest() {
        Map<String, String> m = new HashMap<>();

        System.out.println(m.entrySet());

    }


    private static void subStringTest() {

        String s = "ManageAccountupdateName";

        int index = s.indexOf("Controller");
        System.out.println("Sub String : "+s.substring(0, index != -1 ? index : s.length()));
//        System.out.println("Sub String : "+ StringUtils.substring(s, 0, s.indexOf("Controller")));

        String [] chunks = StringUtils.splitByCharacterTypeCamelCase(s.substring(0, index != -1 ? index : s.length()));

        StringBuilder key = new StringBuilder(s.length());

        for(String chunk: chunks) {
            key.append("_");
            key.append(chunk.toUpperCase());
        }

        System.out.println("key : "+key);
        System.out.println("key : "+key.toString().toUpperCase());
    }
}
