package com.qst.s5.controller;

import com.qst.common.core.controller.BaseController;
import com.qst.s5.domain.MkxAptitudeForm;
import com.qst.s5.domain.MkxLoanForm;
import com.qst.s5.service.MkxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Api(tags = "1牛")
@RestController // controller + responseBody
@RequestMapping("/system/loanApply")
public class MkxController extends BaseController {
    private MkxService mkxService;

    @Autowired
    public void setMkxService(MkxService mkxService) {

        this.mkxService = mkxService;
    }


    /**
     * 测试用的接口
     * @return 一个字符串
     */
    @GetMapping(value = "/greetings-with-response-body", produces = "application/json")
    public String getGreetingWhileReturnTypeIsString() {
        return mkxService.string_to_json("Hello World!");
    }

    /**
     * 获取所有银行名字和利率
     * @return 二维数组，第一维是银行名字，第二维是利率
     */
    @ApiOperation(value = "获取所有银行名字和利率")
    @GetMapping(value = "/get_bank_name_list_for_selector", produces = "application/json")
    public List<List<String>> get_bank_name_list_for_selector() {
        return mkxService.get_bank_name_and_name_list_for_selector();
    }

    /**
     * 根据公司名查询id。如果查不到，则返回null。
     * @param company_name 公司名
     * @return 公司id或null
     */
    @ApiOperation(value = "根据公司名查询id。如果查不到，则返回null。")
    @GetMapping(value = "/query_company_id/{name}", produces = "application/json")
    public Long query_company_id(@PathVariable("name") String company_name) {
        return mkxService.get_company_id_by_name(company_name);
    }

    /**
     * 添加一项贷款申请
     * @param form 贷款申请表单
     * @return 是否成功
     */
    @ApiOperation(value = "第1步 添加一项贷款loan申请")
    @PostMapping(value = "/insert_new_loan_apply",produces = "application/json")
    public boolean insert_new_loan_apply(@RequestBody MkxLoanForm form) {
        return mkxService.insert_loan_apply(form);
    }

//    /**
//     * 添加贷款申请材料Material 插入数据库
//     */
//    @ApiOperation(value = "添加贷款申请材料Material 插入数据库")
//    @PostMapping(value = "/insert_new_loan_apply_material",produces = "application/json")
//    public boolean insert_new_loan_apply_material(@RequestBody MkxFourMaterialFilesPath form) {
//        return mkxService.insert_loan_apply_material();
//    }

    /**
     * 上传四个材料文件
     * @return 状态提示
     */
    @ApiOperation(value = "第2步 上传四个材料materials文件")
    @PostMapping(value = "/upload_four_files", produces = "application/json;charset=UTF-8")
    public String upload_four_files(@RequestPart("files") List<MultipartFile> files) throws IOException {
        String return_status = mkxService.upload_four_files(files);
        if (return_status.equals("上传成功")) {
            return_status += mkxService.insert_loan_apply_material();
        }
        return mkxService.string_to_json(return_status); // 返回json字符串
    }

    /**
     * 上传aptitude 插入数据库
     * @return 状态提示
     */
    @ApiOperation(value = "第3步 上传资质aptitude")
    @PostMapping(value = "/insert_aptitude",produces = "application/json")
    public String insert_aptitude(@RequestBody MkxAptitudeForm form) {
        return mkxService.string_to_json(mkxService.insert_aptitude(form));
    }
}

