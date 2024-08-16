import request from '@/utils/request'

// 查询用户留言格列表
export function listComment(query) {
  return request({
    url: '/system/comment/list',
    method: 'get',
    params: query
  })
}

// 查询用户留言格详细
export function getComment(commentId) {
  return request({
    url: '/system/comment/' + commentId,
    method: 'get'
  })
}

// 新增用户留言格
export function addComment(data) {
  return request({
    url: '/system/comment',
    method: 'post',
    data: data
  })
}

// 修改用户留言格
export function updateComment(data) {
  return request({
    url: '/system/comment',
    method: 'put',
    data: data
  })
}

// 删除用户留言格
export function delComment(commentId) {
  return request({
    url: '/system/comment/' + commentId,
    method: 'delete'
  })
}

// 导出用户留言格
export function exportComment(query) {
  return request({
    url: '/system/comment/export',
    method: 'get',
    params: query
  })
}