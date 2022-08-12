package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 维修记录
 * @author
 * @version 1.0
 * 版权所有：
 * @className RepairRecord
 * @projectName engine
 * @date 2022/7/28
 */

@Entity
@Table(name = "tbl_repair_record")
public class RepairRecord extends BaseEntity {

    @Column(name = "car_serial",columnDefinition = "varchar(100) comment'车辆编号'")
    private String carSerial;

    @Column(name = "module_serial",columnDefinition = "varchar(100) comment'模块编号'")
    private String moduleSerial;

    @Column(name = "module",columnDefinition = "varchar(50) comment'模块名称'")
    private String module;

    @Column(name = "type",columnDefinition = "varchar(250) comment'维修类型'")
    private String type;

    @Column(name = "mon",columnDefinition = "varchar(50) comment'维修时间yyyy-MM'")
    private String mon;

    @Column(name = "date",columnDefinition = "varchar(50) comment'维修时间yyyy-MM-dd'")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(String carSerial) {
        this.carSerial = carSerial;
    }

    public String getModuleSerial() {
        return moduleSerial;
    }

    public void setModuleSerial(String moduleSerial) {
        this.moduleSerial = moduleSerial;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }
}
