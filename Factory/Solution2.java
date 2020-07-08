package Factory;
//工厂方法模式


//以下是以汽车为产品的工厂方法模式的实现示例：

/* 车类 */
abstract class Auto1{           //汽车的抽象类
}

class Car1 extends Auto1 {        //轿车
}

class Truck1 extends Auto1 {      //卡车
}

//抽象汽车工厂
abstract class AbstractAutoFactory{
    public abstract Auto createAuto();//创建一个汽车的抽象方法
}

//轿车工厂
class CarFactory extends AbstractAutoFactory {
    @Override
    public Auto createAuto() {
        return new Car();             //返回的是轿车
    }
}

//卡车工厂
class TruckFactory extends AbstractAutoFactory {
    @Override
    public Auto createAuto() {
        return new Truck();          //返回的是卡车
    }
}

public class Solution2 {
    //主函数：
    public static void main(String[] args) {
        AbstractAutoFactory factory1=new CarFactory();  //定义轿车工厂对象
        AbstractAutoFactory factory2=new TruckFactory();//定义卡车工厂对象
        factory1.createAuto();        //创造了轿车
        factory2.createAuto();        //创造了卡车
    }
}
