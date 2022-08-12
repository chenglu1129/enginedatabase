package com.nytd.retail.controller;

import com.github.pagehelper.PageInfo;
import com.nytd.retail.base.BaseController;
import com.nytd.retail.base.BaseMessage;
import com.nytd.retail.entity.*;
import com.nytd.retail.util.DataUtil;
import com.nytd.retail.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述:
 * 车辆查询列表
 * @author
 * @version 1.0
 * 版权所有：
 * @className CarController
 * @projectName engine
 * @date 2022/7/27
 */

@RestController
@RequestMapping("/v1/api/car")
public class CarController extends BaseController {

    /**
     * 条件查询车辆列表
     * @param page          分页
     * @param pageSize      分页
     * @return  /
     */
    @PostMapping("/find/condition")
    public Result findCondition(Integer page,Integer pageSize){

        try{

            PageInfo<Car> carPageInfo = carService.findCondition(page,pageSize);


            return carPageInfo.getList().size() > 0 ? Result.success("查询成果",carPageInfo.getList(),carPageInfo.getTotal()) : Result.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());
    }

    /**
     * 保存车辆
     * @param car /
     * @return /
     */
    @PostMapping("/publish")
    public Result publish(Car car){

        try{

            if (StringUtils.isEmpty(car.getSerial())){

                car.setSerial(DataUtil.getComSerial());
                car.setSubTime(new Date());

                return carService.insert(car) ? Result.success("保存成功") : Result.error("保存失败");

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());

    }

    /**
     * 删除车辆
     * @param serial
     * @return
     */
    @GetMapping("/remove/{serial}")
    public Result remove(@PathVariable("serial") String serial){

        try{

            return carService.remove(serial) ? Result.success("删除成功") : Result.error("删除失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());
    }

    /**
     * 修理
     * @param carSerial 车辆编号
     * @param serial    编号
     * @param flag      部位名称
     * @return /
     */
    @PostMapping("/repair")
    public Result repair(String carSerial,String serial,String flag,String time,String comment){

        try{

            Car car = carService.findBySerial(carSerial);

            if (car == null){
                return Result.error("当前车辆不存在");
            }

            //新增修改记录
            RepairRecord repairRecord = new RepairRecord();
            repairRecord.setSerial(DataUtil.getComSerial());
            repairRecord.setSubTime(new Date());
            repairRecord.setCarSerial(carSerial);
            repairRecord.setModule(flag);
            repairRecord.setDate(time);
            repairRecord.setMon(time.substring(0,7));
            repairRecord.setType(comment);

            if ("发动机载体".equals(flag)){

                EngineCarrier engineCarrier = engineCarrierMapper.findBySerial(serial,null);

                engineCarrier.setEcRepairtime(time);
                engineCarrier.setEcRepairtype(comment);
                engineCarrierMapper.update(engineCarrier);
                repairRecord.setModuleSerial(engineCarrier.getSerial());

            }else if ("护裙".equals(flag)){

                BackSkirt backSkirt = backSkirtMapper.findBySerial(serial,null);
                backSkirt.setBsRepairtime(time);
                backSkirt.setBsRepairtype(comment);
                backSkirtMapper.update(backSkirt);
                repairRecord.setModuleSerial(backSkirt.getSerial());

            }else if ("前舵".equals(flag)){

                FrontRudder frontRudder = frontRudderMapper.findBySerial(serial,null);

                frontRudder.setFrRepairtime(time);
                frontRudder.setFrRepairtype(comment);
                frontRudderMapper.update(frontRudder);
                repairRecord.setModuleSerial(frontRudder.getSerial());

            }else if ("左前轮".equals(flag)){

                LeftFrontWheel leftFrontWheel = leftFrontWheelMapper.findBySerial(serial,null);

                leftFrontWheel.setLfwRepairtime(time);
                leftFrontWheel.setLfwRepairtype(comment);
                leftFrontWheelMapper.update(leftFrontWheel);
                repairRecord.setModuleSerial(leftFrontWheel.getSerial());

            }else if ("左后轮".equals(flag)){

                LeftRearWheel leftRearWheel = leftRearWheelMapper.findBySerial(serial,null);

                leftRearWheel.setLrwRepairtime(time);
                leftRearWheel.setLrwRepairtype(comment);
                leftRearWheelMapper.update(leftRearWheel);
                repairRecord.setModuleSerial(leftRearWheel.getSerial());

            }else if ("后舵".equals(flag)){

                RearRudder rearRudder = rearRudderMapper.findBySerial(serial,null);

                rearRudder.setRrRepairtime(time);
                rearRudder.setRrRepairtype(comment);
                rearRudderMapper.update(rearRudder);
                repairRecord.setModuleSerial(rearRudder.getSerial());

            }else if ("右前轮".equals(flag)){

                RightFrontWheel rightFrontWheel = rightFrontWheelMapper.findBySerial(serial,null);

                rightFrontWheel.setRfwRepairtime(time);
                rightFrontWheel.setRfwRepairtype(comment);
                rightFrontWheelMapper.update(rightFrontWheel);
                repairRecord.setModuleSerial(rightFrontWheel.getSerial());

            }else if ("右后轮".equals(flag)){

                RightRearWheel rightRearWheel = rightRearWheelMapper.findBySerial(serial,null);

                rightRearWheel.setRrwRepairtime(time);
                rightRearWheel.setRrwRepairtype(comment);
                rightRearWheelMapper.update(rightRearWheel);
                repairRecord.setModuleSerial(rightRearWheel.getSerial());

            }else if ("丝套".equals(flag)){

                SilkSleeve silkSleeve = silkSleeveMapper.findBySerial(serial,null);

                silkSleeve.setSsRepairtime(time);
                silkSleeve.setSsRepairtype(comment);
                silkSleeveMapper.update(silkSleeve);
                repairRecord.setModuleSerial(silkSleeve.getSerial());

            }else {
                return Result.error("数据传输错误");
            }

            return repairRecordService.insert(repairRecord) ? Result.success("修改成功") : Result.error("修改失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());

    }

    /**
     * 点击二级页面的部位跳转详情里，默认查询所有部位的维修记录（折线图展示）
     * @param carSerial
     * @return
     */
    @PostMapping("/detail")
    public Result detail(@RequestParam("carSerial") String carSerial,String moduleSerial){

        try{


            List<Map<String,Object>> repairRecords = repairRecordService.findByCarAndModule(carSerial,moduleSerial);

            //分组
            Map<String,List<Map>> mapListGroup = repairRecords.stream().
                    collect(Collectors.groupingBy(e->e.get("module").toString()));

            return repairRecords.size()>0 ? Result.success("查询成功",mapListGroup) : Result.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());
    }

    /**
     * 查所有载体
     * @return
     */
    @GetMapping("/all/engines")
    public Result findByInfo(){

        try{

           List<Car> cars = carService.findAll();

           return cars.size()>0 ? Result.success("查询成功",cars) : Result.success("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.error(BaseMessage.服务器内部错误请联系管理员.name());
    }
}
