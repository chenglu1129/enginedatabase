package com.nytd.retail.mapper;

import com.nytd.retail.entity.RepairRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 维修记录接口
 * @author
 * @version 1.0
 * 版权所有：
 * @className RepairRecordMapper
 * @projectName engine
 * @date 2022/7/28
 */

@Mapper
public interface RepairRecordMapper {

    /**
     * 新增
     * @param repairRecord
     * @return
     */
    @Insert("INSERT INTO `tbl_repair_record` (`serial`, `sub_time`, `car_serial`, `module`, `module_serial`, `mon`, `type`,`date`) " +
            "VALUES (#{serial},#{subTime},#{carSerial},#{module},#{moduleSerial},#{mon},#{type},#{date})")
    boolean insert(RepairRecord repairRecord);

    @Select("SELECT * FROM tbl_repair_record WHERE is_remove=0 AND module_serial=#{moduleSerial}")
    List<RepairRecord> findByModule(@Param("moduleSerial") String moduleSerial);

    /**
     * 按车辆编号和部位查询各部位在各月份的维修总次数
     * @param carSerial     车辆名称
     * @param moduleSerial        部位名称
     * @return  总条数、年月yyyy-MM、部位名称
     */
    @Select("<script>SELECT count(*) as 'count',substring(mon,7) as 'mon',module as 'module' FROM tbl_repair_record WHERE is_remove=0 AND car_serial=#{carSerial}" +
            "<if test=\"moduleSerial!=null and moduleSerial!=''\">AND module_serial=#{moduleSerial}</if>" +
            " group by module,mon" +
            "</script>")
    List<Map<String,Object>> findByCarAndModule(@Param("carSerial") String carSerial, @Param("moduleSerial") String moduleSerial);

    /**
     * 查询维修次数
     * @param moduleSerial
     * @return
     */
    @Select("SELECT COUNT(*) FROM tbl_repair_record WHERE is_remove=0 AND module_serial=#{moduleSerial}")
    int getCount(@Param("moduleSerial") String moduleSerial);
}
