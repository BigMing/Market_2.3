package Service;

import Dao.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/9/16 0016.
 */
@Service
public class GetUserIdService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public int getUserId(String userName){
        return userMapper.selectUserId(userName);
    }
}
