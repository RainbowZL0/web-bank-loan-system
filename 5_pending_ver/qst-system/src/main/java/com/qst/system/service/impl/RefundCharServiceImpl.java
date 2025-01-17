package com.qst.system.service.impl;

import com.qst.system.domain.Refund;
import com.qst.system.mapper.RefundChartMapper;
import com.qst.system.service.IRefundChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 还款Service业务层处理
 *
 * @author 2.5
 * @date 2023-08-26
 */
@Service
public class RefundCharServiceImpl implements IRefundChartService
{
    @Autowired
    private RefundChartMapper refundMapper;

    /**
     * 查询还款列表
     *
     * @param refund 还款
     * @return 还款
     */
    @Override
    public List<Refund> selectRefundList(Refund refund)
    {
        return refundMapper.selectRefundList(refund);
    }
}