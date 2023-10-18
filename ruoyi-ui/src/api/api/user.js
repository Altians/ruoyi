import request from "@/utils/request";
//test1
//查询
export function test1(query){
    return request({
        url: '/StudentInformation/list',
        method: 'get',
        params: query,
    })
}
//更新
export function edit(query){
    return request({
        url: '/StudentInformation/update',
        method: 'post',
        data: query,
    })
}
//id查询
export function queryId(id){
    return request({
        url: '/StudentInformation/queryId',
        method: 'get',
        params: {id:id},
    })
}
//新增
export function addItem(query){
    return request({
        url: '/StudentInformation/insert',
        method: 'post',
        data: query,
    })
}
//删除
export function deleteItem(ids){
    return request({
        url: '/StudentInformation/delArr',
        method: 'delete',
        data: ids,
    })
}