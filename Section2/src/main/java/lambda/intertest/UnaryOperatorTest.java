package lambda.intertest;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    @Test
    public void identityTest() {
        UnaryOperator<Boolean>
                op = UnaryOperator.identity();
        System.out.println(op.apply(true));
    }

    @Test
    public void acceptTest() {
        UnaryOperator<Integer> xor = a -> a ^ 1;
        System.out.println(xor.apply(2));
    }

    @Test
    public void composeTest(){
        UnaryOperator<Integer> xor = a -> a ^ 1;
        UnaryOperator<Integer> and = a -> a & 1;
        Function<Integer, Integer> compose = xor.compose(and);
        System.out.println(compose.apply(231));
    }


}
