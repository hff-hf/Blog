package com.hff.services.realize;

import com.hff.entity.TType;
import com.hff.mappers.TTypeMapper;
import com.hff.services.interservice.TypeI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/5 - 11:16
 **/
@Service
public class TypeImpl implements TypeI {

    @Autowired
    private TTypeMapper typeMapper;

    @Override
    public List<TType> allTypes() {

        return typeMapper.allTypes();
    }

    @Override
    public List<TType> typeAndBlogs() {
        return typeMapper.typeAndBlogs();
    }

    @Override
    public List<TType> selectTypeAndBlogsById(Long id) {
        return typeMapper.selectTypeAndBlogsById(id);
    }
}
