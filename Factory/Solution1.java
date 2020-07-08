package Factory;
//简单工厂模式


//以下是以汽车为产品的简单工厂模式的实现示例：

/* 车类 */
abstract class Auto{           //汽车的抽象类
}

class Car extends Auto {        //轿车
}

class Truck extends Auto {      //卡车
}

/* 简单工厂模式 */
class AutoFactory {            //简单工厂模式，这个就是工厂类
    //传递不同的参数，获得不同的产品
    public static Auto createAuto(int autoType){
        if(autoType==0){
            return new Car();  //返回轿车实例
        }else if(autoType==1){
            return new Truck();//返回卡车实例
        }
        return null;
    }
}

public class Solution1{
    public static void main(String[] args) {
        //主方法
        Auto car=AutoFactory.createAuto(0);  //制造轿车
        Auto truck=AutoFactory.createAuto(1);//制造卡车
    }
}
