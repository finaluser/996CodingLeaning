package lombok;

import java.util.ArrayList;

/**
 * Value注解:
 * 弱语言变量
 */
public class ValTest {
    public ValTest() {
        // 会根据后面的数据类型的情况来推断前面的数据类型是什么.
        val field = "张三";
        val list = new ArrayList<String>();
        list.add(field);
        list.add("李四");
    }
}
