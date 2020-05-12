package validation;

import javax.validation.Valid;

/**
 * 用户信息的服务类
 */
public class UserInfoService {
    /**
     * 输入参数校验
     *
     * @param userInfo
     */
    public void setUserInfo(@Valid UserInfo userInfo) {

    }

    /**
     * 对输出参数进行校验
     *
     * @return
     */
    public @Valid UserInfo getUserInfo() {
        return new UserInfo();
    }

    /**
     * 空参构造函数
     */
    public UserInfoService() {
    }

    /**
     * 接收UserInfo的构造
     * @param userInfo
     */
    public UserInfoService(@Valid UserInfo userInfo) {

    }
}
