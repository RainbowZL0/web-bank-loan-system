package com.qst.s7.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qst.common.annotation.Log;
import com.qst.common.core.controller.BaseController;
import com.qst.common.core.domain.AjaxResult;
import com.qst.common.enums.BusinessType;
import com.qst.s7.domain.UserComment;
import com.qst.s7.service.IUserCommentService;
import com.qst.common.utils.poi.ExcelUtil;
import com.qst.common.core.page.TableDataInfo;

@Api(tags = "2管理员查看用户留言")
@RestController
@RequestMapping("/system/comment")
public class UserCommentController extends BaseController
{
    @Autowired
    private IUserCommentService userCommentService;

    /**
     * 查询用户留言格列表
     */
    @GetMapping("/list")
    public TableDataInfo list(UserComment userComment)
    {
        startPage();
        List<UserComment> list = userCommentService.selectUserCommentList(userComment);
        return getDataTable(list);
    }

    /**
     * 导出用户留言格列表
     */
    @Log(title = "用户留言格", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(UserComment userComment)
    {
        List<UserComment> list = userCommentService.selectUserCommentList(userComment);
        ExcelUtil<UserComment> util = new ExcelUtil<UserComment>(UserComment.class);
        return util.exportExcel(list, "用户留言格数据");
    }

    /**
     * 获取用户留言格详细信息
     */
    @GetMapping(value = "/{commentId}")
    public AjaxResult getInfo(@PathVariable("commentId") Long commentId)
    {
        return AjaxResult.success(userCommentService.selectUserCommentByCommentId(commentId));
    }

    /**
     * 新增用户留言格
     */
    @Log(title = "用户留言格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserComment userComment)
    {
        return toAjax(userCommentService.insertUserComment(userComment));
    }

    /**
     * 修改用户留言格
     */
    @Log(title = "用户留言格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserComment userComment)
    {
        return toAjax(userCommentService.updateUserComment(userComment));
    }

    /**
     * 删除用户留言格
     */
    @Log(title = "用户留言格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commentIds}")
    public AjaxResult remove(@PathVariable Long[] commentIds)
    {
        return toAjax(userCommentService.deleteUserCommentByCommentIds(commentIds));
    }
}
