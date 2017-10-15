package Service;

import Dao.dao.BuyGoodsMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2014/9/4.
 */

@Service
public class ModifyGoodsFlagService {
    @Autowired(required = false)
    SaleGoodsMapper saleGoodsMapper;

    @Autowired(required = false)
    BuyGoodsMapper buyGoodsMapper;

    private static Logger logger = LoggerFactory.getLogger(ModifyGoodsFlagService.class);

    public void modifyGoodsFlag(int goodsId, int newFlag){
        try {
            SaleGoods saleGoods = saleGoodsMapper.selectByPrimaryKey(goodsId);
            saleGoods.setGoodsflag(newFlag);
            saleGoodsMapper.updateByPrimaryKeySelective(saleGoods);
            //return "set new flag";
        }
        catch (Exception ex) {
            logger.error("exception in ModifyGoodsFlagService", ex);
            //return "exception in ModifyGoodsFlagService";
        }
    }

    public void modifyBuyingFlag(int goodsId, int newFlag){
        try {
            BuyGoods buyGoods = buyGoodsMapper.selectByPrimaryKey(goodsId);
            buyGoods.setGoodsflag(newFlag);
            buyGoodsMapper.updateByPrimaryKeySelective(buyGoods);
            //return "set new flag";
        }
        catch (Exception ex) {
            logger.error("exception in ModifyGoodsFlagService", ex);
            //return "exception in ModifyGoodsFlagService";
        }
    }
}
