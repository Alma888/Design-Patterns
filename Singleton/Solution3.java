package Singleton;
//多线程安全版本3：

//饿汉式——实现方式（不使用同步锁）
public class Solution3 {
    private Solution3(){}//private类型的构造函数，保证其他类对象不能直接new一个该对象的实例
    private static Solution3 instance=new Solution3();//直接初始化一个实例对象
    public static Solution3 getInstance(){  //该类唯一的一个public方法
        return instance;
    }
}
/*
 * 上述代码中的一个缺点是该类加载的时候就会直接new一个静态对象出来，当系统中这样
 * 的类较多时，会使得启动速度变慢 。现在流行的设计都是讲“延迟加载”，我们可以在
 * 第一次使用的时候才初始化第一个该类对象。所以这种适合在小系统。
 */