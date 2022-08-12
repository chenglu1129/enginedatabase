package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 左前轮
 * @author
 * @version 1.0
 * 版权所有：
 * @className LeftFrontWheel
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_left_front_wheel")
public class LeftFrontWheel extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "lfw_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String lfwRepairtime;

    @Column(name = "lfw_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String lfwRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getLfwRepairtime() {
        return lfwRepairtime;
    }

    public void setLfwRepairtime(String lfwRepairtime) {
        this.lfwRepairtime = lfwRepairtime;
    }

    public String getLfwRepairtype() {
        return lfwRepairtype;
    }

    public void setLfwRepairtype(String lfwRepairtype) {
        this.lfwRepairtype = lfwRepairtype;
    }
}
