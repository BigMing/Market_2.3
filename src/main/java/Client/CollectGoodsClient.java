package Client;

import Dao.model.SaleGoods;
import Service.GetUserIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/9 0009.
 */
@Controller
public class CollectGoodsClient {
    private static Logger logger = LoggerFactory.getLogger(CollectGoodsClient.class);
    @Autowired
    private GetUserIdService getUserIdService;

    @RequestMapping(value = "/collectionAdd/{saleGoodsId}",method = RequestMethod.GET)
    @ResponseBody
    public String addCollection(ModelMap model,
                               @PathVariable int saleGoodsId,
                               HttpSession httpSession){
        if(httpSession.getAttribute("userId")!=null){
            int userId = (Integer)httpSession.getAttribute("userId");
            String result = new RestTemplate().postForObject(
                    "http://localhost:8080/collection/{goodsId}/{userId}",
                    null,String.class,saleGoodsId,userId);
            model.addAttribute("message",result);
            return  "result";
        }else {
            return "loginError";
        }

       // return "result";
    }

    @RequestMapping(value = "/collection/show",method = RequestMethod.GET)
    @ResponseBody
    public List<SaleGoods> showCollection(ModelMap model,HttpSession httpSession){
        if(httpSession.getAttribute("userId")!=null) {
            int userId = (Integer) httpSession.getAttribute("userId");
            List<SaleGoods> result = new RestTemplate().getForObject(
                    "http://localhost:8080/collection/{userId}",
                    ArrayList.class, userId);
            return result;
        }
        else{
            return  null;
        }
    }

    @RequestMapping(value = "/collection/delete",method = RequestMethod.POST)
    public String deleteCollection(ModelMap model,
                               @RequestParam int goodsId,
                               @RequestParam int userId){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                "http://localhost:8080/collection/{goodsId}/{userId}",
                goodsId,userId);
        model.addAttribute("message","delete collection");
        return "result";
    }
}
