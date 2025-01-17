package com.qst.system.mapper;

import java.util.List;
import com.qst.system.domain.ComDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企业详情Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
@Mapper
public interface ComDetailsMapper
{
    /**
     * 查询企业详情
     *
     * @param cId 企业详情主键
     * @return 企业详情
     */
    public ComDetails selectComDetailsByCId(Long cId);

    /**
     * 查询企业详情列表
     *
     * @param comDetails 企业详情
     * @return 企业详情集合
     */
    public List<ComDetails> selectComDetailsList(ComDetails comDetails);

    /**
     * 新增企业详情
     *
     * @param comDetails 企业详情
     * @return 结果
     */
    public int insertComDetails(ComDetails comDetails);

    /**
     * 修改企业详情
     *
     * @param comDetails 企业详情
     * @return 结果
     */
    public int updateComDetails(ComDetails comDetails);

    /**
     * 删除企业详情
     *
     * @param cId 企业详情主键
     * @return 结果
     */
    public int deleteComDetailsByCId(Long cId);

    /**
     * 批量删除企业详情
     *
     * @param cIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteComDetailsByCIds(Long[] cIds);

}