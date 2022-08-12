/* eslint-disable */
import http from '../index'

const fileBaseUrl = http.baseURL 

export default {
  upload: fileBaseUrl + '/v1/api/commen/upload'
}