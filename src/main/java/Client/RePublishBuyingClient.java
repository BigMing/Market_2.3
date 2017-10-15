package Client;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class RePublishBuyingClient {
    private static Logger logger = LoggerFactory.getLogger(RePublishBuyingClient.class);

    @RequestMapping(value = "/republish/buy", method = RequestMethod.GET)
    public String showRePublishPage(Model model,@RequestParam int goodsId) {
        //read old info
        BuyGoods buyGoods = new RestTemplate().getForObject(
                "http://localhost:8080/buyGoods/goodsId/{goodsId}",BuyGoods.class,goodsId);
        model.addAttribute(buyGoods);
        return "rePublishBuy";
    }

    @RequestMapping(value = "/repulish/buy", method = RequestMethod.POST)
    public String rePublishBuy(ModelMap model, BuyGoods buyGoods) {
        RestTemplate template = new RestTemplate();
        template.put("http://localhost:8080/buyGoods",buyGoods);

        model.addAttribute("message", "ok");
        return "result";
    }
}
