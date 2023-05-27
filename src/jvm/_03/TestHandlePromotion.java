package jvm._03;

/**
 * VMArgs -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *  -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
 */
public class TestHandlePromotion {
    private  static final int _1MB = 1024*1024;

    @SuppressWarnings("unused")
    public static void testHandlePromotion(){
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,
                allocation6,allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
  /*5*/ allocation4 = new byte[2 * _1MB]; //执行完进行了gc
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation2=null;
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
  /*11*/allocation7 = new byte[2 * _1MB];//执行完进行了gc
    }

    public static void main(String[] args) {
        testHandlePromotion();
        while (true){}
    }
}
