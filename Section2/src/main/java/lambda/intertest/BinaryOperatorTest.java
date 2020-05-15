package lambda.intertest;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    @Test
    public void max_by_test() {
        BinaryOperator<Integer>
                op = BinaryOperator
                .maxBy(
                        (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));

        System.out.println(op.apply(98, 11));
    }

    @Test
    public void min_by_test() {
        BinaryOperator<Integer>
                op = BinaryOperator
                .minBy(
                        (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));

        System.out.println(op.apply(98, 11));
    }
}
