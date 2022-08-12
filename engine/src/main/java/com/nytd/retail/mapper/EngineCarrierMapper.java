package com.nytd.retail.mapper;

import com.nytd.retail.entity.BackSkirt;
import com.nytd.retail.entity.EngineCarrier;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 发动机载体
 * @author
 * @version 1.0
 * 版权所有：
 * @className EngineCarrier
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface EngineCarrierMapper {

    @Insert("INSERT INTO `tbl_engine_carrier` (`serial`, `sub_time`, `ec_repairtime`, `ec_repairtype`, `car_serial`,url,no) " +
            "VALUES (#{serial},#{subTime},#{ecRepairtime},#{ecRepairtype},#{carSerial},#{url},#{no})")
    boolean insert(EngineCarrier engineCarrier);

    @Update("UPDATE `tbl_engine_carrier` SET  `update_time` = #{updateTime}, `ec_repairtime` = #{ecRepairtime}, `ec_repairtype` = #{ecRepairtype}, " +
            "`car_serial` = #{carSerial},url=#{url},no=#{no} WHERE serial=#{serial}")
    boolean update(EngineCarrier engineCarrier);

    @Select("SELECT * FROM tbl_engine_carrier WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    EngineCarrier findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);
}
