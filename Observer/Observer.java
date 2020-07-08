package Observer;

public interface Observer {  //观察者接口
    public void update(Product p);  //价格修改的接口方法
    public void unreg(Product p);   //撤销注册
}
