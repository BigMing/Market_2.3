package Client;

import Dao.model.HotGoods;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class ShowHomePageClient {
    private static Logger logger = LoggerFactory.getLogger(ShowHomePageClient.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showHomePage(ModelMap model){
        model.addAttribute(new User());

        List<HotGoods> hotGoodsList = new RestTemplate().getForObject(
                "http://localhost:8080/hotGoods", ArrayList.class);
        model.addAttribute("hotGoodsList",hotGoodsList);
        return "home";
    }
}
