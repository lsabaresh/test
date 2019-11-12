package com;

import general.ProcessID;
import org.testng.annotations.Test;

import java.lang.management.ManagementFactory;

public class Test1 {

    @Test
    public void m1() {
        System.out.println(Thread.currentThread().getName()+" : com 1 m1, process Id "+ ProcessID.getProcessId(""));
    }

    @Test
    public void m2() {
        System.out.println(Thread.currentThread().getName()+" : com 1 m2, process Id "+ ProcessID.getProcessId(""));
    }


}
