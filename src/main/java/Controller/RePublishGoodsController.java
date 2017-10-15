package Controller;

import Dao.model.SaleGoods;
import Service.RePublishGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2014/9/13 0013.
 */
@Controller
public class RePublishGoodsController {
    @Autowired
    private RePublishGoodsService rePublishGoodsService;

    private static Logger logger = LoggerFactory.getLogger(RePublishGoodsController.class);

    @ResponseBody
    @RequestMapping(value = "/saleGoods/goodsId/{goodsId}",method = RequestMethod.GET)
    public SaleGoods getGoodsInfo(@PathVariable int goodsId){
        return rePublishGoodsService.getGoods(goodsId);
    }

    @ResponseBody
    @RequestMapping(value = "/saleGoods",method = RequestMethod.PUT)
    public void rePublish(@RequestBody SaleGoods saleGoods){
        rePublishGoodsService.updateGoodsInformation(saleGoods);
    }

    @ResponseBody
    @RequestMapping(value = "/saleGoods/images/{goodsId}",method = RequestMethod.GET)
    public List<String> getGoodsImages(@PathVariable int goodsId){
        return rePublishGoodsService.getGoodsImages(goodsId);
    }
}
