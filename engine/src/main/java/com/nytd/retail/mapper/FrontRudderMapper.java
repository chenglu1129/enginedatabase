package com.nytd.retail.mapper;

import com.nytd.retail.entity.BackSkirt;
import com.nytd.retail.entity.EngineCarrier;
import com.nytd.retail.entity.FrontRudder;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 前舵接口
 * @author
 * @version 1.0
 * 版权所有：
 * @className FrontRudderMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface FrontRudderMapper {

    @Insert("INSERT INTO `tbl_front_rudder` (`serial`, `sub_time`, `fr_repairtime`, `fr_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{frRepairtime},#{frRepairtype},#{carSerial})")
    boolean insert(FrontRudder frontRudder);

    @Update("UPDATE `tbl_front_rudder` SET  `update_time` = #{updateTime}, `fr_repairtime` = #{frRepairtime}, `fr_repairtype` = #{frRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(FrontRudder frontRudder);

    @Select("SELECT * FROM tbl_front_rudder WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    FrontRudder findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);
}
