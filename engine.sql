/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : engine

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 12/08/2022 20:06:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_back_skirt
-- ----------------------------
DROP TABLE IF EXISTS `tbl_back_skirt`;
CREATE TABLE `tbl_back_skirt`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `bs_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `bs_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_car
-- ----------------------------
DROP TABLE IF EXISTS `tbl_car`;
CREATE TABLE `tbl_car`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `back_skirt` tinyblob NULL,
  `c_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆名称',
  `engine_carrier` tinyblob NULL,
  `front_rudder` tinyblob NULL,
  `left_front_wheel` tinyblob NULL,
  `left_rear_wheel` tinyblob NULL,
  `no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rear_rudder` tinyblob NULL,
  `right_front_wheel` tinyblob NULL,
  `right_rear_wheel` tinyblob NULL,
  `silk_sleeve` tinyblob NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_engine_carrier
-- ----------------------------
DROP TABLE IF EXISTS `tbl_engine_carrier`;
CREATE TABLE `tbl_engine_carrier`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `ec_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `ec_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  `no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '载体号',
  `url` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_file_module
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file_module`;
CREATE TABLE `tbl_file_module`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `appr` tinyint(2) NOT NULL DEFAULT 0 COMMENT '审核状态  0未发送  1已发送  2已通过  3未通过',
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者名称',
  `author_serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者编号',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门名称',
  `dept_serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门编号',
  `matter_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '所属具体模块名称',
  `matter_serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属具体模块编号',
  `module` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属功能模块',
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件名称',
  `self` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件版本编号',
  `size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  `store` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存储类型  本地云',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件地址',
  `version` tinyint(2) NOT NULL DEFAULT 1 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_front_rudder
-- ----------------------------
DROP TABLE IF EXISTS `tbl_front_rudder`;
CREATE TABLE `tbl_front_rudder`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `fr_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `fr_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_left_front_wheel
-- ----------------------------
DROP TABLE IF EXISTS `tbl_left_front_wheel`;
CREATE TABLE `tbl_left_front_wheel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `lfw_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `lfw_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_left_rear_wheel
-- ----------------------------
DROP TABLE IF EXISTS `tbl_left_rear_wheel`;
CREATE TABLE `tbl_left_rear_wheel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `lrw_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `lrw_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_rear_rudder
-- ----------------------------
DROP TABLE IF EXISTS `tbl_rear_rudder`;
CREATE TABLE `tbl_rear_rudder`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `rr_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `rr_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_repair_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_repair_record`;
CREATE TABLE `tbl_repair_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆编号',
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间yyyy-MM-dd',
  `module` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `module_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块编号',
  `mon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间yyyy-MM',
  `type` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_right_front_wheel
-- ----------------------------
DROP TABLE IF EXISTS `tbl_right_front_wheel`;
CREATE TABLE `tbl_right_front_wheel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `rfw_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `rfw_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_right_rear_wheel
-- ----------------------------
DROP TABLE IF EXISTS `tbl_right_rear_wheel`;
CREATE TABLE `tbl_right_rear_wheel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `rrw_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `rrw_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_silk_sleeve
-- ----------------------------
DROP TABLE IF EXISTS `tbl_silk_sleeve`;
CREATE TABLE `tbl_silk_sleeve`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `car_serial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属车辆编号',
  `ss_repairtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修时间',
  `ss_repairtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_user_account
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_account`;
CREATE TABLE `tbl_user_account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_remove` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否移除? 0存在 1删除',
  `serial` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体编号',
  `sub_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `account_pic` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `real_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户身份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
