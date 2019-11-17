package test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.entity.UserBean;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 获取所有用户列表
     * @return
     */
    public List<UserBean> getUserBeanList() {
        return userDao.getUserBeanList();
    }

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    public UserBean getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }

    /**
     * 根据实际姓名获取用户信息
     * @param realName
     * @return
     */
    public UserBean getUserByRealName(String realName){
        return userDao.getUserByRealName(realName);
    }

    /**
     * 增加新的用户
     * @param userBean
     * @return
     */
    public boolean addUser(UserBean userBean){
        return userDao.addUser(userBean)>0;
    }

    /**
     * 通过用户名删除用户
     * @param userName
     * @return
     */
    public boolean deleteUserByUserName(String userName){
        return userDao.deleteUserByUserName(userName)>0;
    }

    /**
     * 校验用户是否存在
     * @param userBean
     * @return
     */
    public boolean checkUserExists(UserBean userBean){
        return  userDao.checkUserExists(userBean)>0;
    }

    /**
     * 校验用户密码是否正确
     * @param userBean
     * @return
     */
    public boolean checkUserValid(UserBean userBean){
        return userDao.checkUserValid(userBean)>0;
    }
}
