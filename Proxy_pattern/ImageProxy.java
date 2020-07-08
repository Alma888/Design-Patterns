package Proxy_pattern;

import Observer.Observer;

public class ImageProxy implements Image
{
    //组合一个image实例，作为被代理的对象
    private Image image;
    //使用抽象实体来初始化代理对象
    public ImageProxy(Image image)
    {
        this.image = image;
    }
    /**
     * 重写Image接口的show()方法
     * 该方法用于控制对被代理对象的访问，
     * 并根据需要负责创建和删除被代理对象
     */
    @Override
    public void show()
    {
        //只有当真正需要调用image的show方法时才创建被代理对象
        if (image == null)
        {
            image = new BigImage();
        }
        image.show();
    }

    //   调用时，先不创建被代理对象，等真正调用image的show方法时再创建：
    //Image image = new ImageProxy(null);

    public static void main(String[] args)throws Exception{
        Image image=null;
        new ImageProxy(image).show();
        //以指定的target来创建动态代理
        Image panther = (Image)MyProxyFactory.getProxy(image);
        //调用代理对象的info()和run()方法
        panther.show();
    }

    public static class MailObserver implements Observer { //Mail 观察者

        @Override
        public void update(Product p) {      //定义回调方法
            System.out.println("为所有会员发送价格变化信息："+
                    p.getName()+":"+p.getPrice());
        }

        @Override
        public void unreg(Product p) {
            p.getObservers().remove(this);  //去掉本观察者
        }
    }
}