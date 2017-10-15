package Service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml",
        "file:src/main/webapp/WEB-INF/spring-mybatis.xml"})

public class LoginServiceTest extends TestCase {

    @Autowired
    private LoginService loginService;

    @Test
    public void testCheckLogin() throws Exception {
        //System.out.print(loginService.checkLogin("sjm","sjm"));
        System.out.print(loginService.getUserId("sjm"));
    }
}