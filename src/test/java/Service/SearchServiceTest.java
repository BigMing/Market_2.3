package Service;

import Dao.model.SaleGoods;
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

public class SearchServiceTest extends TestCase {

    @Autowired
    SearchService searchService;

    @Test
    public void testSearchGoods() throws Exception {
        System.out.print(searchService.searchGoods("%ip%").get(0).getSalegoodsid());
    }
}