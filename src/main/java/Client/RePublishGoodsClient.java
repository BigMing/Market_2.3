package Client;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/13 0013.
 */
@Controller
public class RePublishGoodsClient {
    private static Logger logger = LoggerFactory.getLogger(RePublishGoodsClient.class);

    @RequestMapping(value = "/republish/goods", method = RequestMethod.GET)
    public String showRePublishPage(Model model,@RequestParam int goodsId) {
        //read old info
        List<String> goodsImages = new RestTemplate().getForObject(
                "http://localhost:8080/saleGoods/images/{goodsId}", ArrayList.class,goodsId);

        SaleGoods saleGoods = new RestTemplate().getForObject(
                "http://localhost:8080/saleGoods/goodsId/{goodsId}",SaleGoods.class,goodsId);



        model.addAttribute(saleGoods);
        return "rePublishGoods";
    }

    @RequestMapping(value = "/republish/goods", method = RequestMethod.POST)
    public String rePublishGoods(ModelMap model,
                                 @RequestParam(value = "headLine") String headLine,
                                 @RequestParam(value = "price",required = false) double price,
                                 @RequestParam(value = "description",required = false) String description,
                                 @RequestParam(value = "phoneNumber") String phoneNumber,
                                 @RequestParam(value = "contactor") String contactor,
                                 @RequestParam(value = "sDId") int sDId,
                                 @RequestParam(value = "tradePlace", required = false) String tradePlace,
                                 @RequestParam(value = "file[]", required = false) CommonsMultipartFile mFile[],
                                 HttpSession httpSession) {

        int userId = (Integer) httpSession.getAttribute("userId");
        String path = "C:\\Users\\li\\Desktop\\实训2\\spring_learning\\sourceCode\\Market_2.1\\src\\main\\webapp\\WEB-INF\\pages\\resources\\image\\goodsImage";
        //System.out.println(path);
        String[] locations = new String[mFile.length];
        for (int i = 0; i < mFile.length; i++) {
            String location = path + "/" + headLine + i + ".jpg";
            File file = new File(location);
            locations[i] = location;
            try {
                mFile[i].getFileItem().write(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setHeadline(headLine);
        saleGoods.setPrice(price);
        saleGoods.setDescription(description);
        saleGoods.setPhonenumber(phoneNumber);
        saleGoods.setContactor(contactor);
        saleGoods.setUserid(userId);
        saleGoods.setTradeplace(tradePlace);
        saleGoods.setSdid(sDId);
        saleGoods.setLocations(locations);
        String result = new RestTemplate().postForObject(
                "http://localhost:8080/saleGoods/map", saleGoods, String.class);
        model.addAttribute("message", result);
        return "result";
    }
}
