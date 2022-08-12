package com.nytd.retail.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nytd.retail.entity.UserAccount;
import com.nytd.retail.mapper.UserAccountMapper;
import com.nytd.retail.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 用户服务
 * @author
 * @version 1.0
 * 版权所有：
 * @className UserAccountService
 * @projectName mall_user
 * @date 2022/4/18
 */

@Service
public class UserAccountService {

    @Resource
    private UserAccountMapper userAccountMapper;


    /**
     * 新增用户
     * @param userAccount
     * @return
     */
    public boolean insert(UserAccount userAccount){

        userAccount.setPassword("123456");


        return userAccountMapper.insert(userAccount);
    }

    /**
     * 修改用户
     * @param userAccount
     * @return
     */
    public boolean update(UserAccount userAccount){

        userAccount.setUpdateTime(new Date());

        return userAccountMapper.update(userAccount);
    }

    /**
     * 删除用户
     * @param serial
     * @return
     */
    public boolean remove(String serial){
        return userAccountMapper.remove(serial);
    }

    /**
     * 判断是否有重复的员工
     * @param userAccount
     * @return
     */
    public boolean isSameUser(UserAccount userAccount){

        List<UserAccount> userAccounts = userAccountMapper.isSameUser(userAccount.getAccount(),userAccount.getPhone());

        return userAccounts!=null && userAccounts.size()>0 ? true : false;

    }

    /**
     * 按编号查询用户
     * @param serial
     * @return
     */
    public UserAccount findBySerial(String serial){
        return userAccountMapper.findBySerial(serial);
    }


    /**
     * 条件查询用户
     * @param nickName
     * @param realName
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<UserAccount> findByCondition(String nickName, String realName,int page,int pageSize){

        PageHelper.startPage(page,pageSize);

        List<UserAccount> userAccounts = userAccountMapper.findByCondition(nickName,realName);

        return new PageInfo<>(userAccounts);

    }

    /**
     * 登陆
     * @param account   账号
     * @param password  密码
     * @return /
     */
    public Result login(String account,String password){


        UserAccount user = userAccountMapper.loginCheck(account);

        if (user == null){
            return Result.error("用户不存在");
        }

        if (!user.getPassword().equals(password)){
            return Result.error("账号密码错误");
        }

        Map<String,Object> res = new HashMap<>();

        res.put("principal",user);

        return Result.success("登陆成功",res);


    }

}
