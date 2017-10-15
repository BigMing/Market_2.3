package Client;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2014/9/10 0010.
 */

@Controller
public class ShowTradeClient {
    private static Logger logger = LoggerFactory.getLogger(ShowTradeClient.class);

    @RequestMapping(value = "/showTrade",method = RequestMethod.GET)
    public String showPersonalPage(ModelMap modelMap,HttpSession httpSession){
        int userId = (Integer)httpSession.getAttribute("userId");
        User user = new RestTemplate().getForObject(
                "http://localhost:8080/user/info/{userId}",User.class,userId);

        modelMap.addAttribute("user",user);
        return "personalCenter";
    }

    @RequestMapping(value = "/showTradePage",method = RequestMethod.GET)
    @ResponseBody
    public SaleGoods[] showPublished(ModelMap model,
                                     HttpSession httpSession){
        int userId = (Integer)httpSession.getAttribute("userId");
        model.addAttribute(new User());
        SaleGoods[] saleGoodses = new RestTemplate().getForObject(
                "http://localhost:8080/publishedInfo/saleGoods/{userId}",SaleGoods[].class,userId);

        BuyGoods[] buyGoodses = new RestTemplate().getForObject(
                "http://localhost:8080/publishedInfo/buyGoods/{userId}",BuyGoods[].class,userId);
        return saleGoodses;
//        model.addAttribute("saleGoodsList",saleGoodses);
//        return "personalCenter";
    }
}
