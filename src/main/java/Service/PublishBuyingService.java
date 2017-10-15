package Service;

import Dao.dao.BuyGoodsMapper;
import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by li on 2014/9/3.
 */

@Service
public class PublishBuyingService {
    @Autowired(required = false)
    BuyGoodsMapper buyGoodsMapper;

    private static Logger logger = LoggerFactory.getLogger(PublishBuyingService.class);

    public void saveBuyingInfomation(BuyGoods buyGoods){
        try{
            buyGoods.setPosttime(new Date());
            buyGoods.setGoodsflag(0);
            buyGoodsMapper.insert(buyGoods);
            //return "insert into DB";
        }
        catch (Exception ex) {
            logger.error("exception in BuyGoodsService.save", ex);
            //System.out.println(ex.getMessage());
            //return "exception in BuyGoodsService.save";
            //return 0;
        }
    }
}
