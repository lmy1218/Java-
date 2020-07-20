package lambda;
/**
 * @Project lambda
 * @Package lambda
 * @author lmy
 * @date 2020/5/8 17:40
 * @version V1.0
 */

import org.junit.Test;
import pojo.Employee;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lmy
 * @ClassName MethodRelfTest
 * @Description 方法引用测试
 *
 * 使用情况： 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 * 本质：lambda表达式
 *
 * 具体分为三种情况：
 * 对象 :: 非静态方法
 * 类 :: 静态方法
 * 类 :: 非静态方法
 * @date 2020/5/8 17:40
 **/

public class MethodRelfTest {

    // 情况一： 对象 :: 实例方法
    // Consumer 中的void accept(T t)
    // PrintStream 中的 void println(T t)
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("===================");
        // 方法引用
        Consumer<String> con2 = System.out :: println;
        con2.accept("beijing");

    }


    // Supplier中的T get()
    // Employee 中的 String getName
    @Test
    public void test2() {
        Employee emp = new Employee(1001, "Tom", 23);

        Supplier<String> spu1 = () -> emp.getName();
        System.out.println(spu1.get());

        // 方法引用
        System.out.println("===============");
        Supplier<String> spu2 = emp :: getName;
        System.out.println(spu2.get());

    }

    // 情况二： 类 :: 静态方法
    // Comparator 中的int compare(T t1, T t2)
    // Integer 中的静态方法int compare(T t1, T t2)
    @Test
    public void test3() {
        // lambda
        Comparator<Integer> con1 = (t1, t2) -> Integer.compare(t1, t2);
        con1.compare(12, 57);
        // 方法引用
        Comparator<Integer> con2 = Integer::compare;
        con2.compare(57, 12);
    }

    //Function 中的 R apply(T t)
    // Math 中的静态方法Long round(Double d);
    @Test
    public void test4() {
        // lambda
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(14.0D));

        // 方法引用
        Function<Double, Long> func2 = Math :: round;
        System.out.println(func2.apply(14.0D));

    }


    // 情况三： 类 :: 实例方法
    // Comparator 中的void accept(T t1, T t2)
    // String 中的 int t1.compareTo(t2)
    @Test
    public void test5() {
        // lambda
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abe"));

        // 方法引用
        Comparator<String> com2 = String :: compareTo;
        System.out.println(com2.compare("abc", "abd"));
    }

    // BiPredicate 中的boolean test(T t1, T t2)
    // String 中的boolean t1.equals(t2)
    @Test
    public void test6() {
        // lambda
        BiPredicate<String, String> pre1 = (t1, t2) -> t1.equals(t2);
        System.out.println(pre1.test("abc", "abc"));

        // 方法引用
        BiPredicate<String, String> pre2 = String :: equals;
        System.out.println(pre2.test("abc", "abb"));
    }

    // Function 中的 R apply(T t)
    // Employee 中的String getName()
    @Test
    public void test7() {
        // lambda
        Employee emp = new Employee(100, "Tom", 23);
        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(emp));

        // 方法引用
        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(emp));

    }

}
