package com.qst.system.mapper;

import com.qst.system.domain.Overdue;
import com.qst.system.domain.OverdueCompany;

import java.util.List;

/**
 * 逾期Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
public interface OverdueCompanyMapper
{

    /**
     * 查询逾期企业列表
     *
     * @param overdueCompany 逾期
     * @return 逾期集合
     */
    public List<OverdueCompany> selectOverdueCompanyList(OverdueCompany overdueCompany);


}