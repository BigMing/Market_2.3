package Controller;

import Dao.model.SaleGoods;
import Service.CollectGoodsService;
import Service.GoodsImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/9 0009.
 */
@Controller
@RequestMapping("/collection")
public class CollectGoodsController {
    @Autowired
    private CollectGoodsService collectGoodsService;
    @Autowired
    private GoodsImagesService goodsImagesService;

    private static Logger logger = LoggerFactory.getLogger(CollectGoodsController.class);

    @ResponseBody
    @RequestMapping(value = "/{goodsId}/{userId}",method = RequestMethod.POST)
    public String addCollection(@PathVariable int goodsId,
                                @PathVariable int userId){
        return collectGoodsService.saveCollectGoods(goodsId,userId);
    }

    @ResponseBody
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public List<SaleGoods> showCollection(@PathVariable int userId){
        List<SaleGoods> saleGoodsList = new ArrayList<SaleGoods>();
        saleGoodsList = collectGoodsService.showCollection(userId);
        for(int i = 0 ;i < saleGoodsList.size();i++){
            int salesGoodsId = saleGoodsList.get(i).getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            //System.out.println(imageUrl.get(0));
            saleGoodsList.get(i).setGoodsImage(imageUrl.get(0));
        }
        return saleGoodsList;
    }

    @ResponseBody
    @RequestMapping(value = "/{goodsId}/{userId}",method = RequestMethod.DELETE)
    public void deleteCollection(@PathVariable int goodsId,
                                @PathVariable int userId){
        collectGoodsService.deleteCollection(userId,goodsId);
    }
}
