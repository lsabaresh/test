package com;

import org.testng.annotations.Test;

public class Test2 {

    @Test
    public void m1() {
        System.out.println(Thread.currentThread().getName()+" : com 2 m1");
    }

    @Test
    public void m2() {
        System.out.println(Thread.currentThread().getName()+" : com 2 m2");
    }
}
