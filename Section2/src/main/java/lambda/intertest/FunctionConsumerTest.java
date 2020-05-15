package lambda.intertest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FunctionConsumerTest {
    @Test
    public void testAccept() {
        // 使用Consumer直接执行语句
        Consumer<Integer> display = a -> System.out.println(a);

        // 使用accept()函数
        display.accept(10);

        // Consumer将列表中的每个元素乘以2
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // 使用Consumer进行列表输出
        Consumer<List<Integer>>
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // 使用accept()进行列表修改
        modify.accept(list);

        // 使用Accept进行列表输出
        dispList.accept(list);
    }

    @Test
    public void andThanTest() {
        // Consumer将列表中的每个元素乘以2
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // 使用Consumer进行列表输出
        Consumer<List<Integer>>
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // using addThen()
        modify.andThen(dispList).accept(list);

    }

    @Test
    public void and_then_exception_test() {
        // Consumer将列表中的每个元素乘以2
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // 使用Consumer进行列表输出
        Consumer<List<Integer>>
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        try {
            // using addThen()
            modify.andThen(null).accept(list);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void andThanExceptionHandleTest() {
        // Consumer将列表中的每个元素乘以2
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i <= list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // 使用Consumer进行列表输出
        Consumer<List<Integer>>
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // using addThen()
        try {
            dispList.andThen(modify).accept(list);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }


}
