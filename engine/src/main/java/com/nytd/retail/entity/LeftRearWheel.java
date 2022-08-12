package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 左后轮
 * @author
 * @version 1.0
 * 版权所有：
 * @className LeftRear
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_left_rear_wheel")
public class LeftRearWheel extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "lrw_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String lrwRepairtime;

    @Column(name = "lrw_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String lrwRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getLrwRepairtime() {
        return lrwRepairtime;
    }

    public void setLrwRepairtime(String lrwRepairtime) {
        this.lrwRepairtime = lrwRepairtime;
    }

    public String getLrwRepairtype() {
        return lrwRepairtype;
    }

    public void setLrwRepairtype(String lrwRepairtype) {
        this.lrwRepairtype = lrwRepairtype;
    }
}
