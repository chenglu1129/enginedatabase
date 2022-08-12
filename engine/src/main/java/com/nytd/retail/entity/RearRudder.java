package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 后舵
 * @author
 * @version 1.0
 * 版权所有：
 * @className RearRudder
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_rear_rudder")
public class RearRudder extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "rr_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String rrRepairtime;

    @Column(name = "rr_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String rrRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getRrRepairtime() {
        return rrRepairtime;
    }

    public void setRrRepairtime(String rrRepairtime) {
        this.rrRepairtime = rrRepairtime;
    }

    public String getRrRepairtype() {
        return rrRepairtype;
    }

    public void setRrRepairtype(String rrRepairtype) {
        this.rrRepairtype = rrRepairtype;
    }
}
