package Singleton;
//多线程安全版本4：

//静态内部类——实现方式（按需创建实例）---强烈推荐使用
public class Solution4 {
    private Solution4(){} //声明为 private 避免调用默认构造方法创建对象

    //静态内部类，在外部类加载的时候并不会被加载。
    //声明为 private 表明静态内部该类只能在该Singleton 类中被访问
    private static class Solution4Holder{
        private static final Solution4 instance=new Solution4();
    }
    public static Solution4 getInstance(){
        return Solution4Holder.instance;
    }
}

//当Singleton 类被加载时，静态内部类Solution4Holder没有被加载进内存。只有当调用
//Solution4Holder.instance时，Solution4Holder 才会被加载，此时初始化instance实例，
// 并且JVM能确保Instance只被实例化一次。
//这种方式不仅具有延迟初始化的好处，而且由JVM 提供了对线程安全的支持。
