package com.nytd.retail.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nytd.retail.entity.FileModule;
import com.nytd.retail.mapper.FileModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FileModuleService {

    @Resource
    private FileModuleMapper fileModuleMapper;

    /**
     * 新增文件
     * @param fileModule /
     * @return /
     */
    public boolean insert(FileModule fileModule){
        return fileModuleMapper.insert(fileModule);
    }

    /**
     * 删除文件
     * @param serial /
     * @return /
     */
    public boolean remove(String serial){
        return fileModuleMapper.remove(serial);
    }

    /**
     * 修改文件
     * @param fileModule /
     * @return /
     */

    public boolean update(FileModule fileModule){
        return fileModuleMapper.update(fileModule);
    }

    /**
     * 按编号查询文件
     * @param serial /
     * @return /
     */

    public FileModule findBySerial(String serial){
        return fileModuleMapper.findBySerial(serial);
    }

    /**
     * 按条件查询文件 分页展示
     * @param deptSerial /
     * @param module /
     * @param matterSerial /
     * @param matterName /
     * @param authorSerial /
     * @param appr /
     * @param name /
     * @return
     */

    public PageInfo<FileModule> findCondition(String deptSerial, String module, String matterSerial,
                                       String matterName, String authorSerial, Integer appr, String name,int pageNum,int pageSize){

        PageHelper.startPage(pageNum,pageSize);

        List<FileModule> fileModules = fileModuleMapper.findCondition(deptSerial,module,matterSerial,matterName,authorSerial,appr,name);

        return new PageInfo<>(fileModules);
    }

    /**
     * 按条件查所有
     * @param deptSerial
     * @param module
     * @param matterSerial
     * @param matterName
     * @param authorSerial
     * @param appr
     * @param name
     * @return
     */
    public List<FileModule> findConditionAll(String deptSerial, String module, String matterSerial,
                                             String matterName, String authorSerial, Integer appr, String name){

        return fileModuleMapper.findCondition(deptSerial,module,matterSerial,matterName,authorSerial,appr,name);
    }

    /**
     * 根据具体模块编号查询所有
     * @param matterSerial
     * @return
     */
    public List<FileModule> findByMatterSerial(String matterSerial){
        return fileModuleMapper.findCondition(null,null,matterSerial,null,null,null,null);
    }

    /**
     * 根据版本编号查所有版本的文件
     * @param self
     * @return
     */
    public List<FileModule> findAllVersion(String self){
        return fileModuleMapper.findBySelf(self);
    }
}
