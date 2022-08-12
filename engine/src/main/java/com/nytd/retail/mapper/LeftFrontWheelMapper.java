package com.nytd.retail.mapper;

import com.nytd.retail.entity.BackSkirt;
import com.nytd.retail.entity.EngineCarrier;
import com.nytd.retail.entity.LeftFrontWheel;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 左前轮接口
 * @author
 * @version 1.0
 * 版权所有：
 * @className LeftFrontWheelMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface LeftFrontWheelMapper {

    @Insert("INSERT INTO `tbl_left_front_wheel` (`serial`, `sub_time`, `lfw_repairtime`, `lfw_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{lfwRepairtime},#{lfwRepairtype},#{carSerial})")
    boolean insert(LeftFrontWheel engineCarrier);

    @Update("UPDATE `tbl_left_front_wheel` SET  `update_time` = #{updateTime}, `lfw_repairtime` = #{lfwRepairtime}, `lfw_repairtype` = #{lfwRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(LeftFrontWheel engineCarrier);

    @Select("SELECT * FROM tbl_left_front_wheel WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    LeftFrontWheel findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);

}
