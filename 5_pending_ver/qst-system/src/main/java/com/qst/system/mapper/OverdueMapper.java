package com.qst.system.mapper;

import java.util.List;
import com.qst.system.domain.Overdue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;

/**
 * 逾期Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
@Mapper
public interface OverdueMapper
{
    /*根据企业编号统计逾期次数*/
    @Value("oveComNo")
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
     * 删除逾期
     *
     * @param oveId 逾期主键
     * @return 结果
     */
    public int deleteOverdueByOveId(Long oveId);

    /**
     * 批量删除逾期
     *
     * @param oveIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOverdueByOveIds(Long[] oveIds);
}