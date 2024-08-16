package com.qst.s5.controller;

import com.qst.s5.domain.MkxUserCommentForm;
import com.qst.s5.service.MkxService;
import com.qst.s5.service.MkxUserCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "1用户留言")
@RestController
@RequestMapping("/mkxUserComment")
public class MkxUserCommentController {
    private MkxUserCommentService mkxUserCommentService;
    private MkxService mkxService;


    @Autowired
    public void setMkxUserCommentService(MkxUserCommentService mkxUserCommentService) {
        this.mkxUserCommentService = mkxUserCommentService;
    }
    @Autowired
    public void setMkxService(MkxService mkxService) {
        this.mkxService = mkxService;
    }


    /**
     * 新增一条用户留言
     * @return 操作结果
     */
    @ApiOperation("新增一条用户留言")
    @PostMapping(value = "/add/{user_name}", produces = "application/json")
    public String add_user_comment(@RequestBody MkxUserCommentForm mkxUserCommentForm,
                                   @PathVariable("user_name") String user_name) {
        String result = mkxUserCommentService.add_user_comment(mkxUserCommentForm, user_name);
        return mkxService.string_to_json(result);
    }
}
