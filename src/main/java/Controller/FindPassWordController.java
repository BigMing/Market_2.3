package Controller;

import Dao.model.User;
import Service.FindPassWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2014/9/8 0008.
 */
@Controller
@RequestMapping("/user/passWord")
public class FindPassWordController {

    @Autowired
    private FindPassWordService findPassWordService;

    private static Logger logger = LoggerFactory.getLogger(FindPassWordController.class);

    @ResponseBody
    @RequestMapping(value = "/{email}",method = RequestMethod.GET)
    public String checkEmail(@PathVariable String email) {
        String newEmail = email.replace("*", ".");
        //System.out.println(newEmail);
        User user = findPassWordService.checkEmail(newEmail);

        findPassWordService.sendMail(user);
        if (user != null)
            return "we will sent you a page to modify password in your email";
        else
            return "user not exist";
    }

    @ResponseBody
    @RequestMapping(value = "/{randomNumber}/{userId}",method = RequestMethod.GET)
    public boolean check(@PathVariable String randomNumber,
                                     @PathVariable int userId){
        System.out.println(randomNumber + userId);
        return findPassWordService.check(randomNumber,userId);
    }
}
