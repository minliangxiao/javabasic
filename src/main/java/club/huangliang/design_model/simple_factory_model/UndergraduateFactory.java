package club.huangliang.design_model.simple_factory_model;

/**
 * 工厂的实现2
 */
public class UndergraduateFactory implements IFactory {
    @Override
    public LeiFeng CreateLeiFeng() {
        return new Undergraduate();
    }
}
