package test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.entity.UserBean;

import java.util.List;

@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser.do")
    @ResponseBody
    public List<UserBean> getUserBeanList(){
        return userService.getUserBeanList();
    }

}
