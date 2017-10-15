package Controller;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Service.GoodsImagesService;
import Service.ShowTradeInPersonalCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2014/9/10 0010.
 */

@Controller
@RequestMapping("/publishedInfo")
public class ShowTradeListController {
    @Autowired
    ShowTradeInPersonalCenterService showTradeInPersonalCenterService;

    @Autowired
    private GoodsImagesService goodsImagesService;
    private static Logger logger = LoggerFactory.getLogger(ShowTradeListController.class);

    @ResponseBody
    @RequestMapping(value = "/saleGoods/{userId}",method = RequestMethod.GET)
    public SaleGoods[] showPublishedGoods(@PathVariable int userId){
        SaleGoods[] saleGoodses = showTradeInPersonalCenterService.showGoodsInformation(userId);
        for(int i = 0 ;i < saleGoodses.length;i++){
            int salesGoodsId = saleGoodses[i].getSalegoodsid();
            List<String> imageUrl = goodsImagesService.findImageBySaleGoodsId(salesGoodsId);
            //System.out.println(imageUrl.get(0));
            saleGoodses[i].setGoodsImage(imageUrl.get(0));
        }
        return saleGoodses;
    }

    @ResponseBody
    @RequestMapping(value = "/buyGoods/{userId}",method = RequestMethod.GET)
    public BuyGoods[] showPubishedBuy(@PathVariable int userId){
        return showTradeInPersonalCenterService.showBuyingInformation(userId);
    }
}
