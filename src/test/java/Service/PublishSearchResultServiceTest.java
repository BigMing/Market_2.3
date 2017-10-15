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


public class PublishSearchResultServiceTest extends TestCase {

    @Autowired
    PublishGoodsService publishGoodsService;

    @Test
    public void testSaveGoodsInfomation() throws Exception {
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setHeadline("耳机");
        saleGoods.setPrice(1000.0);
        saleGoods.setDescription("onsale");
        saleGoods.setPhonenumber("1234567890");
        saleGoods.setContactor("dongdong");
        saleGoods.setSdid(4);
        saleGoods.setUserid(5);
        saleGoods.setGoodsflag(0);
        //System.out.print(publishGoodsService.saveGoodsInfomation(saleGoods));
    }
}