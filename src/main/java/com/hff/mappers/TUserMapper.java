package com.hff.mappers;


import com.hff.entity.TBlog;
import com.hff.entity.TUser;

import java.util.List;

public interface TUserMapper {


    List<TUser> userAndBlogs();

    TUser selectByPrimaryKey(Long id);

    List<TUser> userAndBlogsByTypeId(Long id);
    List<TUser> userAndBlogsByTagId(Long id);
    List<TUser> userAndBlogsBycontentAndTitle(TBlog blog);
    TUser checkNickName(String nickName);
    TUser userAndBlogByBlogId(Long id);









    int insertUser(TUser user);

    TUser checkUser(TUser user);

}