package Service;

import Dao.dao.GoodsImageMapper;
import Dao.model.GoodsImage;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by li on 2014/9/13.
 */
@Service
public class GoodsImagesService {
    @Autowired(required = false)
    private GoodsImageMapper goodsImageMapper;

    private static Logger logger = LoggerFactory.getLogger(GoodsImagesService.class);

    public List<String> findImageBySaleGoodsId(int saleGoodsId) {
        List<String> goodsImageList = goodsImageMapper.selectByGoodsId(saleGoodsId);
        //System.out.println(goodsImageList.get(0));
        return goodsImageList;
    }
}
