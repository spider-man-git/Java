package com.cmyzzf.service.impl;

import com.cmyzzf.mapper.IUserMapper;
import com.cmyzzf.model.User;
import com.cmyzzf.service.IUserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int insert(User user) throws Exception {
        int result = userMapper.insert(user);
        System.out.println("result="+result);
        Thread.sleep(1000L);
//        导致事务回滚的条件
//        throw new RuntimeException("test");
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public User selectUserUnCommit(String name) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectUser(name);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User selectUserCommit(String name) {
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectUser(name);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User testRepeatRead(String zzf) {
        User user = userMapper.selectUser("zzf");
        System.out.println("user="+user.getAge());
        userMapper.updateByName("zzf");
        User user1 = userMapper.selectUser("zzf");
        System.out.println("user1="+user1.getAge());
        return user1;
    }
}
