package com.nytd.retail.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nytd.retail.base.BaseMessage;
import com.nytd.retail.entity.*;
import com.nytd.retail.mapper.*;
import com.nytd.retail.util.DataUtil;
import com.nytd.retail.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 车辆
 * @author
 * @version 1.0
 * 版权所有：
 * @className CarService
 * @projectName engine
 * @date 2022/7/26
 */

@Service
public class CarService {

    @Resource
    private EngineCarrierMapper engineCarrierMapper;

    @Resource
    private FrontRudderMapper frontRudderMapper;

    @Resource
    private LeftFrontWheelMapper leftFrontWheelMapper;

    @Resource
    private LeftRearWheelMapper leftRearWheelMapper;

    @Resource
    private RearRudderMapper rearRudderMapper;

    @Resource
    private RightFrontWheelMapper rightFrontWheelMapper;

    @Resource
    private RightRearWheelMapper rightRearWheelMapper;

    @Resource
    private SilkSleeveMapper silkSleeveMapper;

    @Resource
    private BackSkirtMapper backSkirtMapper;

    @Resource
    private CarMapper carMapper;

    @Resource
    private RepairRecordMapper repairRecordMapper;


    /**
     * 新增车辆和各个部件
     * @param car                   车辆
     * @param engineCarrier         发动机载体
     * @param frontRudder           前舵
     * @param leftFrontWheel        左前轮
     * @param leftRearWheel         左后轮
     * @param rearRudder            后舵
     * @param rightFrontWheel       右前轮
     * @param rightRearWheel        右后轮
     * @param silkSleeve            丝套
     * @param backSkirt             护裙
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Car car){


        String carSerial = car.getSerial();

        EngineCarrier engineCarrier = new EngineCarrier();

        engineCarrier.setSerial(DataUtil.getComSerial());
        engineCarrier.setCarSerial(carSerial);
        engineCarrier.setSubTime(new Date());
        //处理载体图片
        if (!StringUtils.isEmpty(car.getUrl())){
            engineCarrier.setUrl(car.getUrl());
        }
        //载体号
        if (!StringUtils.isEmpty(car.getNo())){
            engineCarrier.setNo(car.getNo());
        }

        FrontRudder frontRudder = new FrontRudder();
        frontRudder.setSerial(DataUtil.getComSerial());
        frontRudder.setCarSerial(carSerial);
        frontRudder.setSubTime(new Date());

        LeftFrontWheel leftFrontWheel = new LeftFrontWheel();
        leftFrontWheel.setSerial(DataUtil.getComSerial());
        leftFrontWheel.setCarSerial(carSerial);
        leftFrontWheel.setSubTime(new Date());

        LeftRearWheel leftRearWheel = new LeftRearWheel();
        leftRearWheel.setSerial(DataUtil.getComSerial());
        leftRearWheel.setCarSerial(carSerial);
        leftFrontWheel.setSubTime(new Date());

        RearRudder rearRudder = new RearRudder();
        rearRudder.setSerial(DataUtil.getComSerial());
        rearRudder.setCarSerial(carSerial);
        rearRudder.setSubTime(new Date());

        RightFrontWheel rightFrontWheel = new RightFrontWheel();
        rightFrontWheel.setSerial(DataUtil.getComSerial());
        rightFrontWheel.setCarSerial(carSerial);
        rightFrontWheel.setSubTime(new Date());

        RightRearWheel rightRearWheel = new RightRearWheel();
        rightRearWheel.setSerial(DataUtil.getComSerial());
        rightRearWheel.setCarSerial(carSerial);
        rightRearWheel.setSubTime(new Date());

        SilkSleeve silkSleeve = new SilkSleeve();
        silkSleeve.setSerial(DataUtil.getComSerial());
        silkSleeve.setCarSerial(carSerial);
        silkSleeve.setSubTime(new Date());

        BackSkirt backSkirt = new BackSkirt();
        backSkirt.setSerial(DataUtil.getComSerial());
        backSkirt.setCarSerial(carSerial);
        backSkirt.setSubTime(new Date());

        engineCarrierMapper.insert(engineCarrier);
        frontRudderMapper.insert(frontRudder);
        leftFrontWheelMapper.insert(leftFrontWheel);
        leftRearWheelMapper.insert(leftRearWheel);
        rearRudderMapper.insert(rearRudder);
        rightFrontWheelMapper.insert(rightFrontWheel);
        rightRearWheelMapper.insert(rightRearWheel);
        silkSleeveMapper.insert(silkSleeve);
        backSkirtMapper.insert(backSkirt);

        return carMapper.insert(car);

    }

    /**
     * 按条件分页查 ,
     * @param page  /
     * @param pageSize  /
     * @return  /
     */
    public PageInfo<Car> findCondition(int page,int pageSize){

        PageHelper.startPage(page,pageSize);

        List<Car> carPageInfo = carMapper.findCondition();

        //查询各个部件
        carPageInfo.forEach(item ->{
            String carSerial = item.getSerial();

            BackSkirt backSkirt = backSkirtMapper.findBySerial(null,carSerial);
            backSkirt.setCount(repairRecordMapper.getCount(backSkirt.getSerial()));

            EngineCarrier engineCarrier = engineCarrierMapper.findBySerial(null,carSerial);
            engineCarrier.setCount(repairRecordMapper.getCount(engineCarrier.getSerial()));

            FrontRudder frontRudder = frontRudderMapper.findBySerial(null,carSerial);
            frontRudder.setCount(repairRecordMapper.getCount(frontRudder.getSerial()));

            LeftFrontWheel leftFrontWheel = leftFrontWheelMapper.findBySerial(null,carSerial);
            leftFrontWheel.setCount(repairRecordMapper.getCount(leftFrontWheel.getSerial()));

            LeftRearWheel leftRearWheel = leftRearWheelMapper.findBySerial(null,carSerial);
            leftRearWheel.setCount(repairRecordMapper.getCount(leftRearWheel.getSerial()));

            RearRudder rearRudder = rearRudderMapper.findBySerial(null,carSerial);
            rearRudder.setCount(repairRecordMapper.getCount(rearRudder.getSerial()));

            RightFrontWheel rightFrontWheel = rightFrontWheelMapper.findBySerial(null,carSerial);
            rightFrontWheel.setCount(repairRecordMapper.getCount(rightFrontWheel.getSerial()));

            RightRearWheel rightRearWheel = rightRearWheelMapper.findBySerial(null,carSerial);
            rightRearWheel.setCount(repairRecordMapper.getCount(rightRearWheel.getSerial()));

            SilkSleeve silkSleeve = silkSleeveMapper.findBySerial(null,carSerial);
            silkSleeve.setCount(repairRecordMapper.getCount(silkSleeve.getSerial()));

            item.setBackSkirt(backSkirt);
            item.setEngineCarrier(engineCarrier);
            item.setFrontRudder(frontRudder);
            item.setLeftFrontWheel(leftFrontWheel);
            item.setLeftRearWheel(leftRearWheel);
            item.setRearRudder(rearRudder);
            item.setRightFrontWheel(rightFrontWheel);
            item.setRightRearWheel(rightRearWheel);
            item.setSilkSleeve(silkSleeve);
        });

        return new PageInfo<>(carPageInfo);

    }

