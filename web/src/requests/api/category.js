import http from '../index'

const baseURL = http.baseURL

export default{
   publish: baseURL + '/v1/api/category/publish',
   remove:  baseURL + '/v1/api/category/remove/{serial}',
   findCondition: baseURL + '/v1/api/category/find/condition',
   findAll: baseURL + '/v1/api/category/find/all'
}