package Controller;

import Dao.model.User;
import Service.CommentService;
import Service.LoginService;
import Service.ModifyUserInfomationService;
import Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by li on 2014/9/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    RegisterService registerService;
    @Autowired
    LoginService loginService;
    @Autowired
    CommentService commentService;
    @Autowired
    ModifyUserInfomationService modifyUserInfomationService;


    @RequestMapping(value="/",method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestBody User user){
        System.out.println(user.getUsername());
        return  registerService.saveUserInfomation(user);
    }

    @ResponseBody
    @RequestMapping(value = "/info/{userId}",method = RequestMethod.GET)
    public User getUserInfo(@PathVariable int userId){
        return modifyUserInfomationService.getUserInfo(userId);
    }

    @RequestMapping(value="/{userId}",method = RequestMethod.PUT)
    public void modifyInformation(@PathVariable("userId") int userId ,@RequestBody User user){
        modifyUserInfomationService.modifyUserInfomation(userId,user.getEmail(),user.getHeadimage(),user.getUsername());
    }

    @ResponseBody
    @RequestMapping(value = "/{userId}/{passWord}",method = RequestMethod.PUT)
    public void modifyPassWord(@PathVariable("userId") int userId,@PathVariable("passWord") String oldPassWord,
                               @RequestBody String newPassWord) {
        //System.out.println(userId);
        //System.out.print(oldPassWord);
        modifyUserInfomationService.modifyPassWord(userId, oldPassWord, newPassWord);
    }

    @ResponseBody
    @RequestMapping(value = "/passWord/{userId}/{newPassWord}",method = RequestMethod.PUT)
    public void resetPassWord(@PathVariable int userId,@PathVariable String newPassWord){
        modifyUserInfomationService.resetPassWord(userId,newPassWord);
    }

    @RequestMapping(value = "/userId/{username}/{password}",method = RequestMethod.GET)
    @ResponseBody
    public int login(@PathVariable String username,
                     @PathVariable String password) {
        //System.out.println(username + password);
        //System.out.println(loginService.checkLogin(username,password));
        if (loginService.checkLogin(username, password)) {
            //System.out.println(loginService.getUserId(username));
            return loginService.getUserId(username);
        }
        else
            return 0;
    }
}