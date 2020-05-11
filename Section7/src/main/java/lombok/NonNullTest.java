package lombok;

/**
 * @NonNull 作用在方法的属性上, 或者入参上
 * 作用是生成非空检查
 */
public class NonNullTest {
    public NonNullTest(@NonNull String field) {
        System.out.println(field);
    }
}
