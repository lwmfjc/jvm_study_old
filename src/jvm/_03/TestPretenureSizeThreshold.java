package jvm._03;

/**
 * VM Options: -verbose:gc -XX:+UseSerialGC  -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728   //3MB
 */
public class TestPretenureSizeThreshold {
    private static final int _1MB=1024*1024;
    public static void testPretunureSizeThreshold(){
        byte[] allocation;
        allocation=new byte[4*_1MB];
    }

    public static void main(String[] args) {
        testPretunureSizeThreshold();
    }
}
