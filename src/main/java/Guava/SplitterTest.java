package Guava;

/**
 * Created by Sabaresh on 5/20/2016.
 */

import com.google.common.base.Splitter;

//http://www.dotnetperls.com/splitter

public class SplitterTest {
    public static void main(String args[]) {
        SplitterTest tester = new SplitterTest();
        tester.testSplitter();

    }

    private void testSplitter() {
        System.out.println(Splitter.on(',')
                .omitEmptyStrings()
                .split("the ,quick, ,brown, fox, jumps, over, the, lazy, little dog."));
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, ,brown, fox, jumps, over, the, lazy, little dog."));
        String test = "name=saba;employee=tcs";

        System.out.println(Splitter.on(';')
                            .withKeyValueSeparator("=").split(test));
    }
}
