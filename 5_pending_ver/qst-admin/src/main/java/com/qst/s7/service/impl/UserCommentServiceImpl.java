package com.qst.s7.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qst.s7.mapper.UserCommentMapper;
import com.qst.s7.domain.UserComment;
import com.qst.s7.service.IUserCommentService;

/**
 * 用户留言格Service业务层处理
 * 
 * @author qst
 * @date 2023-09-07
 */
@Service
public class UserCommentServiceImpl implements IUserCommentService 
{
    @Autowired
    private UserCommentMapper userCommentMapper;

    /**
     * 查询用户留言格
     * 
     * @param commentId 用户留言格主键
     * @return 用户留言格
     */
    @Override
    public UserComment selectUserCommentByCommentId(Long commentId)
    {
        return userCommentMapper.selectUserCommentByCommentId(commentId);
    }

    /**
     * 查询用户留言格列表
     * 
     * @param userComment 用户留言格
     * @return 用户留言格
     */
    @Override
    public List<UserComment> selectUserCommentList(UserComment userComment)
    {
        return userCommentMapper.selectUserCommentList(userComment);
    }

    /**
     * 新增用户留言格
     * 
     * @param userComment 用户留言格
     * @return 结果
     */
    @Override
    public int insertUserComment(UserComment userComment)
    {
        return userCommentMapper.insertUserComment(userComment);
    }

    /**
     * 修改用户留言格
     * 
     * @param userComment 用户留言格
     * @return 结果
     */
    @Override
    public int updateUserComment(UserComment userComment)
    {
        return userCommentMapper.updateUserComment(userComment);
    }

    /**
     * 批量删除用户留言格
     * 
     * @param commentIds 需要删除的用户留言格主键
     * @return 结果
     */
    @Override
    public int deleteUserCommentByCommentIds(Long[] commentIds)
    {
        return userCommentMapper.deleteUserCommentByCommentIds(commentIds);
    }

    /**
     * 删除用户留言格信息
     * 
     * @param commentId 用户留言格主键
     * @return 结果
     */
    @Override
    public int deleteUserCommentByCommentId(Long commentId)
    {
        return userCommentMapper.deleteUserCommentByCommentId(commentId);
    }
}
