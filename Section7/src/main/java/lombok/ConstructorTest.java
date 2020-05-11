package lombok;

import com.sun.istack.internal.NotNull;

/**
 * 构造函数注解
 *
 * @AllArgConstructor 全参构造函数
 * @NoArgConstructor 无参构造函数
 * @RequiredArgConstructor 必要参数构造函数
 */
@RequiredArgsConstructor
public class ConstructorTest {
    private final String field1;
    @NonNull
    private String field2;
    private String field3;
}
