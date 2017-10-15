package Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2014/9/8 0008.
 */

@Controller
public class FindPassWordClient {
    private static Logger logger = LoggerFactory.getLogger(FindPassWordClient.class);

    @RequestMapping(value =  "/findPassWord/check", method = RequestMethod.POST)
    public String checkUserNameAndEmail(ModelMap model,
                                        @RequestParam(value = "email", required = true) String email){
        //System.out.println(email);
        String newEmail = email.replace('.','*');
        //System.out.println(newEmail);
        String result = new RestTemplate().getForObject(
                "http://localhost:8080/user/passWord/{email}",
                String.class, newEmail);

        model.addAttribute("message", result);
        return "result";
    }

    @RequestMapping(value = "/findPassWord/{randomNumber}",method = RequestMethod.GET)
    public String checkPassWord(@PathVariable String randomNumber,
                                @RequestParam int userId,ModelMap modelMap){
        boolean result = new RestTemplate().getForObject(
                "http://localhost:8080/user/passWord/{randomNumber}/{userId}",
                boolean.class, randomNumber, userId);
        if (result) {
            modelMap.addAttribute("userId",userId);
            return "reset-password";
        }
        else
            return null;
    }
}
