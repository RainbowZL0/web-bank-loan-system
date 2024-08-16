package com.qst.s6.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhl
 * @date 2023/8/31
 */
@ApiModel("公司详情展示")
public class ComInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("公司ID")
    private Long comId;
    @ApiModelProperty("公司名称")
    private String comName;
    @ApiModelProperty("公司编号")
    private String comNo;
    @ApiModelProperty("公司电话")
    private String comPhone;
    @ApiModelProperty("公司邮箱")
    private String comEmail;
    @ApiModelProperty("贷款数量")
    private String loanSum;
    @ApiModelProperty("法人姓名")
    private String cLegalName;
    @ApiModelProperty("法人证件号")
    private String cLegalId;
    @ApiModelProperty("公司地址")
    private String cAddress;

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }
    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComNo() {
        return comNo;
    }

    public void setComNo(String comNo) {
        this.comNo = comNo;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public String getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(String loanSum) {
        this.loanSum = loanSum;
    }

    public String getcLegalName() {
        return cLegalName;
    }

    public void setcLegalName(String cLegalName) {
        this.cLegalName = cLegalName;
    }

    public String getcLegalId() {
        return cLegalId;
    }

    public void setcLegalId(String cLegalId) {
        this.cLegalId = cLegalId;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

}
