package com.qst.s6.service.impl;

import com.qst.common.core.domain.entity.SysUser;
import com.qst.system.mapper.User2ComMapper;
import com.qst.s6.bean.ComInfo;
import com.qst.s6.service.IUserInfoService;
import com.qst.system.domain.ComDetails;
import com.qst.system.domain.Company;
import com.qst.system.mapper.ComDetailsMapper;
import com.qst.system.mapper.CompanyMapper;
import com.qst.system.mapper.LoansMapper;
import com.qst.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhl
 * @date 2023/8/30
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    private CompanyMapper companyMapper;
    private ComDetailsMapper comDetailsMapper;
    private LoansMapper loansMapper;
    private User2ComMapper user2ComMapper;



    @Autowired
    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }
    @Autowired
    public void setComDetailsMapper(ComDetailsMapper comDetailsMapper) {
        this.comDetailsMapper = comDetailsMapper;
    }
    @Autowired
    public void setLoansMapper(LoansMapper loansMapper) {
        this.loansMapper = loansMapper;
    }
    @Autowired
    public void setUser2ComMapper(User2ComMapper user2ComMapper) {
        this.user2ComMapper = user2ComMapper;
    }


    /**
     * 根据公司ID查询公司相关数据
     * @param uId 用户ID
     * @return 公司相关数据
     */
    @Override
    public ComInfo selectCompanyDetailsByUserId(String uId) {
        int cId = user2ComMapper.selectCIdByUId(uId);
        Company company = companyMapper.selectCompanyByComId((long) cId);
        ComDetails details = comDetailsMapper.selectComDetailsByCId((long) cId);

        ComInfo info = new ComInfo();
        info.setComId(company.getComId());
        info.setComName(company.getComName());
        info.setComNo(company.getComNo());
        info.setComPhone(company.getComPhone());
        info.setComEmail(company.getComEmail());
        info.setLoanSum(String.valueOf(loansMapper.countLoan(String.valueOf(cId))));
        info.setcLegalName(details.getcLegalName());
        info.setcLegalId(details.getcLegalId());
        info.setcAddress(details.getcAddress());

        return info;
    }

}
