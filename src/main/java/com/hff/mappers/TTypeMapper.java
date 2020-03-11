package com.hff.mappers;


import com.hff.entity.TType;

import java.util.List;

public interface TTypeMapper {


    int deleteByPrimaryKey(Long id);

    int insert(TType record);

    List<TType> allTypes();

    List<TType> typeAndBlogs();

    List<TType> selectTypeAndBlogsById(Long id);

    int insertSelective(TType record);

    TType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TType record);

    int updateByPrimaryKey(TType record);
}