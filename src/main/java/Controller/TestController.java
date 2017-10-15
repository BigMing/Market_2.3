package Controller;

import Dao.model.User;
import Service.ToolsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;;

/**
 * Created by Administrator on 2014/9/15 0015.
 */
@Controller
public class TestController {
   @Autowired
   private ToolsService toolsService;

//   @RequestMapping(value = "/",method = RequestMethod.GET )
//    public String showHomePage(Model model){
////       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////       String name = principal.toString();
////       if(principal instanceof UserDetails)
////           name = ((UserDetails)principal).getUsername();
//       //toolsService.check();
////       System.out.print(name);
//       model.addAttribute(new User());
//       return "publishGoods";
//   }
//    @RequestMapping(value = "/",method = RequestMethod.GET )
//    public String showGoodsPage(Model model){
//        model.addAttribute(new User());
//        return "publishGoods";
//    }
}//anonymousUser