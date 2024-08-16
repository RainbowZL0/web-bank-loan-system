package com.qst.s5.controller;

import com.qst.s5.domain.MkxCalculatorForm;
import com.qst.s5.service.MkxCalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "1贷款计算器")
@RestController
@RequestMapping("/mkxLoanCalculator")
public class MkxCalculatorController {
    public MkxCalculatorService mkxCalculatorService;


    @Autowired
    public void setMkxCalculatorService(MkxCalculatorService mkxCalculatorService) {
        this.mkxCalculatorService = mkxCalculatorService;
    }


    /**
     * 按月贷款还款额计算
     *
     * @return 还款总额
     */
    @ApiOperation("按月贷款还款额计算")
    @PostMapping(value = "/loanByMonth", produces = "application/json")
    public Float money_back_by_month(@RequestBody MkxCalculatorForm mkxCalculatorForm) {
        return mkxCalculatorService.money_back_by_month(mkxCalculatorForm);
    }

}
