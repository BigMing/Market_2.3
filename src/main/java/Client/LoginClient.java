package Client;

import Dao.model.Comment;
import Dao.model.HotGoods;
import Dao.model.User;
import com.google.code.kaptcha.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/9/7 0007.
 */

@Controller
public class LoginClient {
    private static Logger logger = LoggerFactory.getLogger(LoginClient.class);

    @RequestMapping(value = "/login/show", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        model.addAttribute(new User());
        return "publishGoods";
    }

    @RequestMapping(value = "/login/result", method = RequestMethod.POST)
    @ResponseBody
    public String getLoginInfo(ModelMap model,
            @RequestParam(value="username", required=true) String username,
            @RequestParam(value="password", required=true) String password,
            @RequestParam(value = "verifyCode") String verifyCode,
            HttpServletRequest request,
            HttpSession httpSession){
//        System.out.println(username);
//        System.out.println(password);
        String code = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        code = code.toLowerCase();
        verifyCode = verifyCode.toLowerCase();
        if (verifyCode.equals(code)){
            int userId = new RestTemplate().getForObject(
                    "http://localhost:8080/user/userId/{username}/{password}",
                    Integer.class, username, password);

//            Comment[] comments = new RestTemplate().getForObject(
//                    "http://localhost:8080/comment/{userId}",
//                    Comment[].class,userId);
//            model.addAttribute("message","success login");
//            model.addAttribute("List",comments);
            if(userId != 0){
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("userId", userId);
                httpSession.setAttribute("flag", true);
                return "ok";
            }
            else
                return "error";
        }
        else {
            model.addAttribute("message","验证码错误");
            return "error";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession httpSession,Model model){
        List<HotGoods> hotGoodsList = new RestTemplate().getForObject(
                "http://localhost:8080/hotGoods", ArrayList.class);
        model.addAttribute("hotGoodsList",hotGoodsList);
        model.addAttribute(new User());
        httpSession.removeAttribute("userId");
        httpSession.setAttribute("flag",false);
        return "redirect:/";
    }
}
