package lombok;

import com.sun.istack.internal.NotNull;

/**
 * @Getter注解 为类中的属性生成get方法
 * 作用在类上: 为类中的所有属性生成get方法
 * 作用在属性上:为类中的某个属性生成get方法
 */

public class GetterTest {
    @Getter(lazy = true)
    private final String field1 = "张三";
    @Getter(value = AccessLevel.PRIVATE, onMethod_ = {@NotNull})
    private String field2;
}
