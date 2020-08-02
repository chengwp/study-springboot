package com.cwp.study.biz.user.service.impl;

import com.cwp.study.biz.user.service.UserService;
import com.cwp.study.dao.user.entity.User;
import com.cwp.study.dao.user.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User getUser(Long userId){
        return userDao.selectByPrimaryKey(userId);
    }
}
