package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 丝套
 * @author
 * @version 1.0
 * 版权所有：
 * @className SilkSleeve
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_silk_sleeve")
public class SilkSleeve extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "ss_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String ssRepairtime;

    @Column(name = "ss_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String ssRepairtype;

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getSsRepairtime() {
        return ssRepairtime;
    }

    public void setSsRepairtime(String ssRepairtime) {
        this.ssRepairtime = ssRepairtime;
    }

    public String getSsRepairtype() {
        return ssRepairtype;
    }

    public void setSsRepairtype(String ssRepairtype) {
        this.ssRepairtype = ssRepairtype;
    }
}
