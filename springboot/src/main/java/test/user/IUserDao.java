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

}
