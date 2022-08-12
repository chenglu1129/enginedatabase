package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 护裙实体
 * @author
 * @version 1.0
 * 版权所有：
 * @className BackSkirt
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_back_skirt")
public class BackSkirt extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "bs_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String bsRepairtime;

    @Column(name = "bs_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String bsRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getBsRepairtime() {
        return bsRepairtime;
    }

    public void setBsRepairtime(String bsRepairtime) {
        this.bsRepairtime = bsRepairtime;
    }

    public String getBsRepairtype() {
        return bsRepairtype;
    }

    public void setBsRepairtype(String bsRepairtype) {
        this.bsRepairtype = bsRepairtype;
    }
}
