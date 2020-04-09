package club.huangliang.interview.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* 这是一个反射的实列
* */
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取类
        Class robotClazz=Class.forName("club.huangliang.interview.reflect.Robot");
        //创建类
        Robot robot= (Robot) robotClazz.newInstance();
        //打印这个类的名字
        System.out.println("class Name is :" +robotClazz.getName());
        /*
        * 知识点一：通过反射获取到这个类的所有方法（包括私有方法）
        *       getDeclaredMethod能够获取到这个类所有的基本上所有的方法（私有的和共有的）但是不能获取继承的方法和接口实现的方法
        *       参数name:表示类里面的方法明  参数String.class：表示方法的参数
        * */
        Method getHello=robotClazz.getDeclaredMethod("throwHello",String.class);
        //对于私有方法需要开启权限
        getHello.setAccessible(true);
        //执行通过反射获取到的方法
        Object str=getHello.invoke(robot,"grow up");
        System.out.println("the Result of Robot's throwHello Method is "+str);
        /*
        * 知识点二：获取公共方法，和继承的方法和接口方法
        *           getMethod:能够获取到这个类所有的公共方法（包括继承下来的方法和接口方法）
        * */
        Method sayHi = robotClazz.getMethod("sayHi", String.class);
        sayHi.invoke(robot,"yb");
        /*
        * 知识点三：获取属性
        * */
        Field name = robotClazz.getDeclaredField("name");
        //因为name是private的，所以还是要开启它的权限
        name.setAccessible(true);
        //对属性进行赋值
        name.set(robot,"growup yb");
        //再次调用sayHi 方法，
        sayHi.invoke(robot,"handsome boy ");

//        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
