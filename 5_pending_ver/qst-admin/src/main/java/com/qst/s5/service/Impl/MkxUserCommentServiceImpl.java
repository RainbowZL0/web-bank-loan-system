package com.qst.s5.service.Impl;

import com.netflix.discovery.converters.Auto;
import com.qst.s5.domain.MkxUserCommentForm;
import com.qst.s5.mapper.MkxUserCommentMapper;
import com.qst.s5.service.MkxService;
import com.qst.s5.service.MkxUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MkxUserCommentServiceImpl implements MkxUserCommentService {
    private MkxUserCommentMapper mkxUserCommentMapper;
    private MkxService mkxService;


    @Autowired
    public void setMkxUserCommentMapper(MkxUserCommentMapper mkxUserCommentMapper) {
        this.mkxUserCommentMapper = mkxUserCommentMapper;
    }
    @Autowired
    public void setMkxService(MkxService mkxService) {
        this.mkxService = mkxService;
    }


    /**
     * 添加一条用户评论
     * @param mkxUserCommentForm 用户评论表单
     * @return 操作结果
     */
    @Override
    public String add_user_comment(MkxUserCommentForm mkxUserCommentForm,
                                   String user_name) {
        // 根据用户名查询用户ID 并且设置到用户留言表单中
        Long user_id = mkxService.select_userID_by_userName(user_name);
        mkxUserCommentForm.setUser_id(user_id);
        // 添加用户留言
        int rows = mkxUserCommentMapper.add_user_comment(mkxUserCommentForm);
        if (rows > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }
}
