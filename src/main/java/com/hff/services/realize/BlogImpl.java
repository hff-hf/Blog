package com.hff.services.realize;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hff.entity.TBlog;
import com.hff.mappers.TBlogMapper;
import com.hff.services.interservice.BlogI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/2 - 15:40
 **/
@Service
public class BlogImpl implements BlogI {

    @Autowired
    private TBlogMapper blogMapper;


//    private int defultePageNum=1;
//    private int defultePageSize=5;
//    private boolean nextPage =false;
//    private boolean proPage = false;

    @Override
    public List<TBlog> selectAll() {

        List<TBlog> list = blogMapper.selectAll();

        return list;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {

        if(blogMapper.deleteByPrimaryKey(id)==1){
            return true;
        }

        return false;
    }

    @Override
    public List<TBlog> selcetAllByTime() {
        List<TBlog> blogs = blogMapper.selcetAllByTime();
        return blogs;
    }

    @Override
    public int insertBlog(TBlog blog) {

        return blogMapper.insertBlog(blog);
    }

    @Override
    public TBlog blogAndUserByBlogId(Long id) {
        return blogMapper.blogAndUserByBlogId(id);
    }

    @Override
    public List<TBlog> selcrtTimeGroup() {
        return blogMapper.selcrtTimeGroup();
    }

    @Override
    public List<TBlog> blogAndUser() {
        return blogMapper.blogAndUser();
    }

    @Override
    public TBlog selectByPrimaryKey(Long id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public TBlog selectblogComments(Long id) {
        return blogMapper.selectblogComments(id);
    }

    @Override
    public List<TBlog> blogAndUserByTypeId(Long id) {
        return blogMapper.blogAndUserByTypeId(id);
    }

    @Override
    public List<TBlog> researchEveryThings(TBlog blog) {
        return blogMapper.researchEveryThings(blog);
    }

    @Override
    public int addBrownTime(Long id) {
        return blogMapper.addBrownTime(id);
    }


//    public boolean isProPage() {
//        return proPage;
//    }
//
//    public void setProPage(boolean proPage) {
//        this.proPage = proPage;
//    }
//
//    public int getDefultePageNum() {
//        return defultePageNum;
//    }
//
//    public void setDefultePageNum(int defultePageNum) {
//        this.defultePageNum = defultePageNum;
//    }
//
//    public int getDefultePageSize() {
//        return defultePageSize;
//    }
//
//    public void setDefultePageSize(int defultePageSize) {
//        this.defultePageSize = defultePageSize;
//    }
//
//    public boolean isNextPage() {
//        return nextPage;
//    }
//
//    public void setNextPage(boolean nextPage) {
//        this.nextPage = nextPage;
//    }
}
