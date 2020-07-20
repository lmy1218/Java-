package stream;
/**
 * @Project lambda
 * @Package stream
 * @author lmy
 * @date 2020/5/10 19:28
 * @version V1.0
 */

import org.junit.Test;
import pojo.Employee;
import pojo.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lmy
 * @ClassName StreamAPIMOMTest
 * @Description Stream中间件测试
 * @date 2020/5/10 19:28
 **/

public class StreamAPIMOMTest {


    // 筛选与切片
    @Test
    public void test() {
        List<Employee> list = EmployeeData.getEmployee();
        // filter(Predicate p) --接收Lambda，从流中排除某些元素
        // 查询年龄大于20的
        list.stream().filter(e -> e.getAge() > 20).forEach(System.out :: println);

        System.out.println("=========================================");
        // limit(n) --截断流， 使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out :: println);

        System.out.println("===========================");
        // skip(n) -- 跳过元素，返回一个扔掉了前n 个元素的流，若流中不足n 个元素，则返回null
        list.stream().skip(2).forEach(System.out :: println);

        System.out.println("==============================");
        // disinct() -- 筛选，通过流所生成元素的hashCode() 和 equals() 方法去除重复元素
        list.add(new Employee(105, "吕布", 25));
        list.add(new Employee(106, "刘邦", 45));
        list.add(new Employee(105, "吕布", 24));
        list.add(new Employee(106, "刘邦", 45));
        list.stream().distinct().forEach(System.out :: println);
    }


    // 映射
    @Test
    public void test2() {
        // map(Function f) --接收一个函数作为参数，将元素转换成其它形式或提取信息，该函数会被应用到每个元素上， 并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        // 将小写转大写
        list.stream().map(String :: toUpperCase).forEach(System.out :: println);

        System.out.println("======================");
        // 获取员工姓名长度大于3的员工的姓名
        List<Employee> employeeList = EmployeeData.getEmployee();
        employeeList.stream().filter(e -> e.getName().length() > 2).map(e -> e.getName()).forEach(System.out :: println);

        System.out.println("=================");
        Stream<Stream<Character>> streams = list.stream().map(StreamAPIMOMTest::fromStringToStream);
        streams.forEach(s -> {
            s.forEach(System.out :: println);
        });

        System.out.println("==========================");
        // flatMap(Function f) --接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        list.stream().flatMap(StreamAPIMOMTest::fromStringToStream).forEach(System.out :: println);

    }


    // 排序
    @Test
    public void test3() {
        // sorted -- 自然排序
        List<Integer> list = Arrays.asList(12, 43, 434, 23, 67, -1);
        list.stream().sorted().forEach(System.out :: println);

        List<Employee> employees = EmployeeData.getEmployee();
        employees.stream().sorted().forEach(System.out :: println);

        System.out.println("============================");
        // sorted(Comparator com) -- 定制排序规则
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out :: println);

    }



    // 得到字符串对应的字符集合stream流
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

}
