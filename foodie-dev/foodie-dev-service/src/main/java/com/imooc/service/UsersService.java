package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UsersService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * 新增用户
     * @param userBO
     */
    public Users createUser(UserBO userBO);

}
