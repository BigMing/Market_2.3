package Service;

import Dao.model.CollectGoods;
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


public class CollectSearchResultServiceTest extends TestCase {

    @Autowired
    CollectGoodsService collectGoodsService;

    @Test
    public void testSaveCollectGoods() throws Exception {
        System.out.println(collectGoodsService.saveCollectGoods(1,2));
    }

    @Test
    public void testJudgeCollectGoods() throws Exception {
        //System.out.println(collectGoodsService.judgeCollectGoods(1,3));
    }

    @Test
    public void testShowCollection() throws Exception{
        //collectGoodsService.showCollection(2);
    }

    @Test
    public void testDeleteCollection() throws Exception{
        //System.out.print(collectGoodsService.deleteCollection(3,1));
    }
}