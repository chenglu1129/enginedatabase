package com.nytd.retail.controller;

import com.github.pagehelper.PageInfo;
import com.nytd.retail.base.BaseController;
import com.nytd.retail.base.BaseMessage;
import com.nytd.retail.entity.UserAccount;
import com.nytd.retail.util.DataUtil;
import com.nytd.retail.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className UserAccountController
 * @projectName engine
 * @date 2022/7/26
 */

@RestController
@RequestMapping("/v1/api/user")
public class UserAccountController extends BaseController {

    /**
     * 保存用户
     * @param userAccount /
     * @return /
     */
    @PostMapping("/publish")
    public Result publish(UserAccount userAccount){

        try{

            if (StringUtils.isEmpty(userAccount.getSerial())){

                boolean r = userAccountService.isSameUser(userAccount);

                if (r){
                    return Result.error("已有相同的用户，请重新分配账号");
                }

                userAccount.setSerial(DataUtil.getComSerial());
                userAccount.setSubTime(new Date());

                return userAccountService.insert(userAccount) ? Result.success("新增成功") : Result.error("新增失败");

            }else {

                userAccount.setUpdateTime(new Date());

                return userAccountService.update(userAccount) ? Result.success("修改成功") : Result.error("修改失败");

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());
    }


    /**
     * 删除用户
     * @param serial /
     * @return /
     */
    @GetMapping("/remove/{serial}")
    public Result remove(@PathVariable("serial") String serial){

        try{

            return userAccountService.remove(serial) ? Result.success("删除成功") : Result.error("删除失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());

    }

    /**
     * 条件查询用户
     * @param nickName /
     * @param realName /
     * @param page /
     * @param pageSize /
     * @return /
     */
    @PostMapping("/find/condition")
    public Result findCondition(String nickName, String realName,Integer page,Integer pageSize){

        try{

            PageInfo<UserAccount> userAccountPageInfo = userAccountService.findByCondition(nickName,realName,page,pageSize);

            return Result.success("查询成功",userAccountPageInfo.getList(),userAccountPageInfo.getTotal());

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());
    }
}
