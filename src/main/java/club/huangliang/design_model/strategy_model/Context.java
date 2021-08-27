package club.huangliang.design_model.strategy_model;

/**
 * 上下文类
 */
public class Context {
    Strategy strategy;
    public Context(Strategy strategy){  //初始化具体的策略
        this.strategy=strategy;
    }
    //上下文接口
    public void ContextInterface(){  //调用具体的算法
        strategy.AlgorithmInterface();
    }
}
