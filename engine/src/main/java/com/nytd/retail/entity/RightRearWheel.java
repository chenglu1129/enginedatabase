package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 右后轮
 * @author
 * @version 1.0
 * 版权所有：
 * @className RightRearWheel
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_right_rear_wheel")
public class RightRearWheel extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "rrw_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String rrwRepairtime;

    @Column(name = "rrw_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String rrwRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getRrwRepairtime() {
        return rrwRepairtime;
    }

    public void setRrwRepairtime(String rrwRepairtime) {
        this.rrwRepairtime = rrwRepairtime;
    }

    public String getRrwRepairtype() {
        return rrwRepairtype;
    }

    public void setRrwRepairtype(String rrwRepairtype) {
        this.rrwRepairtype = rrwRepairtype;
    }
}
