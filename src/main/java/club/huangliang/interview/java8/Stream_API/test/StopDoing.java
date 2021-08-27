package club.huangliang.interview.java8.Stream_API.test;

import club.huangliang.interview.java8.Stream_API.pojo.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StopDoing {
    List<Employee>emps = Arrays.asList(
            new Employee("huang",22, Employee.Status.FREE),
            new Employee("tt",24, Employee.Status.FREE),
            new Employee("jack",28, Employee.Status.BUSY),
            new Employee("tom",29, Employee.Status.FREE),
            new Employee("toney",30, Employee.Status.BUSY),
            new Employee("toney",30, Employee.Status.BUSY)
    );

    /**
     * allMatch：检查是否匹配所有元素
     * anyMatch：检查是否至少匹配一个元素
     * noneMatch：检查是否没有匹配所有元素
     * findFirst：返回第一个元素
     * findAny：返回当前流中的任意元素
     * count：返回流中元素的总个数
     * max：返回流中最大值
     * min：返回流中最小值
     */
    @Test
    public void serch(){
        List<Employee.Status> list = Arrays.asList(Employee.Status.FREE, Employee.Status.BUSY, Employee.Status.VOCATION);

        boolean flag1 = list.stream()
                .allMatch((s) -> s.equals(Employee.Status.BUSY));
        System.out.println(flag1);

        boolean flag2 = list.stream()
                .anyMatch((s) -> s.equals(Employee.Status.BUSY));
        System.out.println(flag2);

        boolean flag3 = list.stream()
                .noneMatch((s) -> s.equals(Employee.Status.BUSY));
        System.out.println(flag3);

        // 避免空指针异常 Optional的使用能够避免空指针异常
        Optional<Employee.Status> op1 = list.stream()
                .findFirst();
        // 如果Optional为空 找一个替代的对象 Optional.orElse（T other） 如果Optional中存在值则 返回值  否者返回other
        Employee.Status s1 = op1.orElse(Employee.Status.BUSY);
        System.out.println(s1);

        Optional<Employee.Status> op2 = list.stream()
                .findAny();
        System.out.println(op2);

        long count = list.stream()
                .count();
        System.out.println(count);
    }

    /**
     * 归约：reduce(T identity, BinaryOperator) / reduce(BinaryOperator) 可以将流中的数据反复结合起来，得到一个值
     * 收集：collect 将流转换成其他形式；接收一个 Collector 接口的实现，用于给流中元素做汇总的方法
     */
    @Test
    public void collectAnDinduction(){

        //归纳
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer integer = list1.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(integer);

        //收集 collect
        //放入List
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        //放入Set
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        //放入LinkedHashSet
        LinkedHashSet<String> linkedHashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        linkedHashSet.forEach(System.out::println);



    }

}
