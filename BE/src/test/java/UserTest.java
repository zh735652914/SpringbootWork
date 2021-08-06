
import com.springbootWork.service.UserService;
import com.springbootWork.util.Md5Encrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ---
 * @date 3/6/2020
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
    @Test
    public void Test1() {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println("SpringVersion: " + version);
        System.out.println("SpringBootVersion: " + version1);
    }

    @Test
    public void Test2() {
        String password = "111111";
        Md5Encrypt md5Encrypt = new Md5Encrypt();
        String md5 = md5Encrypt.computeHexString(password);
        String PASSWORD_SALT = UserService.getPasswordSalt();
        System.out.println("加密后密码为： " + md5Encrypt.computeHexString(md5 + PASSWORD_SALT));
    }
}
