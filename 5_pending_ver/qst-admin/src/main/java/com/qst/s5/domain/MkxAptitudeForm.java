package com.qst.s5.domain;

public class MkxAptitudeForm {
    /**
     * 抵押物
     */
    private String aptPawn;
    /**
     * 贷款记录
     */
    private String aptLoansRecord;
    /**
     * 市值
     */
    private String aptComValue;


    public String getAptPawn() {
        return aptPawn;
    }

    public String getAptLoansRecord() {
        return aptLoansRecord;
    }

    public String getAptComValue() {
        return aptComValue;
    }

    public void setAptPawn(String aptPawn) {
        this.aptPawn = aptPawn;
    }

    public void setAptLoansRecord(String aptLoansRecord) {
        this.aptLoansRecord = aptLoansRecord;
    }

    public void setAptComValue(String aptComValue) {
        this.aptComValue = aptComValue;
    }
}
