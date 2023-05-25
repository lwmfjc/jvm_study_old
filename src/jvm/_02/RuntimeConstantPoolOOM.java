package jvm._02;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.6 VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 * 1.8 VM Args: -Xmx6M
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用Set保持常量池引用，避免FullGC回收常量池行为
        Set<String> set = new HashSet<String>();
        //short范围内足以让6MB的PermSize产生OOM
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
