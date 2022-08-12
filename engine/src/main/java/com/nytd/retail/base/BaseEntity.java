package com.nytd.retail.base;

//import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//主键策略

    @Column(name = "serial",columnDefinition = "varchar(40) not null comment'实体编号' ")
    private String serial;

    @Column(name = "is_remove",columnDefinition = "tinyint(2) not null default 0 comment'是否移除? 0存在 1删除' ")
    private int isRemove;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "sub_time")
    private Date subTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;//更新日期

    @Transient
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(int isRemove) {
        this.isRemove = isRemove;
    }

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
