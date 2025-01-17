package com.qst.system.mapper;

import java.util.List;
import com.qst.system.domain.Refund;
import org.apache.ibatis.annotations.Mapper;

/**
 * 还款Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
@Mapper
public interface RefundMapper
{

    /*根据企业编号统计还款次数*/
    public int countRefund(String refComNo);

    /**
     * 查询还款
     *
     * @param refId 还款主键
     * @return 还款
     */
    public Refund selectRefundByRefId(Long refId);

    /**
     * 查询还款列表
     *
     * @param refund 还款
     * @return 还款集合
     */
    public List<Refund> selectRefundList(Refund refund);

    /**
     * 新增还款
     *
     * @param refund 还款
     * @return 结果
     */
    public int insertRefund(Refund refund);

    /**
     * 修改还款
     *
     * @param refund 还款
     * @return 结果
     */
    public int updateRefund(Refund refund);

    /**
     * 删除还款
     *
     * @param refId 还款主键
     * @return 结果
     */
    public int deleteRefundByRefId(Long refId);

    /**
     * 批量删除还款
     *
     * @param refIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRefundByRefIds(Long[] refIds);
}