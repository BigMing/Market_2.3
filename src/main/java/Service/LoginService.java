package Service;

import Dao.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2014/9/3.
 */

@Service
public class LoginService {

    @Autowired(required = false)
    private UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    public boolean checkLogin(String userNameOrEmail, String passWord) {
        try {
            String tempPassWord = userMapper.findPassWord(userNameOrEmail);
            if (tempPassWord == null) {
                return false;
                //the user have not register
            } else {
                //System.out.print(tempPassWord);
                if (tempPassWord.equals(passWord)) {
                    return true;
                    //the password is right, login success
                }
                else {
                    return false;
                    //the password is wrong, login fail
                }
            }
        } catch (Exception ex) {
            logger.error("exception in LoginService.checkLogin", ex);
            return false;
        }
    }

    public int getUserId(String userNameOrEmail){
        try {
            return userMapper.selectUserId(userNameOrEmail);
        }
        catch (Exception ex){
            logger.error("exception in LoginService.getUserId",ex);
            //System.out.println(ex.getMessage());
            return 0;
        }
    }
}
