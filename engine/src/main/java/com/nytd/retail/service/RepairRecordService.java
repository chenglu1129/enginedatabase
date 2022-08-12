package com.nytd.retail.service;

import com.nytd.retail.entity.RepairRecord;
import com.nytd.retail.mapper.RepairRecordMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 维修记录
 * @author
 * @version 1.0
 * 版权所有：
 * @className RepairRecordService
 * @projectName engine
 * @date 2022/7/28
 */

@Service
public class RepairRecordService {

    @Resource
    private RepairRecordMapper repairRecordMapper;

    /**
     * 新增
     * @param repairRecord /
     * @return /
     */
    public boolean insert(RepairRecord repairRecord){
        return repairRecordMapper.insert(repairRecord);
    }

    /**
     * 按部位查询
     * @param moduleSerial /
     * @return /
     */
    public List<RepairRecord> findByModule(@Param("moduleSerial") String moduleSerial){
        return repairRecordMapper.findByModule(moduleSerial);
    }

    /**
     * 按部门和车辆查询
     * @param carSerial /
     * @param moduleSerial /
     * @return /
     */
    public List<Map<String,Object>> findByCarAndModule(@Param("carSerial") String carSerial, @Param("moduleSerial") String moduleSerial){
        return repairRecordMapper.findByCarAndModule(carSerial,moduleSerial);
    }

    /**
     * 查总数
     * @param moduleSerial
     * @return
     */
    public int getCount(String moduleSerial){
        return repairRecordMapper.getCount(moduleSerial);
    }
}
