SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                             `admin_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员Id',
                             `admin_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                             `admin_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                             `admin_privilege` int(11) NOT NULL COMMENT '角色\r\n二进制表示权限\r\n1-系管理\r\n2-专业管理\r\n4-班级管理\r\n8-用户管理\r\n16-教师管理\r\n32-活动管理\r\n64-选课管理\r\n128-管理员管理',
                             PRIMARY KEY (`admin_id`) USING BTREE,
                             UNIQUE INDEX `idx_admin_username`(`admin_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '111111', 255);
INSERT INTO `admin` VALUES (2, 'admintest', '111111', 96);
INSERT INTO `admin` VALUES (3, 'admintest3', '222222', 96);

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
                           `activity_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '活动Id',
                           `activity_teacher_id` int(10) UNSIGNED NOT NULL COMMENT '发起人Id',
                           `activity_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动名称',
                           `activity_grade` int(10) UNSIGNED NOT NULL COMMENT '授课年级',
                           `activity_time` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课时间 星期几-第几节-几节课',
                           `activity_location` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课地址',
                           `activity_credit` int(10) UNSIGNED NOT NULL COMMENT '学分',
                           `activity_selected_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已选人数',
                           `activity_max_size` int(10) UNSIGNED NOT NULL COMMENT '最大容量',
                           `activity_exam_date` datetime(0) NULL DEFAULT NULL COMMENT '考试时间',
                           `activity_exam_location` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '考试地点',
                           PRIMARY KEY (`activity_id`) USING BTREE,
                           INDEX `fk_activity_teacher_id`(`activity_teacher_id`) USING BTREE,
                           INDEX `idx_activity_name`(`activity_name`) USING BTREE,
                           CONSTRAINT `fk_activity_teacher_id` FOREIGN KEY (`activity_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, 1, '游泳', 2017, '1-1-2', '北京', 5, 18, 50, NULL, NULL);
