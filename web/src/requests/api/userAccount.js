/* eslint-disable */
import http from '../index'

const baseURL = http.baseURL

export default{
    publish: baseURL + "/v1/api/user/publish",
    remove: baseURL + "/v1/api/user/remove/{serial}",
    findCondition: baseURL + "/v1/api/user/find/condition",
    findAll: baseURL + "/v1/api/user/all"
}   