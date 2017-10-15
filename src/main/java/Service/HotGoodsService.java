package Service;

import Dao.dao.HotGoodsMapper;
import Dao.dao.SaleGoodsClickNumberMapper;
import Dao.dao.SaleGoodsMapper;
import Dao.model.HotGoods;
import Dao.model.SaleGoods;
import Dao.model.SaleGoodsClickNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/13 0013.
 */
@Service
public class HotGoodsService {
    @Autowired(required = false)
    private SaleGoodsClickNumberMapper saleGoodsClickNumberMapper;
    @Autowired(required = false)
    private SaleGoodsMapper saleGoodsMapper;
    @Autowired(required = false)
    private HotGoodsMapper hotGoodsMapper;
    @Autowired
    private GoodsImagesService goodsImagesService;

    private static Logger logger = LoggerFactory.getLogger(HotGoodsService.class);

    @Scheduled(cron = "0 0 3 * * ?")
    public void getHotGoods(){
        try {
            hotGoodsMapper.deleteAll();
            List<SaleGoodsClickNumber> list = saleGoodsClickNumberMapper.selectAll();
            //System.out.println(list.get(0).getSalegoodsid());
            List<SaleGoods> goodsList = new ArrayList<SaleGoods>();
            System.out.println(goodsList.size());
            for (int i = 0; i < 6; i++) {
                SaleGoods saleGoods = saleGoodsMapper.selectByPrimaryKey(list.get(i).getSalegoodsid());
                goodsList.add(saleGoods);
            }
            //get hot goods list
            //System.out.println(goodsList.get(0).getHeadline());
            HotGoods hotGoods = new HotGoods();
            for (int i = 0; i < goodsList.size(); i++){
                int goodsId = goodsList.get(i).getSalegoodsid();
                hotGoods.setSalegoodsid(goodsId);
                List<String> strings = goodsImagesService.findImageBySaleGoodsId(goodsId);
                String imageUrl = strings.get(0);
                hotGoods.setHotgoodsimage(imageUrl);
                hotGoods.setHotgoodsid(i + 1);
                hotGoodsMapper.insert(hotGoods);
            }
        }
        catch (Exception ex){
            logger.error("exception in ShowHotGoodsService.getHotGoods",ex);
            //return null;
        }
    }

    public List<HotGoods> showGotHoods(){
        return hotGoodsMapper.selectAll();
    }
}
