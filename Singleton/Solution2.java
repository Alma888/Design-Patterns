package Singleton;
//多线程安全版本2：

//懒汉式——实现方式（使用双重同步锁）—强烈推荐使用
public class Solution2 {
    private Solution2(){}
    private static Solution2 instance=null;   //静态的类型引用
    public static Solution2 getInstance(){  //获取实例的方法，保证同步
        if(instance==null){                 //判断第一次
            synchronized (Solution2.class){
                if(instance==null){         //判断第二次
                    instance=new Solution2();  //创建新的
                }
            }
        }
        return instance;
    }
}
