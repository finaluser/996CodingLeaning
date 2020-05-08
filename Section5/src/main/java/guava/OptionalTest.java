package guava;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 学习使用JDK8中的Optional的使用方法
 */
public class OptionalTest {
    @Test
    public void test() {
        /**
         * 三种创建Optional对象的方式
         */
        // 创建空的Optional对象
        Optional.empty();
        // 创建非Null值的引用对象
        Optional.of("王龙");
        // 使用任意值创建Optional对象
        Optional<Object> optional = Optional.ofNullable("张三");


        /**
         * 判断是否引用缺失方法(不建议使用)
         */
        optional.isPresent();

        /**
         * 当Optional引用存在时执行
         * 类似的方法map,filter,flatMap
         */
        optional.ifPresent(System.out::println);

        /**
         * 当引用缺失时执行
         */
        optional.orElse("引用缺失");
        optional.orElseGet(() -> {
            // 自定义引用缺失时候的返回值
            return "自定义引用缺失";
        });
        // 当Optional引用缺失时会抛出一个异常
//        optional.orElseThrow(() -> {
//            throw new RuntimeException("运行时异常");
//        });
    }

    /**
     * 使用Optional防止流为空的案例
     * @param list
     */
    public static void stream(List<String> list) {
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        stream(null);
    }

}
