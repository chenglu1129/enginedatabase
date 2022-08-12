package com.nytd.retail.mapper;

import com.nytd.retail.entity.UserAccount;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 描述:
 * 用户mapper
 * @author
 * @version 1.0
 * 版权所有：
 * @className UserAccountMapper
 * @projectName mall_user
 * @date 2022/4/18
 */

@Mapper
public interface UserAccountMapper {

    /**
     * 新增用户
     * @param userAccount /
     * @return /
     */
    @Insert("INSERT INTO `tbl_user_account` (`serial`, `sub_time`, `account`,  `nick_name`, `password`, `phone`, `real_name`, `type`) " +
            "VALUES (#{serial},#{subTime},#{account},#{nickName},#{password},#{phone},#{realName},#{type})")
    boolean insert(UserAccount userAccount);

    /**
     * 修改用户
     * @param userAccount /
     * @return /
     */
    @Update("UPDATE `tbl_user_account` SET `update_time` = #{updateTime}, `nick_name` = #{nickName}, `password` = #{password}, " +
            "`phone` = #{phone}, `real_name` = #{realName}, `type` = #{type} WHERE serial=#{serial}")
    boolean update(UserAccount userAccount);

    /**
     * 删除用户
     * @param serial /
     * @return
     */
    @Update("UPDATE tbl_user_account SET is_remove=1 WHERE serial=#{serial}")
    boolean remove(@Param("serial") String serial);

    /**
     * 按条件查询用户
     * @param nickName  /
     * @param realName  /
     * @return /
     */
    @Select("<script>SELECT * FROM tbl_user_account WHERE is_remove=0" +
            "<if test=\"nickName!=null and nickName!=''\">AND nick_name LIKE CONCAT ('%',#{nickName},'%')</if>" +
            "<if test=\"realName!=null and realName!=''\">AND real_name LIKE CONCAT ('%',#{realName},'%')</if>" +
            "</script>")
    List<UserAccount> findByCondition(String nickName, String realName);


    /**
     * 是否存在相同用户
     * @param account /
     * @param phone /
     * @return
     */
    @Select("SELECT * FROM tbl_user_account WHERE (account=#{account} or phone=#{phone})")
    List<UserAccount> isSameUser(@Param("account") String account,@Param("phone") String phone);

    /**
     * 按编号查询用户
     * @param serial /
     * @return /
     */
    @Select("SELECT * FROM tbl_user_account WHERE serial=#{serial} AND is_remove=0")
    UserAccount findBySerial(@Param("serial") String serial);


    /**
     * 登陆检测
     * @param account
     * @return
     */
    @Select("SELECT * FROM tbl_user_account WHERE account=#{account} AND is_remove=0")
    UserAccount loginCheck(@Param("account") String account);

}
