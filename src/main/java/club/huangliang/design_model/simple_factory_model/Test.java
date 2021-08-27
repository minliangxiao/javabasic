package club.huangliang.design_model.simple_factory_model;

/**
 * 测试类也是调用类
 */
public class Test {
    @org.junit.Test
    public void test(){
        IFactory factory = new UndergraduateFactory();
        LeiFeng student = factory.CreateLeiFeng();

        student.Sweep();
        student.Wash();
        student.BuyRice();
        System.out.println("\n --------------------------");

        IFactory factory2 = new VolunteerFactory();
        LeiFeng volunteer = factory2.CreateLeiFeng();

        volunteer.Sweep();
        volunteer.Wash();
        volunteer.BuyRice();

    }
}
