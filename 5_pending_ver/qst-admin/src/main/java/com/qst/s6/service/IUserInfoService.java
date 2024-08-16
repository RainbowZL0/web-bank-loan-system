package com.qst.s6.service;

import com.qst.s6.bean.ComInfo;

/**
 * @author zhl
 * @date 2023/8/30
 */
public interface IUserInfoService {

    /**
     * 根据公司ID查询公司相关数据
     * @param uId 用户ID
     * @return 公司相关数据
     */
    public ComInfo selectCompanyDetailsByUserId(String uId);


}
