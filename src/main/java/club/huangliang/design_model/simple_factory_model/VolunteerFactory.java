package club.huangliang.design_model.simple_factory_model;

/**
 * 工厂的实现一
 */
public class VolunteerFactory implements IFactory {
    @Override
    public LeiFeng CreateLeiFeng() {
        return new Volunteer();
    }
}
