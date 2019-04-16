package com.thread.responsetype.dao;

import com.thread.responsetype.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    Stock selectByItemId(Integer itemid);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}