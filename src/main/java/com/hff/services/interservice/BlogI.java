package com.hff.services.interservice;

import com.hff.entity.TBlog;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/2 - 15:40
 **/
public interface BlogI {

    List<TBlog> selectAll();

    boolean deleteByPrimaryKey(Long id);

    List<TBlog> selcetAllByTime();

    int insertBlog(TBlog blog);

    TBlog blogAndUserByBlogId(Long id);

    List<TBlog> selcrtTimeGroup();
    List<TBlog> blogAndUser();

    TBlog selectByPrimaryKey(Long id);

    TBlog selectblogComments(Long id);

    List<TBlog> blogAndUserByTypeId(Long id);

    List<TBlog> researchEveryThings(TBlog blog);

    int addBrownTime(Long id);
}