INSERT INTO `activity` VALUES (2, 1, '爬山', 2019, '1-3-2', '武汉', 4, 0, 30, NULL, NULL);
INSERT INTO `activity` VALUES (3, 1, '郊游', 2017, '2-3-2', '北京', 2, 1, 50, NULL, NULL);
INSERT INTO `activity` VALUES (4, 1, '骑行', 2017, '5-5-3', '武汉', 2, 0, 1, NULL, NULL);
INSERT INTO `activity` VALUES (5, 1, '野炊', 2017, '3-9-2', '北京', 3, 0, 10, NULL, NULL);

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
                             `class_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '班级Id',
                             `class_major_id` int(10) UNSIGNED NOT NULL COMMENT '专业Id',
                             `class_grade` int(10) UNSIGNED NOT NULL COMMENT '年级',
                             `class_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班级名称',
                             PRIMARY KEY (`class_id`) USING BTREE,
                             INDEX `fk_major_id`(`class_major_id`) USING BTREE,
                             INDEX `idx_class_name`(`class_name`) USING BTREE,
                             CONSTRAINT `fk_major_id` FOREIGN KEY (`class_major_id`) REFERENCES `major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 1, 2017, '计信1班');
INSERT INTO `class` VALUES (2, 1, 2019, '计信1班');
INSERT INTO `class` VALUES (3, 4, 2017, '数学1班');
INSERT INTO `class` VALUES (4, 5, 2017, '测试班级1');
INSERT INTO `class` VALUES (5, 5, 2017, '测试班级2');
INSERT INTO `class` VALUES (6, 5, 2017, '测试班级3');
INSERT INTO `class` VALUES (7, 5, 2017, '测试班级4');
INSERT INTO `class` VALUES (8, 5, 2017, '测试班级5');
INSERT INTO `class` VALUES (9, 5, 2017, '测试班级6');
INSERT INTO `class` VALUES (10, 5, 2017, '测试班级7');
INSERT INTO `class` VALUES (11, 5, 2017, '测试班级8');
INSERT INTO `class` VALUES (12, 5, 2017, '测试班级9');
INSERT INTO `class` VALUES (13, 5, 2017, '测试班级10');
INSERT INTO `class` VALUES (14, 5, 2019, '演示班级1');
INSERT INTO `class` VALUES (15, 5, 2019, '演示班级2');
INSERT INTO `class` VALUES (16, 5, 2019, '演示班级3');
INSERT INTO `class` VALUES (17, 5, 2019, '演示班级4');
INSERT INTO `class` VALUES (18, 5, 2019, '演示班级5');
INSERT INTO `class` VALUES (19, 5, 2019, '演示班级6');
INSERT INTO `class` VALUES (20, 5, 2019, '演示班级7');
INSERT INTO `class` VALUES (21, 5, 2019, '演示班级8');
INSERT INTO `class` VALUES (22, 5, 2019, '演示班级9');
INSERT INTO `class` VALUES (23, 5, 2019, '演示班级10');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
                                  `department_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系Id',
                                  `department_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系名称',
                                  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '计算机系');
INSERT INTO `department` VALUES (2, '数学系');
INSERT INTO `department` VALUES (3, '物理系');
INSERT INTO `department` VALUES (4, '化学系');
INSERT INTO `department` VALUES (5, '测试系1');
INSERT INTO `department` VALUES (6, '测试系2');
INSERT INTO `department` VALUES (7, '测试系3');
INSERT INTO `department` VALUES (8, '测试系4');
INSERT INTO `department` VALUES (9, '测试系5');
INSERT INTO `department` VALUES (10, '测试系6');
INSERT INTO `department` VALUES (11, '测试系7');
INSERT INTO `department` VALUES (12, '测试系8');
INSERT INTO `department` VALUES (13, '测试系9');
INSERT INTO `department` VALUES (14, '测试系10');
INSERT INTO `department` VALUES (15, '临时系1');
INSERT INTO `department` VALUES (16, '临时系2');
INSERT INTO `department` VALUES (17, '临时系3');
INSERT INTO `department` VALUES (18, '临时系4');
INSERT INTO `department` VALUES (19, '临时系5');
INSERT INTO `department` VALUES (20, '临时系6');
INSERT INTO `department` VALUES (21, '临时系7');
INSERT INTO `department` VALUES (22, '临时系8');
INSERT INTO `department` VALUES (23, '临时系9');
INSERT INTO `department` VALUES (24, '临时系10');
INSERT INTO `department` VALUES (25, '演示系1');
INSERT INTO `department` VALUES (26, '演示系2');
INSERT INTO `department` VALUES (27, '演示系3');
INSERT INTO `department` VALUES (28, '演示系4');
INSERT INTO `department` VALUES (29, '演示系5');
INSERT INTO `department` VALUES (30, '演示系6');
INSERT INTO `department` VALUES (31, '演示系7');
INSERT INTO `department` VALUES (32, '演示系8');
INSERT INTO `department` VALUES (33, '演示系9');
INSERT INTO `department` VALUES (34, '演示系10');
INSERT INTO `department` VALUES (35, '演示系11');
INSERT INTO `department` VALUES (36, '演示系12');
INSERT INTO `department` VALUES (37, '演示系13');
INSERT INTO `department` VALUES (38, '演示系14');
INSERT INTO `department` VALUES (39, '演示系15');
INSERT INTO `department` VALUES (40, '演示系16');
INSERT INTO `department` VALUES (41, '演示系17');
INSERT INTO `department` VALUES (42, '演示系18');
INSERT INTO `department` VALUES (43, '演示系19');
INSERT INTO `department` VALUES (44, '演示系20');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
                             `major_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '专业Id',
                             `major_department_id` int(10) UNSIGNED NOT NULL COMMENT '系Id',
                             `major_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '专业名称',
                             PRIMARY KEY (`major_id`) USING BTREE,
                             INDEX `fk_major_department_id`(`major_department_id`) USING BTREE,
                             INDEX `idx_major_name`(`major_name`) USING BTREE,
                             CONSTRAINT `fk_major_department_id` FOREIGN KEY (`major_department_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, 1, '计算机科学与技术');
