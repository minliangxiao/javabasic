package club.huangliang.design_model.test;

public class NoFly  implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("no fly");
    }
}
