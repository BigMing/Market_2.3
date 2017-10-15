package Service;

import Dao.dao.GoodsImageMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by li on 2014/9/4.
 */

@Service
public class RePublishGoodsService {
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired(required = false)
    private GoodsImageMapper goodsImageMapper;

    private static Logger logger = LoggerFactory.getLogger(RePublishGoodsService.class);

    public String updateGoodsInformation(SaleGoods saleGoods){
        try {
            saleGoods.setPosttime(new Date());
            saleGoods.setGoodsflag(0);
            //find better way
            saleGoodsMapper.updateByPrimaryKeySelective(saleGoods);
            return "update goods";
        }
        catch (Exception ex) {
            logger.error("exception in RePublishGoodsService", ex);
            //System.out.println(ex.getMessage());
            return "exception in RePublishGoodsService";
            //return 0;
        }
    }

    public SaleGoods getGoods(int goodsId){
        return saleGoodsMapper.selectByPrimaryKey(goodsId);
    }

    public List<String> getGoodsImages(int goodsId){
        return goodsImageMapper.selectByGoodsId(goodsId);
    }
}
