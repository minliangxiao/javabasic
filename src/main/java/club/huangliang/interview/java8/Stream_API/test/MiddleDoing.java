package club.huangliang.interview.java8.Stream_API.test;

import club.huangliang.interview.java8.Stream_API.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 流的中间操作
 */
public class MiddleDoing {
    List<Employee> list= Arrays.asList(
            new Employee("huang",22, Employee.Status.FREE),
            new Employee("tt",24, Employee.Status.FREE),
            new Employee("jack",28, Employee.Status.BUSY),
            new Employee("tom",29, Employee.Status.FREE),
            new Employee("toney",30, Employee.Status.BUSY),
            new Employee("toney",30, Employee.Status.BUSY)
    );

    /**常用的中间操作
     *切片与筛选
     * filter：接收 Lambda ，从流中排除某些元素
     * limit：截断流，使其元素不超过给定数量
     * skip(n)：跳过元素，返回一个舍弃了前n个元素的流；若流中元素不足n个，则返回一个空流；与 limit(n) 互补
     * distinct：筛选，通过流所生成的 hashCode() 与 equals() 取除重复元素
     */
    @Test
    public void testFilter(){

        list.stream()
                .filter(x -> x.getAge() > 25)
                .limit(3)
                .distinct()
                .skip(1)
                .forEach(System.out::println);

    }

    /**映射
     * map：接收 Lambda ，将元素转换为其他形式或提取信息；接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap：接收一个函数作为参数，将流中每一个值都换成另一个流，然后把所有流重新连接成一个流
     *
     * map 与 flatMap 的区别特别像 list的add 和addAll的区别
     */
    @Test
    public void testMap(){
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        MiddleDoing middleDoing=new MiddleDoing();
        // 测试 flatMap
        list.stream().flatMap(middleDoing::filterCharacter)
                .forEach(System.out::println);


    }

    public Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    /**
     * sorted()：自然排序 按照hash码值排序
     * sorted(Comparator c)：定制排序  自己定义规则
     */
    @Test
    public void sortIng(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .sorted() //comparaTo()
                .forEach(System.out::println);
        //定制排序
        this.list.stream()
                .sorted((e1, e2) -> { //compara()
                    if (e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }


}
