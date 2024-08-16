<template>
  <div v-if="page===0">
    <h2 class="fs-title">贷款条件</h2>
      <h3 class="fs-subtitle">请认真阅读</h3>
      <div style="text-align: center;">
        <textarea v-model="textdata" style="width: 70%; height: 500px" class="fs-textarea"/>
      </div>
      <div class="controls">
        <input v-model="checkflag" type="checkbox" style="margin-left: 70%;">已阅读</input>
      </div>
      <el-button type="primary" @click="readText" style="margin-left: 70%;">下一页</el-button>
  </div>
  <div v-else-if="page===1" class="loanTable">
    <div class="form">
      <el-form ref="form1" :model="form1" label-width="120px" style="" :rules="rules1">
        <h1 class="fs-title">贷款表</h1>
        <el-form-item label="企业名称：" prop="companyName">
          <el-input v-model="form1.companyName" style="width: 80%" placeholder="请输入企业名称"  @blur="updateCompanyName"/>
        </el-form-item>
        <el-form-item label="银行名称：" :span="11" prop="loanFromBankId">
          <el-select v-model="form1.loanFromBankId" placeholder="请选择银行名称" @change="handleSelectChange">
            <el-option v-for = "bank in banklist"
                        :key = "bank.bankId"
                        :label="bank.bankName"
                        :value="bank.bankId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="贷款期限：" prop="loaLisId">
          <el-select v-model="form1.loaLisId" placeholder="请选择贷款期限">
            <el-option label="三个月" value="3"></el-option>
            <el-option label="六个月" value="6"></el-option>
            <el-option label="九个月" value="9"></el-option>
            <el-option label="一年" value="12"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="贷款用途：" prop="loanUsedFor">
          <el-input v-model="form1.loanUsedFor" style="width: 80%" placeholder="请输入贷款用途"/>
        </el-form-item>
        <el-form-item label="贷款利率：" prop="loanRate">
          <el-input v-model="form1.loanRate" readonly="" style="width: 80%"/>
        </el-form-item>
        <el-form-item label="贷款金额(￥)：" prop="loanAmount">
          <el-input v-model="form1.loanAmount" style="width: 80%"/>
        </el-form-item>
        <h3 class="fs-title">收款信息</h3>
        <el-form-item label="收款账户：" prop="applicatorBankAccountID">
          <el-input v-model="form1.applicatorBankAccountID"  style="width: 80%" placeholder="在此输入...."/>
        </el-form-item>
        <el-form-item label="收款人：" prop="applicatorName">
          <el-input v-model="form1.applicatorName"  style="width: 80%" placeholder="在此输入...."/>
        </el-form-item>
        <el-form-item label="开户行：" prop="applicatorBankName">
          <el-input v-model="form1.applicatorBankName" style="width: 80%" placeholder="在此输入...."/>
        </el-form-item>
        <el-form-item label="身份证号：" prop="applicatorIdentityCardNumber">
          <el-input v-model="form1.applicatorIdentityCardNumber"  style="width: 80%" placeholder="在此输入...."/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm1">提交</el-button>
          <el-button @click="back0">返回上一页捏</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
  <div v-else-if="page===2" class="loanTable">
    <div class="form">
        <h3 class="fs-title">材料表</h3>
        <h4 class="fs-subtitle">请按顺序上传相关材料照片</h4>
        <h4 class="fs-subtitle">近六个月流水照片-企业营业执照-征信报告-抵押物</h4>
        <el-upload
          ref="upload"
          action=""
          accept=".jpg,.jpeg,.png,.gif,.bmp,.pdf,.JPG,.JPEG,.PBG,.GIF,.BMP,.PDF"
          multiple
          :limit="4"
          :format="['jpg','jpeg','png','gif']"
          :on-preview="handlePreview"
          :on-change="handleChange"
          :on-remove="handleRemove"
          :on-exceed="handleExceed"
          :file-list="fileList"
          :http-request="uploadFile"
          :auto-upload="false">
            <el-button style="position: absolute; left:40%; top:180px; transform: translate(-50%,0)" slot="trigger" size="small" type="primary">选取文件</el-button>
            <el-button style="position: absolute; left:60%; top:180px; transform: translate(-50%,0)" size="small" type="success" @click="submitUpload">上传到服务器
            </el-button>
        </el-upload>
    </div>
  </div>
  <div v-else-if="page===3" class="loanTable">
    <div class="form">
      <el-form ref="form2" :model="form2" label-width="120px" style="" :rules="rules2">
        <h3 class="fs-title">资质表</h3>
        <h4 class="fs-subtitle">请如实填写</h4>
        <el-form-item label="抵押物：" prop="aptPawn">
          <el-input v-model="form2.aptPawn" style="width: 80%" placeholder="在此输入"/>
        </el-form-item>
        <el-form-item label="有无贷款" prop="aptLoansRecord">
          <el-select v-model="form2.aptLoansRecord" placeholder="请选择">
            <el-option label="无" value="0"></el-option>
            <el-option label="有" value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="企业市值：" prop="aptComValue">
          <el-input v-model="form2.aptComValue" style="width: 80%" placeholder="在此输入"/>
        </el-form-item>
        <el-form-item>
          <el-button style="position: absolute; left:40%; transform: translate(-50%,0)" type="primary" @click="submitForm2">提交</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
  <div v-else>
    <h1>您已完成贷款申请！</h1>
  </div>


