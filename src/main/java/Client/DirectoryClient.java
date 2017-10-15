package Client;

import Dao.model.HotGoods;
import Dao.model.SaleGoods;
import Dao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2014/9/9.
 */
@Controller
public class DirectoryClient {

    @RequestMapping(value = "/directoryShow/{sDId}",method = RequestMethod.GET)
    public String showGoodsByDirectory(@PathVariable("sDId") int sDId,
                                       ModelMap modelMap,
                                       HttpSession httpSession){
        RestTemplate rest = new RestTemplate();
        modelMap.addAttribute(new User());
        httpSession.setAttribute("searchValue", sDId);
        List<HotGoods> hotGoodsList = new RestTemplate().getForObject(
                "http://localhost:8080/hotGoods", ArrayList.class);
        System.out.println(hotGoodsList.size());
        modelMap.addAttribute("hotGoodsList",hotGoodsList);
        return "showGoods";
    }

    @RequestMapping(value = "/directoryGetGoods", method = RequestMethod.GET)
    @ResponseBody
    public List<SaleGoods> getSaleGoods(HttpSession httpSession){
        RestTemplate rest = new RestTemplate();
        int sDid = (Integer)httpSession.getAttribute("searchValue");
        List<SaleGoods> list = rest.getForObject(
                "http://localhost:8080/directory/{sDId}", ArrayList.class,sDid);
        return list;
    }

    @RequestMapping(value = "/directoryShow/orderByHotRate/{sDId}",method = RequestMethod.GET)
    public String directoryOrderByHotRate(@PathVariable("sDId") int sDId,ModelMap modelMap){
        RestTemplate rest = new RestTemplate();
        List<SaleGoods> list = rest.getForObject(
                "http://localhost:8080/directory/orderByHotRate/{sDId}", ArrayList.class,sDId);
        modelMap.addAttribute(new User());
        modelMap.addAttribute("List",list);
        return "showGoods";
    }

    @RequestMapping(value = "/directoryShow/orderByPostTime/{sDId}",method = RequestMethod.GET)
    public String directoryOrderByPostTime(@PathVariable("sDId") int sDId,ModelMap modelMap){
        RestTemplate template = new RestTemplate();
        List<SaleGoods> list = template.getForObject(
                "http://localhost:8080/directory/orderByPostTime/{sDId}",ArrayList.class,sDId);
        modelMap.addAttribute(new User());
        modelMap.addAttribute("List",list);
        return "showGoods";
    }

    @RequestMapping(value = "/directoryShow/orderByPrice/{sDId}",method = RequestMethod.GET)
    public String directoryOrderByPrice(@PathVariable("sDId") int sDId,ModelMap modelMap){
        RestTemplate template = new RestTemplate();
        List<SaleGoods> list = template.getForObject(
                "http://localhost:8080/directory/orderByPrice/{sDId}",ArrayList.class,sDId);
        modelMap.addAttribute(new User());
        modelMap.addAttribute("List",list);
        return "showGoods";
    }
}
