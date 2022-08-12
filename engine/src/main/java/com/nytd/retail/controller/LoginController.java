package com.nytd.retail.controller;

import com.nytd.retail.base.BaseController;
import com.nytd.retail.base.BaseMessage;
import com.nytd.retail.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/v1/api/auth")
public class LoginController extends BaseController {

    /**
     * 登陆
     * @param account   账号
     * @param password  密码
     * @param request /
     * @return /
     */
    @PostMapping("/login")
    public Result login(@RequestParam("account") String account,@RequestParam("password") String password, HttpServletRequest request){

        try{

           Result res = userAccountService.login(account,password);

           return res;

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.toString());

    }


}
