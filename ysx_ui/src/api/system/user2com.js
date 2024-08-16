import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";

export function getComId(userId){
    return request({
        url:'/lma/info?uId=' + praseStrEmpty(userId),
        method:'get'
    })
}