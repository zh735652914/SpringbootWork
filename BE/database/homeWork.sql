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
                             `admin_privilege` int(11) NOT NULL COMMENT '角色\r\n二进制表示权限\r\n1-系管理\r\n2-专业管理\r\n4-班级管理\r\n8-学生管理\r\n16-教师管理\r\n32-课程管理\r\n64-选课管理\r\n128-管理员管理',
                             PRIMARY KEY (`admin_id`) USING BTREE,
                             UNIQUE INDEX `idx_admin_username`(`admin_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_admin
-- ----------------------------
INSERT INTO `rc_admin` VALUES (1, 'admin', '1111111', 255);
INSERT INTO `rc_admin` VALUES (2, 'azure99', '81a5f5a9bfde4cdcb5b9fe1f8508df2a', 96);

-- ----------------------------
-- Table structure for rc_class
-- ----------------------------
DROP TABLE IF EXISTS `rc_class`;
CREATE TABLE `rc_class`  (
                             `class_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '班级Id',
                             `class_major_id` int(10) UNSIGNED NOT NULL COMMENT '专业Id',
                             `class_grade` int(10) UNSIGNED NOT NULL COMMENT '年级',
                             `class_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班级名称',
                             PRIMARY KEY (`class_id`) USING BTREE,
                             INDEX `fk_major_id`(`class_major_id`) USING BTREE,
                             INDEX `idx_class_name`(`class_name`) USING BTREE,
                             CONSTRAINT `fk_major_id` FOREIGN KEY (`class_major_id`) REFERENCES `rc_major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_class
-- ----------------------------
INSERT INTO `rc_class` VALUES (1, 1, 2017, '计信1班');
INSERT INTO `rc_class` VALUES (2, 1, 2019, '计信1班');
INSERT INTO `rc_class` VALUES (3, 4, 2017, '数学1班');
INSERT INTO `rc_class` VALUES (4, 5, 2017, '测试班级1');
INSERT INTO `rc_class` VALUES (5, 5, 2017, '测试班级2');
INSERT INTO `rc_class` VALUES (6, 5, 2017, '测试班级3');
INSERT INTO `rc_class` VALUES (7, 5, 2017, '测试班级4');
INSERT INTO `rc_class` VALUES (8, 5, 2017, '测试班级5');
INSERT INTO `rc_class` VALUES (9, 5, 2017, '测试班级6');
INSERT INTO `rc_class` VALUES (10, 5, 2017, '测试班级7');
INSERT INTO `rc_class` VALUES (11, 5, 2017, '测试班级8');
INSERT INTO `rc_class` VALUES (12, 5, 2017, '测试班级9');
INSERT INTO `rc_class` VALUES (13, 5, 2017, '测试班级10');
INSERT INTO `rc_class` VALUES (14, 5, 2019, '演示班级1');
INSERT INTO `rc_class` VALUES (15, 5, 2019, '演示班级2');
INSERT INTO `rc_class` VALUES (16, 5, 2019, '演示班级3');
INSERT INTO `rc_class` VALUES (17, 5, 2019, '演示班级4');
INSERT INTO `rc_class` VALUES (18, 5, 2019, '演示班级5');
INSERT INTO `rc_class` VALUES (19, 5, 2019, '演示班级6');
INSERT INTO `rc_class` VALUES (20, 5, 2019, '演示班级7');
INSERT INTO `rc_class` VALUES (21, 5, 2019, '演示班级8');
INSERT INTO `rc_class` VALUES (22, 5, 2019, '演示班级9');
INSERT INTO `rc_class` VALUES (23, 5, 2019, '演示班级10');