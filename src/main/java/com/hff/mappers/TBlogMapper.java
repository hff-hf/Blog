package com.hff.mappers;


import com.hff.entity.TBlog;

import java.util.List;

public interface TBlogMapper {


    int insertBlog(TBlog blog);

    List<TBlog> blogAndUserByTypeId(Long id);

    TBlog blogAndUserByBlogId(Long id);

    TBlog selectblogComments(Long id);

    List<TBlog> selcetAllByTime();


    List<TBlog> selectAll();

    List<TBlog> selcrtTimeGroup();

    List<TBlog> researchEveryThings(TBlog blog);
    int addBrownTime(Long id);













































    int deleteByPrimaryKey(Long id);


    List<TBlog> blogAndUser();





    int countBlog();

    int insert(TBlog record);



    int insertSelective(TBlog record);

    TBlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TBlog record);

    int updateByPrimaryKey(TBlog record);
}