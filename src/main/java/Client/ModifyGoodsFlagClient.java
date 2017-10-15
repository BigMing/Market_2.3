package Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class ModifyGoodsFlagClient{
    private static Logger logger = LoggerFactory.getLogger(ModifyGoodsFlagClient.class);

    @RequestMapping(value = "/modify/goodsFlag",method = RequestMethod.POST)
    public void getModifyGoodsMessage(@RequestParam int goodsId,
                                 @RequestParam int newFlag){
        RestTemplate template = new RestTemplate();
        template.put("http://localhost:8080/saleGoods/flag/{goodsId}/{newFlag}",
                null,goodsId,newFlag);
    }

    @RequestMapping(value = "/modify/buyingFlag",method = RequestMethod.POST)
    public void getModifyBuyingMessage(@RequestParam int buyingId,
                                       @RequestParam int newFlag){
        RestTemplate template = new RestTemplate();
        template.put("http://localhost:8080/buyGoods/flag/{buyingId}/{newFlag}",
                null,buyingId,newFlag);
    }
}
