package lambda;
/**
 * @Project lambda
 * @Package lambda
 * @author lmy
 * @date 2020/5/8 16:34
 * @version V1.0
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author lmy
 * @ClassName LambdaTest
 * @Description 测试Lambda的语法
 * @date 2020/5/8 16:34
 **/

/**
 * 举例：（o1, o2）-> Integer.compare(o1,o2);
 * 格式：
 *  -> ：箭头操作符
 *  -> 左边: lambda形参列表
 *  -> 右边: lambda体 （其实就是重写的抽象方法的方法体）
 *
 * Lambda 表达式的使用：分为六种情况
 */
public class LambdaTest {

    // 语法一：无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("非lambda");
            }
        };
        r1.run();

        System.out.println("=============================");
        Runnable r2 = () -> System.out.println("lambda");

        r2.run();


    }

    // 语法二： 有一个参数，但没有返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("你和猪的区别是什么？");

        // lambda实现
        System.out.println("==================");
        Consumer<String> con2 = (String s) -> System.out.println(s);
        // 类型推断，省略了类型声明
        Consumer<String> con3 = (s) -> System.out.println(s);
        // 如果只有一个参数，可以省略小括号
        Consumer<String> con4 = s -> System.out.println(s);
        con2.accept("都是猪");
    }


    // 语法三： lambda 有两个或两个以上的参数、发多条执行语句、并且可以有返回值
    @Test
    public void test3() {
        Comparator<Integer> con1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(con1.compare(8, 9));

        System.out.println("=====================");
        Comparator<Integer> con2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        // 若只有一条语句
        Comparator<Integer> con3 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(con2.compare(10, 9));
    }


}
