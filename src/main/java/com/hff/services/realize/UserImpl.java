package com.hff.services.realize;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hff.entity.TBlog;
import com.hff.entity.TUser;
import com.hff.mappers.TUserMapper;
import com.hff.services.interservice.UserI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/3 - 10:18
 **/
@Service
public class UserImpl implements UserI {

    @Autowired
    private TUserMapper userMapper;

    private int defultePageNum=1;
   // private int defultePageSize=5;
    private boolean nextPage =false;
    private boolean proPage = false;


    @Override
    public List<TUser> userAndBlogs() {

         PageHelper.startPage(defultePageNum, 5);
        List<TUser> tUsers = userMapper.userAndBlogs();
        PageInfo<TUser> pageInfo = new PageInfo<>(tUsers);
        List<TUser> list = pageInfo.getList();

        setNextPage(pageInfo.isHasNextPage());
        setProPage(pageInfo.isHasPreviousPage());
        return list;
    }

    @Override
    public List<TUser> userAndBlogsByTypeId(Long id) {
        return userMapper.userAndBlogsByTypeId(id);
    }

    @Override
    public List<TUser> userAndBlogsBycontentAndTitle(TBlog blog) {
        return userMapper.userAndBlogsBycontentAndTitle(blog);
    }

    @Override
    public List<TUser> userAndBlogsByTagId(Long id) {
        return userMapper.userAndBlogsByTagId(id);
    }


    @Override
    public int insertUser(TUser user) {
        return userMapper.insertUser(user);
    }

    @Override
    public TUser checkNickName(String nickName) {
        return userMapper.checkNickName(nickName);
    }

    @Override
    public TUser userAndBlogByBlogId(Long id) {
        return userMapper.userAndBlogByBlogId(id);
    }

    @Override
    public TUser checkUser(TUser user) {
        return userMapper.checkUser(user);
    }

    @Override
    public TUser selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }



    public int getDefultePageNum() {
        return defultePageNum;
    }

    public void setDefultePageNum(int defultePageNum) {
        this.defultePageNum = defultePageNum;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isProPage() {
        return proPage;
    }

    public void setProPage(boolean proPage) {
        this.proPage = proPage;
    }
}
