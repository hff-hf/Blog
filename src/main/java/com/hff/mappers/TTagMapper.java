package com.hff.mappers;


import com.hff.entity.TTag;

import java.util.List;

public interface TTagMapper {


    List<TTag> selectAll();

    int deleteByPrimaryKey(Long id);

    int insertTag(TTag tag);

    List<TTag> TagsAndblogs();

    List<TTag> TagsAndblogTag();


    int insertSelective(TTag record);

    TTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TTag record);

    int updateByPrimaryKey(TTag record);
}