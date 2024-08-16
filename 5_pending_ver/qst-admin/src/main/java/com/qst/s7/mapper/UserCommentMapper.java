package com.qst.s7.mapper;

import java.util.List;
import com.qst.s7.domain.UserComment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户留言格Mapper接口
 * 
 * @author qst
 * @date 2023-09-07
 */
@Mapper
public interface UserCommentMapper 
{
    /**
     * 查询用户留言格
     * 
     * @param commentId 用户留言格主键
     * @return 用户留言格
     */
    public UserComment selectUserCommentByCommentId(Long commentId);

    /**
     * 查询用户留言格列表
     * 
     * @param userComment 用户留言格
     * @return 用户留言格集合
     */
    public List<UserComment> selectUserCommentList(UserComment userComment);

    /**
     * 新增用户留言格
     * 
     * @param userComment 用户留言格
     * @return 结果
     */
    public int insertUserComment(UserComment userComment);

    /**
     * 修改用户留言格
     * 
     * @param userComment 用户留言格
     * @return 结果
     */
    public int updateUserComment(UserComment userComment);

    /**
     * 删除用户留言格
     * 
     * @param commentId 用户留言格主键
     * @return 结果
     */
    public int deleteUserCommentByCommentId(Long commentId);

    /**
     * 批量删除用户留言格
     * 
     * @param commentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserCommentByCommentIds(Long[] commentIds);
}
