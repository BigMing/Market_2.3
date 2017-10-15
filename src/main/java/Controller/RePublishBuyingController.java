package Controller;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Service.RePublishBuyingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class RePublishBuyingController {
    @Autowired
    private RePublishBuyingService rePublishBuyingService;

    private static Logger logger = LoggerFactory.getLogger(RePublishBuyingController.class);

    @ResponseBody
    @RequestMapping(value = "/buyGoods/goodsId/{goodsId}",method = RequestMethod.GET)
    public BuyGoods getBuyingInfo(@PathVariable int goodsId){
        return rePublishBuyingService.getBuying(goodsId);
    }

    @ResponseBody
    @RequestMapping(value = "/buyGoods",method = RequestMethod.PUT)
    public void rePublish(@RequestBody BuyGoods buyGoods){
        rePublishBuyingService.updateBuyingInformation(buyGoods);
    }
}
