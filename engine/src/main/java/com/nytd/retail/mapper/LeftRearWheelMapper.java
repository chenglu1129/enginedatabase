package com.nytd.retail.mapper;

import com.nytd.retail.entity.LeftFrontWheel;
import com.nytd.retail.entity.LeftRearWheel;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className LeftRearWheelMapper
 * @projectName engine
 * @date 2022/7/26
 */
@Mapper
public interface LeftRearWheelMapper {

    @Insert("INSERT INTO `tbl_left_rear_wheel` (`serial`, `sub_time`, `lrw_repairtime`, `lrw_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{lrwRepairtime},#{lrwRepairtype},#{carSerial})")
    boolean insert(LeftRearWheel engineCarrier);

    @Update("UPDATE `tbl_left_rear_wheel` SET  `update_time` = #{updateTime}, `lrw_repairtime` = #{lrwRepairtime}, `lrw_repairtype` = #{lrwRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(LeftRearWheel engineCarrier);

    @Select("SELECT * FROM tbl_left_rear_wheel WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    LeftRearWheel findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);
}
