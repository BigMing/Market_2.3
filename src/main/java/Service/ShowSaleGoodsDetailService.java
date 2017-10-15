package Service;

import Dao.dao.BuyGoodsMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2014/9/15.
 */
@Service
public class ShowSaleGoodsDetailService {
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired(required = false)
    private BuyGoodsMapper buyGoodsMapper;

    public SaleGoods getSaleGoods(int saleGoodsId){
        return saleGoodsMapper.selectByPrimaryKey(saleGoodsId);
    }

    public BuyGoods getBuyGoods(int buyGoodsId){
        return buyGoodsMapper.selectByPrimaryKey(buyGoodsId);
    }
}
