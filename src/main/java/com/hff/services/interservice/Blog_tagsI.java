package com.hff.services.interservice;

import com.hff.entity.TBlogTags;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/6 - 15:55
 **/
public interface Blog_tagsI {

    int insertBlogTags(List<TBlogTags> record);
}
