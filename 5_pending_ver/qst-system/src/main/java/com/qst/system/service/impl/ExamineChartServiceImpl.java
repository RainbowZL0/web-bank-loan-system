package com.qst.system.service.impl;


import com.qst.system.domain.Examine;
import com.qst.system.mapper.ExamineChartMapper;
import com.qst.system.mapper.ExamineMapper;
import com.qst.system.service.IExamineChartService;
import com.qst.system.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 审批Service业务层处理
 *
 * @author 2.5
 * @date 2023-08-26
 */
@Service
public class ExamineChartServiceImpl implements IExamineChartService
{
    @Autowired
    private ExamineChartMapper examineMapper;

    /**
     * 查询审批列表
     *
     * @param examine 审批
     * @return 审批
     */
    @Override
    public List<Examine> selectExamineList(Examine examine)
    {
        return examineMapper.selectExamineList(examine);
    }

}