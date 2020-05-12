package validation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 验证测试类
 */
public class ValidationTest {
    // 验证器
    private Validator validator;
    // 待验证对象
    private UserInfo userInfo;
    // 验证结果集合
    private Set<ConstraintViolation<UserInfo>> set;
    // 验证结果集合
    private Set<ConstraintViolation<UserInfoService>> otherSet;

    /**
     * 初始化
     */
    @BeforeEach
    public void init() {
        // 初始化验证器
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        //初始化待验证对象
        userInfo = new UserInfo();
//        userInfo.setUserId("001");
        userInfo.setUserName(" ");
        userInfo.setPassword("123456");
        userInfo.setPhone("13278788989");
//        userInfo.setEmail("asdasd@qq.com");
        userInfo.setAge(19);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, 7, 9);
        userInfo.setBirthday(calendar.getTime());
        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        userInfo.setFriends(list);
    }

    /**
     * 结果打印
     */
    @AfterEach
    public void print() {
        set.forEach(item -> {
            // 输出验证错误信息
            System.out.println(item.getMessage());
        });
    }

    @Test
    public void NullValidation() {
        // 验证器对对象进行验证
        set = validator.validate(userInfo);
    }

    /**
     * 级联验证测试类
     */
    @Test
    public void graphValidation() {
        set = validator.validate(userInfo);
    }

    @Test
    public void groupValidation() {
        set = validator.validate(userInfo, UserInfo.RegisterGroup.class, UserInfo.LoginGroup.class);
    }

    /**
     * 验证组排序
     */
    @Test
    public void groupSequenceValidation() {
        set = validator.validate(userInfo, UserInfo.Group.class);
    }

    /**
     * 对方法输入参数进行约束注解校验
     */
    @Test
    public void paramValidation() throws NoSuchMethodException {
        // 获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();
        UserInfoService service = new UserInfoService();
        // 获取待验证方法
        Method method = service.getClass().getMethod("setUserInfo", UserInfo.class);
        // 获取方法的输入参数
        Object[] paramObjects = new Object[]{new UserInfo()};

        // 对方法的输入参数进行校验
        otherSet = executableValidator.validateParameters(service, method, paramObjects);
    }

    /**
     * 对方法返回值进行校验
     */
    @Test
    public void returnValueValidation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();
        // 构造要验证的方法对象
        UserInfoService service = new UserInfoService();
        Method method = service.getClass().getMethod("getUserInfo");
        // 调用方法得到返回值
        Object invoke = method.invoke(service);
        // 校验方法返回值是否符合约束
        otherSet = executableValidator.validateReturnValue(service, method, invoke);
    }

    //对构造函数的输入参数进行校验
    @Test
    public void constructorValidation() throws NoSuchMethodException {
        // 获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();
        // 获取构造函数
        Constructor<UserInfoService> constructor = UserInfoService.class.getConstructor(UserInfo.class);
        Object[] paramObjects = new Object[]{new UserInfo()};
        //校验构造函数
        otherSet = executableValidator.validateConstructorParameters(constructor, paramObjects);
    }

    /**
     * 自定义手机号验证器
     */
    @Test
    public void customPhoneValidation(){
        // 验证器对对象进行验证
        set = validator.validate(userInfo);
    }
}
