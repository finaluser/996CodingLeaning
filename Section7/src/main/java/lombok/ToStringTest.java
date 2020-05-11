package lombok;

import org.junit.jupiter.api.Test;

/**
 * 默认生成ToString方法
 * 必须作用在类上
 */
@ToString(
        includeFieldNames = false,
        exclude = {"field1"},
        doNotUseGetters = true

)
public class ToStringTest {
    @Setter
    private String field1;
    @Setter
    private String field2;

    public String getField2() {
        System.out.println("调用Get方法");
        return this.field2;
    }

    @Test
    public void test() {
        ToStringTest toStringTest = new ToStringTest();
        toStringTest.setField1("张三");
        toStringTest.setField2("李四");
        System.out.println(toStringTest.toString());
    }

}
