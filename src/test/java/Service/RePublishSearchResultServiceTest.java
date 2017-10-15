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


public class RePublishSearchResultServiceTest extends TestCase {

    @Autowired
    RePublishGoodsService rePublishGoodsService;

    @Test
    public void testUpdateGoodsInformation() throws Exception {
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setSalegoodsid(4);
        saleGoods.setHeadline("魔声");
        saleGoods.setPrice(1000.0);
        saleGoods.setDescription("头戴耳机");
        saleGoods.setPhonenumber("1234567890");
        saleGoods.setContactor("dongdong");
        saleGoods.setSdid(4);
        saleGoods.setUserid(5);
        saleGoods.setGoodsflag(0);
        System.out.print(rePublishGoodsService.updateGoodsInformation(saleGoods));
    }
}