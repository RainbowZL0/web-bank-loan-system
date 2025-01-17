package com.qst.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qst.common.core.domain.entity.Cities;
import com.qst.common.core.domain.entity.Provinces;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qst.common.annotation.Excel;
import com.qst.common.core.domain.BaseEntity;

/**
 * 企业详情对象 com_details
 * @author 2.5
 * @date 2023-08-26
 */
@ApiModel("企业详情实体类")
public class ComDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long cId;
    /**
     * 企业Id
     */
    @ApiModelProperty("企业Id")
    @Excel(name = "企业Id")
    private String coId;

    /**
     * 企业积分
     */
    @ApiModelProperty("企业积分")
    @Excel(name = "企业积分")
    private String cIntegral;

    /**
     * 营业执照
     */
    @ApiModelProperty("营业执照")
    @Excel(name = "营业执照")
    private String cLicense;

    /**
     * 企业类型 (0 公司 ，1 个体商户)
     */
    @ApiModelProperty("企业类型")
    @Excel(name = "企业类型 (0 公司 ，1 个体商户)")
    private String cType;

    /**
     * 法人姓名
     */
    @ApiModelProperty("法人姓名")
    @Excel(name = "法人姓名")
    private String cLegalName;

    /**
     * 法人证件号
     */
    @ApiModelProperty("法人证件号")
    @Excel(name = "法人证件号")
    private String cLegalId;

    /**
     * 法人证件路径
     */
    @ApiModelProperty("法人证件路径")
    @Excel(name = "法人证件路径")
    private String cLegalImg;

    /**
     * 有效期限
     */
    @ApiModelProperty("有效期限")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期限", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cLegalTime;

    /**
     * 注册省
     */
    @ApiModelProperty("注册省")
    @Excel(name = "注册省")
    private String cPro;

    /**
     * 注册市
     */
    @ApiModelProperty("注册市")
    @Excel(name = "注册市")
    private String cCity;

    /**
     * 公司详细地址
     */
    @ApiModelProperty("公司详细地址")
    @Excel(name = "公司详细地址")
    private String cAddress;

    /**
     * 经营范围
     */
    @ApiModelProperty("经营范围")
    @Excel(name = "经营范围")
    private String cBusSco;

    /**
     * 营业执照到期时间
     */
    @ApiModelProperty("营业执照到期时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "营业执照到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cLicTime;

    /**注册省**/
    private Provinces provinces;

    /**注册市**/
    private Cities cities;

    /**企业信息**/
    private Company company;


    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getcId() {
        return cId;
    }

    public void setcIntegral(String cIntegral) {
        this.cIntegral = cIntegral;
    }

    public String getcIntegral() {
        return cIntegral;
    }

    public void setcLicense(String cLicense) {
        this.cLicense = cLicense;
    }

    public String getcLicense() {
        return cLicense;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcType() {
        return cType;
    }

    public void setcLegalName(String cLegalName) {
        this.cLegalName = cLegalName;
    }

    public String getcLegalName() {
        return cLegalName;
    }

    public void setcLegalId(String cLegalId) {
        this.cLegalId = cLegalId;
    }

    public String getcLegalId() {
        return cLegalId;
    }

    public void setcLegalImg(String cLegalImg) {
        this.cLegalImg = cLegalImg;
    }

    public String getcLegalImg() {
        return cLegalImg;
    }

    public void setcLegalTime(Date cLegalTime) {
        this.cLegalTime = cLegalTime;
    }

    public Date getcLegalTime() {
        return cLegalTime;
    }

    public void setcPro(String cPro) {
        this.cPro = cPro;
    }

    public String getcPro() {
        return cPro;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcBusSco(String cBusSco) {
        this.cBusSco = cBusSco;
    }

    public String getcBusSco() {
        return cBusSco;
    }

    public void setcLicTime(Date cLicTime) {
        this.cLicTime = cLicTime;
    }

    public Date getcLicTime() {
        return cLicTime;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("cId", getcId())
                .append("coId", getCoId())
                .append("cIntegral", getcIntegral())
                .append("cLicense", getcLicense())
                .append("cType", getcType())
                .append("cLegalName", getcLegalName())
                .append("cLegalId", getcLegalId())
                .append("cLegalImg", getcLegalImg())
                .append("cLegalTime", getcLegalTime())
                .append("cPro", getcPro())
                .append("cCity", getcCity())
                .append("cAddress", getcAddress())
                .append("cBusSco", getcBusSco())
                .append("cLicTime", getcLicTime())
                .append("provinces", getProvinces())
                .append("cities", getCities())
                .append("company", getCompany())
                .toString();
    }
}