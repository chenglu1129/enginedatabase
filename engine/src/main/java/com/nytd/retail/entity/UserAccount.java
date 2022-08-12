package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className UserAccount
 * @projectName mall_user
 * @date 2022/4/18
 */

@Entity
@Table(name = "tbl_user_account")
public class UserAccount extends BaseEntity {

    @Column(name = "account", columnDefinition = "varchar(100) comment'账号'")
    private String account;

    @Column(name = "account_pic", columnDefinition = "text comment'头像'")
    private String accountPic;

    @Column(name = "nick_name", columnDefinition = "varchar(100) comment'昵称'")
    private String nickName;

    @Column(name = "password", columnDefinition = "varchar(100) comment'密码'")
    private String password;

    @Column(name = "real_name", columnDefinition = "varchar(100) comment'姓名'")
    private String realName;

    @Column(name = "phone", columnDefinition = "varchar(20) comment'手机号'")
    private String phone;

    @Column(name = "type",columnDefinition = "varchar(10) comment'用户身份'")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountPic() {
        return accountPic;
    }

    public void setAccountPic(String accountPic) {
        this.accountPic = accountPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
