package com.hff.services.realize;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hff.entity.TTag;
import com.hff.mappers.TTagMapper;
import com.hff.services.interservice.TageI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/4 - 16:14
 **/
@Service
public class TagImpl implements TageI {

    @Autowired
    private TTagMapper tagMapper;


//    private int defultePageNum=1;
//    private int defultePageSize=5;
//    private boolean nextPage =false;
//    private boolean proPage = false;

    @Override
    public List<TTag> selectAll() {

//        PageHelper.startPage(defultePageNum, defultePageSize);
        List<TTag> tags = tagMapper.selectAll();

//        PageInfo<TTag> pageInfo = new PageInfo<>(tags);

  //      setNextPage(pageInfo.isHasNextPage());
//        setProPage(pageInfo.isHasPreviousPage());


 //       List<TTag> list = pageInfo.getList();

        return tags;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {

        if(tagMapper.deleteByPrimaryKey(id)==1){
            return true;
        }

        return false;
    }

    @Override
    public List<TTag> TagsAndblogs() {
        return tagMapper.TagsAndblogs();
    }

    @Override
    public List<TTag> TagsAndblogTag() {
        return tagMapper.TagsAndblogTag();
    }


    @Override
    public boolean insertTag(TTag tag) {
        return tagMapper.insertTag(tag)==1;
    }

    @Override
    public List<TTag> allTags() {
        return null;
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
