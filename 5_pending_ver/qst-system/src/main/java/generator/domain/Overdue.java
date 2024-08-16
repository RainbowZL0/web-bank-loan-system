package generator.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 逾期表
* @TableName overdue
*/
public class Overdue implements Serializable {

    /**
    * id
    */
    @NotNull(message="[id]不能为空")
    @ApiModelProperty("id")
    private Integer oveId;
    /**
    * 企业编号
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("企业编号")
    @Length(max= 255,message="编码长度不能超过255")
    private String oveComNo;
    /**
    * 贷款ID
    */
    @ApiModelProperty("贷款ID")
    private Integer oveLoaId;
    /**
    * 逾期金额
    */
    @ApiModelProperty("逾期金额")
    private Integer oveMoney;
    /**
    * 逾期开始时间
    */
    @ApiModelProperty("逾期开始时间")
    private Date oveStartTime;
    /**
    * 逾期结束时间
    */
    @ApiModelProperty("逾期结束时间")
    private Date oveLastTime;
    /**
    * 减少积分数
    */
    @ApiModelProperty("减少积分数")
    private Integer oveCutCount;
    /**
    * 额外利息
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("额外利息")
    @Length(max= 255,message="编码长度不能超过255")
    private String oveAddInt;
    /**
    * 删除标识 0 正常 2 删除
    */
    @NotNull(message="[删除标识 0 正常 2 删除]不能为空")
    @ApiModelProperty("删除标识 0 正常 2 删除")
    private String oveDel;

    /**
    * id
    */
    private void setOveId(Integer oveId){
    this.oveId = oveId;
    }

    /**
    * 企业编号
    */
    private void setOveComNo(String oveComNo){
    this.oveComNo = oveComNo;
    }

    /**
    * 贷款ID
    */
    private void setOveLoaId(Integer oveLoaId){
    this.oveLoaId = oveLoaId;
    }

    /**
    * 逾期金额
    */
    private void setOveMoney(Integer oveMoney){
    this.oveMoney = oveMoney;
    }

    /**
    * 逾期开始时间
    */
    private void setOveStartTime(Date oveStartTime){
    this.oveStartTime = oveStartTime;
    }

    /**
    * 逾期结束时间
    */
    private void setOveLastTime(Date oveLastTime){
    this.oveLastTime = oveLastTime;
    }

    /**
    * 减少积分数
    */
    private void setOveCutCount(Integer oveCutCount){
    this.oveCutCount = oveCutCount;
    }

    /**
    * 额外利息
    */
    private void setOveAddInt(String oveAddInt){
    this.oveAddInt = oveAddInt;
    }

    /**
    * 删除标识 0 正常 2 删除
    */
    private void setOveDel(String oveDel){
    this.oveDel = oveDel;
    }


    /**
    * id
    */
    private Integer getOveId(){
    return this.oveId;
    }

    /**
    * 企业编号
    */
    private String getOveComNo(){
    return this.oveComNo;
    }

    /**
    * 贷款ID
    */
    private Integer getOveLoaId(){
    return this.oveLoaId;
    }

    /**
    * 逾期金额
    */
    private Integer getOveMoney(){
    return this.oveMoney;
    }

    /**
    * 逾期开始时间
    */
    private Date getOveStartTime(){
    return this.oveStartTime;
    }

    /**
    * 逾期结束时间
    */
    private Date getOveLastTime(){
    return this.oveLastTime;
    }

    /**
    * 减少积分数
    */
    private Integer getOveCutCount(){
    return this.oveCutCount;
    }

    /**
    * 额外利息
    */
    private String getOveAddInt(){
    return this.oveAddInt;
    }

    /**
    * 删除标识 0 正常 2 删除
    */
    private String getOveDel(){
    return this.oveDel;
    }

}
