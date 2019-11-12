package collections.map;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    public static void main(String[] args) throws Exception {

        WeakHashMap<A, String> map = new WeakHashMap<>();

        A  a = new A(1);
        A  b = new A(1);

        map.put(a, "a");

        ReferenceQueue<A> rq = new ReferenceQueue<>();

        WeakReference<A> wf = new WeakReference<>(b, rq);

//        a = null;
        b = null;

        System.gc();

        Thread.sleep(1000 * 2);

        System.out.println(map.size());

        System.out.println(wf.get() != null ? wf.get().s : null);

        System.out.println(rq.poll().get().s);
    }

    static class A {
        int s;
        public A(int s) {
            this.s = s;
        }
    }
}
