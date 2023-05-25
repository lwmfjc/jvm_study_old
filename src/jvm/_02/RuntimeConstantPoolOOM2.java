package jvm._02;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.6 VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 * 1.8 VM Args: -Xmx6M
 */
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
/*
        //jdk6
        String str1=new StringBuilder("计算机").append("软件").toString();

        //JDK6中，intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池
        //中存储，返回的也是永久代里面这个字符串实例的引用，而
        //由StringBuilder创建的字符串对象实例在Java堆上，所以必然不可能是同一个引用，结果将返回false。
        System.out.println(str1.intern()==str1);
        String str2=new StringBuilder("Ja").append("va").toString();
        System.out.println(str1.intern()==str2);
*/

        //jdk7及以上
        String str1=new StringBuilder("计算机").append("软件").toString();
        //jdk7+：此intern()返回的引用和由StringBuilder创建的那个字符串实例就是同一个
        System.out.println(str1.intern()==str1);

        //jdk7+: “java” 这个字符串在执行String-Builder.toString()之前就已经出现过了，字符串常量
        //池中已经有它的引用，不符合intern()方法要求“首次遇到”的原则，“计算机软件”这个字符串则是首次
        //出现的，因此结果返回true
        //也就是说呢，"java".intern()返回的并不是刚刚在堆中创建的那个对象的引用，而是
        //之前已经创建过的
        String str2=new StringBuilder("Ja").append("va").toString();
        System.out.println(str1.intern()==str2);
    }
}
