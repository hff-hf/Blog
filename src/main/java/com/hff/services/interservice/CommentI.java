package com.hff.services.interservice;

import com.hff.entity.TComment;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/5 - 16:14
 **/
public interface CommentI {

    int insertComment(TComment record);

    List<TComment> selectAllByBlogId(Long id);
}
