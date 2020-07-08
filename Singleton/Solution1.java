package Singleton;
//多线程安全版本1：

//懒汉式——实现方式（使用同步方法）
public class Solution1 {
    private Solution1(){}
    private static Solution1 instance=null;   //静态的类型引用
    public static synchronized Solution1 getInstance(){   //获取实例的方法，保证同步
        if(instance==null){
            instance=new Solution1();    //创建新的
        }
        return instance;
    }
}
