package Controller;

import Dao.model.SaleGoods;
import Service.GoodsImagesService;
import Service.PublishGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2014/9/9 0009.
 */

@Controller
public class PublishGoodsController {
    @Autowired
    private PublishGoodsService publishGoodsService;

    private static Logger logger = LoggerFactory.getLogger(PublishGoodsController.class);

    @ResponseBody
    @RequestMapping(value = "/saleGoods/map", method = RequestMethod.POST)
    public String addSaleGoods(@RequestBody SaleGoods saleGoods) {
        publishGoodsService.saveGoodsInfomation(saleGoods);
        return "publish goods";
    }
}

//    @RequestMapping("/buyGoodsInfo/{headLine}/{price}/{description}/{phoneNumber}/{contactor}/{sDId}/{userId}")
//    @ResponseBody
//    public String publishBuying(@PathVariable String headLine,
//                                @PathVariable double price,
//                                @PathVariable String description,
//                                @PathVariable String phoneNumber,
//                                @PathVariable String contactor,
//                                @PathVariable int sDId,
//                                @PathVariable int userId){
//        BuyGoods buyGoods = new BuyGoods();
//        buyGoods.setHeadline(headLine);
//        buyGoods.setPrice(price);
//        buyGoods.setDescription(description);
//        buyGoods.setPhonenumber(phoneNumber);
//        buyGoods.setContactor(contactor);
//        buyGoods.setSdid(sDId);
//        buyGoods.setUserid(userId);
//        publishBuyingService.saveBuyingInfomation(buyGoods);
//        return "publish buying";
//    }
//    @RequestMapping("/saleGoods/")
//    @ResponseBody
//    public String publishGoods(@PathVariable String headLine,
//                               @PathVariable double price,
//                               @PathVariable String description,
//                               @PathVariable String phoneNumber,
//                               @PathVariable String contactor,
//                               @PathVariable int sDId,
//                               @PathVariable int userId){
//        SaleGoods saleGoods = new SaleGoods();
//        saleGoods.setHeadline(headLine);
//        saleGoods.setPrice(price);
//        saleGoods.setDescription(description);
//        saleGoods.setPhonenumber(phoneNumber);
//        saleGoods.setContactor(contactor);
//        saleGoods.setSdid(sDId);
//        saleGoods.setUserid(userId);
//        publishGoodsService.saveGoodsInfomation(saleGoods);
//        return "publish goods";
//    }
