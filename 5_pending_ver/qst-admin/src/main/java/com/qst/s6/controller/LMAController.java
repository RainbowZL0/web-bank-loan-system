package com.qst.s6.controller;

import com.qst.common.core.controller.BaseController;
import com.qst.s5.service.MkxService;
import com.qst.s6.bean.ComInfo;
import com.qst.s6.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("展示公司详情")
@RestController
@RequestMapping("/lma")
public class LMAController extends BaseController {
    private IUserInfoService userInfoService;
    private MkxService mkxService;


    @Autowired
    public void setMkxService(MkxService mkxService) {
        this.mkxService = mkxService;
    }
    @Autowired
    public void setUserInfoService(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    /**
     * 根据用户名查询公司相关数据
     *
     * @param user_name 用户名
     * @return 公司相关数据
     */
    @ApiOperation("根据用户名查询公司情况")
    @GetMapping("/info/{user_name}")
    public ComInfo getInfo(@PathVariable String user_name) {
        Long uId = mkxService.select_userID_by_userName(user_name);
        return userInfoService.selectCompanyDetailsByUserId(String.valueOf(uId));
    }

    /**
     * 根据用户名查询用户ID
     * @param user_name 用户名
     * @return 用户ID
     */
    @ApiOperation("根据用户名查询用户ID")
    @GetMapping("/id/{user_name}")
    public Long getId(@PathVariable String user_name) {
        return mkxService.select_userID_by_userName(user_name);
    }

}
