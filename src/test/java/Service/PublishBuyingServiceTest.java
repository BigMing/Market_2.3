package Service;

import Dao.model.BuyGoods;
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


public class PublishBuyingServiceTest extends TestCase {

    @Autowired
    PublishBuyingService publishBuyingService;

    @Test
    public void testSaveBuyingInfomation() throws Exception {
//        BuyGoods Goods = new BuyGoods();
//        Goods.setHeadline("耳机");
//        //Goods.setPrice(1000.0);
//        //Goods.setDescription("onsale");
//        Goods.setPhonenumber("1234567890");
//        Goods.setContactor("dongdong");
//        Goods.setSdid(4);
//        Goods.setUserid(5);
//        Goods.setGoodsflag(0);
//        System.out.print(publishBuyingService.saveBuyingInfomation(Goods));
    }
}