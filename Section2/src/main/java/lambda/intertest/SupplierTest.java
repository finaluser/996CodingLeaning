package lambda.intertest;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class SupplierTest {
    @Test
    public void getTest(){
        Supplier<Double> randomValue = () -> Math.random();

        System.out.println(randomValue.get());
    }
}
