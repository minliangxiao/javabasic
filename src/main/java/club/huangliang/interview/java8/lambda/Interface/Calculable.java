package club.huangliang.interview.java8.lambda.Interface;
/*
*  更具符号 计算两个值
* */

//计算接口
@FunctionalInterface //表示接口中只能有一个方法，lambda实现的函数接口只能有一个抽象方法（一个房啊发）。
public interface Calculable {
    //计算两个int数值
    int calculateInt(int a,int b);
}
