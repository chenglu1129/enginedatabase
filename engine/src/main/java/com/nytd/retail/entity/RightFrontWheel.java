package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 右前轮
 * @author
 * @version 1.0
 * 版权所有：
 * @className RightFrontWheel
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_right_front_wheel")
public class RightFrontWheel extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "rfw_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String rfwRepairtime;

    @Column(name = "rfw_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String rfwRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getRfwRepairtime() {
        return rfwRepairtime;
    }

    public void setRfwRepairtime(String rfwRepairtime) {
        this.rfwRepairtime = rfwRepairtime;
    }

    public String getRfwRepairtype() {
        return rfwRepairtype;
    }

    public void setRfwRepairtype(String rfwRepairtype) {
        this.rfwRepairtype = rfwRepairtype;
    }
}
