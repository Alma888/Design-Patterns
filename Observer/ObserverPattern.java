package Observer;

//以下是一个观察者模式实现示例。当商品价格发生变化时，通知网页观察者修改网页数据
//和 并通知 E-mail 观察者发送 E-mail。


import Proxy_pattern.ImageProxy;

public class ObserverPattern {
    //主方法
    public static void main(String[] args) {
        Product p=new Product("《Java核心技术》",103.00);    //创建一个商品
        Observer o1=new WebObserver();      //创建第一个观察者
        Observer o2=new ImageProxy.MailObserver();     //创建第二个观察者

        p.addObservers(o1);                 //注册第一个观察者
        p.addObservers(o2);                 //注册第二个观察者
        System.out.println("===第1次价格变动===");
        p.setPrice(80);                     //修改商品价格
        o1.unreg(p);                        //第一个观察者取消观察
        System.out.println("===第2次价格变动===");
        p.setPrice(100);                    //再次修改价格
    }
}

//以上代码中，设定了两个观察者，商品发生了两次价格变化。第一次价格变化时，
// 两个观察者都做出了响应；第二次价格变化时，只有观察者2在进行观察。