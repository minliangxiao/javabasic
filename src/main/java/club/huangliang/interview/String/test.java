package club.huangliang.interview.String;

import org.junit.Test;

public class test {
    @Test
    public void test(){
        String test="123";
        String str="1";
        String str1="2";
        String str2="3";
        System.out.println(test=="1"+"2"+"3");
        System.out.println(test==str+str1+str2);

    }
    @Test
    public void test2(){
        String s0="12";
        final String s1="2";
        String s2="1"+s1;
        System.out.println(s0==s2);
    }

}
