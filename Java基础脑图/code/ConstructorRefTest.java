package lambda;
/**
 * @Project lambda
 * @Package lambda
 * @author lmy
 * @date 2020/5/8 18:37
 * @version V1.0
 */

import org.junit.Test;
import pojo.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lmy
 * @ClassName ConstructorRefTest
 * @Description 构造器引用
 * @date 2020/5/8 18:37
 **/

public class ConstructorRefTest {

    // 构造器引用
    // Supplier 中的T get()
    @Test
    public void test1() {
        // lambda
        Supplier<Employee> spu1 = () -> new Employee();
        Employee emp1 = spu1.get();
        System.out.println(emp1);
        System.out.println("===============");

        // 构造器引用
        Supplier<Employee> spu2 = Employee::new;
        Employee emp2 = spu2.get();
        System.out.println(emp2);
    }

    // Function 中的R apply(T t)
    @Test
    public void test2() {
        // lambda
        Function<Integer, Employee> func1 = id -> new Employee(id);
        func1.apply(111);

        // 构造器引用
        Function<Integer, Employee> func2 = Employee::new;
        func2.apply(111);
    }

    // BiFunction 中的R apply(T t, U u)
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> bfunc1 = (id, name) -> new Employee(id, name);
        System.out.println(bfunc1.apply(100, "Tom"));

        // 构造器引用
        BiFunction<Integer, String, Employee> bfunc2 = Employee::new;
        System.out.println(bfunc2.apply(110, "Tom"));
    }

    // 数组引用
    // Function 中的R apply(T t)
    @Test
    public void test4() {
        // lambda
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);

        // 数组引用
        Function<Integer, String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(5);

    }
}
