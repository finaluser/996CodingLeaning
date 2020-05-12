package validation;

/**
 * 用户信息的服务类
 */
public class UserInfoService {
    /**
     * 输入参数校验
     *
     * @param userInfo
     */
    public void setUserInfo(UserInfo userInfo) {

    }

    /**
     * 对输出参数进行校验
     *
     * @return
     */
    public UserInfo getUserInfo() {
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
    public UserInfoService(UserInfo userInfo) {

    }
}
