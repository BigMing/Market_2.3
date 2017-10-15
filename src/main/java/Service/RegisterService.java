package Service;

import Dao.dao.UserMapper;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.io.File;

/**
 * Created by li on 2014/9/3.
 */

@Service
public class RegisterService {

    @Autowired(required = false)
    private UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(RegisterService.class);

    public String saveUserInfomation(User user) {
        try {
            if (judgeUserName(user.getUsername()) == false) {
                if (judgeEmail(user.getEmail()) == false){
                    user.setHeadimage("D:\\Market_2.1\\src\\main\\webapp\\WEB-INF\\pages\\resources\\image\\headImage\\default.jpg");
                    userMapper.insert(user);
                    return "successful register";
                }
                else {
                    return "email repeat";
                }
            } else {
                return "userName repeat.";
            }
        } catch (Exception ex) {
            logger.error("exception in RegisterService.saveUserInfomation", ex);
            //System.out.println(ex.getMessage());
            return "exception in RegisterService.saveUserInfomation";
        }
    }

    public boolean judgeUserName(String userName){
        try{
            String tempUserName = userMapper.selectByUserName(userName);
            if (tempUserName == null){
                return false;
            }
            else
                return true;
        }
        catch (Exception ex){
            logger.error("exception in RegisterService.judgeUserName",ex);
            return false;
        }
    }

    public boolean judgeEmail(String email){
        try{
            User user = userMapper.selectByEmail(email);
            if (user == null){
                //System.out.print(userMapper.selectByEmail(email));
                return false;
            }
            else
                return true;
        }
        catch (Exception ex){
            logger.error("exception in RegisterService.judgeUserEmail",ex);
            return false;
        }
    }
}




