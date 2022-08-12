package com.nytd.retail.mapper;

import com.nytd.retail.entity.LeftRearWheel;
import com.nytd.retail.entity.RearRudder;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 后舵
 * @author
 * @version 1.0
 * 版权所有：
 * @className RearRudderMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface RearRudderMapper {

    @Insert("INSERT INTO `tbl_rear_rudder` (`serial`, `sub_time`, `rr_repairtime`, `rr_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{rrRepairtime},#{rrRepairtype},#{carSerial})")
    boolean insert(RearRudder rearRudder);

    @Update("UPDATE `tbl_rear_rudder` SET `update_time` = #{updateTime}, `rr_repairtime` = #{rrRepairtime}, `rr_repairtype` = #{rrRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(RearRudder rearRudder);

    @Select("SELECT * FROM tbl_rear_rudder WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    RearRudder findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);

}
