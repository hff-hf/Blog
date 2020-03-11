package com.hff.services.interservice;

import com.hff.entity.TBlog;
import com.hff.entity.TUser;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/3 - 10:17
 **/
public interface UserI {


    List<TUser> userAndBlogs();

    int insertUser(TUser user);
    TUser checkNickName(String nickName);
    TUser userAndBlogByBlogId(Long id);

    TUser checkUser(TUser user);

    TUser selectByPrimaryKey(Long id);
    List<TUser> userAndBlogsByTagId(Long id);

    List<TUser> userAndBlogsByTypeId(Long id);

    List<TUser> userAndBlogsBycontentAndTitle(TBlog blog);

}
