import request from '@/utils/request'

// 查询活动管理列表
export function submit_comment(user_name, data) {
  return request({
    url: '/mkxUserComment/add/' + user_name,
    method: 'post',
    data: data
  })
}
