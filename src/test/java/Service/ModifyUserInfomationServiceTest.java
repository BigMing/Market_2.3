package Service;

import Dao.model.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml","file:src/main/webapp/WEB-INF/spring-mybatis.xml"})

public class ModifyUserInfomationServiceTest extends TestCase {

    @Autowired
    ModifyUserInfomationService modifyUserInfomationService;

    @Test
    public void testModifyUserInfomation() throws Exception {
        User user = new User();
        user.setUserid(6);

        user.setEmail("sunjm@qq.com");
        user.setPassword("12");
       // System.out.print(modifyUserInfomationService.modifyUserInfomation(user));
    }
}