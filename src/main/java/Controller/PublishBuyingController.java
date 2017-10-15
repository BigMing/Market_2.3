package Controller;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Service.PublishBuyingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2014/9/10 0010.
 */
@Controller
public class PublishBuyingController {
    @Autowired
    private PublishBuyingService publishBuyingService;

    private static Logger logger = LoggerFactory.getLogger(PublishBuyingController.class);

    @ResponseBody
    @RequestMapping(value = "/buyGoods/",method = RequestMethod.POST)
    public String addBuyGoods(@RequestBody BuyGoods buyGoods){
        publishBuyingService.saveBuyingInfomation(buyGoods);
        return "publish buying";
    }
}
