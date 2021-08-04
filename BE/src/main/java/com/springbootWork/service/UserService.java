package com.springbootWork.service;

import com.springbootWork.manager.LoginStatusManager;
import com.springbootWork.manager.UserManager;
import com.springbootWork.model.bo.AuthInfoBO;
import com.springbootWork.model.bo.LoginStatusBO;
import com.springbootWork.model.constant.UserType;
import com.springbootWork.model.vo.response.ResultVO;
import com.springbootWork.util.Md5Encrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends BaseService {
    private static final String PASSWORD_SALT = "_Rain_Ng-_Azure_99";

    private final HttpSession session;
    private final UserManager manager;
    private final LoginStatusManager loginStatusManager;
    private final Md5Encrypt md5Encrypt;

    public UserService(HttpSession session, UserManager manager, LoginStatusManager loginStatusManager, Md5Encrypt md5Encrypt) {
        this.session = session;
        this.manager = manager;
        this.loginStatusManager = loginStatusManager;
        this.md5Encrypt = md5Encrypt;
    }

    public ResultVO login(String username, String password, Integer userType) {
        AuthInfoBO authInfo = manager.getAuthInfoByUsername(username, userType);
        if (authInfo == null) {
            return failedResult("用户不存在");
        }

        //这块原始代码是将用户输入的密码进行Hash计算后进行对比，需要数据库中的密码也是Hash后的值；
//        String passwordHash = computePasswordHash(password);
//        if (!passwordHash.equals(authInfo.getPassword())) {
//            return failedResult("密码错误");
//        }

        //直接将用户输入的密码对数据库中的密码进行对比，没有经过Hash
        //用户注册的时候写入数据库的密码可能是Hash后的，需要注意一下！！！
        if (!password.equals(authInfo.getPassword())) {
            return failedResult("密码错误");
        }

        if (authInfo.getUserType().equals(UserType.STUDENT)) {
            manager.updateStudentLastLoginTime(username);
        }

        LoginStatusBO statusBO = LoginStatusBO.fromAuthInfo(authInfo);
        loginStatusManager.setLoginStatus(session, statusBO);

        return result(statusBO);
    }

    public ResultVO getLoginStatus() {
        LoginStatusBO statusBO = loginStatusManager.getLoginStatus(session);
        return result(statusBO);
    }

    public ResultVO logout() {
        loginStatusManager.setLoginStatus(session, null);
        return result("注销成功");
    }

    public String computePasswordHash(String password) {
        String md5 = md5Encrypt.computeHexString(password);
        return md5Encrypt.computeHexString(md5 + PASSWORD_SALT);
    }
}
