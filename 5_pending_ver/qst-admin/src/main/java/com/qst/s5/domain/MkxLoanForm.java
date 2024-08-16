package com.qst.s5.domain;

/**
 * 接收贷款申请表单
 */
public class MkxLoanForm {
    /**
     * 贷款期限 注意不是Id，是期限，虽然名字叫Id
     */
    private Long loaLisId;

    /**
     * 申请公司id
     */
    private Long companyId;
    /**
     * 贷款银行id
     */
    private Long loanFromBankId;
    /**
     * 贷款用途
     */
    private String loanUsedFor;
    /**
     * 贷款利率
     */
    private String loanRate;
    /**
     * 贷款金额
     */
    private Long loanAmount;
    /**
     * 申请人银行账号
     */
    private String applicatorBankAccountID;
    /**
     * 申请人姓名
     */
    private String applicatorName;
    /**
     * 申请人开户银行名
     */
    private String applicatorBankName;
    /**
     * 申请人身份证号
     */
    private String applicatorIdentityCardNumber;



    public String getLoanUsedFor() {
        return loanUsedFor;
    }

    public void setLoanUsedFor(String loanUsedFor) {
        this.loanUsedFor = loanUsedFor;
    }

    public String getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(String loanRate) {
        this.loanRate = loanRate;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getApplicatorBankAccountID() {
        return applicatorBankAccountID;
    }

    public void setApplicatorBankAccountID(String applicatorBankAccountID) {
        this.applicatorBankAccountID = applicatorBankAccountID;
    }

    public String getApplicatorName() {
        return applicatorName;
    }

    public void setApplicatorName(String applicatorName) {
        this.applicatorName = applicatorName;
    }

    public String getApplicatorBankName() {
        return applicatorBankName;
    }

    public void setApplicatorBankName(String applicatorBankName) {
        this.applicatorBankName = applicatorBankName;
    }

    public String getApplicatorIdentityCardNumber() {
        return applicatorIdentityCardNumber;
    }

    public void setApplicatorIdentityCardNumber(String applicatorIdentityCardNumber) {
        this.applicatorIdentityCardNumber = applicatorIdentityCardNumber;
    }

    public Long getLoaLisId() {
        return loaLisId;
    }

    public void setLoaLisId(Long loaLisId) {
        this.loaLisId = loaLisId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getLoanFromBankId() {
        return loanFromBankId;
    }

    public void setLoanFromBankId(Long loanFromBankId) {
        this.loanFromBankId = loanFromBankId;
    }

}
