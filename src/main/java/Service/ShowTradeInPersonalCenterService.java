package Service;

import Dao.dao.BuyGoodsMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2014/9/4.
 */

@Service
public class ShowTradeInPersonalCenterService {
    @Autowired(required = false)
    SaleGoodsMapper saleGoodsMapper;

    @Autowired(required = false)
    BuyGoodsMapper buyGoodsMapper;

    private static Logger logger = LoggerFactory.getLogger(ShowTradeInPersonalCenterService.class);

    public SaleGoods[] showGoodsInformation(int userId){
        try {
            List<SaleGoods> list = saleGoodsMapper.selectByUserId(userId);
            SaleGoods[] saleGoodses = new SaleGoods[list.size()];
            for (int i = 0; i < list.size(); i++){
                saleGoodses[i] = list.get(i);
            }
            //System.out.println(list.size());
            return saleGoodses;
        }
        catch (Exception ex) {
            logger.error("exception in ShowGoodsInPersonalCenterService.sale", ex);
            //System.out.println(ex.getMessage());
            //return "exception in ShowGoodsInPersonalCenterService.sale";
            return null;
        }
    }

    public BuyGoods[] showBuyingInformation(int userId){
        try {
            List<BuyGoods> list = buyGoodsMapper.selectByUserId(userId);
            BuyGoods[] buyGoodses = new BuyGoods[list.size()];
            for (int i = 0; i < list.size(); i++){
                buyGoodses[i] = list.get(i);
            }
            //System.out.println(list.size());
            return buyGoodses;
        }
        catch (Exception ex) {
            logger.error("exception in ShowGoodsInPersonalCenterService.buying", ex);
            //System.out.println(ex.getMessage());
            //return "exception in ShowGoodsInPersonalCenterService.buying";
            return null;
        }
    }
}
