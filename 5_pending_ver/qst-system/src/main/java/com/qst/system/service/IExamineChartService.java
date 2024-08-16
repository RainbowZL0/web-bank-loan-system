package com.qst.system.service;

import com.qst.system.domain.Examine;

import java.util.List;

/**
 * 审批Service接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
public interface IExamineChartService
{
    /**
     * 查询审批列表
     *
     * @param examine 审批
     * @return 审批集合
     */
    public List<Examine> selectExamineList(Examine examine);

}