    /**
     * 按编号查
     * @param serial /
     * @return /
     */
    public Car findBySerial(String serial){
        return carMapper.findBySerial(serial);
    }

    /**
     * 删除车辆
     * @param serial /
     * @return /
     */
    public boolean remove(String serial){
        return carMapper.remove(serial);
    }

    /**
     * 查所有车辆
     * @return /
     */

    public List<Car> findAll(){
        List<Car> cars = carMapper.findCondition();

        //查询各个部件
        cars.forEach(item ->{

            String carSerial = item.getSerial();

            BackSkirt backSkirt = backSkirtMapper.findBySerial(null,carSerial);

            EngineCarrier engineCarrier = engineCarrierMapper.findBySerial(null,carSerial);

            FrontRudder frontRudder = frontRudderMapper.findBySerial(null,carSerial);

            LeftFrontWheel leftFrontWheel = leftFrontWheelMapper.findBySerial(null,carSerial);

            LeftRearWheel leftRearWheel = leftRearWheelMapper.findBySerial(null,carSerial);

            RearRudder rearRudder = rearRudderMapper.findBySerial(null,carSerial);

            RightFrontWheel rightFrontWheel = rightFrontWheelMapper.findBySerial(null,carSerial);

            RightRearWheel rightRearWheel = rightRearWheelMapper.findBySerial(null,carSerial);

            SilkSleeve silkSleeve = silkSleeveMapper.findBySerial(null,carSerial);

            item.setBackSkirt(backSkirt);
            item.setEngineCarrier(engineCarrier);
            item.setFrontRudder(frontRudder);
            item.setLeftFrontWheel(leftFrontWheel);
            item.setLeftRearWheel(leftRearWheel);
            item.setRearRudder(rearRudder);
            item.setRightFrontWheel(rightFrontWheel);
            item.setRightRearWheel(rightRearWheel);
            item.setSilkSleeve(silkSleeve);
        });

        return cars;
    }
}
