package Controller;

import Service.ModifyGoodsFlagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class ModifyGoodsFlagController {
    private static Logger logger = LoggerFactory.getLogger(ModifyGoodsFlagController.class);

    @Autowired
    private ModifyGoodsFlagService modifyGoodsFlagService;

    @ResponseBody
    @RequestMapping(value = "/saleGoods/flag/{goodsId}/{newFlag}",method = RequestMethod.PUT)
    public void modifyGoodsFlag(@PathVariable int goodsId,
                                @PathVariable int newFlag){
        modifyGoodsFlagService.modifyGoodsFlag(goodsId,newFlag);
    }

    @ResponseBody
    @RequestMapping(value = "/buyGoods/flag/{buyingId}/{newFlag}",method = RequestMethod.PUT)
    public void modifyBuyingFlag(@PathVariable int buyingId,
                                 @PathVariable int newFlag){
        modifyGoodsFlagService.modifyBuyingFlag(buyingId,newFlag);
    }
}
