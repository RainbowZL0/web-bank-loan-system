package com.qst.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qst.system.mapper.RefundMapper;
import com.qst.system.domain.Refund;
import com.qst.system.service.IRefundService;

/**
 * 还款Service业务层处理
 *
 * @author 2.5
 * @date 2023-08-26
 */
@Service
public class RefundServiceImpl implements IRefundService
{
    @Autowired
    private RefundMapper refundMapper;

    @Override
    public int countRefund(String refComNo) {
        return refundMapper.countRefund(refComNo);
    }

    /**
     * 查询还款
     *
     * @param refId 还款主键
     * @return 还款
     */
    @Override
    public Refund selectRefundByRefId(Long refId)
    {
        return refundMapper.selectRefundByRefId(refId);
    }

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

    /**
     * 新增还款
     *
     * @param refund 还款
     * @return 结果
     */
    @Override
    public int insertRefund(Refund refund)
    {
        return refundMapper.insertRefund(refund);
    }

    /**
     * 修改还款
     *
     * @param refund 还款
     * @return 结果
     */
    @Override
    public int updateRefund(Refund refund)
    {
        return refundMapper.updateRefund(refund);
    }

    /**
     * 批量删除还款
     *
     * @param refIds 需要删除的还款主键
     * @return 结果
     */
    @Override
    public int deleteRefundByRefIds(Long[] refIds)
    {
        return refundMapper.deleteRefundByRefIds(refIds);
    }

    /**
     * 删除还款信息
     *
     * @param refId 还款主键
     * @return 结果
     */
    @Override
    public int deleteRefundByRefId(Long refId)
    {
        return refundMapper.deleteRefundByRefId(refId);
    }
}