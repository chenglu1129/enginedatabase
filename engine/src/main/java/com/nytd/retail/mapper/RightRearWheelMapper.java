package com.nytd.retail.mapper;

import com.nytd.retail.entity.RightFrontWheel;
import com.nytd.retail.entity.RightRearWheel;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 右后轮
 * @author
 * @version 1.0
 * 版权所有：
 * @className RightRearWheelMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface RightRearWheelMapper {

    @Insert("INSERT INTO `tbl_right_rear_wheel` (`serial`, `sub_time`, `rrw_repairtime`, `rrw_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{rrwRepairtime},#{rrwRepairtype},#{carSerial})")
    boolean insert(RightRearWheel rightRearWheel);

    @Update("UPDATE `tbl_right_rear_wheel` SET `update_time` = #{updateTime}, `rrw_repairtime` = #{rrwRepairtime}, `rrw_repairtype` = #{rrwRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(RightRearWheel rightRearWheel);

    @Select("SELECT * FROM tbl_right_rear_wheel WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    RightRearWheel findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);

}
