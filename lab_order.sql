/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : lab_order

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 17/03/2024 16:53:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_msg
-- ----------------------------
DROP TABLE IF EXISTS `admin_msg`;
CREATE TABLE `admin_msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_msg
-- ----------------------------
INSERT INTO `admin_msg` VALUES (1, 'admin', '123456');
INSERT INTO `admin_msg` VALUES (2, 'admin1', '123');
INSERT INTO `admin_msg` VALUES (3, 'admin2', '123');
INSERT INTO `admin_msg` VALUES (4, 'admin3', '123');
INSERT INTO `admin_msg` VALUES (5, 'admin4', '123');

-- ----------------------------
-- Table structure for class_msg
-- ----------------------------
DROP TABLE IF EXISTS `class_msg`;
CREATE TABLE `class_msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '班级' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class_msg
-- ----------------------------
INSERT INTO `class_msg` VALUES (1, '班级名0');
INSERT INTO `class_msg` VALUES (2, '班级名1');
INSERT INTO `class_msg` VALUES (3, '班级名2');
INSERT INTO `class_msg` VALUES (4, '班级名3');
INSERT INTO `class_msg` VALUES (5, '班级名4');

-- ----------------------------
-- Table structure for college_msg
-- ----------------------------
DROP TABLE IF EXISTS `college_msg`;
CREATE TABLE `college_msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '学院' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of college_msg
-- ----------------------------
INSERT INTO `college_msg` VALUES (1, '学院名0');
INSERT INTO `college_msg` VALUES (2, '学院名1');
INSERT INTO `college_msg` VALUES (3, '学院名2');
INSERT INTO `college_msg` VALUES (4, '学院名3');
INSERT INTO `college_msg` VALUES (5, '学院名4');

-- ----------------------------
-- Table structure for course_msg
-- ----------------------------
DROP TABLE IF EXISTS `course_msg`;
CREATE TABLE `course_msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程名',
  `caddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '上课地址',
  `class_id` int(11) NULL DEFAULT NULL COMMENT '班级',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师ID',
  `order_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预约日期',
  `course_time` int(11) NULL DEFAULT NULL COMMENT '上课时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_msg
-- ----------------------------
INSERT INTO `course_msg` VALUES (1, '课程名0', '上课地址0', 1, 3, '2023-05-17', 1);
INSERT INTO `course_msg` VALUES (2, '课程名1', '上课地址1', 4, 4, '2023-05-18', 3);
INSERT INTO `course_msg` VALUES (3, '课程名2', '上课地址2', 4, 3, '2023-05-17', 5);
INSERT INTO `course_msg` VALUES (4, '课程名3', '上课地址3', 4, 3, '2023-05-18', 3);
INSERT INTO `course_msg` VALUES (5, '课程名4', '上课地址4', 2, 3, '2023-05-18', 4);

-- ----------------------------
-- Table structure for lab_order
-- ----------------------------
DROP TABLE IF EXISTS `lab_order`;
CREATE TABLE `lab_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预约日期',
  `order_time` int(11) NULL DEFAULT NULL COMMENT '预约时间',
  `using_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预约用途',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '实验室ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '实验室预约' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lab_order
