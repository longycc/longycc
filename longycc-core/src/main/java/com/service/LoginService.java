package com.service;

import com.util.User;

/**
 * login service层
 */
public interface LoginService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 验证用户
     * @param user
     * @return
     */
    int selectUser(User user);
}
