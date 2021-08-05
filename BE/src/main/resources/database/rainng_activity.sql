SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rc_admin
-- ----------------------------
DROP TABLE IF EXISTS `rc_admin`;
CREATE TABLE `rc_admin`  (
  `admin_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员Id',
  `admin_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `admin_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `admin_privilege` int(11) NOT NULL COMMENT '角色\r\n二进制表示权限\r\n1-系管理\r\n2-专业管理\r\n4-班级管理\r\n8-用户管理\r\n16-教师管理\r\n32-活动管理\r\n64-选课管理\r\n128-管理员管理',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `idx_admin_username`(`admin_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_admin
-- ----------------------------
INSERT INTO `rc_admin` VALUES (1, 'admin', '111111', 255);
INSERT INTO `rc_admin` VALUES (2, 'admintest', '111111', 96);
INSERT INTO `rc_admin` VALUES (3, 'admintest3', '222222', 96);

-- ----------------------------
-- Table structure for rc_activity
-- ----------------------------
DROP TABLE IF EXISTS `rc_activity`;
CREATE TABLE `rc_activity`  (
  `activity_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '活动Id',
  `activity_teacher_id` int(10) UNSIGNED NOT NULL COMMENT '发起人Id',
  `activity_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动名称',
  `activity_grade` int(10) UNSIGNED NOT NULL COMMENT '授课年级',
  `activity_time` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课时间 星期几-第几节-几节课',
  `activity_location` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动地址',
  `activity_describe`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动描述',
  `activity_selected_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已选人数',
  `activity_max_size` int(10) UNSIGNED NOT NULL COMMENT '最大容量',
  PRIMARY KEY (`activity_id`) USING BTREE,
  INDEX `fk_activity_teacher_id`(`activity_teacher_id`) USING BTREE,
  INDEX `idx_activity_name`(`activity_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_activity
-- ----------------------------
INSERT INTO `rc_activity` VALUES (1, 1, '游泳', 2017, '1-1-2', '北京', '测试', 18, 50);
INSERT INTO `rc_activity` VALUES (2, 1, '爬山', 2019, '1-3-2', '武汉', '测试', 30, 60);
INSERT INTO `rc_activity` VALUES (3, 1, '郊游', 2017, '2-3-2', '北京', '测试', 1, 50);
INSERT INTO `rc_activity` VALUES (4, 1, '骑行', 2017, '5-5-3', '武汉', '测试', 0, 20);
INSERT INTO `rc_activity` VALUES (5, 1, '野炊', 2017, '3-9-2', '北京', '测试', 0, 10);

-- ----------------------------
-- Table structure for rc_consumer
-- ----------------------------
DROP TABLE IF EXISTS `rc_consumer`;
CREATE TABLE `rc_consumer`  (
  `consumer_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `consumer_number` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `consumer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `consumer_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `consumer_email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `consumer_birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `consumer_sex` tinyint(1) UNSIGNED NOT NULL COMMENT '性别',
  `consumer_last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`consumer_id`) USING BTREE,
  UNIQUE INDEX `idx_consumer_number`(`consumer_number`) USING BTREE,
  INDEX `idx_consumer_name`(`consumer_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_consumer
-- ----------------------------
INSERT INTO `rc_consumer` VALUES (1, '201711010001', '李雨轩', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, '1998-08-19 16:09:47', 1, '2019-12-16 17:16:47');
INSERT INTO `rc_consumer` VALUES (2, '201711010002', '宋健', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (3, '201711010003', '李同学1', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (4, '201711010004', '李同学2', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (5, '201711010005', '李同学3', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (6, '201711010006', '李同学4', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (7, '201711010007', '李同学5', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (8, '201711010008', '李同学6', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (9, '201711010009', '李同学7', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (10, '201711010010', '李同学8', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (11, '201711010011', '李同学9', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `rc_consumer` VALUES (12, '201711010012', '张同学1', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (13, '201711010013', '张同学2', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (14, '201711010014', '张同学3', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (15, '201711010015', '张同学4', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (16, '201711010016', '张同学5', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (17, '201711010017', '张同学6', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (18, '201711010018', '张同学7', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (19, '201711020001', '王同学1', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (20, '201711020002', '王同学2', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (21, '201711020003', '王同学3', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (22, '201711020004', '王同学4', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (23, '201711020005', '王同学5', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (24, '201711020006', '王同学6', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (25, '201711020007', '王同学7', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (26, '201711020008', '王同学8', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (27, '201711020009', '王同学9', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `rc_consumer` VALUES (28, '201711020010', '王同学10', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for rc_consumer_activity
-- ----------------------------
DROP TABLE IF EXISTS `rc_consumer_activity`;
CREATE TABLE `rc_consumer_activity`  (
  `sc_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选课Id',
  `sc_consumer_id` int(10) UNSIGNED NOT NULL COMMENT '用户Id',
  `sc_activity_id` int(10) UNSIGNED NOT NULL COMMENT '活动Id',
  `sc_daily_score` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '日常表现分',
  `sc_exam_score` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '期末测试分',
  `sc_score` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '总成绩',
  PRIMARY KEY (`sc_id`) USING BTREE,
  INDEX `fk_sc_activity_id`(`sc_activity_id`) USING BTREE,
  INDEX `fk_sc_consumer_id`(`sc_consumer_id`) USING BTREE,
  CONSTRAINT `fk_sc_activity_id` FOREIGN KEY (`sc_activity_id`) REFERENCES `rc_activity` (`activity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sc_consumer_id` FOREIGN KEY (`sc_consumer_id`) REFERENCES `rc_consumer` (`consumer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_consumer_activity
-- ----------------------------
INSERT INTO `rc_consumer_activity` VALUES (1, 1, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (2, 2, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (3, 3, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (4, 4, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (5, 5, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (6, 6, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (7, 7, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (8, 8, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (9, 9, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (10, 10, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (11, 11, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (12, 12, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (13, 13, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (14, 14, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (15, 15, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (16, 16, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (17, 17, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (18, 18, 1, NULL, NULL, NULL);
INSERT INTO `rc_consumer_activity` VALUES (19, 1, 3, 98, 100, 99);

-- ----------------------------
-- Table structure for rc_teacher
-- ----------------------------
DROP TABLE IF EXISTS `rc_teacher`;
CREATE TABLE `rc_teacher`  (
  `teacher_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教师Id',
  `teacher_number` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工号',
  `teacher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师姓名',
  `teacher_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  UNIQUE INDEX `idx_teacher_number`(`teacher_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_teacher
-- ----------------------------
INSERT INTO `rc_teacher` VALUES (1, '201711010001', '张三', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (2, '201711020001', '宋老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (3, '201711010002', '宋老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (4, '201711010003', '张老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (5, '201711010004', '吕老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (6, '201711010005', '王老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (7, '201711010006', '丁老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (8, '201711010007', '高老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `rc_teacher` VALUES (9, '201711010008', '赵老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');

SET FOREIGN_KEY_CHECKS = 1;
