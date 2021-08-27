package club.huangliang.design_model.strategy_model;

/**
 * 客户端（测试类）
 */
public class Test {
    @org.junit.Test
    public void test (){
        Context context;
        // 调用a算法
        context=new Context(new ConcreteStrategyA());
        context.ContextInterface();

        //调用b算法
        context=new Context(new ConcreteStrategyB());
        context.ContextInterface();

        //调用c算法
        context=new Context(new ConcreteStrategyC());
        context.ContextInterface();

    }
}
