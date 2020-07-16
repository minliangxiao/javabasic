package club.huangliang.interview.java8.lambda;
/*
* lambda之前用匿名累不类解决问题
*
* 通过匿名内部类赖实现接口方法。
* */

import club.huangliang.interview.java8.lambda.Interface.Calculable;

public class NotNameClass {

  public static Calculable calculable(char opr){
      Calculable result = null; //如将它申明为类变量则静态方法体中拿不到这个
      if (opr=='+'){
          result=new Calculable() {
              public int calculateInt(int a, int b) {
                  return a+b;
              }
          };

      }else if (opr=='-'){
          result=new Calculable() {
              public int calculateInt(int a, int b) {
                  return a-b;
              }
          };
      }else if (opr=='/'){
           result=new Calculable() {
               public int calculateInt(int a, int b) {
                   return a/b;
               }
           };
      }else if (opr=='*'){
          result=new Calculable() {
              public int calculateInt(int a, int b) {
                  return a*b;
              }
          };
      }
      return result;
  }
    /*测试方法*/
    public static void main(String[] args) {
        int n1=10;
        int n2=5;
        Calculable f1=calculable('+');
        Calculable f2=calculable('-');
        Calculable f3=calculable('*');
        Calculable f4=calculable('/');
        System.out.printf("%d+%d=%d\n",n1,n2,f1.calculateInt(n1,n2));
        System.out.printf("%d-%d=%d\n",n1,n2,f2.calculateInt(n1,n2));
        System.out.printf("%d*%d=%d\n",n1,n2,f3.calculateInt(n1,n2));
        System.out.printf("%d/%d=%d\n",n1,n2,f4.calculateInt(n1,n2));
    }
}

