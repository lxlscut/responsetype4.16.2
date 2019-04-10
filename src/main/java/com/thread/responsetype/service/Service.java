package com.thread.responsetype.service;

import com.thread.responsetype.entity.Info;
import com.thread.responsetype.service.usermodel.Usermodel;

public interface Service {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Usermodel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}
