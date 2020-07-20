package stream;
/**
 * @Project lambda
 * @Package stream
 * @author lmy
 * @date 2020/5/10 21:26
 * @version V1.0
 */

import org.junit.Test;
import pojo.Employee;
import pojo.EmployeeData;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lmy
 * @ClassName StreamEndTest
 * @Description 终止操作
 * @date 2020/5/10 21:26
 **/

public class StreamEndTest {

    // 匹配与查询
    @Test
    public void test1() {
        
        List<Employee> employees = EmployeeData.getEmployee();

        // allMatch(Predicate p) --检查是否匹配所有元素
        boolean result = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(result);

        // anyMatch(Predicate p) --检查是否至少匹配一个元素
        result = employees.stream().anyMatch(e -> e.getAge() > 30);
        System.out.println(result);

        // noneMatch(Predicate p) --检查是否没有匹配的元素
        result = employees.stream().noneMatch(e -> e.getName().startsWith("孙"));
        System.out.println(result);

        // findFirst --返回第一个元素
        Optional<Employee> first = employees.stream().sorted().findFirst();
        System.out.println(first);

        // findAny --返回当前流中任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

        // count --返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getAge() > 20).count();
        System.out.println(count);

        // max(Comparator c) --返回流中最大值
        Optional<Integer> max = employees.stream().map(e -> e.getAge()).max(Integer::compare);
        System.out.println(max);

        // min(Comparator c) -- 返回流中最小值
        Optional<Integer> min = employees.stream().map(e -> e.getAge()).min(Integer::compare);
        System.out.println(min);

        // forEach（Consumer c） -- 内部迭代
        employees.stream().forEach(System.out :: println);
    }


    // 归约
    @Test
    public void test2() {
        // reduce(T identity, BinaryOperator b) --可以将流中的元素反复结合起来，得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);


        // reduce(BinaryOperator b) --可以将流中的元素反复结合起来，得到一个值，返回Optional<T>
        List<Employee> employee = EmployeeData.getEmployee();
        Optional<Integer> sum = employee.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println(sum);
    }


    // 收集
    @Test
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployee();
        // collect(Collector c) --将流转换为其它形式，接收一个Collector接口的实现
        List<Employee> employeeList = employees.stream().filter(e -> e.getAge() > 20).collect(Collectors.toList());
        employeeList.forEach(System.out :: println);

        System.out.println("==============================");
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getAge() > 20).collect(Collectors.toSet());
        employeeSet.forEach(System.out :: println);

    }


}
