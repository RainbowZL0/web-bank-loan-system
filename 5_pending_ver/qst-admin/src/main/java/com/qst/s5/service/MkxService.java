package com.qst.s5.service;

import com.qst.s5.domain.MkxAptitudeForm;
import com.qst.s5.domain.MkxLoanForm;
import com.qst.system.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface MkxService {
    List<Bank> get_all_bank_list();
    List<Company> get_all_company_list();
    boolean is_company_name_exist(String name);
    boolean is_bank_name_exist(String name);
    Long get_bank_id_by_name(String name);
    Long get_company_id_by_name(String name);
    Bank get_bank_by_id(Long id);
    Company get_company_by_id(Long id);
    List<List<String>> get_bank_name_and_name_list_for_selector();
    boolean insert_loan_apply(MkxLoanForm form);
    Loans new_loan_object(
            Long loaId,
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
            String loaSign
    );
    String get_loan_rate_by_bank_id(Long id);
    Date generate_date_object();

    Materials new_material_object(
        Long lisId,
        Long lisComId,
        Long lisLoaId,
        String lisIdCard,
        String lisSixRunWater,
        String lisWork,
        String lisReport,
        String lisPawn,
        String lisDel,
        Company company
    );

    String insert_loan_apply_material();
    String upload_four_files(List<MultipartFile> files) throws IOException;

    Aptitude new_aptitude_object(
        Long aptId,
        Long comId,
        String comName,
        Long aptLoaId,
        String aptCredit,
        String aptPawn,
        String aptLoansRecord,
        String aptComValue,
        String aptDel,
        Company company
    );

    String insert_aptitude(MkxAptitudeForm form);

    /**
     * 根据用户名查询用户ID
     * @param userName 用户名
     * @return 用户ID
     */
    Long select_userID_by_userName(String userName);

    /**
     * 把String变为json String，返回前端
     * @param string 字符串
     * @return json
     */
    String string_to_json(String string);

}
