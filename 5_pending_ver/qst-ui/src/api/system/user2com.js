import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";

export function getComId(userName){
    return request({
        url:'/lma/info/' + praseStrEmpty(userName),
        method:'get'
    })
}
