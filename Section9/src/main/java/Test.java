import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;


public class Test {
    @org.junit.jupiter.api.Test
    public void testDebug() {
        List<Integer> integers = Arrays.asList(12, 3, 4, 5, 6);
        System.out.println(integers);
        integers.forEach(item->{
            System.out.println(item);
        });
        System.out.println(integers);
    }
}
