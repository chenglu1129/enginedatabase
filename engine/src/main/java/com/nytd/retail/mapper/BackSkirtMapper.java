package com.nytd.retail.mapper;

import com.nytd.retail.entity.BackSkirt;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 * 护裙接口
 * @author
 * @version 1.0
 * 版权所有：
 * @className BackSkirtMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface BackSkirtMapper {

    @Insert("INSERT INTO `tbl_back_skirt` (`serial`, `sub_time`, `bs_repairtime`, `bs_repairtype`, `car_serial`) " +
            "VALUES (#{serial},#{subTime},#{bsRepairtime},#{bsRepairtype},#{carSerial})")
    boolean insert(BackSkirt backSkirt);

    @Update("UPDATE `tbl_back_skirt` SET  `update_time` = #{updateTime}, `bs_repairtime` = #{bsRepairtime}, `bs_repairtype` = #{bsRepairtype}, " +
            "`car_serial` = #{carSerial} WHERE serial=#{serial}")
    boolean update(BackSkirt backSkirt);

    @Select("SELECT * FROM tbl_back_skirt WHERE is_remove=0 AND (serial=#{serial} or car_serial=#{carSerial})")
    BackSkirt findBySerial(@Param("serial") String serial,@Param("carSerial") String carSerial);


}
