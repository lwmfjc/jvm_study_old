package jvm._02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeFiled= Unsafe.class.getDeclaredFields()[0];
        unsafeFiled.setAccessible(true);
        //null:表示获取的是静态字段
        Unsafe unsafe=(Unsafe) unsafeFiled.get(null);
        while (true){
            //单位：字节
            unsafe.allocateMemory(_1MB);
        }


    }

}
