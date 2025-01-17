package com.qst.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qst.common.annotation.Log;
import com.qst.common.core.controller.BaseController;
import com.qst.common.core.domain.AjaxResult;
import com.qst.common.enums.BusinessType;
import com.qst.system.domain.Bank;
import com.qst.system.service.IBankService;
import com.qst.common.utils.poi.ExcelUtil;
import com.qst.common.core.page.TableDataInfo;

/**
 * 银行Controller
 * @author 2.5
 * @date 2023-08-26
 */
@RestController
@RequestMapping("/system/bank")
public class BankController extends BaseController
{
    @Autowired
    private IBankService bankService;

    /**
     * 查询银行列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Bank bank)
    {
        startPage();
        List<Bank> list = bankService.selectBankList(bank);
        return getDataTable(list);
    }

    /**
     * 导出银行列表
     */
    @PreAuthorize("@ss.hasPermi('system:bank:export')")
    @Log(title = "银行", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Bank bank)
    {
        List<Bank> list = bankService.selectBankList(bank);
        ExcelUtil<Bank> util = new ExcelUtil<Bank>(Bank.class);
        return util.exportExcel(list, "银行数据");
    }

    /**
     * 获取银行详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bank:query')")
    @GetMapping(value = "/{bankId}")
    public AjaxResult getInfo(@PathVariable("bankId") Long bankId)
    {
        return AjaxResult.success(bankService.selectBankByBankId(bankId));
    }

    /**
     * 新增银行
     */
    @PreAuthorize("@ss.hasPermi('system:bank:add')")
    @Log(title = "银行", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Bank bank)
    {
        return toAjax(bankService.insertBank(bank));
    }

    /**
     * 修改银行
     */
    @PreAuthorize("@ss.hasPermi('system:bank:edit')")
    @Log(title = "银行", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Bank bank)
    {
        return toAjax(bankService.updateBank(bank));
    }

    /**
     * 删除银行
     */
    @PreAuthorize("@ss.hasPermi('system:bank:remove')")
    @Log(title = "银行", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bankIds}")
    public AjaxResult remove(@PathVariable Long[] bankIds)
    {
        return toAjax(bankService.deleteBankByBankIds(bankIds));
    }
}
