package com.qst.s5.service.Impl;

import com.qst.common.core.domain.entity.SysUser;
import com.qst.s5.domain.MkxAptitudeForm;
import com.qst.s5.domain.MkxLoanForm;
import com.qst.s5.service.MkxFileService;
import com.qst.s5.service.MkxService;
import com.qst.system.domain.*;
import com.qst.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MkxServiceImpl implements MkxService {
    private IBankService bankService;
    private ICompanyService companyService;
    private ILoansService loansService;
    private IMaterialsService materialsService;
    private MkxFileService mkxFileService;
    private IAptitudeService aptitudeService;
    private ISysUserService sysUserService;


    @Autowired
    public void setBankService(IBankService bankService) {
        this.bankService = bankService;
    }
    @Autowired
    public void setCompanyService(ICompanyService companyService) {
        this.companyService = companyService;
    }
    @Autowired
    public void setLoansService(ILoansService loansService) {
        this.loansService = loansService;
    }
    @Autowired
    public void setMaterialsService(IMaterialsService materialsService) {
        this.materialsService = materialsService;
    }
    @Autowired
    public void setMkxFileService(MkxFileService mkxFileService) {
        this.mkxFileService = mkxFileService;
    }
    @Autowired
    public void setAptitudeService(IAptitudeService aptitudeService) {
        this.aptitudeService = aptitudeService;
    }
    @Autowired
    public void setSysUserService(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }


    /**
     * 获取所有银行名字和利率
     * 用于selector，展示所有可选的银行
     * @return 二维数组，第一维是银行名字，第二维是利率
     */
    @Override
    public List<List<String>> get_bank_name_and_name_list_for_selector() {
        List<Bank> bank_list = bankService.selectBankNames(); // get a list contains all bank objects
        List<List<String>> bank_return_list = new ArrayList<>(); // create a new list to return

        for (Bank bank : bank_list) {
            String bank_name = bank.getBankName();
            String bank_rate = bank.getBankRate();

            List<String> bank_i_data = new ArrayList<>(); // this is element of return list
            bank_i_data.add(bank_name);
            bank_i_data.add(bank_rate);

            bank_return_list.add(bank_i_data);  // add the element to the return list
        }
        return bank_return_list;
    }

    /**
     * 根据银行名查询id。如果查不到，则返回null。
     * 用于添加贷款申请form时，根据银行名查询银行id
     * @param name 银行名
     * @return 银行id或null
     */
    @Override
    public Long get_bank_id_by_name(String name) {
        List<Bank> bank_list = this.get_all_bank_list(); // get a list contains all bank objects
        for (Bank bank : bank_list) {
            if (bank.getBankName().equals(name)) {
                return bank.getBankId();
            }
        }
        return null;
    }

    /**
     * 根据公司名查询id。如果查不到，则返回null。
     * 用于输入公司名时，检查公司名是否存在
     * @param company_name 公司名
     * @return 公司id或null
     */
    @Override
    public Long get_company_id_by_name(String company_name) {
        List<Company> company_list = this.get_all_company_list();
        // search for the company id with the same name
        // if found, return the id
        for (Company company1 : company_list) {
            if (company1.getComName().equals(company_name)) {
                return company1.getComId();
            }
        }
        return null;
    }

    /**
     * 检查银行名是否存在
     * @param name 银行名
     * @return 是否存在
     */
    @Override
    public boolean is_bank_name_exist(String name) {
        List<Bank> all_bank_list = this.get_all_bank_list(); // get a list contains all bank objects
        for (Bank bank : all_bank_list) {
            if (bank.getBankName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查公司名是否存在
     * @param name 公司名
     * @return 是否存在
     */
    @Override
    public boolean is_company_name_exist(String name) {
        List<Company> all_company_list = this.get_all_company_list(); // get a list contains all company objects
        for (Company company : all_company_list) {
            if (company.getComName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取所有银行对象
     * @return 所有银行对象
     */
    @Override
    public List<Bank> get_all_bank_list() {
        return bankService.selectBankNames(); // get a list contains all bank objects
    }

    /**
     * 获取所有公司对象
     * @return 所有公司对象
     */
    @Override
    public List<Company> get_all_company_list() {
        Company company = new Company();
        // get a list contains all company objects
        return companyService.selectCompanyList(company);
    }

    /**
     * 根据银行id查询银行对象
     * @param id 银行id
     * @return 银行对象
     */
    @Override
    public Bank get_bank_by_id(Long id) {
        return bankService.selectBankByBankId(id);
    }

    /**
     * 根据公司id查询公司对象
     * @param id 公司id
     * @return 公司对象
     */
    @Override
    public Company get_company_by_id(Long id) {
        return companyService.selectCompanyByComId(id);
    }

    /**
     * 根据银行id查询利率
     * @param id 银行id
     * @return 利率
     */
    @Override
    public String get_loan_rate_by_bank_id(Long id) {
        Bank bank = this.get_bank_by_id(id);
        return bank.getBankRate();
    }

    @Override
    public Date generate_date_object() {
        return null;
    }

    /**
     * 创建一个贷款对象
     * @param loaId 贷款id
     *              loaNo 贷款编号
     *              loaComNo 公司编号
     *              loaBankId 银行编号
     *              loaLisId 贷款期限
     *              loaUse 贷款用途
     *              loaIntegral 贷款积分
     *              loaRate 贷款利率
     *              loaState 贷款状态
     *              loaTime 贷款申请时间
     *              loaMoney 贷款金额
     *              loaEndTime 贷款到期时间
     *              bAccountNo 申请人银行账号
     *              bName 申请人姓名
     *              bBankName 申请人开户银行名
     *              bIdCard 申请人身份证号
     *              loaDel 贷款删除标志
     *              company 公司对象
     *              bank 银行对象
     *              loaSign 贷款签约
     */
    @Override
    public Loans new_loan_object(Long loaId,
                                 String loaNo,
                                 Long loaComNo,
                                 Long loaBankId,
                                 Long loaLisId,
                                 String loaUse,
                                 String loaIntegral,
                                 String loaRate,
                                 String loaState,
                                 Date loaTime,
                                 Long loaMoney,
                                 Date loaEndTime,
                                 String bAccountNo,
                                 String bName,
                                 String bBankName,
                                 String bIdCard,
                                 String loaDel,
                                 Company company,
                                 Bank bank,
                                 String loaSign) {
        Loans loans = new Loans();

        loans.setLoaId(loaId);
        loans.setLoaNo(loaNo);
        loans.setLoaComNo(loaComNo);
        loans.setLoaBankId(loaBankId);
        loans.setLoaLisId(loaLisId);
        loans.setLoaUse(loaUse);
        loans.setLoaIntegral(loaIntegral);
        loans.setLoaRate(loaRate);
        loans.setLoaState(loaState);
        loans.setLoaTime(loaTime);
        loans.setLoaMoney(loaMoney);
        loans.setLoaEndTime(loaEndTime);
        loans.setbAccountNo(bAccountNo);
        loans.setbName(bName);
        loans.setbBankName(bBankName);
        loans.setbIdCard(bIdCard);
        loans.setLoaDel(loaDel);
        loans.setCompany(company);
        loans.setBank(bank);
        loans.setLoaSign(loaSign);

        return loans;
    }

    private Loans current_loan_object;
    /**
     * 添加一项贷款申请
     * 每一个属性都有细致的处理，比如是否必要填写，比如是否从其他属性得到：
     * 1. loaId 在mysql的xml中 会被一个自增的整数覆盖，这里写不写都行。
     * 2. loaNo 在loansService里 也会被一个随机编号覆盖
     * 3. loaComNo 从公司名字得到
     * 4. loaBankId 从银行名字得到
     * 5. loaLisId 贷款期限，暂时不指定
     * 6. loaUse 贷款用途
     * 7. loaIntegral 贷款积分
     * 8. loaRate 贷款利率，从银行id得到
     * 9. loaState 贷款状态
     * 10. loaTime 贷款申请时间
     * 11. loaMoney 贷款金额
     * 12. loaEndTime 贷款到期时间
     * 13. bAccountNo 申请人银行账号
     * 14. bName 申请人姓名
     * 15. bBankName 申请人开户银行名
     * 16. bIdCard 申请人身份证号
     * 17. loaDel 贷款删除标志
     * 18. company 公司对象 不需要 是mysql的xml里填充的
     * 19. bank 银行对象 不需要 是mysql的xml里填充的
     * 20. loaSign 贷款签约 未知
     * @param form 贷款申请表单
     * @return 是否成功
     */
    @Override
    public boolean insert_loan_apply(MkxLoanForm form) {
        // loaId 在mysql的xml中 会被一个自增的整数覆盖，这里写不写都行。
        // useGeneratedKeys="true" keyProperty="loaId"
//        Long loaId = 123456L; // 贷款id, main key
        // loaNo 在loansService里 也会被一个随机编号覆盖
//        String loaNo = "在loansService里会被一个随机编号覆盖，这里写不写都行。"; // 贷款编号
        Long loaComNo = form.getCompanyId(); // 公司编号
        Long loaBankId = form.getLoanFromBankId(); // 银行编号
        Long loaLisId = form.getLoaLisId(); // 贷款期限
        String loaUse = form.getLoanUsedFor(); // 贷款用途
        String loaIntegral = "0"; // 贷款积分
        String loaRate = this.get_loan_rate_by_bank_id(loaBankId); // 贷款利率
        String loaState = "0"; // 贷款状态
        Date loaTime = new Date(); // 贷款申请时间
        Long loaMoney = form.getLoanAmount(); // 贷款金额
//        Date loaEndTime = null; // 贷款到期时间
        String bAccountNo = form.getApplicatorBankAccountID(); // 申请人银行账号
        String bName = form.getApplicatorName(); // 申请人姓名
        String bBankName = form.getApplicatorBankName(); // 申请人开户银行名
        String bIdCard = form.getApplicatorIdentityCardNumber(); // 申请人身份证号
        String loaDel = "0"; // 贷款删除标志
//        Company company = null; // 公司对象
//        Bank bank = null; // 银行对象
//        String loaSign = null; // 贷款签约

        Loans loans = this.new_loan_object(
            null,
            null,
            loaComNo,
            loaBankId,
            loaLisId,
            loaUse,
            loaIntegral,
            loaRate,
            loaState,
            loaTime,
            loaMoney,
            null,
            bAccountNo,
            bName,
            bBankName,
            bIdCard,
            loaDel,
            null,
            null,
            null
        );
        loansService.insertLoans(loans);

        this.current_loan_object = loans; // preserve the loan for the later material object
        return true;
    }

    /**
     * 创建一个贷款材料对象
     * @param lisId 贷款材料id
     * @param lisComId 公司id
     * @param lisLoaId 贷款id
     * @param lisIdCard 身份证
     * @param lisSixRunWater 六个月流水
     * @param lisWork 工作证明
     * @param lisReport 企业报告
     * @param lisPawn 抵押物
     * @param lisDel 删除标志 设为0？
     * @param company 公司对象 不需要 是mysql的xml里按照公司id join的
     * @return 贷款材料对象
     */
    @Override
    public Materials new_material_object(Long lisId,
                                         Long lisComId,
                                         Long lisLoaId,
                                         String lisIdCard,
                                         String lisSixRunWater,
                                         String lisWork,
                                         String lisReport,
                                         String lisPawn,
                                         String lisDel,
                                         Company company) {
        Materials materials = new Materials();
        materials.setLisId(lisId);
        materials.setLisComId(lisComId);
        materials.setLisLoaId(lisLoaId);
        materials.setLisIdCard(lisIdCard);
        materials.setLisSixRunWater(lisSixRunWater);
        materials.setLisWork(lisWork);
        materials.setLisReport(lisReport);
        materials.setLisPawn(lisPawn);
        materials.setLisDel(lisDel);
        materials.setCompany(company);
        return materials;
    }

    /**
     * 当前贷款材料对象
     */
    private Materials current_material_object;
    public List<String> four_files_path_list = new ArrayList<>();
    /**
     * 上传四个文件
     * 调用的前提条件：
     * 1. 必须先上传贷款申请loan_apply
     * 2. 文件数量必须为4
     *
     * @param files 文件列表
     * @return 上传结果
     */
    @Override
    public String upload_four_files(List<MultipartFile> files) throws IOException {
        String return_status;
        if (this.current_loan_object == null) {
//            this.four_files_path_list.clear(); // 清空文件路径列表
            return_status = "贷款表单还未上传，请在上传它后再上传材料";
            return return_status;
        }
        // 检查文件数量是否为4
        if (files.size() != 4) {
            return_status = "文件数量错误，应为4个。实际为" + files.size();
            return return_status;
        }
        // 存储这4个文件到本地
        return_status = this.mkxFileService.upload_file_list(files);
        if (!return_status.equals("上传成功")) { // 如果上传不是成功状态 则返回错误信息
            return return_status;
        }
        // 暂存4个文件的路径为一个list，存为一个类属性
        for (MultipartFile file : files) {
            String file_path = this.mkxFileService.join_path(
                    "/profile",
                    file.getOriginalFilename()
            );
            this.four_files_path_list.add(file_path);
        }
        return_status = "上传成功";
        return return_status;
    }

    /**
     * 添加一项贷款申请材料
     * 1. lisId 贷款材料id 不用管 在xml sql里已经设置为自增
     * 2. lisComId 公司id 从已经缓存的loan对象中得到
     * 3. lisLoaId 贷款id 从已经缓存的loan对象中得到
     * 4. lisIdCard 身份证 从已经缓存的loan对象中得到
     * 5. lisSixRunWater 六个月流水 从上传的材料文件中得到
     * 6. lisWork 工作证明  从上传的材料文件中得到
     * 7. lisReport 企业报告 从上传的材料文件中得到
     * 8. lisPawn 抵押物 从上传的材料文件中得到
     * 9. lisDel 删除标志 设为0？
     * 10. company 公司对象
     * @return 是否成功
     */
    @Override
    public String insert_loan_apply_material() {
//        Long lisId = null; // 贷款材料id
        Long lisComId = this.current_loan_object.getLoaComNo(); // 公司id
        Long lisLoaId = this.current_loan_object.getLoaId(); // 贷款id
        String lisIdCard = this.current_loan_object.getbIdCard(); // 身份证
        String lisSixRunWater = this.four_files_path_list.get(0); // 六个月流水
        String lisWork = this.four_files_path_list.get(1); // 工作证明
        String lisReport = this.four_files_path_list.get(2); // 企业报告
        String lisPawn = this.four_files_path_list.get(3); // 抵押物
        String lisDel = "0"; // 删除标志
//        Company company = null; // 公司对象

        Materials materials = this.new_material_object(
            null,
            lisComId,
            lisLoaId,
            lisIdCard,
            lisSixRunWater,
            lisWork,
            lisReport,
            lisPawn,
            lisDel,
            null
        );

        materialsService.insertMaterials(materials);
        this.four_files_path_list.clear(); // 清空文件路径列表
        this.current_material_object = materials; // preserve the material for the later aptitude object
        return "材料插入数据库成功";
    }

    /**
     * 创建一个资质对象
     * @param aptId 资质编号 资质id 不用管 在xml sql里已经设置为自增
     * @param comId 企业ID 从已经缓存的loan对象中得到
     * @param comName 企业名称 不用管 数据库里没有这一列
     * @param aptLoaId 贷款ID 从已经缓存的loan对象中得到
     * @param aptCredit 信用额度 不管
     * @param aptPawn 抵押物 从前端得到
     * @param aptLoansRecord 贷款记录 从前端得到
     * @param aptComValue 企业市值 从前端得到
     * @param aptDel 删除标识 0为正常 2为删除
     * @param company 公司对象
     * @return 资质对象
     */
    @Override
    public Aptitude new_aptitude_object(Long aptId,
                                        Long comId,
                                        String comName,
                                        Long aptLoaId,
                                        String aptCredit,
                                        String aptPawn,
                                        String aptLoansRecord,
                                        String aptComValue,
                                        String aptDel,
                                        Company company) {
        Aptitude aptitude = new Aptitude();
        aptitude.setAptId(aptId);
        aptitude.setComId(comId);
        aptitude.setComName(comName);
        aptitude.setAptLoaId(aptLoaId);
        aptitude.setAptCredit(aptCredit);
        aptitude.setAptPawn(aptPawn);
        aptitude.setAptLoansRecord(aptLoansRecord);
        aptitude.setAptComValue(aptComValue);
        aptitude.setAptDel(aptDel);
        aptitude.setCompany(company);
        return aptitude;
    }

//    /**
//     * 当前资质aptitude对象缓存
//     */
//    private Aptitude current_aptitude_object;
    /**
     * 插入一个aptitude对象。
     * 正常流程下，必须先提交loan申请，再提交material材料，最后再提交aptitude资质。
     * @param form 资质表单
     */
    @Override
    public String insert_aptitude(MkxAptitudeForm form) {
        if (this.current_loan_object == null) {
            return "贷款表单loan_apply还未上传，请在上传它后再上传资质aptitude";
        }
        if (this.current_material_object == null) {
            return "贷款材料materials还未上传，请在上传它后再上传资质aptitude";
        }

//        Long aptId = null; // 资质编号
        Long comId = this.current_loan_object.getLoaComNo(); // 企业ID
//        String comName = null; // 企业名称
        Long aptLoaId = this.current_loan_object.getLoaId(); // 贷款ID
//        String aptCredit = null; // 信用额度
        String aptPawn = form.getAptPawn(); // 抵押物
        String aptLoansRecord = form.getAptLoansRecord(); // 贷款记录
        String aptComValue = form.getAptComValue(); // 企业市值
        String aptDel = "0"; // 删除标识
//        Company company = null; // 公司对象

        Aptitude aptitude = this.new_aptitude_object(
            null,
            comId,
            null,
            aptLoaId,
            null,
            aptPawn,
            aptLoansRecord,
            aptComValue,
            aptDel,
            null
        );

        aptitudeService.insertAptitude(aptitude);
//        this.current_aptitude_object = aptitude; // preserve the aptitude for the later loan object

        return "资质aptitude插入数据库成功 贷款申请流程已结束";
    }


    /**
     * 根据用户名查询用户ID
     * @param userName 用户名
     * @return 用户ID
     */
    @Override
    public Long select_userID_by_userName(String userName) {
        SysUser user = sysUserService.selectUserByUserName(userName);
        return user.getUserId();
    }

    /**
     * 把String变为json String，返回前端
     * @param string 字符串
     * @return json
     */
    public String string_to_json(String string) {
        return "\"" + string + "\"";
    }
}

