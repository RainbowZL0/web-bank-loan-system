package com.qst.s5.service.Impl;

import com.qst.s5.domain.MkxCalculatorForm;
import com.qst.s5.service.MkxCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class MkxCalculatorServiceImpl implements MkxCalculatorService {

    /**
     * 按月贷款还款额计算
     *
     * @return 还款总额
     */
    @Override
    public Float money_back_by_month(MkxCalculatorForm mkxCalculatorForm) {
        Float interest = mkxCalculatorForm.loanAmount
                * (mkxCalculatorForm.interestRateEachMonthPercent / 100)
                * mkxCalculatorForm.lastingMonths;
        return mkxCalculatorForm.loanAmount + interest;
    }
}
