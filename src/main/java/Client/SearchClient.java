package Client;

import Dao.model.HotGoods;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/9 0009.
 */
@Controller
public class SearchClient {

    private static Logger logger = LoggerFactory.getLogger(SearchClient.class);

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchMessage(ModelMap model,
                                   HttpSession httpSession,
                                   @RequestParam(value = "searchWord", required = true) String searchWord){
        model.addAttribute(new User());
        httpSession.setAttribute("searchValue", searchWord);
        List<HotGoods> hotGoodsList = new RestTemplate().getForObject(
                "http://localhost:8080/hotGoods", ArrayList.class);
        System.out.println(hotGoodsList.size());
        model.addAttribute("hotGoodsList",hotGoodsList);
//        List<SaleGoods> searchResult = new RestTemplate().getForObject(
//                "http://localhost:8080/saleGoods/{searchWord}", ArrayList.class, searchWord);
//
//        //List<String> headLines = searchResult.getSaleGoodsHeadLineList();
//        model.addAttribute("List",searchResult);
        return "showGoods";
    }

    @RequestMapping(value = "/searchGetGoods", method = RequestMethod.GET)
    @ResponseBody
    public List<SaleGoods> getSearchGoods(HttpSession httpSession){
        String searchWord = (String)httpSession.getAttribute("searchValue");
        List<SaleGoods> searchResult = new RestTemplate().getForObject(
                "http://localhost:8080/saleGoods/{searchWord}", ArrayList.class, searchWord);
        return searchResult;
    }

    @RequestMapping(value = "/search/orderByHotRate",method = RequestMethod.GET)
    public String searchByHotRate(ModelMap model,
                                  @RequestParam(value = "searchWord") String searchWord){
        List<SaleGoods> searchResult = new RestTemplate().getForObject(
                "http://localhost:8080/saleGoods/orderByHotRate/{searchWord}",
                ArrayList.class,searchWord);
        model.addAttribute("List",searchResult);
        return "result";
    }

    @RequestMapping(value = "/search/orderByPostTime",method = RequestMethod.GET)
    public String searchByPostTime(ModelMap model,
                                   @RequestParam(value = "searchWord") String searchWord){
        List<SaleGoods> searchResult = new RestTemplate().getForObject(
                "http://localhost:8080/saleGoods/orderByPostTime/{searchWord}",
                ArrayList.class,searchWord);
        model.addAttribute("List",searchResult);
        return "result";
    }

    @RequestMapping(value = "/search/orderByPrice",method = RequestMethod.GET)
    public String searchByPrice(ModelMap model,
                                @RequestParam(value = "searchWord") String searchWord){
        List<SaleGoods> searchResult = new RestTemplate().getForObject(
                "http://localhost:8080/saleGoods/orderByPrice/{searchWord}",
                ArrayList.class,searchWord);
        model.addAttribute("List",searchResult);
        return "result";
    }
}
