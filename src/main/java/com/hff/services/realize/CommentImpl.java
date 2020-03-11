package com.hff.services.realize;

import com.hff.entity.TComment;
import com.hff.mappers.TCommentMapper;
import com.hff.services.interservice.CommentI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther hff
 * @time 2020/3/5 - 16:15
 **/
@Service
public class CommentImpl implements CommentI {

    @Autowired
    private TCommentMapper commentMapper;




    @Override
    public int insertComment(TComment record) {
        return commentMapper.insertComment(record);
    }

    @Override
    public List<TComment> selectAllByBlogId(Long id) {
        return commentMapper.selectAllByBlogId(id);
    }
}
