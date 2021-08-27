package club.huangliang.design_model.simple_factory_model;
/*
*  简单工厂抽象类的实现
* */

//学雷峰的志愿者
public class Volunteer extends LeiFeng {
    @Override
    public void Sweep() {
        System.out.print("社区志愿者帮忙打扫   ");
    }

    @Override
    public void Wash() {
        System.out.print("社区志愿者帮忙洗衣服   ");
    }

    @Override
    public void BuyRice() {
        System.out.print("社区志愿者帮忙买米   ");

    }

}

//学雷锋的大学生
class  Undergraduate extends LeiFeng {

    @Override
    public void Sweep() {
        System.out.print("大学生帮忙打扫   ");

    }

    @Override
    public void Wash() {
        System.out.print("大学生帮忙洗衣服   ");

    }

    @Override
    public void BuyRice() {
        System.out.print("大学生帮忙买米   ");

    }

}