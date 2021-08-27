package club.huangliang.interview.java8.Stream_API.test;

import club.huangliang.interview.java8.Stream_API.pojo.Employee;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class test {
    @Test
   public void test(){
        List<Employee> list = Arrays.asList(
                new Employee("张三",23, Employee.Status.BUSY),
                new Employee("黄",23, Employee.Status.FREE),
                new Employee("良",23, Employee.Status.FREE),
                new Employee("帅",23, Employee.Status.FREE)
        );
        Map<String,Employee> map=new HashMap<>();
        list.forEach(x-> {
            if (x.getName().length()<2) {
                map.put(UUID.randomUUID().toString(),x);
            }

        });
        System.out.println(map);
   }
}
