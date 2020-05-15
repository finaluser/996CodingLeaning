package lambda.intertest;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FunctionTest {
    @Test
    public void applyTest() {
        Function<Integer, Double> half = a -> a / 2.0;
        // 使用apply方法返回结果
        System.out.println(half.apply(10));
    }

    @Test
    public void andThenTest() {
        Function<Integer, Double> half = a -> a / 2.0;

        half = half.andThen(a -> 3 * a);

        System.out.println(half.apply(10));
    }

    @Test
    public void andThenExceptionTest() {
        Function<Integer, Double> half = a -> a / 2.0;

        try {

            // 传入Null
            half = half.andThen(null);
        } catch (Exception e) {
            System.out.println("Exception thrown "
                    + "while passing null: " + e);
        }
    }

    @Test
    public void composeTest() {
        Function<Integer, Double> half = a -> a / 2.0;
        half = half.compose(a -> 3 * a);
        System.out.println(half.apply(5));
    }

    @Test
    public void identityTest() {
        Function<Object, Object> function = Function.identity();
        System.out.println(function.apply(100));
        System.out.println(Function.identity().apply(100111));
    }

}
