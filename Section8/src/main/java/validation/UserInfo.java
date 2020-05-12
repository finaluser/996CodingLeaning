package validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 待验证对象
 */
@Getter
@Setter
public class UserInfo {

    // 登录场景
    public interface LoginGroup {

    }


    //注册场景
    public interface RegisterGroup {

    }

    // 组排序场景
    @GroupSequence({
            LoginGroup.class,
            RegisterGroup.class,
            Default.class
    })
    public interface Group {

    }

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空",
            groups = LoginGroup.class
    )
    private String userId;
    /**
     * 用户名
     *
     * @NotEmpty:不会自动去掉前后的空格
     */
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    /**
     * 密码
     *
     * @Notblank会自动去除字符串前后的空格
     */
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 20, message = "密码不能小于6位不能多于20位")
    private String password;
    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空", groups = RegisterGroup.class)
    @Email(message = "无效邮箱")
    private String email;

    /**
     * 手机号码
     */
    @Phone(message = "手机号不是132开头的")
    private String phone;

    /**
     * 生日
     */
    @Past(message = "生日不能为未来时间")
    private Date birthday;
    /**
     * 年龄
     */
    @Max(value = 60, message = "年龄太大")
    @Min(value = 18, message = "年龄未满")
    private Integer age;

    /**
     * 好友列表
     */
    @Size(min = 1, message = "不能少于1个")
    private List<@Valid UserInfo> friends;


}
