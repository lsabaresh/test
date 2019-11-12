package com;

import general.ProcessID;
import org.testng.annotations.Test;

@Test(enabled = false)
public class Test2 {

//    @Test
    public void m1() {
        System.out.println(Thread.currentThread().getName()+" : com 2 m1, process Id "+ ProcessID.getProcessId(""));
    }

//    @Test(enabled = false)
    public void m2() {
        System.out.println(Thread.currentThread().getName()+" : com 2 m2, process Id "+ ProcessID.getProcessId(""));
    }
}
