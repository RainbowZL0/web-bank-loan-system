package com.qst.system.service;

import java.util.List;
import com.qst.system.domain.Overdue;

/**
 * 逾期Service接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
public interface IOverdueService
{
    /*根据企业编号统计逾期次数*/
    public int countOverdue(String oveComNo);

    /**
     * 查询逾期
     *
     * @param oveId 逾期主键
     * @return 逾期
     */
    public Overdue selectOverdueByOveId(Long oveId);

    /**
     * 查询逾期列表
     *
     * @param overdue 逾期
     * @return 逾期集合
     */
    public List<Overdue> selectOverdueList(Overdue overdue);

    /**
     * 新增逾期
     *
     * @param overdue 逾期
     * @return 结果
     */
    public int insertOverdue(Overdue overdue);

    /**
     * 修改逾期
     *
     * @param overdue 逾期
     * @return 结果
     */
    public int updateOverdue(Overdue overdue);

    /**
     * 批量删除逾期
     *
     * @param oveIds 需要删除的逾期主键集合
     * @return 结果
     */
    public int deleteOverdueByOveIds(Long[] oveIds);

    /**
     * 删除逾期信息
     *
     * @param oveId 逾期主键
     * @return 结果
     */
    public int deleteOverdueByOveId(Long oveId);
}