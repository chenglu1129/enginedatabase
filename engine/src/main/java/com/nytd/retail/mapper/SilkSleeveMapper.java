package com.nytd.retail.mapper;

import com.nytd.retail.entity.RightRearWheel;
import com.nytd.retail.entity.SilkSleeve;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 丝套接口
 * @author
 * @version 1.0
 * 版权所有：
 * @className SilkSleeveMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface SilkSleeveMapper {

    @Insert("INSERT INTO `tbl_silk_sleeve` (`serial`, `sub_time`, `ss_repairtime`, `ss_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{ssRepairtime},#{ssRepairtype},#{carSerial})")
    boolean insert(SilkSleeve silkSleeve);

    @Update("UPDATE `tbl_silk_sleeve` SET `update_time` = #{updateTime}, `ss_repairtime` = #{ssRepairtime}, `ss_repairtype` = #{ssRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(SilkSleeve silkSleeve);

    @Select("SELECT * FROM tbl_silk_sleeve WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    SilkSleeve findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);
}
