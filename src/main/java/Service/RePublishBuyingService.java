package Service;

import Dao.dao.BuyGoodsMapper;
import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by li on 2014/9/4.
 */

@Service
public class RePublishBuyingService {
    @Autowired(required = false)
    BuyGoodsMapper buyGoodsMapper;

    private static Logger logger = LoggerFactory.getLogger(RePublishBuyingService.class);

    public BuyGoods getBuying(int goodsId){
        return buyGoodsMapper.selectByPrimaryKey(goodsId);
    }

    public String updateBuyingInformation(BuyGoods buyGoods){
        try{
            buyGoods.setPosttime(new Date());
            buyGoods.setGoodsflag(0);
            buyGoodsMapper.updateByPrimaryKeySelective(buyGoods);
            return "update buying";
        }
        catch (Exception ex){
            logger.error("exception in RePublishBuyingService", ex);
            return "exception in RePublishBuyingService";
        }
    }
}
