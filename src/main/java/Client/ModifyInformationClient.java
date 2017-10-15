package Client;

import Dao.model.HotGoods;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 2014/9/8.
 */
@Controller
public class ModifyInformationClient {

    @RequestMapping(value="/modify/user/{userId}",method = RequestMethod.POST)

    public void modifyInformation(@PathVariable int userId,
                                  @RequestParam(value="userName",required = false) String userName,
                                  @RequestParam(value="email",required = false) String email,
                                  @RequestParam(value = "file",required = false) CommonsMultipartFile mFile){
        User user = new User();
        user.setEmail(email);
        user.setUsername(userName);
        String path = new File(this.getClass().getResource("").getPath()).getAbsolutePath();
        path = path +  "/../../../../../" + "src/main/webapp/WEB-INF/pages/resources/image/";
        String location = path + userId + ".jpg";
        File file = new File(location);
        user.setHeadimage(location);
        try {
            mFile.getFileItem().write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RestTemplate rest = new RestTemplate();
        rest.put("http://localhost:8080/user/{userId}",user,userId);
    }

    @RequestMapping(value = "/modifyPassWord",method =RequestMethod.POST)
    public String modifyPassWord(HttpSession httpSession,ModelMap modelMap,
                               @RequestParam(value = "oldPassWord",required = true) String oldPassWord,
                               @RequestParam(value = "newPassWord",required = true) String newPassWord){
        int userId = (Integer)httpSession.getAttribute("userId");
        RestTemplate rest = new RestTemplate();
        rest.put("http://localhost:8080/user/{userId}/{passWord}",
                newPassWord,userId,oldPassWord);
        modelMap.addAttribute(new User());
        return "personalCenter";
    }

    @RequestMapping(value = "/resetPassWord/{userId}",method = RequestMethod.POST)
    public String resetPassWord(@PathVariable int userId,
                               @RequestParam String newPassWord,
                               ModelMap modelMap){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/user/passWord/{userId}/{newPassWord}",
                null,userId,newPassWord);

        modelMap.addAttribute("message","reset password");
        modelMap.addAttribute(new User());
        List<HotGoods> hotGoodsList = new RestTemplate().getForObject(
                "http://localhost:8080/hotGoods", ArrayList.class);
        System.out.println(hotGoodsList.size());
        modelMap.addAttribute("hotGoodsList",hotGoodsList);
        return "home";
    }
}
