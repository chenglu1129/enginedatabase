package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述:
 * 车辆实体类
 * @author
 * @version 1.0
 * 版权所有：
 * @className Car
 * @projectName engine
 * @date 2022/7/26
 */

@Entity
@Table(name = "tbl_car")
public class Car extends BaseEntity {

    @Column(name = "c_name",columnDefinition = "varchar(25) comment'车辆名称'")
    private String cName;

    @Transient
    private String url;

    @Transient
    private String no;

    @Transient
    private EngineCarrier engineCarrier;

    @Transient
    private FrontRudder frontRudder;

    @Transient
    private LeftFrontWheel leftFrontWheel;

    @Transient
    private LeftRearWheel leftRearWheel;

    @Transient
    private RearRudder rearRudder;

    @Transient
    private RightFrontWheel rightFrontWheel;

    @Transient
    private RightRearWheel rightRearWheel;

    @Transient
    private SilkSleeve silkSleeve;

    @Transient
    private BackSkirt backSkirt;

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

    public BackSkirt getBackSkirt() {
        return backSkirt;
    }

    public void setBackSkirt(BackSkirt backSkirt) {
        this.backSkirt = backSkirt;
    }

    public FrontRudder getFrontRudder() {
        return frontRudder;
    }

    public void setFrontRudder(FrontRudder frontRudder) {
        this.frontRudder = frontRudder;
    }

    public LeftFrontWheel getLeftFrontWheel() {
        return leftFrontWheel;
    }

    public void setLeftFrontWheel(LeftFrontWheel leftFrontWheel) {
        this.leftFrontWheel = leftFrontWheel;
    }

    public LeftRearWheel getLeftRearWheel() {
        return leftRearWheel;
    }

    public void setLeftRearWheel(LeftRearWheel leftRearWheel) {
        this.leftRearWheel = leftRearWheel;
    }

    public RearRudder getRearRudder() {
        return rearRudder;
    }

    public void setRearRudder(RearRudder rearRudder) {
        this.rearRudder = rearRudder;
    }

    public RightFrontWheel getRightFrontWheel() {
        return rightFrontWheel;
    }

    public void setRightFrontWheel(RightFrontWheel rightFrontWheel) {
        this.rightFrontWheel = rightFrontWheel;
    }

    public RightRearWheel getRightRearWheel() {
        return rightRearWheel;
    }

    public void setRightRearWheel(RightRearWheel rightRearWheel) {
        this.rightRearWheel = rightRearWheel;
    }

    public SilkSleeve getSilkSleeve() {
        return silkSleeve;
    }

    public void setSilkSleeve(SilkSleeve silkSleeve) {
        this.silkSleeve = silkSleeve;
    }

    public EngineCarrier getEngineCarrier() {
        return engineCarrier;
    }

    public void setEngineCarrier(EngineCarrier engineCarrier) {
        this.engineCarrier = engineCarrier;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
