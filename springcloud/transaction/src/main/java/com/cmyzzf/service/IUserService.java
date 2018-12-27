package com.cmyzzf.service;

import com.cmyzzf.model.User;

public interface IUserService {

    int insert(User user) throws InterruptedException, Exception;

    User selectUserUnCommit(String name);

    User selectUserCommit(String zzf);

    User testRepeatRead(String zzf);
}
