package Client;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2014/9/14.
 */
@Controller
public class ShowGoodsDetailClient {
    @RequestMapping(value="/showSaleGoodsDetail/{saleGoodsId}",method = RequestMethod.GET)
    public String showSaleGoodsDetail(@PathVariable int saleGoodsId,ModelMap model)  {
        model.addAttribute(new User());
        SaleGoods saleGoods = new RestTemplate().getForObject(
                "http://localhost:8080/goodsDetail/saleGoods/{saleGoodsId}",SaleGoods.class,saleGoodsId);
        List<String> goodsImage = new RestTemplate().getForObject(
                "http://localhost:8080/goodsImage/saleGoods/{saleGoodsId}",ArrayList.class,saleGoodsId);
        model.addAttribute("saleGoods",saleGoods);
        model.addAttribute("defaultGoodsImage",goodsImage.get(0));
        model.addAttribute("goodsImage",goodsImage);
        return "goodsDetail";
    }

    @RequestMapping(value="/showGoodsDetail/buyGoods/{buyGoodsId}",method = RequestMethod.GET)
    public String showBuyGoodsDetail(@PathVariable int buyGoodsId,ModelMap model)  {
        //model.addAttribute(new SaleGoods());
        BuyGoods buyGoods = new RestTemplate().getForObject(
                "http://localhost:8080/goodsDetail/buyGoods/{buyGoodsId}",BuyGoods.class,buyGoodsId);
        model.addAttribute("buyGoods",buyGoods);
        return "specificGoods";
    }
}
