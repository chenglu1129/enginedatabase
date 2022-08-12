package com.nytd.retail.entity;

import com.nytd.retail.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * 描述:
 * 文件实体类
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className Shop
 * @projectName mall_user
 * @date 2021/8/31
 */
@Entity
@Table(name = "tbl_file_module")
public class FileModule extends BaseEntity {

    @Column(name = "name",columnDefinition = "text comment'文件名称'")
    private String name;

    @Column(name = "url",columnDefinition = "text comment'文件地址'")
    private String url;

    @Column(name = "type",columnDefinition = "varchar(255) comment'文件类型'")
    private String type;

    @Column(name = "size",columnDefinition = "varchar(10) comment'文件大小'")
    private String size;

    @Column(name = "author_serial",columnDefinition = "varchar(40) comment'作者编号'")
    private String authorSerial;

    @Column(name = "author",columnDefinition = "varchar(10) comment'作者名称'")
    private String author;

    @Column(name = "store",columnDefinition = "varchar(10) comment'存储类型  本地\\云'")
    private String store;

    @Column(name = "appr",columnDefinition = "tinyint(2) not null default 0 comment'审核状态  0未发送  1已发送  2已通过  3未通过'")
    private int appr;

    @Column(name = "module",columnDefinition = "varchar(100) comment'所属功能模块'")
    private String module;

    @Column(name = "matter_serial",columnDefinition = "varchar(40) comment'所属具体模块编号'")
    private String matterSerial;

    @Column(name = "matter_name",columnDefinition = "text comment'所属具体模块名称'")
    private String matterName;

    @Column(name = "dept_serial",columnDefinition = "varchar(40) comment'所属部门编号'")
    private String deptSerial;

    @Column(name = "dept_name",columnDefinition = "varchar(20) comment'所属部门名称'")
    private String deptName;

    @Column(name = "version",columnDefinition = "tinyint(2) not null default 1 comment'版本号'")
    private int version;

    @Column(name = "self",columnDefinition = "varchar(40) comment'文件版本编号'")
    private String self;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileModule that = (FileModule) o;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAuthorSerial() {
        return authorSerial;
    }

    public void setAuthorSerial(String authorSerial) {
        this.authorSerial = authorSerial;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getAppr() {
        return appr;
    }

    public void setAppr(int appr) {
        this.appr = appr;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMatterSerial() {
        return matterSerial;
    }

    public void setMatterSerial(String matterSerial) {
        this.matterSerial = matterSerial;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    public String getDeptSerial() {
        return deptSerial;
    }

    public void setDeptSerial(String deptSerial) {
        this.deptSerial = deptSerial;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
