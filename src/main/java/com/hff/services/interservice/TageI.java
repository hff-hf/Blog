package com.hff.services.interservice;

import com.hff.entity.TTag;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/4 - 16:13
 **/
public interface TageI {

    List<TTag> selectAll();
    boolean deleteByPrimaryKey(Long id);

    List<TTag> TagsAndblogs();

    List<TTag> TagsAndblogTag();

    boolean insertTag(TTag tag);

    List<TTag> allTags();


}
