package com.nytd.retail.mapper;

import com.nytd.retail.entity.BackSkirt;
import com.nytd.retail.entity.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 描述:
 * 车辆接口
 * @author
 * @version 1.0
 * 版权所有：
 * @className CarMapper
 * @projectName engine
 * @date 2022/7/26
 */

@Mapper
public interface CarMapper {

    /**
     * 保存
     * @param car /
     * @return
     */
    @Insert("INSERT INTO `tbl_car` (`serial`, `sub_time`, `c_name`) " +
            "VALUES (#{serial},#{subTime},#{cName})")
    boolean insert(Car car);

    /**
     * 修改
     * @param car /
     * @return
     */
    @Update("UPDATE `tbl_car` SET  `update_time` = #{updateTime}, `c_name` = #{cName}  WHERE serial=#{serial}")
    boolean update(Car car);

    /**
     * 删除
     * @param serial /
     * @return /
     */
    @Update("UPDATE tbl_car SET is_remove=1 WHERE serial=#{serial}")
    boolean remove(@Param("serial") String serial);

    /**
     * 按编号查
     * @param serial /
     * @return
     */
    @Select("SELECT * FROM tbl_car WHERE is_remove=0 AND serial=#{serial}")
    Car findBySerial(@Param("serial") String serial);

    /**
     * 按条件查
     * @return /
     */
    @Select("SELECT * FROM tbl_car WHERE is_remove=0")
    List<Car> findCondition();
}
