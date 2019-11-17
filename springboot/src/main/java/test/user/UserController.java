package test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.entity.UserBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser.do")
    @ResponseBody
    public List<UserBean> getUserBeanList(){
        return userService.getUserBeanList();
    }

    @RequestMapping("/getUserByUserName.do")
    @ResponseBody
    public UserBean getUserByUserName(String userName){
        return userService.getUserByUserName(userName);
    }

    @RequestMapping("/getUserByRealName.do")
    @ResponseBody
    public UserBean getUserByRealName(String realName){
        return userService.getUserByRealName(realName);
    }

    @RequestMapping("/addUser.do")
    @ResponseBody
    public boolean addUser(UserBean userBean){
        return userService.addUser(userBean);
    }

    @RequestMapping("/deleteUserByUserName.do")
    @ResponseBody
    public boolean deleteUserByUserName(String userName){
        return userService.deleteUserByUserName(userName);
    }

    @RequestMapping("/checkUserExists.do")
    @ResponseBody
    public boolean checkUserExists(UserBean userBean){
        return userService.checkUserExists(userBean);
    }

    @RequestMapping("/checkUserValid.do")
    @ResponseBody
    public Map<String, Object> checkUserValid(UserBean userBean){
        Map<String, Object> resMap = new HashMap<>();
        boolean resState = false;
        String resMsg;
        if (!(resState = userService.checkUserExists(userBean))){
            resMsg = "用户不存在!";
        }else if (!(resState = userService.checkUserValid(userBean))){
            resMsg = "用户密码不正确!";
        }else {
            resMsg = "校验成功!";
        }
        resMap.put("state", resState);
        resMap.put("msg", resMsg);
        return resMap;
    }

}