</template>

<script>
/**
 * 页面核心数据结构体说明文档
 *
 *
 */
// import from

import {listBank} from "@/api/system/bank";
import {listCompany} from "@/api/system/company";
import {addList,uploadFiles,insertAptitude} from "@/api/system/loanschart";
// import {insertAptitude} from "@api/system/aptitude";

export default {
  name: "Faq",
  props: {
    sampleP: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      sampleD: "value",
      textdata: "    一、贷款流程" + "\n" +
                "        1、借款人提供贷款证明材料；" + "\n" +
                "        2、管理中心审核、决定；" + "\n" +
                "        3、借款人签订借款合同；" + "\n" +
                "        4、借款人到房管部门办理抵押手续；" + "\n" +
                "        5、发放贷款；" + "\n" +
                "        6、借款人按合同规定归还贷款本息。" + "\n" +
                "    二、贷款条件" + "\n" +
                "        1、具有有效的身份证明；" + "\n" +
                "        2、按时连续足额缴存住房公积金6个月（含）以上；" + "\n" +
                "        3、有符合规定的首付款凭证；" + "\n" +
                "        4、有符合规定的购房合同（协议）；" + "\n" +
                "        5、无贷款、无担保、信用良好，具有完全民事行为能力和偿还贷款本息的能力；" + "\n" +
                "        6、有符合法律规定的担保；" + "\n" +
                "        7、同意提供管理中心需要审核的其他有关证明材料。" + "\n" +
                "    三、贷款应提供的证明材料  （另附）" + "\n" +
                "    四、贷款额度和期限" + "\n" +
                "        ㈠ 贷款额度须同时符合以下条件,取其中最低值。" + "\n" +
                "        1、按单笔最高贷款额度计算" + "\n" +
                "            夫妻双方按时连续足额缴存住房公积金的，贷款最高额度55万元；" + "\n" +
                "            单方按时连续足额缴存住房公积金的，贷款最高额度30万元；" + "\n" +
                "        2、按工资基数计算" + "\n" +
                "            计算贷款额时，双方缴存的，以借款人和配偶的住房公积金缴存工资基数之和为准，" + "\n" +
                "            月还款额与缴存工资基数比上限控制在50%；单方缴存的，以借款人的住房公积金缴存工资基数为准，" + "\n" +
                "            月还款额与缴存工资基数比上限控制在50%。" + "\n" +
                "        3、按账户余额和缴存年限计算" + "\n" +
                "            贷款额度=（借款申请人住房公积金缴存账户余额+共同申请人住房公积金缴存账户余额） 20倍" + "\n" +
                "            缴存时间系数" + "\n" +
                "            商品房总价款的认定：房屋建筑面积 每平方米价格。" + "\n" +
                "        二手房总价款的认定：参照《中华人民共和国税收缴款书》票据上的计税金额和《新乡市存量房买卖合同》或《房屋买卖契约》协议中的成交价格，二者取低。" + "\n" +
                "        ㈡ 贷款期限" + "\n" +
                "            贷款期限最长不超过30年，且不得超过借款人法定退休前剩余工作年限；" + "\n" +
                "            购买普通住房（建筑面积144平米及以下）的，可延至借款人法定退休年龄后5年，最长贷款期限为30年。" + "\n" +
                "    五、贷款利率" + "\n" +
                "        按贷款期限的长短而实行不同档次的利率，具体利率档次依照人民银行公布的贷款利率档次执行；贷款期限在1年以上的遇法定利率调整，于下年初开始，按相应利率档次执行新的利率规定。" + "\n" +
                "        目前执行的贷款年利率5年（含）以下2.75%;5年以上3.25%。住房套数的界定标准及二套房利率按国家政策执行。" + "\n" +
                "    六、贷款本息偿还方式" + "\n" +
                "        借款人应按合同约定的还款方式，委托贷款银行通过借记卡、存折等方式代扣。" + "\n" +
                "        借款人如提前归还贷款时，到新乡市市民中心三楼住房公积金受委托贷款银行窗口申请办理，不收取任何费用；其提" + "\n" +
                "        前归还部分不再计收利息，已计收的贷款利息不再调整。" + "\n" +
                "        对逾期贷款，会产生额外利息。额外利息也是逾期产生的罚息，本平台根据银行要求在贷款执行利率基础上加收50%" + "\n" +
                "    七、担保方式" + "\n" +
                "        ㈠ 房产抵押担保        ㈡ 保证担保" + "\n" +
                "        房产抵押担保的，抵押物应为所购住房，所购住房不具备抵押条件前，也可用贷款机构所在地符合抵押条件的其它住房抵押。" + "\n" +
                "        开发商保证担保的，必须具有代偿全部贷款本息的能力，同意提供有关资质证明材料，按照合作协议条款的约定，共同承担连带责任；放贷前，足额存入保证金，并办结所购房产预抵押登记手续。" + "\n" +
                "    八、处  罚" + "\n" +
                "        依据借款合同的约定，借款人连续3个月或累计6个月不按借款合同偿还贷款本息时，住房公积金管理中心将委托放贷银行会同有关部门处置抵押物，启动自然担保人履行共同承担连带责任程序，偿还借款人所欠贷款本息、罚息等有关费用，不足部分依法追索。",
      form1: {
        loanUsedFor:"",
      },

      form2:{
      },
      page: 0,
      checkflag : false,
      fileList: [],
      formDate: '',
      bankInfo:{
        bankName:'',
        bankRate:'',
      },
      banklist:[],
      //检验规则一
      rules1: {
          companyName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur'},
            { validator: this.checkCompanyName, trigger: 'blur'}
          ],
          loanFromBankId: [
            { required: true, message: '请选择银行名称', trigger: 'blur'}
          ],
          loaLisId: [
            { required: true, message: '请选择贷款期限', trigger: 'blur'}
          ],
          loanAmount: [
            { required: true, message: '贷款金额不能为空', trigger: 'blur'},
            { pattern: /^[1-9]\d*$/,message: '只能输入正整数', trigger: 'blur'}
          ],
          applicatorBankAccountID: [
            { required: true, message: '收款账户不能为空', trigger: 'blur'},
          ],
          applicatorName: [
            { required: true, message: '收款人不能为空', trigger: 'blur'},
          ],
          applicatorBankName: [
            { required: true, message: '开户行不能为空', trigger: 'blur'},
          ],
          applicatorIdentityCardNumber: [
            { required: true, message: '身份证号不能为空', trigger: 'blur'},
            { pattern:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, message: '错误的身份证号', trigger: 'blur'}
          ]
        },
        rules2: {
          aptPawn: [
            { required: true, message: '请输入抵押物', trigger: 'blur'},
          ],
          aptLoansRecord: [
            { required: true, message: '请选择有无贷款', trigger: 'blur'}
          ],
          aptComValue: [
            { required: true, message: '请输入企业市值', trigger: 'blur'},
            { pattern: /^[1-9]\d*$/,message: '只能输入正整数', trigger: 'blur'}
          ],
        },
    };
  },
  computed: {
    /* sampleC() {
      return this.sampleD + "--";
    }, */
  },
  created() {
    this.getList();
  },
  mounted() {},
  methods: {

    /** 查询银行列表 */
    getList() {
      listBank().then(response => {
        this.banklist = response.rows;
      });
    },

    /** 根据选择项改变汇率 */
    handleSelectChange(){

      for(let i=0; i<this.banklist.length;i++){
        if (this.banklist[i].bankId == this.form1.loanFromBankId){
          this.form1.loanRate=this.banklist[i].bankRate;
          break;
        }
      }
    },

    /**提交第一部分表单 */
    submitForm1(){
      this.$refs["form1"].validate((valid) =>{
        if(valid){
          addList(this.form1).then(response => {
            console.log("success");
            this.msgSuccess("新增成功");
            this.page+=1;
          })
        }
        else{
          this.$message.warning("表单项存在错误，请检查！");
        }
      })
    },

    /**提交第三部分表单 */
    submitForm2(){
      this.$refs["form2"].validate((valid) =>{
        if(valid){
          insertAptitude(this.form2).then(response => {
            console.log("success");
            this.msgSuccess("新增成功");
            this.page++;
          })
        }
        else{
          this.$message.warning("表单项存在错误，请检查！");
        }
      })
    },

    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.comId != null) {
            updateCompany(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCompany(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },

    //输入时转化公司名为id
    updateCompanyName(){
      listCompany().then(response => {
        let flag=0;
        for(let i=0; i<response.rows.length;i++){
          if (response.rows[i].comName == this.form1.companyName){
            this.form1.companyId=response.rows[i].comId;
            flag=1;
            break;
          }
        };
        if(flag==0) this.form1.companyId = 'notFound';
      });
    },

    //检查公司名
    checkCompanyName(rule, value, callback){
      if(this.form1.companyId == 'notFound'){
        callback(new Error('未找到该公司'));
      }
      else{
        callback();
      }
    },

    readText() {
      if(this.checkflag){this.page=1;}

      else alert("请阅读须知,并勾选按钮!");

    },

    back0() {
      this.page-=1;
    },

    resetForm() {
        this.form1.resetFields()
    },


    //上传4个材料的方法
    //上传至本地fileData
    uploadFile(file){
      this.formDate.append('files',file.file);
      console.log("222");
      console.log(this.formDate);
    },

    submitUpload(){
      this.$confirm('请再次确认上传文件是否正确！', "提交", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.formDate = new FormData();
        this.$refs.upload.submit();
        uploadFiles(this.formDate).then(response=>{
          if(response.match("上传成功材料插入数据库成功")){
            console.log("success");
            this.msgSuccess(response);
            this.page++;
          }else{
            console.log("failed");
            this.$message.error(response);
          };

        })
      });
    },
    //移除
    handleRemove(file, fileList) {
        this.fileList = fileList;
        // return this.$confirm(`确定移除 ${ file.name }？`);
    },

    handlePreview(file) {
      console.log(file);
    },

    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 4 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },

    //监控上传文件列表
    handleChange(file, fileList) {
      let existFile = fileList.slice(0, fileList.length - 1).find(f => f.name === file.name);
      if (existFile) {
          this.$message.error('当前文件已经存在!');
          fileList.pop();
      }
      this.fileList = fileList;
    },
  },
  watch: {
  },
};
</script>

<!--<style scoped>-->
<style lang="scss" scoped>
    .fs-title {
        margin: 0px auto 30px auto;
        text-align: center;
        color: #707070;
    }
    .fs-subtitle {
        margin: 0px auto 30px auto;
        text-align: center;
        color: #707070;
    }

    .loanTable{
      padding-top: 50px;
      display: grid;
      place-items: center;
    }
    .form{
      width: 70%;
      height: 800px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }

</style>
