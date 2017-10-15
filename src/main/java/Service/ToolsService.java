package Service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/9/16 0016.
 */
@Service
public class ToolsService {
    public String check(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.toString();
        if(principal instanceof UserDetails)
            name = ((UserDetails)principal).getUsername();
        if (name.equals("anonymousUser")){
            return "error";
        }
        else
            return name;
    }
}
