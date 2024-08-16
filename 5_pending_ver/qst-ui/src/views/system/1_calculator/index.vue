<template>
  <div style="text-align: center; margin: 0 auto; width: 80%;">
    <el-form ref="my_form" :model="form" label-width="120px">
      <h1 style="font-size: 2rem; margin-bottom: 1rem;">贷款计算器</h1>

      <el-form-item label="贷款金额" prop="companyName" style="margin-bottom: 1rem;">
        <el-input v-model="form.loanAmount" style="width: 80%; border: 2px solid #42b983;" placeholder="￥"/>
      </el-form-item>

      <el-form-item label="每月利率%" prop="loanUsedFor" style="margin-bottom: 1rem;">
        <el-input v-model="form.interestRateEachMonthPercent" style="width: 80%; border: 2px solid #42b983;" placeholder="百分数"/>
      </el-form-item>

      <el-form-item label="贷款月数" prop="loanRate" style="margin-bottom: 1rem;">
        <el-input v-model="form.lastingMonths" style="width: 80%; border: 2px solid #42b983;"/>
      </el-form-item>

      <!-- 错误消息显示 -->
      <div v-if="errorMessage">
        <p style="color: red;">{{ errorMessage }}</p>
      </div>

      <!-- 计算结果显示 -->
      <div v-if="calculatedAmount">
        <h2 style="font-size: 1.5rem; margin-top: 1rem;">计算结果：{{ calculatedAmount }}元</h2>
      </div>

      <el-button @click="clearForm" style="margin-right: 1rem;">清空</el-button>
      <el-button type="primary" @click="calculateLoan" style="background-color: #42b983; border-color: #42b983;">计算</el-button>
    </el-form>
  </div>
</template>


<script>
import { get_money_after_months } from "@/api/system/1_calculator";

export default {
  name: "calculator",
  data() {
    return {
      form: {
        loanAmount: "",
        interestRateEachMonthPercent: "",
        lastingMonths: ""
      },
      calculatedAmount: null,
      errorMessage: "" // 用于存储错误消息的字段
    };
  },
  methods: {
    async calculateLoan() {
      // 在计算之前先进行检查
      if (this.checkFields()) {
        try {
          const response = await get_money_after_months(this.form);
          console.log('还款总额:', response);
          this.calculatedAmount = response;
        } catch (error) {
          console.log('Error:', error);
        }
      }
    },
    clearForm() {
      this.form.loanAmount = "";
      this.form.interestRateEachMonthPercent = "";
      this.form.lastingMonths = "";
      this.calculatedAmount = null;
      this.errorMessage = ""; // 清空错误消息
    },
    // 检查字段的有效性
    checkFields() {
      this.errorMessage = ""; // 先清空旧的错误消息
      if (!this.form.loanAmount || !this.form.interestRateEachMonthPercent || !this.form.lastingMonths) {
        this.errorMessage = "所有字段都不能为空";
        return false;
      }
      if (!Number.isInteger(parseFloat(this.form.lastingMonths))) {
        this.errorMessage = "贷款月数必须为整数";
        return false;
      }
      return true; // 如果所有检查都通过了，返回 true
    }
  }
};
</script>
