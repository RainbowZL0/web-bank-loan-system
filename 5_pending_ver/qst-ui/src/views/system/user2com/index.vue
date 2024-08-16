<template>
  <div class ='app-container'>
    <el-descriptions title="公司详细信息">
      <el-descriptions-item label="公司名称">{{ company.comName }}</el-descriptions-item>
      <el-descriptions-item label="公司编号">{{ company.comNo }}</el-descriptions-item>
      <el-descriptions-item label="公司电话">{{ company.comPhone }}</el-descriptions-item>
      <el-descriptions-item label="公司邮箱">{{ company.comEmail }}</el-descriptions-item>
      <el-descriptions-item label="贷款总额">{{ company.loanSum }}</el-descriptions-item>
      <el-descriptions-item label="公司地址">{{ company.cAddress }}</el-descriptions-item>
      <el-descriptions-item label="法人姓名">{{ company.cLegalName }}</el-descriptions-item>
      <el-descriptions-item label="法人证件号">{{ company.cLegalId }}</el-descriptions-item>

    </el-descriptions>
  </div>
</template>


<script>
  import {getComId} from "@/api/system/user2com";
  export default {

    data() {
      return {
        company: {
          comName: "",
          comNo: "",
          comPhone: "",
          comEmail: "",
          loanSum: "",
          cLegalName: "",
          cLegalId: "",
          cAddress: ""
        }
      }
    },

    created() {
      this.getCId();
    },

    methods: {

      getUsername(){
        const match = document.cookie.match(new RegExp('(^| )' + 'username' + '=([^;]+)'))
        return match ? match[2] : undefined
      },

      getCId(){
        getComId(this.getUsername()).then(response=>{
          this.company = response
        })

      }

    }





  }
</script>

<style>
  .home {
  font-family:  "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;;
}
</style>
