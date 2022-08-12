/* eslint-disable */
import http from '../index'

const baseURL = http.baseURL

export default{
   publish: baseURL + '/v1/api/car/publish',
   remove:  baseURL + '/v1/api/car/remove/{serial}',
   findCondition: baseURL + '/v1/api/car/find/condition',
   repair: baseURL + '/v1/api/car/repair',
   detail: baseURL + '/v1/api/car/detail',
   getCars:baseURL + '/v1/api/car/all/engines'

}