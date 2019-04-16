package com.thread.responsetype.service;

import com.thread.responsetype.entity.Info;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.service.usermodel.Usermodel;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Usermodel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    void register(Usermodel usermodel) throws Mexception;

    Usermodel loginvalidate(Integer tel,String password) throws Mexception;
}
