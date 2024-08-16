import request from '@/utils/request'

// 查询贷款列表
export function listLoans(query) {
  return request({
    url: '/system/loanschart/list',
    method: 'get',
    params: query
  })
}

//贷款表添加
export function addList(data){
  return request({
    url: '/system/loanApply/insert_new_loan_apply',
    method: 'post',
    data: data
  })
}

//添加材料表
export function uploadFiles(data) {
  return request({
    url: '/system/loanApply/upload_four_files',
    method: 'post',
    data: data
  })
}

//新写的导入资质
export function insertAptitude(data){
  return request({
    url: '/system/loanApply/insert_aptitude',
    method: 'post',
    data: data
  })
}