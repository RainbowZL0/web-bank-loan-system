package com.qst.s5.controller;

import com.qst.s5.service.MkxResolve404Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To address the issue of 404 error when opening the system ui.
 */
@Api(tags = "1MkxResolve404Controller")
@RestController
@RequestMapping("/system/count/")
public class MkxResolve404Controller {
    private MkxResolve404Service mkxResolve404Service;


    @Autowired
    public void setMkxResolve404Service(MkxResolve404Service mkxResolve404Service) {
        this.mkxResolve404Service = mkxResolve404Service;
    }


    /**
     * Get the number of companies.
     * @return number of companies
     */
    @ApiOperation(value = "")
    @GetMapping("companyCount")
    public Integer getCompanyNumber() {
        return mkxResolve404Service.getCompanyNumber();
    }

    /**
     * Get the number of notices.
     * @return number of notices
     */
    @ApiOperation(value = "Get number of notices.")
    @GetMapping("noticeCount")
    public Integer getNoticeNumber() {
        return mkxResolve404Service.getNoticeNumber();
    }

    /**
     * Get loan money.
     * @return loan money
     */
    @ApiOperation(value = "Get amount of loan money.")
    @GetMapping("loaMoney")
    public Integer getLoanMoney() {
        return mkxResolve404Service.getLoanMoney();
    }

    /**
     * Get bill money.
     * @return bill money
     */
    @ApiOperation(value = "Get amount of bill money.")
    @GetMapping("loaCount")
    public Integer getBillMoney() {
        return mkxResolve404Service.getBillMoney();
    }
}
