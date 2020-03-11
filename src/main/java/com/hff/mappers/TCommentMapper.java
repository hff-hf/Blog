package com.hff.mappers;


import com.hff.entity.TComment;

import java.util.List;

public interface TCommentMapper {

    int insertComment(TComment record);
    List<TComment> selectAllByBlogId(Long id);











    int deleteByPrimaryKey(Long id);

    int insert(TComment record);


    TComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TComment record);

    int updateByPrimaryKey(TComment record);
}