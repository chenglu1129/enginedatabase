package com.nytd.retail.mapper;

import com.nytd.retail.entity.RearRudder;
import com.nytd.retail.entity.RightFrontWheel;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 右前轮
 * @author
 * @version 1.0
 * 版权所有：
 * @className RightFrontWheelMapper
 * @projectName engine
 * @date 2022/7/26
 */
@Mapper
public interface RightFrontWheelMapper {

    @Insert("INSERT INTO `tbl_right_front_wheel` (`serial`, `sub_time`, `rfw_repairtime`, `rfw_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{rfwRepairtime},#{rfwRepairtype},#{carSerial})")
    boolean insert(RightFrontWheel rightFrontWheel);

    @Update("UPDATE `tbl_right_front_wheel` SET `update_time` = #{updateTime}, `rfw_repairtime` = #{rfwRepairtime}, `rfw_repairtype` = #{rfwRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(RightFrontWheel rightFrontWheel);

    @Select("SELECT * FROM tbl_right_front_wheel WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    RightFrontWheel findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);
}
