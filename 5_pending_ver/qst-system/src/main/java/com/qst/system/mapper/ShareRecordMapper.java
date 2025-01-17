package com.qst.system.mapper;

import java.util.List;
import com.qst.system.domain.ShareRecord;

/**
 * 分享数据管理Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
public interface ShareRecordMapper
{
    /**
     * 查询分享数据管理
     *
     * @param rId 分享数据管理主键
     * @return 分享数据管理
     */
    public ShareRecord selectShareRecordByRId(Long rId);

    /**
     * 查询分享数据管理列表
     *
     * @param shareRecord 分享数据管理
     * @return 分享数据管理集合
     */
    public List<ShareRecord> selectShareRecordList(ShareRecord shareRecord);

    /**
     * 新增分享数据管理
     *
     * @param shareRecord 分享数据管理
     * @return 结果
     */
    public int insertShareRecord(ShareRecord shareRecord);

    /**
     * 修改分享数据管理
     *
     * @param shareRecord 分享数据管理
     * @return 结果
     */
    public int updateShareRecord(ShareRecord shareRecord);

    /**
     * 删除分享数据管理
     *
     * @param rId 分享数据管理主键
     * @return 结果
     */
    public int deleteShareRecordByRId(Long rId);

    /**
     * 批量删除分享数据管理
     *
     * @param rIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShareRecordByRIds(Long[] rIds);
}