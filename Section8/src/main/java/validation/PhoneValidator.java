package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义手机号约束注解关联验证器
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * 自定义手机号的验证逻辑
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String check = "132\\d{8}";
        Pattern regex = Pattern.compile(check);
        // 空值处理
        String phone = Optional.ofNullable(value).orElse("");
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }
}
