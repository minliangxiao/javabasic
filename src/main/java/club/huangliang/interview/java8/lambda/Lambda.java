package club.huangliang.interview.java8.lambda;

import club.huangliang.interview.java8.lambda.Interface.Calculable;
import club.huangliang.interview.java8.lambda.Interface.Calculable_s;

/*
*  用lambda来实现 接口方法
*
*  要想让 idea支持lambda 需要做出一些设置 https://blog.csdn.net/u010360923/article/details/90574604
*
*  idea 可能还会报编译错误：https://www.cnblogs.com/comeluder/p/8215317.html
*
*  不管是内部类实现  还是lambda实现 还是implements实现，只要类实现了接口里面的方法这个类都可以调用
*  区别可能是 实例.方法.实现 或者 实例.方法
* */
public class Lambda   {
    Calculable result;
    Calculable_s result_s;
    public Calculable calculable(char opr){
        if (opr=='+'){
            result=(int a,int b)->{
                return a+b;
            };
        }else if (opr=='-'){
            //简写方式省略参数
            result=( a, b)->{
                return a-b;
            };
        }
        return result;
    }
    public Calculable_s calculable_s(char opr){
        if (opr=='*'){
            // 如只有一个参数可以不用小括号
            result_s=a->{
                return a*a;
            };
        }else {
            // 省略return 和大括号
            result_s=a->a*a*a;
        }
        return result_s;
    }

    /*测试*/
    public static void main(String[] args) {
        int n1=10;
        int n2=5;
        Lambda lambda=new Lambda();
        System.out.printf("%d+%d=%d\n", n1,n2,lambda.calculable('+').calculateInt(n1,n2));
        System.out.printf("%d-%d=%d\n", n1,n2,lambda.calculable('-').calculateInt(n1,n2));
        System.out.printf("%d*%d=%d\n", n1,n1,lambda.calculable_s('*').calculateInt(n1));
        System.out.printf("%d*%d*%d=%d\n", n1,n1,n1,lambda.calculable_s('/').calculateInt(n1));
    }

}
