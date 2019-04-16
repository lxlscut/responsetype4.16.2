package com.thread.responsetype.dao;

import com.thread.responsetype.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    List<Item> select();

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}