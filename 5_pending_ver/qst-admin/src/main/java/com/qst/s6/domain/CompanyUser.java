package com.qst.s6.domain;

import com.qst.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;

/**
 * @author zhl
 * @date 2023/8/31
 */
@ApiModel("用户名与公司id的映射对象")
public class CompanyUser extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long cId;
    private Integer uId;
}
