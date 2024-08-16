import request from '@/utils/request'

// 查询活动管理列表
export function get_money_after_months(data) {
  return request({
    url: '/mkxLoanCalculator/loanByMonth',
    method: 'post',
    data: data
  })
}
