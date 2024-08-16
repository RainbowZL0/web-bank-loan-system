package com.qst.system.mapper;

import com.qst.system.domain.BankSend;

import java.util.List;

/**
 * 放款Mapper接口
 *
 * @author 2.5
 * @date 2023-08-26
 */
public interface BankSendChartMapper
{
    /**
     * 查询放款列表
     *
     * @param bankSend 放款
     * @return 放款集合
     */
    public List<BankSend> selectBankSendList(BankSend bankSend);

}