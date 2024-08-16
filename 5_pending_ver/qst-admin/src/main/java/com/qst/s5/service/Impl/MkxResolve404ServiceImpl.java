package com.qst.s5.service.Impl;

import com.qst.s5.service.MkxResolve404Service;
import com.qst.system.service.ICompanyService;
import com.qst.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MkxResolve404ServiceImpl implements MkxResolve404Service {
    private ICompanyService companyService;
    private ISysNoticeService sysNoticeService;

    @Autowired
    public void setCompanyService(ICompanyService companyService) {
        this.companyService = companyService;
    }
    @Autowired
    public void setSysNoticeService(ISysNoticeService sysNoticeService) {
        this.sysNoticeService = sysNoticeService;
    }


    /**
     * Get the number of companies.
     * @return number of companies
     */
    @Override
    public Integer getCompanyNumber() {
        return companyService.selectCompanyCount();
    }

    /**
     * Get the number of notices.
     * @return number of notices
     */
    @Override
    public Integer getNoticeNumber() {
        return sysNoticeService.selectNoticeCount();
    }

    @Override
    public Integer getLoanMoney() {
        return null;
    }

    @Override
    public Integer getBillMoney() {
        return null;
    }
}
