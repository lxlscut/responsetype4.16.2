package com.thread.responsetype.dao;

import com.thread.responsetype.entity.Password;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer id);

    Password selectByUserid(Integer userid);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);
}