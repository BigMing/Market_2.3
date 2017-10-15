package Client;

import Dao.model.BuyGoods;
import Dao.model.SaleGoods;
import Dao.model.User;
import Service.GetUserIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/9/9 0009.
 */
@Controller
public class PublishClient {
    private static Logger logger = LoggerFactory.getLogger(PublishClient.class);

    @RequestMapping(value = "/publish",method = RequestMethod.GET)
    public String showPublishPage(Model model,HttpSession httpSession){
        System.out.println(httpSession.getAttribute("userId"));
        model.addAttribute(new User());
        return "publishGoods";
    }

    @RequestMapping(value = "/publishGoods", method = RequestMethod.POST)
    public String publishGoods(ModelMap model,
                               @RequestParam(value = "tradeType") String type,
                               @RequestParam(value = "headLine") String headLine,
                               @RequestParam(value = "price",required = false) double price,
                               @RequestParam(value = "description",required = false) String description,
                               @RequestParam(value = "phoneNumber") String phoneNumber,
                               @RequestParam(value = "contactor") String contactor,
                               @RequestParam(value = "sDId") int sDId,
                               @RequestParam(value = "tradePlace", required = false) String tradePlace,
                               @RequestParam(value = "file[]", required = false) CommonsMultipartFile mFile[],
                               HttpSession httpSession) {
        int userId = (Integer)httpSession.getAttribute("userId");
        if (type.equals("sale")) {
            String path = "E:\\Market_2.3\\src\\main\\webapp\\WEB-INF\\pages\\resources\\image\\goodsImage";
            //System.out.println(path);
            String[] locations = new String[mFile.length];
            for (int i = 0; i < mFile.length; i++){
                String location = path + "/" + headLine + i + ".jpg";
                File file = new File(location);
                try {
                    mFile[i].getFileItem().write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                location = "resources/image/goodsImage" + "/" + headLine + i + ".jpg";
                locations[i] = location;
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
        } else {
            String result = publishBuy(headLine, price, description, phoneNumber, contactor, sDId, userId, tradePlace);
            model.addAttribute("message", result);
            return "result";
        }
    }

    public String publishBuy(String headLine, double price, String description, String phoneNumber,
                             String contactor, int sDId, int userId, String tradePlace) {
        BuyGoods buyGoods = new BuyGoods();
        buyGoods.setHeadline(headLine);
        buyGoods.setDescription(description);
        buyGoods.setPrice(price);
        buyGoods.setPhonenumber(phoneNumber);
        buyGoods.setContactor(contactor);
        buyGoods.setSdid(sDId);
        buyGoods.setUserid(userId);
        buyGoods.setTradeplace(tradePlace);
        String result = new RestTemplate().postForObject(
                "http://localhost:8080/buyGoods/",buyGoods,String.class);
        return result;
    }
}

//    @RequestMapping(value = "/publish/goods", method = RequestMethod.GET)
//    public String showPublishPage(Model model) {
//        model.addAttribute(new User());
//        model.addAttribute(new SaleGoods());
//        return "publishGoods";
//    }
//
//    @RequestMapping(value = "/publish/goods", method = RequestMethod.POST)
//    public String publish(ModelMap model, SaleGoods saleGoods,
//                          @RequestParam(value = "file", required = false) CommonsMultipartFile mFile,
//                          @RequestParam(value = "tradeType", required = true) String tradeType,
//                          @RequestParam(value = "sDId", required = true) int sDId) {
//        if (tradeType.equals("sale")) {
//            String path = new File(this.getClass().getResource("").getPath()).getAbsolutePath();
//            path = path + "/../../../../../" + "src/main/webapp/WEB-INF/pages/resources/image/";
//            //System.out.println(path);
//            String location = path + saleGoods.getHeadline() + ".jpg";
//            File file = new File(location); //新建一个文件
//            try {
//                //将上传的文件写入新建的文件中
//                mFile.getFileItem().write(file);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            //System.out.println(saleGoods.getHeadline());
//            saleGoods.setSdid(sDId);
//            String result = new RestTemplate().postForObject(
//                    "http://localhost:8080/saleGoods/{location}", saleGoods, String.class, location);
//            model.addAttribute("message", result);
//            return "result";
//        } else {
//
//        }
//    }