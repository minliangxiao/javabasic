package club.huangliang.interview.reflect;

/*
 * 这是用做演示自定义classLoader的例子
 * */
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader mcl=new MyClassLoader("D:\\javawebcode\\test\\","myClass.class");
        //获取这个字节码文件中的类(可以理解生成一个实例)
        Class<?> clazz = mcl.loadClass("myClass");
        //这个getClassLoader（）方法能够打印出是什么类
        System.out.println(clazz.getClassLoader());
        clazz.newInstance();

    }
}
