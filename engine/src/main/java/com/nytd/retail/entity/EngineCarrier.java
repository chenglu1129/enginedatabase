package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 发动机载体
 * @author
 * @version 1.0
 * 版权所有：
 * @className EngineCarrier
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_engine_carrier")
public class EngineCarrier extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'所属车辆编号'")
    private String carSerial;

    @Column(name = "ec_repairtime",columnDefinition = "varchar(50) comment'维修时间'")
    private String ecRepairtime;

    @Column(name = "ec_repairtype",columnDefinition = "varchar(50) comment'维修类型'")
    private String ecRepairtype;

    @Column(name = "url",columnDefinition = "varchar(250) comment'图片地址'")
    private String url;

    @Column(name = "no",columnDefinition = "varchar(10) comment'载体号'")
    private String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getEcRepairtime() {
        return ecRepairtime;
    }

    public void setEcRepairtime(String ecRepairtime) {
        this.ecRepairtime = ecRepairtime;
    }

    public String getEcRepairtype() {
        return ecRepairtype;
    }

    public void setEcRepairtype(String ecRepairtype) {
        this.ecRepairtype = ecRepairtype;
    }
}
