package stream;
/**
 * @Project lambda
 * @Package stream
 * @author lmy
 * @date 2020/5/9 19:30
 * @version V1.0
 */

import org.junit.Test;
import pojo.Employee;
import pojo.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lmy
 * @ClassName StreamTest
 * @Description Stream API
 * @date 2020/5/9 19:30
 *
 * Stream 关注的事对数据的运算，与CPU打交道
 * Collection集合关注数据的存储，与内存打交道
 *
 * Stream 自身不保存数据
 * Stream 不会改变原对象， 相反会返回一个一个新的Stream
 * Stream 操作是延迟执行的，这意味着她会等到需要结果时才执行
 *
 * Stream 执行流程：
 *  Stream的实例化
 *  一系列的中间操作（过滤、映射....）
 *  终止操作
 *
 **/

public class StreamTest {

    // Stream创建方式一: 通过集合创建
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployee();
        // default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }


    // Stream创建方式二： 通过数组
    @Test
    public void test2() {
        String str = "wo,shi,li,ming,yang";
        String[] strs = str.split(",");

        // 使用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        Stream<String> stream = Arrays.stream(strs);

    }

    // Stream创建方式二： 通过Stream 的 of()方法
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
    }


    // Stream创建方式二： 创建无限流
    @Test
    public void test4() {
        // 迭代
        // public static <T> Stream<T>.iterate(final T seed, final UnaryOperator<T> f)
        // 遍历前十个偶数
        Stream.iterate(0,t -> t + 2 ).limit(10).forEach(System.out :: println);


        // 生成
        // public static <T> Stream<T> gennerate(Supplier<T> s)
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);

    }

}
