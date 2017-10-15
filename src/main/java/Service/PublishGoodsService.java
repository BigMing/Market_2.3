package Service;

import Dao.dao.GoodsImageMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.GoodsImage;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by li on 2014/9/3.
 */

@Service
public class PublishGoodsService {
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired(required = false)
    private GoodsImageMapper goodsImageMapper;

    private static Logger logger = LoggerFactory.getLogger(PublishGoodsService.class);

    public void saveGoodsInfomation(SaleGoods saleGoods){
        try {
            //System.out.println(saleGoods.getHeadline());
            saleGoods.setPosttime(new Date());
            saleGoods.setGoodsflag(0);
            saleGoodsMapper.insert(saleGoods);
            //return "insert into DB";
            saveGoodsImage(saleGoods.getUserid(),saleGoods.getHeadline(),saleGoods.getLocations());
        }
        catch (Exception ex) {
            //System.out.println(saleGoods.getSdid());
            logger.error("exception in PublishGoodsService", ex);
            //System.out.println(ex.getMessage());
            //return "exception in PublishGoodsService";
            //return 0;
        }
    }

    public void saveGoodsImage(int useId, String headLine, String[] locations){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",useId);
        map.put("headLine",headLine);
        int goodsId = saleGoodsMapper.selectSaleGoodsId(map);
        GoodsImage goodsImage = new GoodsImage();
        for (int i = 0;i < locations.length; i++){
            goodsImage.setGoodsimage(locations[i]);
            goodsImage.setSalegoodsid(goodsId);
            goodsImageMapper.insert(goodsImage);
        }
    }
}
