package com.thread.responsetype.dao;

import com.thread.responsetype.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer id);

    Info selectBytelphone(Integer telphone);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}