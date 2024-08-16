package com.qst.system.mapper;

import com.qst.system.domain.Examine;

import java.util.List;

/**
 * 审批Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
public interface ExamineChartMapper
{


    /**
     * 查询审批列表
     *
     * @param examine 审批
     * @return 审批集合
     */
    public List<Examine> selectExamineList(Examine examine);

}