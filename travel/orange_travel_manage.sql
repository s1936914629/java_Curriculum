-- 创建数据库
-- CREATE DATABASE orange_travel_manage;
-- 设置编码格式
SET NAMES utf8mb4;

-- 取消外键约束
SET FOREIGN_KEY_CHECKS = 0;

-- 旅游线路表
DROP TABLE IF EXISTS `tourism_line`;
CREATE TABLE `tourism_line`  (
  `route_num` int NOT NULL AUTO_INCREMENT COMMENT '线路号',
  `origin` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '起点城市',
  `destination` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目的城市',
  `day_num` int NOT NULL COMMENT '旅程天数',
  `attractions` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主要景点',
  PRIMARY KEY (`route_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- 旅游线路记录
INSERT INTO `tourism_line` VALUES (1, '重庆', '丽江', 10, '丽江古城、玉龙雪山、束河古镇、拉市海湿地公园');
INSERT INTO `tourism_line` VALUES (2, '重庆', '南京', 5, '玄武湖、中山林、莫愁湖、金牛湖、玄武湖');
INSERT INTO `tourism_line` VALUES (3, '重庆', '三亚', 10, '亚龙湾、椰梦长廊、南山文化旅游区、天涯海角');
INSERT INTO `tourism_line` VALUES (4, '重庆', '长沙', 5, '橘子洲风景区、岳麓山风景区、爱晚亭、橘子洲大桥');
INSERT INTO `tourism_line` VALUES (5, '重庆', '上海', 5, '世博园、外滩、东方明珠电视塔、迪士尼');
INSERT INTO `tourism_line` VALUES (6, '重庆', '武汉', 6, '黄鹤楼、武汉长江大桥、东湖生态旅游风景区');
INSERT INTO `tourism_line` VALUES (7, '重庆', '甘肃', 7, '敦煌莫高窟、西北魔鬼城、甘南草原');
INSERT INTO `tourism_line` VALUES (8, '重庆', '内蒙古', 8, '呼伦贝尔大草原、阿尔山');
INSERT INTO `tourism_line` VALUES (9, '重庆', '成都', 3, '都江堰、武侯祠、宽窄巷子');
INSERT INTO `tourism_line` VALUES (10, '重庆', '拉萨', 11, '布达拉宫、纳木错、布达拉广场、巴廊街');
INSERT INTO `tourism_line` VALUES (11, '重庆', '苏州', 4, '平江路、七里山塘、周庄古镇、虎丘山风景区');
INSERT INTO `tourism_line` VALUES (12, '重庆', '遵义', 14, '四洞沟景区、红石野古风景区');
INSERT INTO `tourism_line` VALUES (13, '重庆', '西安', 8, '西安鼓楼、华清宫、回民街');
INSERT INTO `tourism_line` VALUES (14, '重庆', '北京', 9, '故宫、天安门广场、八达岭长城、鸟巢');
INSERT INTO `tourism_line` VALUES (15, '重庆', '桂林', 6, '阳朔西街、漓江、遇龙河、十里画廊');
INSERT INTO `tourism_line` VALUES (16, '重庆', '杭州', 5, '西湖风景区、雷峰塔、灵隐寺');

-- 游客表
DROP TABLE IF EXISTS `tourist`;
CREATE TABLE `tourist`  (
  `tourist_num` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `tourist_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tourist_sex` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tourist_age` int NOT NULL,
  `tourist_idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tourist_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tourist_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_num` int NOT NULL,
  `accompanied` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accommodation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tourist_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 211032 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- 游客记录
INSERT INTO `tourist` VALUES (211001, 211001, '卢冉念', '女', 22, '532622200101231928', '重庆市xx区xx大道xx号', '14769280074', 1, '无', '无');
INSERT INTO `tourist` VALUES (211002, 211002, '岩奔', '女', 20, '532823200010293936', '重庆市xx区xx大道xx号', '14788043901', 2, '无', '无');
INSERT INTO `tourist` VALUES (211003, 211003, '肖明安', '男', 21, '513426199912141017', '重庆市xx区xx大道xx号', '15559729206', 1, '无', '无');
INSERT INTO `tourist` VALUES (211004, 211004, '羊禹飞', '男', 21, '532524200001243814', '重庆市xx区xx大道xx号', '13354953047', 1, '无', '无');
INSERT INTO `tourist` VALUES (211005, 211005, '朱洪春', '男', 19, '530622200104132245', '重庆市xx区xx大道xx号', '17387067363', 2, '无', '无');
INSERT INTO `tourist` VALUES (211006, 211006, '罗天飞', '男', 21, '532123199906201615', '重庆市xx区xx大道xx号', '15587008445', 2, '无', '无');
INSERT INTO `tourist` VALUES (211007, 211007, '罗建英', '女', 25, '533421199506040722', '重庆市xx区xx大道xx号', '18508719791', 7, '无', '无');
INSERT INTO `tourist` VALUES (211008, 211008, '杨春明', '男', 22, '532626199804192355', '重庆市xx区xx大道xx号', '19989969935', 8, '无', '无');
INSERT INTO `tourist` VALUES (211009, 211009, '冯润泽', '男', 20, '532626199804192000', '重庆市xx区xx大道xx号', '18687291160', 9, '无', '无');
INSERT INTO `tourist` VALUES (211010, 211010, '白简者', '男', 20, '532531200004010219', '重庆市xx区xx大道xx号', '18087312037', 3, '无', '无');
INSERT INTO `tourist` VALUES (211011, 211011, '张子鹏', '男', 20, '533024200010154518', '重庆市xx区xx大道xx号', '18887533732', 2, '无', '无');
INSERT INTO `tourist` VALUES (211012, 211012, '王娇', '女', 19, '530326200103183621', '重庆市xx区xx大道xx号', '15559829547', 2, '无', '无');
INSERT INTO `tourist` VALUES (211013, 211013, '银源福', '男', 19, '532123200107160058', '重庆市xx区xx大道xx号', '13097454119', 2, '无', '无');
INSERT INTO `tourist` VALUES (211014, 211014, '饶文丽', '女', 20, '533522200010122625', '重庆市xx区xx大道xx号', '15559887405', 2, '无', '无');
INSERT INTO `tourist` VALUES (211015, 211015, '郭超', '男', 19, '532129200105153135', '重庆市xx区xx大道xx号', '15381047655', 2, '无', '无');
INSERT INTO `tourist` VALUES (211016, 211016, '黄继国', '男', 20, '532627200010193913', '重庆市xx区xx大道xx号', '18487808535', 2, '无', '无');
INSERT INTO `tourist` VALUES (211017, 211017, '李鸿媛', '女', 21, '532924199912082122', '重庆市xx区xx大道xx号', '15750218623', 2, '无', '无');
INSERT INTO `tourist` VALUES (211018, 211018, '冷旭涵', '男', 21, '530124199903280818', '重庆市xx区xx大道xx号', '18669029069', 2, '无', '无');
INSERT INTO `tourist` VALUES (211019, 211019, '黄安芮', '女', 20, '53262720001206252X', '重庆市xx区xx大道xx号', '15126708397', 2, '无', '无');

-- 用户表结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户类型',
  `user_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- 用户记录
INSERT INTO `user` VALUES (1, '王飞飞', '123456', '管理员', '未登录');
INSERT INTO `user` VALUES (4, '0', '0', '管理员', '已登录');
INSERT INTO `user` VALUES (12, '111', '111', '游客', '未登录');
INSERT INTO `user` VALUES (13, '222', '222', '游客', '未登录');

-- 打开外键约束
SET FOREIGN_KEY_CHECKS = 1;
