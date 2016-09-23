package demo.springboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.dao.UserDao;
import demo.springboot.model.Users;

/**
 * spring-boot rest服务
 * 
 * @author macma 2016年9月23日 下午1:38:44
 */
@Service
public class HelloService implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5405586759113170806L;
    @Autowired
    private UserDao           userDao;

    public List<Users> getAllUserInfo() {
        return userDao.getAllUserInfo();
    }

    public Users getUserInfo(String username) {
        return userDao.getUserInfo(username);
    }

    public void saveUser(Users user) {
        if (userDao.getUserInfo(user.getUsername()) == null) {
            userDao.addUser(user.getUsername(), user.getPassword(), 1);
        } else {
            userDao.updateUser(user);
        }
    }

}
