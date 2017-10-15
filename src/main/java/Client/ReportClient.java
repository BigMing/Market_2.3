package Client;

import Dao.model.User;
import Service.GetUserIdService;
import Service.ToolsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * Created by li on 2014/9/10.
 */

@Controller
public class ReportClient {
    private static Logger logger = LoggerFactory.getLogger(ReportClient.class);
    @Autowired
    private GetUserIdService getUserIdService;
    @Autowired
    private ToolsService toolsService;


    @RequestMapping(value = "/report/{saleGoodsId}",method = RequestMethod.GET)
    public String getReportMessage(ModelMap model,
                                   @RequestParam String reportText,
                                  @PathVariable int saleGoodsId,
                                  HttpSession httpSession) {
        int userId = (Integer) httpSession.getAttribute("userId");
        String result = new RestTemplate().postForObject(
                "http://localhost:8080/report/{reportText}/{goodsId}/{userId}",
                null, String.class, reportText, saleGoodsId, userId);

        //model.addAttribute("message", "we will deal with youe report soon");
       // model.addAttribute(new User());
        return "redirect:/showSaleGoodsDetail/"+ saleGoodsId;
    }
}
