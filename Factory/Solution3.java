package Factory;

//抽象工厂方法模式

//以下是以汽车为产品的抽象工厂方法模式的实现示例：

/* 车类 */
abstract class Auto2{           //汽车的抽象类
}

class Car2 extends Auto2 {        //轿车
}

class Truck2 extends Auto2 {      //卡车
}

/* 零件类 */
abstract class Wheel{           //轮胎的抽象类
}

class CarWheel extends Wheel {   //轿车轮胎
}

class TruckWheel extends Wheel { //卡车轮胎
}

/* 抽象工厂方法模式（可以生成多种不同的产品 ，*/
/* 且这些产品之间有一定的联系， */
/* 关系在于：生成轿车的工厂只能生成轿车的轮胎，不能生成卡车的轮胎）*/

//可以创造一个轮胎接口
interface CreateWheelAble{
    public abstract Wheel createWheel();
}

//抽象汽车工厂
abstract class AbstractAutoFactory1 implements CreateWheelAble {
    public abstract Auto createAuto();        //创造一个汽车的抽象方法
    @Override
    public abstract Wheel createWheel();      //创造一个轮胎的抽象方法
}

//轿车工厂
class CarFactory2 extends AbstractAutoFactory1 {
    @Override
    public Auto createAuto() {
        return new Car();                    //返回的是轿车
    }
    @Override
    public Wheel createWheel() {
        return new CarWheel();               //返回的是轿车轮胎
    }
}

//卡车工厂
class TruckFactory2 extends AbstractAutoFactory1 {
    @Override
    public Auto createAuto() {
        return new Truck();                //返回的是卡车
    }

    @Override
    public Wheel createWheel() {
        return new TruckWheel();          //返回的是卡车轮胎
    }
}

public class Solution3 {
    public static void main(String[] args) {
        //抽象工厂方法，创建多个有联系的产品
        AbstractAutoFactory1 aaf=new CarFactory2(); //轿车系列产品工厂
        Auto a=aaf.createAuto();           //生产轿车
        Wheel w=aaf.createWheel();         //生产轿车轮子
    }
}
