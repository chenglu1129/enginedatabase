package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 前舵实体
 * @author
 * @version 1.0
 * 版权所有：
 * @className FrontRudder
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_front_rudder")
public class FrontRudder extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "fr_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String frRepairtime;

    @Column(name = "fr_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String frRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getFrRepairtime() {
        return frRepairtime;
    }

    public void setFrRepairtime(String frRepairtime) {
        this.frRepairtime = frRepairtime;
    }

    public String getFrRepairtype() {
        return frRepairtype;
    }

    public void setFrRepairtype(String frRepairtype) {
        this.frRepairtype = frRepairtype;
    }
}
