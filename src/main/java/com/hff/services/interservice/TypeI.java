package com.hff.services.interservice;

import com.hff.entity.TType;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/5 - 11:14
 **/
public interface TypeI {

    List<TType> allTypes();
    List<TType> typeAndBlogs();
    List<TType> selectTypeAndBlogsById(Long id);
}
