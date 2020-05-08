package guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不可变集合的用法
 */
public class ImmutableTest {
    public static void test(List<Integer> list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 将可变集合转换成不可变集合
        List<Integer> integers = Collections.unmodifiableList(list);
        test(integers);
        System.out.println(list);
    }

    @Test
    public void immutable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        /**
         * 构造不可变集合的三种方式
         */
        // 通过已存在的集合创建
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(list);
        integers.add(12);
        // 通过初始值直接创建不可变集合
        ImmutableSet<Integer> of = ImmutableSet.of(1, 2, 3, 4, 5);
        of.add(3);
        // 通过构造器的方式创建不可变集合
        ImmutableSet<Object> build = ImmutableSet.builder()
                .add(1)
                .addAll(Sets.newHashSet(2, 3))
                .add(4)
                .build();
        build.add(1);
        build.stream().forEach(System.out::println);
    }
}
