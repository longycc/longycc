package com.service.impl;

import com.dao.LoginDao;
import com.service.LoginService;
import com.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * login service层实现类
 * @author longy
 * @since 2020/11/27
 */
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * login Dao层接口
     */
    @Autowired
    LoginDao loginDao;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        if(user.username.isEmpty() && user.username==""){
            return 0;
        }else if(user.email.isEmpty() && user.email==""){
            return 0;
        }else if (user.password.isEmpty()&&user.password==""){
            return 0;
        }
        int temp = loginDao.addUser(user);
        return temp;
    }

    /**
     * 验证用户
     * @param user
     * @return
     */
    @Override
    public int selectUser(User user) {
        User temp = loginDao.selectUser(user);
        if(temp==null){
            return 0;
        }
        return 1;
    }

}
