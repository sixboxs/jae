package test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.entity.UserBean;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    public List<UserBean> getUserBeanList() {
        return userDao.getUserBeanList();
    }
}
