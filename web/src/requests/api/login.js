/* eslint-disable */
import http from '../index'

const baseURL = http.baseURL

export default{
    loginSubmit:baseURL + '/v1/api/auth/login',
    registSubmit:baseURL + '/v1/api/auth/register',
}