-- ----------------------------
INSERT INTO `lab_order` VALUES (1, '2023-05-18', 2, '预约用途0', 1);
INSERT INTO `lab_order` VALUES (2, '2023-05-17', 1, '预约用途1', 5);
INSERT INTO `lab_order` VALUES (3, '2023-05-17', 4, '预约用途2', 3);
INSERT INTO `lab_order` VALUES (4, '2023-05-18', 5, '预约用途3', 3);
INSERT INTO `lab_order` VALUES (5, '2023-05-18', 3, '预约用途4', 2);
INSERT INTO `lab_order` VALUES (6, '2024-03-06', 1, 'ceshi', 3);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `cel_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系电话',
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '实验室管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, 'manage', '123', '姓名0', '13052653265', '2023-05-17 16:04:39');
INSERT INTO `manage` VALUES (2, 'manage1', '123', '姓名1', '13553613261', '2023-05-17 16:04:39');
INSERT INTO `manage` VALUES (3, 'manage2', '123', '姓名2', '13552623265', '2023-05-17 16:04:39');
INSERT INTO `manage` VALUES (4, 'manage3', '123', '姓名3', '13052623165', '2023-05-18 16:04:39');
INSERT INTO `manage` VALUES (5, 'manage4', '123', '姓名4', '13052633163', '2023-05-18 16:04:39');

-- ----------------------------
-- Table structure for order_gather
-- ----------------------------
DROP TABLE IF EXISTS `order_gather`;
CREATE TABLE `order_gather`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `college_id` int(11) NULL DEFAULT NULL COMMENT '学院',
  `course_time` int(11) NULL DEFAULT NULL COMMENT '时段',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3206 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '预约汇总' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_gather
-- ----------------------------
INSERT INTO `order_gather` VALUES (3181, 1, 1, 1);
INSERT INTO `order_gather` VALUES (3182, 1, 2, 1);
INSERT INTO `order_gather` VALUES (3183, 1, 3, 1);
INSERT INTO `order_gather` VALUES (3184, 1, 4, 0);
INSERT INTO `order_gather` VALUES (3185, 1, 5, 1);
INSERT INTO `order_gather` VALUES (3186, 2, 1, 0);
INSERT INTO `order_gather` VALUES (3187, 2, 2, 0);
INSERT INTO `order_gather` VALUES (3188, 2, 3, 0);
INSERT INTO `order_gather` VALUES (3189, 2, 4, 1);
INSERT INTO `order_gather` VALUES (3190, 2, 5, 0);
INSERT INTO `order_gather` VALUES (3191, 3, 1, 0);
INSERT INTO `order_gather` VALUES (3192, 3, 2, 0);
INSERT INTO `order_gather` VALUES (3193, 3, 3, 0);
INSERT INTO `order_gather` VALUES (3194, 3, 4, 1);
INSERT INTO `order_gather` VALUES (3195, 3, 5, 0);
INSERT INTO `order_gather` VALUES (3196, 4, 1, 0);
INSERT INTO `order_gather` VALUES (3197, 4, 2, 0);
INSERT INTO `order_gather` VALUES (3198, 4, 3, 2);
INSERT INTO `order_gather` VALUES (3199, 4, 4, 2);
INSERT INTO `order_gather` VALUES (3200, 4, 5, 0);
INSERT INTO `order_gather` VALUES (3201, 5, 1, 0);
INSERT INTO `order_gather` VALUES (3202, 5, 2, 0);
INSERT INTO `order_gather` VALUES (3203, 5, 3, 0);
INSERT INTO `order_gather` VALUES (3204, 5, 4, 0);
INSERT INTO `order_gather` VALUES (3205, 5, 5, 1);

-- ----------------------------
-- Table structure for room_msg
-- ----------------------------
DROP TABLE IF EXISTS `room_msg`;
CREATE TABLE `room_msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `room_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '实验室名称',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '实验室地点',
  `manage_id` int(11) NULL DEFAULT NULL COMMENT '负责管理员',
  `max_num` int(11) NULL DEFAULT NULL COMMENT '可容纳人数',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `room_type` int(11) NULL DEFAULT NULL COMMENT '实验室类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '实验室' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_msg
-- ----------------------------
INSERT INTO `room_msg` VALUES (1, '讲座名称0', '讲座名称0', 1, 18, '备注0', 2);
INSERT INTO `room_msg` VALUES (2, '讲座名称1', '讲座名称1', 4, 17, '备注1', 2);
INSERT INTO `room_msg` VALUES (3, '讲座名称2', '讲座名称2', 3, 22, '备注2', 2);
INSERT INTO `room_msg` VALUES (4, '讲座名称3', '讲座名称3', 3, 76, '备注3', 1);
INSERT INTO `room_msg` VALUES (5, '讲座名称4', '讲座名称4', 4, 94, '备注4', 1);

-- ----------------------------
-- Table structure for service_msg
-- ----------------------------
DROP TABLE IF EXISTS `service_msg`;
CREATE TABLE `service_msg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `service_nae` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备名',
  `service_status` int(11) NULL DEFAULT NULL COMMENT '设备状态',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '所属实验室',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '实验室设备' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of service_msg
-- ----------------------------
INSERT INTO `service_msg` VALUES (1, '设备名0', 1, 2);
INSERT INTO `service_msg` VALUES (2, '设备名1', 2, 3);
INSERT INTO `service_msg` VALUES (3, '设备名2', 1, 2);
INSERT INTO `service_msg` VALUES (4, '设备名3', 1, 4);
INSERT INTO `service_msg` VALUES (5, '设备名4', 2, 2);

