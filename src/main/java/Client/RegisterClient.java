package Client;

import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by li on 2014/9/8.
 */
@Controller
public class RegisterClient {
    private static Logger logger = LoggerFactory.getLogger(RegisterClient.class);

    @RequestMapping(value = "/register/show", method = RequestMethod.GET)
    public String showRegisterPage(Model model){
        model.addAttribute(new User());
        return "headline";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegisterResult(ModelMap modelMap, User user){
        //System.out.println(user.getUsername());
        RestTemplate rest = new RestTemplate();
        String result = rest.postForObject(
                "http://localhost:8080/user/",user, String.class);
        modelMap.addAttribute("message",result);
        return "result";
    }
}

