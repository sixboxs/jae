package test.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import test.entity.UserBean;

import java.util.List;

@Repository("userDao")
public interface IUserDao {
    /**
     * 根据用户列表
     * @return
     */
    List<UserBean> getUserBeanList( );

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    UserBean getUserByUserName(String userName);

    /**
     * 根据真实姓名获取用户信息
     * @param realName
     * @return
     */
    UserBean getUserByRealName(String realName);

    /**
     * 添加新的用户
     * @param userBean
     * @return
     */
    int addUser(UserBean userBean);

    /**
     * 根据用户名删除用户
     * @param userName
     * @return
     */
    int deleteUserByUserName(String userName);

    /**
     * 校验用户是否存在
     * @param userBean
     * @return
     */
    int checkUserValid(UserBean userBean);

    /**
     * 校验用户是否存在
     * @param userBean
     * @return
     */
    int checkUserExists(UserBean userBean);
}
