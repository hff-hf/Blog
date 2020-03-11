package com.hff.mappers;


import com.hff.entity.TBlogTags;

import java.util.List;

public interface TBlogTagsMapper {


    int insert(TBlogTags record);

    int insertBlogTags(List<TBlogTags> record);


}