-- ----------------------------
-- Table structure for slab_order
-- ----------------------------
DROP TABLE IF EXISTS `slab_order`;
CREATE TABLE `slab_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `stu_id` int(11) NULL DEFAULT NULL COMMENT '学生ID',
  `stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生学号',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生名',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '实验室ID',
  `app_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '申请原因',
  `college_id` int(11) NULL DEFAULT NULL COMMENT '学生学院',
  `order_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预约日期',
  `order_time` int(11) NULL DEFAULT NULL COMMENT '预约时段',
  `order_status` int(11) NULL DEFAULT NULL COMMENT '预约状态',
  `create_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '学生预约' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of slab_order
-- ----------------------------
INSERT INTO `slab_order` VALUES (1, 1, 'student', '姓名0', 5, '申请原因0', 1, '2023-05-18', 2, 2, '2023-05-18');
INSERT INTO `slab_order` VALUES (2, 2, 'student1', '姓名1', 5, '申请原因1', 5, '2023-05-17', 5, 4, '2023-05-18');
INSERT INTO `slab_order` VALUES (3, 4, 'student3', '姓名3', 1, '申请原因2', 4, '2023-05-18', 3, 4, '2023-05-17');
INSERT INTO `slab_order` VALUES (4, 5, 'student4', '姓名4', 3, '申请原因3', 4, '2023-05-18', 4, 1, '2023-05-17');
INSERT INTO `slab_order` VALUES (5, 3, 'student2', '姓名2', 4, '申请原因4', 4, '2023-05-17', 4, 1, '2023-05-18');
INSERT INTO `slab_order` VALUES (6, 1, 'student', '姓名0', 3, 'ceshi', 1, '2024-03-06', 1, 2, '2024-03-17');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `cel_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别',
  `stu_type` int(11) NULL DEFAULT NULL COMMENT '学生类型',
  `cid` int(11) NULL DEFAULT NULL COMMENT '学院',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级',
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '学生' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'student', '123', '姓名0', '13052653265', '32423422222@qq.com', 1, 1, 1, '班级0', '2023-05-17 16:04:41');
INSERT INTO `student` VALUES (2, 'student1', '123', '姓名1', '13553613261', '32423422222@qq.com', 1, 1, 5, '班级1', '2023-05-18 16:04:41');
INSERT INTO `student` VALUES (3, 'student2', '123', '姓名2', '13552623265', '9523895@qq.com', 1, 2, 4, '班级2', '2023-05-17 16:04:41');
INSERT INTO `student` VALUES (4, 'student3', '123', '姓名3', '13052623165', '9523895@qq.com', 1, 1, 4, '班级3', '2023-05-18 16:04:41');
INSERT INTO `student` VALUES (5, 'student4', '123', '姓名4', '13052633163', '8384388333@qq.com', 2, 2, 4, '班级4', '2023-05-17 16:04:41');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '工号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `cel_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系电话',
  `job_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职称',
  `cid` int(11) NULL DEFAULT NULL COMMENT '所属学院',
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '教师' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'teacher', '123', '姓名0', '13052653265', '职称0', 3, '2023-05-17 16:04:40');
INSERT INTO `teacher` VALUES (2, 'teacher1', '123', '姓名1', '13553613261', '职称1', 2, '2023-05-18 16:04:40');
INSERT INTO `teacher` VALUES (3, 'teacher2', '123', '姓名2', '13552623265', '职称2', 1, '2023-05-18 16:04:40');
INSERT INTO `teacher` VALUES (4, 'teacher3', '123', '姓名3', '13052623165', '职称3', 2, '2023-05-17 16:04:40');
INSERT INTO `teacher` VALUES (5, 'teacher4', '123', '姓名4', '13052633163', '职称4', 4, '2023-05-18 16:04:40');

-- ----------------------------
-- Table structure for tlab_order
-- ----------------------------
DROP TABLE IF EXISTS `tlab_order`;
CREATE TABLE `tlab_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `teacher_id` int(11) NULL DEFAULT NULL COMMENT '教师ID',
  `teacher_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '教师工号',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '教师名',
  `college_id` int(11) NULL DEFAULT NULL COMMENT '学院',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '实验室',
  `course_id` int(11) NULL DEFAULT NULL COMMENT '上课课程',
  `order_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预约原因',
  `order_date` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '预约日期',
  `order_time` int(11) NULL DEFAULT NULL COMMENT '预约时段',
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建时间',
  `order_status` int(11) NULL DEFAULT NULL COMMENT '预约状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '教师实验预约' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tlab_order
-- ----------------------------
INSERT INTO `tlab_order` VALUES (1, 3, 'teacher2', '姓名2', 1, 5, 3, '预约原因0', '2023-05-18', 3, '2023-05-17 16:04:46', 4);
INSERT INTO `tlab_order` VALUES (2, 3, 'teacher2', '姓名2', 1, 2, 1, '预约原因1', '2023-05-18', 5, '2023-05-18 16:04:46', 4);
INSERT INTO `tlab_order` VALUES (3, 5, 'teacher4', '姓名4', 4, 5, 4, '预约原因2', '2023-05-18', 3, '2023-05-17 16:04:46', 2);
INSERT INTO `tlab_order` VALUES (4, 1, 'teacher', '姓名0', 3, 1, 4, '预约原因3', '2023-05-18', 4, '2023-05-17 16:04:46', 1);
INSERT INTO `tlab_order` VALUES (5, 4, 'teacher3', '姓名3', 2, 2, 4, '预约原因4', '2023-05-17', 4, '2023-05-18 16:04:46', 1);

SET FOREIGN_KEY_CHECKS = 1;
