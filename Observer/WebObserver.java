package Observer;


public class WebObserver implements Observer { //Web 观察者
    @Override
    public void update(Product p) {           //定义回调方法
        System.out.println("更新页面价格："+p.getName()+":"+p.getPrice());
    }

    @Override
    public void unreg(Product p) {
        p.getObservers().remove(this);   //去掉本观察者
    }
}


