package Service;

import Dao.dao.UserMapper;
import Dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2014/9/3.
 */

@Service
public class ModifyUserInfomationService {

    @Autowired(required = false)
    private UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(ModifyUserInfomationService.class);

    public String modifyUserInfomation(int userId, String userName, String email, String headImageUrl){
        try{
            User user = userMapper.selectByPrimaryKey(userId);
            user.setUsername(userName);
            user.setEmail(email);
            user.setHeadimage(headImageUrl);
            userMapper.updateByPrimaryKeySelective(user);
            return "update infomation";
        }
        catch (Exception ex) {
            logger.error("exception in ModifyUserInfomationService.modifyInformation", ex);
            return "exception in ModifyUserInfomationService.modifyInformation";
        }
    }

    public String modifyPassWord(int userId, String oldPassWord, String newPassWord){
        try {
            User user = userMapper.selectByPrimaryKey(userId);
            if (oldPassWord.equals(user.getPassword())){
                user.setPassword(newPassWord);
                userMapper.updateByPrimaryKeySelective(user);
                return "update password";
            }
            else
                return "password wrong";
        }
        catch (Exception ex){
            logger.error("exception in ModifyUserInfomationService.modifyPassWord", ex);
            return "exception in ModifyUserInfomationService.modifyPassWord";
        }
    }

    public String resetPassWord(int userId, String newPassWord){
        try {
            User user = userMapper.selectByPrimaryKey(userId);
            user.setPassword(newPassWord);
            userMapper.updateByPrimaryKeySelective(user);
            return "reset password";
        }
        catch (Exception ex){
            logger.error("exception in ModifyUserInfomationService.modifyPassWord", ex);
            return "exception in ModifyUserInfomationService.modifyPassWord";
        }
    }

    public User getUserInfo(int userId){
        return userMapper.selectByPrimaryKey(userId);
    }
}
