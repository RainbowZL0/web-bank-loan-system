<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="企业编号" prop="comNo">
        <el-input
          v-model="queryParams.comNo"
          placeholder="请输入企业编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业名称" prop="comName">
        <el-input
          v-model="queryParams.comName"
          placeholder="请输入企业名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="comEmail">
        <el-input
          v-model="queryParams.comEmail"
          placeholder="请输入邮箱"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="comPhone">
        <el-input
          v-model="queryParams.comPhone"
          placeholder="请输入电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="密码" prop="comPwd">
        <el-input
          v-model="queryParams.comPwd"
          placeholder="请输入密码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="注册时间" prop="comTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.comTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择注册时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注、激活码" prop="comRemark">
        <el-input
          v-model="queryParams.comRemark"
          placeholder="请输入备注、激活码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0 正常，1 停用，2 未激活，3 未实名, 4 已实名" prop="comStatus">
        <el-select v-model="queryParams.comStatus" placeholder="请选择0 正常，1 停用，2 未激活，3 未实名, 4 已实名" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="0 存在， 2删除" prop="comDel">
        <el-input
          v-model="queryParams.comDel"
          placeholder="请输入0 存在， 2删除"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:company:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:company:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:company:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:company:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="companyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="comId" />
      <el-table-column label="企业编号" align="center" prop="comNo" />
      <el-table-column label="企业名称" align="center" prop="comName" />
      <el-table-column label="邮箱" align="center" prop="comEmail" />
      <el-table-column label="电话" align="center" prop="comPhone" />
      <el-table-column label="密码" align="center" prop="comPwd" />
      <el-table-column label="注册时间" align="center" prop="comTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.comTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注、激活码" align="center" prop="comRemark" />
      <el-table-column label="0 正常，1 停用，2 未激活，3 未实名, 4 已实名" align="center" prop="comStatus" />
      <el-table-column label="0 存在， 2删除" align="center" prop="comDel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:company:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:company:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改贷款公司对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="企业编号" prop="comNo">
          <el-input v-model="form.comNo" placeholder="请输入企业编号" />
        </el-form-item>
        <el-form-item label="企业名称" prop="comName">
          <el-input v-model="form.comName" placeholder="请输入企业名称" />
        </el-form-item>
        <el-form-item label="邮箱" prop="comEmail">
          <el-input v-model="form.comEmail" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="电话" prop="comPhone">
          <el-input v-model="form.comPhone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="密码" prop="comPwd">
          <el-input v-model="form.comPwd" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="注册时间" prop="comTime">
          <el-date-picker clearable size="small"
            v-model="form.comTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择注册时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注、激活码" prop="comRemark">
          <el-input v-model="form.comRemark" placeholder="请输入备注、激活码" />
        </el-form-item>
        <el-form-item label="0 正常，1 停用，2 未激活，3 未实名, 4 已实名">
          <el-radio-group v-model="form.comStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="0 存在， 2删除" prop="comDel">
          <el-input v-model="form.comDel" placeholder="请输入0 存在， 2删除" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCompany, getCompany, delCompany, addCompany, updateCompany, exportCompany } from "@/api/system/company";

export default {
  name: "Company",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 贷款公司表格数据
      companyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        comNo: null,
        comName: null,
        comEmail: null,
        comPhone: null,
        comPwd: null,
        comTime: null,
        comRemark: null,
        comStatus: null,
        comDel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        comNo: [
          { required: true, message: "企业编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询贷款公司列表 */
    getList() {
      this.loading = true;
      listCompany(this.queryParams).then(response => {
        this.companyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        comId: null,
        comNo: null,
        comName: null,
        comEmail: null,
        comPhone: null,
        comPwd: null,
        comTime: null,
        comRemark: null,
        comStatus: "0",
        comDel: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.comId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加贷款公司";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const comId = row.comId || this.ids
      getCompany(comId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改贷款公司";
      });
    },
    /** 提交按钮 */
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
    /** 删除按钮操作 */
    handleDelete(row) {
      const comIds = row.comId || this.ids;
      this.$confirm('是否确认删除贷款公司编号为"' + comIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCompany(comIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有贷款公司数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportCompany(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