INSERT INTO `major` VALUES (2, 1, '软件工程');
INSERT INTO `major` VALUES (3, 1, '信息工程');
INSERT INTO `major` VALUES (4, 2, '应用数学');
INSERT INTO `major` VALUES (5, 2, '数学师范');
INSERT INTO `major` VALUES (6, 5, '测试专业1');
INSERT INTO `major` VALUES (7, 5, '测试专业2');
INSERT INTO `major` VALUES (8, 5, '测试专业3');
INSERT INTO `major` VALUES (9, 5, '测试专业4');
INSERT INTO `major` VALUES (10, 5, '测试专业5');
INSERT INTO `major` VALUES (11, 5, '测试专业6');
INSERT INTO `major` VALUES (12, 5, '测试专业7');
INSERT INTO `major` VALUES (13, 5, '测试专业8');
INSERT INTO `major` VALUES (14, 5, '测试专业9');
INSERT INTO `major` VALUES (15, 5, '测试专业10');
INSERT INTO `major` VALUES (16, 6, '临时专业1');
INSERT INTO `major` VALUES (17, 6, '临时专业2');
INSERT INTO `major` VALUES (18, 6, '临时专业3');
INSERT INTO `major` VALUES (19, 6, '临时专业4');
INSERT INTO `major` VALUES (20, 6, '临时专业5');
INSERT INTO `major` VALUES (21, 6, '临时专业6');
INSERT INTO `major` VALUES (22, 6, '临时专业7');
INSERT INTO `major` VALUES (23, 6, '临时专业8');
INSERT INTO `major` VALUES (24, 6, '临时专业9');
INSERT INTO `major` VALUES (25, 6, '临时专业10');
INSERT INTO `major` VALUES (26, 7, '演示专业1');
INSERT INTO `major` VALUES (27, 7, '演示专业2');
INSERT INTO `major` VALUES (28, 7, '演示专业3');
INSERT INTO `major` VALUES (29, 7, '演示专业4');
INSERT INTO `major` VALUES (30, 7, '演示专业5');
INSERT INTO `major` VALUES (31, 7, '演示专业6');
INSERT INTO `major` VALUES (32, 7, '演示专业7');
INSERT INTO `major` VALUES (33, 7, '演示专业8');
INSERT INTO `major` VALUES (34, 7, '演示专业9');
INSERT INTO `major` VALUES (35, 7, '演示专业10');
INSERT INTO `major` VALUES (36, 7, '演示专业11');
INSERT INTO `major` VALUES (37, 7, '演示专业12');
INSERT INTO `major` VALUES (38, 7, '演示专业13');
INSERT INTO `major` VALUES (39, 7, '演示专业14');
INSERT INTO `major` VALUES (40, 7, '演示专业15');
INSERT INTO `major` VALUES (41, 7, '演示专业16');
INSERT INTO `major` VALUES (42, 7, '演示专业17');
INSERT INTO `major` VALUES (43, 7, '演示专业18');
INSERT INTO `major` VALUES (44, 7, '演示专业19');
INSERT INTO `major` VALUES (45, 7, '演示专业20');

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`  (
                               `consumer_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户Id',
                               `consumer_class_id` int(10) UNSIGNED NOT NULL COMMENT '班级Id',
                               `consumer_number` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
                               `consumer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
                               `consumer_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                               `consumer_email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
                               `consumer_birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
                               `consumer_sex` tinyint(1) UNSIGNED NOT NULL COMMENT '性别',
                               `consumer_last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时间',
                               PRIMARY KEY (`consumer_id`) USING BTREE,
                               INDEX `fk_consumer_class_id`(`consumer_class_id`) USING BTREE,
                               UNIQUE INDEX `idx_consumer_number`(`consumer_number`) USING BTREE,
                               INDEX `idx_consumer_name`(`consumer_name`) USING BTREE,
                               CONSTRAINT `fk_consumer_class_id` FOREIGN KEY (`consumer_class_id`) REFERENCES `class` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumer
-- ----------------------------
INSERT INTO `consumer` VALUES (1, 1, '201711010001', '李雨轩', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, '1998-08-19 16:09:47', 1, '2019-12-16 17:16:47');
INSERT INTO `consumer` VALUES (2, 1, '201711010002', '宋健', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (3, 1, '201711010003', '李同学1', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (4, 1, '201711010004', '李同学2', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (5, 1, '201711010005', '李同学3', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (6, 1, '201711010006', '李同学4', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (7, 1, '201711010007', '李同学5', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (8, 1, '201711010008', '李同学6', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (9, 1, '201711010009', '李同学7', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (10, 1, '201711010010', '李同学8', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (11, 1, '201711010011', '李同学9', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 0, NULL);
INSERT INTO `consumer` VALUES (12, 1, '201711010012', '张同学1', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (13, 1, '201711010013', '张同学2', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (14, 1, '201711010014', '张同学3', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (15, 1, '201711010015', '张同学4', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (16, 1, '201711010016', '张同学5', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (17, 1, '201711010017', '张同学6', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (18, 1, '201711010018', '张同学7', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (19, 3, '201711020001', '王同学1', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (20, 3, '201711020002', '王同学2', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (21, 3, '201711020003', '王同学3', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (22, 3, '201711020004', '王同学4', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (23, 3, '201711020005', '王同学5', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (24, 3, '201711020006', '王同学6', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (25, 3, '201711020007', '王同学7', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (26, 3, '201711020008', '王同学8', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (27, 3, '201711020009', '王同学9', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);
INSERT INTO `consumer` VALUES (28, 3, '201711020010', '王同学10', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for consumer_activity
-- ----------------------------
DROP TABLE IF EXISTS `consumer_activity`;
CREATE TABLE `consumer_activity`  (
                                      `sc_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选课Id',
                                      `sc_consumer_id` int(10) UNSIGNED NOT NULL COMMENT '用户Id',
                                      `sc_activity_id` int(10) UNSIGNED NOT NULL COMMENT '活动Id',
                                      `sc_daily_score` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '日常表现分',
                                      `sc_exam_score` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '期末测试分',
                                      `sc_score` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '总成绩',
                                      PRIMARY KEY (`sc_id`) USING BTREE,
                                      INDEX `fk_sc_activity_id`(`sc_activity_id`) USING BTREE,
                                      INDEX `fk_sc_consumer_id`(`sc_consumer_id`) USING BTREE,
                                      CONSTRAINT `fk_sc_activity_id` FOREIGN KEY (`sc_activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                      CONSTRAINT `fk_sc_consumer_id` FOREIGN KEY (`sc_consumer_id`) REFERENCES `consumer` (`consumer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumer_activity
-- ----------------------------
INSERT INTO `consumer_activity` VALUES (1, 1, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (2, 2, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (3, 3, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (4, 4, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (5, 5, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (6, 6, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (7, 7, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (8, 8, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (9, 9, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (10, 10, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (11, 11, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (12, 12, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (13, 13, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (14, 14, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (15, 15, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (16, 16, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (17, 17, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (18, 18, 1, NULL, NULL, NULL);
INSERT INTO `consumer_activity` VALUES (19, 1, 3, 98, 100, 99);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
                               `teacher_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教师Id',
                               `teacher_department_id` int(10) UNSIGNED NOT NULL COMMENT '系Id',
                               `teacher_number` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工号',
                               `teacher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师姓名',
                               `teacher_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                               PRIMARY KEY (`teacher_id`) USING BTREE,
                               INDEX `fk_teacher_department_id`(`teacher_department_id`) USING BTREE,
                               UNIQUE INDEX `idx_teacher_number`(`teacher_number`) USING BTREE,
                               CONSTRAINT `fk_teacher_department_id` FOREIGN KEY (`teacher_department_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 1, '201711010001', '张三', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (2, 3, '201711020001', '宋老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (3, 1, '201711010002', '宋老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (4, 1, '201711010003', '张老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (5, 1, '201711010004', '吕老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (6, 1, '201711010005', '王老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (7, 1, '201711010006', '丁老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (8, 1, '201711010007', '高老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');
INSERT INTO `teacher` VALUES (9, 1, '201711010008', '赵老师', '81a5f5a9bfde4cdcb5b9fe1f8508df2a');

SET FOREIGN_KEY_CHECKS = 1;
