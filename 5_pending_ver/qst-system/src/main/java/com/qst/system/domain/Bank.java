package com.qst.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qst.common.annotation.Excel;
import com.qst.common.core.domain.BaseEntity;

/**
 * 银行对象 bank
 * @author 2.5
 * @date 2023-08-26
 */
public class Bank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 银行id */
    private Long bankId;

    /** 银行名称 */
    @Excel(name = "银行名称")
    private String bankName;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String bankEmail;

    /** 密码 */
    @Excel(name = "密码")
    private String bankPassword;

    /** 贷款利率 */
    @Excel(name = "贷款利率")
    private String bankRate;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String bankPhone;

    /** 贷款期限 月为单位，最少3个月 */
    @Excel(name = "贷款期限 月为单位，最少3个月")
    private String bankLength;

    /** 省id */
    @Excel(name = "省id")
    private String bankProId;

    /** 市ID */
    @Excel(name = "市ID")
    private String bankCitId;

    /** 区ID */
    @Excel(name = "区ID")
    private String bankAraId;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String bankAdress;

    /** 删除标识 0 正常 2 删除 */
    @Excel(name = "删除标识 0 正常 2 删除")
    private String bankDel;

    /** 贷款产品说明 */
    @Excel(name = "贷款产品说明")
    private String bankBz;

    public void setBankId(Long bankId) 
    {
        this.bankId = bankId;
    }

    public Long getBankId() 
    {
        return bankId;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setBankEmail(String bankEmail) 
    {
        this.bankEmail = bankEmail;
    }

    public String getBankEmail() 
    {
        return bankEmail;
    }
    public void setBankPassword(String bankPassword) 
    {
        this.bankPassword = bankPassword;
    }

    public String getBankPassword() 
    {
        return bankPassword;
    }
    public void setBankRate(String bankRate) 
    {
        this.bankRate = bankRate;
    }

    public String getBankRate() 
    {
        return bankRate;
    }
    public void setBankPhone(String bankPhone) 
    {
        this.bankPhone = bankPhone;
    }

    public String getBankPhone() 
    {
        return bankPhone;
    }
    public void setBankLength(String bankLength) 
    {
        this.bankLength = bankLength;
    }

    public String getBankLength() 
    {
        return bankLength;
    }
    public void setBankProId(String bankProId) 
    {
        this.bankProId = bankProId;
    }

    public String getBankProId() 
    {
        return bankProId;
    }
    public void setBankCitId(String bankCitId) 
    {
        this.bankCitId = bankCitId;
    }

    public String getBankCitId() 
    {
        return bankCitId;
    }
    public void setBankAraId(String bankAraId) 
    {
        this.bankAraId = bankAraId;
    }

    public String getBankAraId() 
    {
        return bankAraId;
    }
    public void setBankAdress(String bankAdress) 
    {
        this.bankAdress = bankAdress;
    }

    public String getBankAdress() 
    {
        return bankAdress;
    }
    public void setBankDel(String bankDel) 
    {
        this.bankDel = bankDel;
    }

    public String getBankDel() 
    {
        return bankDel;
    }
    public void setBankBz(String bankBz) 
    {
        this.bankBz = bankBz;
    }

    public String getBankBz() 
    {
        return bankBz;
    }

//    cai

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bankId", getBankId())
            .append("bankName", getBankName())
            .append("bankEmail", getBankEmail())
            .append("bankPassword", getBankPassword())
            .append("bankRate", getBankRate())
            .append("bankPhone", getBankPhone())
            .append("bankLength", getBankLength())
            .append("bankProId", getBankProId())
            .append("bankCitId", getBankCitId())
            .append("bankAraId", getBankAraId())
            .append("bankAdress", getBankAdress())
            .append("bankDel", getBankDel())
            .append("bankBz", getBankBz())
            .toString();
    }
}
