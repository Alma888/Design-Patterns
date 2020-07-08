package Observer;

import java.util.HashSet;

//产品类
public class Product {          //被观察者
    private String name;        //商品名称
    private double price;      //价格
    private HashSet<Observer> observers; //保存所有的观察者

    //构造方法
    public Product(String name, double price){
        this.name=name;
        this.price=price;
        observers=new HashSet<Observer>();
    }

    //添加 观察者
    public void addObservers(Observer ob) {
        observers.add(ob);
    }

    //通知监听者（观察者）执行update()方法
    public void notifyObserver(){
        for(Observer ob:observers){
            ob.update(this);   //回调所有观察者的观察方法
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        //当价格改变的时候，就通知观察者；
        notifyObserver();
    }


    public HashSet<Observer> getObservers() {
        return observers;
    }

    public void setObservers(HashSet<Observer> observers) {
        this.observers = observers;
    }
}
//以上代码中，设定了两个观察者，商品发生了两次价格变化。第一次价格变化时，
// 两个观察者都做出了响应；第二次价格变化时，只有观察者2在进行观察。