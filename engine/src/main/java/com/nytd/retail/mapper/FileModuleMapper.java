package com.nytd.retail.mapper;

import com.nytd.retail.entity.FileModule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FileModuleMapper {

    /**
     * 新增文件
     * @param fileModule
     * @return
     */
    @Insert("INSERT INTO tbl_file_module(serial, sub_time, appr, author, author_serial, dept_name, dept_serial, " +
            "matter_name, matter_serial, module, name, size, store, type, url,version,self) " +
            "VALUES (#{serial},#{subTime},#{appr},#{author},#{authorSerial},#{deptName},#{deptSerial}," +
            "#{matterName},#{matterSerial},#{module},#{name},#{size},#{store},#{type},#{url},#{version},#{self})")
    boolean insert(FileModule fileModule);

    /**
     * 删除文件
     * @param serial
     * @return
     */
    @Update("UPDATE tbl_file_module SET is_remove=1 WHERE serial=#{serial}")
    boolean remove(String serial);

    /**
     * 修改文件
     * @param fileModule
     * @return
     */
    @Update("UPDATE tbl_file_module SET  update_time =#{updateTime} , appr =#{appr} , author =#{author} , author_serial =#{authorSerial} , " +
            "dept_name =#{deptName} , dept_serial =#{deptSerial} , matter_name =#{matterName} , matter_serial =#{matterSerial} , module =#{module} , " +
            "name =#{name} , size =#{size} , store =#{store} , type =#{type} , url =#{url}, version=#{version}, self=#{self}  WHERE serial=#{serial}")
    boolean update(FileModule fileModule);

    /**
     * 按编号查询文件
     * @param serial
     * @return
     */
    @Select("SELECT serial,name,url,dept_name,appr,author,matter_name,matter_serial,module,version FROM tbl_file_module WHERE serial=#{serial} AND is_remove=0")
    FileModule findBySerial(String serial);

    /**
     * 按条件查询文件
     * @param deptSerial
     * @param module
     * @param matterSerial
     * @param matterName
     * @param authorSerial
     * @param appr
     * @param name
     * @return
     */
    @Select("<script>SELECT serial,name,url,dept_name,appr,author,matter_name,matter_serial,module,version FROM tbl_file_module WHERE is_remove=0" +
            "<if test=\"deptSerial!=null and deptSerial!=''\">AND dept_serial=#{deptSerial}</if>" +
            "<if test=\"module!=null and module!=''\">AND module=#{module}</if>" +
            "<if test=\"matterSerial!=null and matterSerial!=''\">AND matter_serial=#{matterSerial}</if>" +
            "<if test=\"matterName!=null and matterName!=''\">AND matter_name=#{matterName}</if>" +
            "<if test=\"authorSerial!=null and authorSerial!=''\">AND author_serial=#{authorSerial}</if>" +
            "<if test=\"appr!=null\">AND appr=#{appr}</if>" +
            "<if test=\"name!=null and name!=''\">AND name LIKE CONCAT ('%',#{name},'%')</if>" +
            " ORDER BY sub_time ASC"+
            "</script>")
    List<FileModule> findCondition(String deptSerial, String module, String matterSerial,
                                   String matterName, String authorSerial, Integer appr, String name);

    /**
     * 按版本编号查询所有版本
     * @param self
     * @return
     */
    @Select("SELECT serial,name,url,dept_name,appr,author,matter_name,matter_serial,module,version FROM tbl_file_module " +
            "WHERE self=#{self} AND is_remove=0 ORDER BY version ASC")
    List<FileModule> findBySelf(String self);

}
