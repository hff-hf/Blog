package com.hff.services.realize;

import com.hff.entity.TBlogTags;
import com.hff.mappers.TBlogTagsMapper;
import com.hff.services.interservice.Blog_tagsI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/6 - 15:59
 **/
@Service
public class Blog_tagsImpl implements Blog_tagsI {

    @Autowired
    private TBlogTagsMapper blogTagsMapper;



    @Override
    public int insertBlogTags(List<TBlogTags> record) {
        return blogTagsMapper.insertBlogTags(record);
    }
}
