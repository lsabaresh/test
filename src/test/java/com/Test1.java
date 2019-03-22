package com;

import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void m1() {
        System.out.println(Thread.currentThread().getName()+" : com 1 m1");
    }

    @Test
    public void m2() {
        System.out.println(Thread.currentThread().getName()+" : com 1 m2");
    }
}
