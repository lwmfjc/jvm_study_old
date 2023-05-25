package jvm._03;

import java.sql.Ref;

/**
 * args: -verbose:gc
 * testGC()执行后，objA和objB会不会被GC呢
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 占点内存，在GC中看清楚是否回收过
     */
    private byte[] bigSize=new byte[2*_1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();

        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;

        System.gc();
        //如果使用的是引用计数法，那么他们是不会被回收的
        //实际上发生了gc
    }
}
