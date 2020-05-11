package lombok;

/**
 * 用于生成equals和hashcode方法
 */
@EqualsAndHashCode(
        exclude = "field1"
)
public class EqualsAndHashCodeTest {
    private String field1;
    private String field2;
}
