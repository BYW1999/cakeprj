/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50701
Source Host           : localhost:3306
Source Database       : cake

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2018-10-22 09:10:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cake`
-- ----------------------------
DROP TABLE IF EXISTS `cake`;
CREATE TABLE `cake` (
  `cakeid` int(11) NOT NULL AUTO_INCREMENT,
  `cakename` varchar(50) NOT NULL,
  `cakesize` int(11) NOT NULL,
  `cakeintroduce` varchar(1024) DEFAULT NULL,
  `cakeprice` int(11) NOT NULL,
  `cakediscount` int(11) DEFAULT NULL,
  `bigpic` varchar(1024) NOT NULL,
  `smapic1` varchar(1024) NOT NULL,
  `smapic2` varchar(1024) NOT NULL,
  `smapic3` varchar(1024) DEFAULT NULL,
  `cakerate` int(11) DEFAULT NULL,
  `tag` varchar(1024) DEFAULT NULL,
  `typeid` int(50) NOT NULL,
  PRIMARY KEY (`cakeid`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cake
-- ----------------------------
INSERT INTO `cake` VALUES ('1', '提拉米苏', '5', '水果的芬芳先侵袭你的鼻腔，纯滑扎实的奶油与浓郁稠密的巧克力前后夹击你的味蕾，酥皮与蛋糕揉碎了最后一道防线，夹层中媚红的果酱俘虏了你的感官，接踵而至的回味激荡着灵魂，至死方休', '109', '99', 'images/m1.png', 'images/g3.png', 'images/g3.png', 'images/g3.png', '5', '', '4');
INSERT INTO `cake` VALUES ('2', '马卡龙', '5', '咬第一口你就会有种 哇 我好有钱的味道 第二口更有钱 第三口你就能感觉到什么富翁，全部吃完你的人生就圆满了 耶', '55', '50', 'images/m1.png', 'images/g3.png', 'images/g3.png', 'images/g3.png', null, null, '4');
INSERT INTO `cake` VALUES ('3', '茶拉明', '4', '心情低落？来点甜吧？ \r\n甜的太腻？来块蛋糕吧。 \r\n全天然植物奶油，给你安心的甜蜜； \r\n纯粹低筋面粉，给空虚填满松软； \r\n你不会相信，竟然还有一种蛋糕能美得只想将它摆在案头，看一眼就满足得眉开眼笑。 \r\n心情不美丽？来块蛋糕吧。', '89', '88', 'images/m2.png', 'images/g4.png', 'images/g4.png', 'images/g4.png', null, null, '5');
INSERT INTO `cake` VALUES ('4', '特玛星浪', '3', '它不是最眩、最醒目的，但是总有忠实拥趸对它青睐有加', '126', '116', 'images/m2.png', 'images/g4.png', 'images/g4.png', 'images/g4.png', null, null, '5');
INSERT INTO `cake` VALUES ('5', '嘉莉朵', '5', '香浓诱人的巧克力口味；柔软的口感、甜蜜的味道,完美的全巧克力蛋糕经得起各种口味的挑剔.表面富有曲线美的巧克力花纹与蛋糕的名称相得益彰。', '65', '60', 'images/m2.png', 'images/g4.png', 'images/g4.png', 'images/g4.png', null, null, '5');
INSERT INTO `cake` VALUES ('6', '黑森林', '0', '油香浓郁、口感深香有回味,吃在口中香软诱人,自有一种独特风味,令人一品难忘', '78', '75', 'images/m3.png', 'images/g5.png', 'images/g5.png', 'images/g5.png', null, null, '6');
INSERT INTO `cake` VALUES ('7', '布朗尼', '0', '来自大自然的鲜明而清新的粉红色,涂抹在可爱的花朵上,还有灿烂的蝴蝶轻轻驻足。不是童话,却胜似童话。讨好味觉的艺术得到了淋漓尽致的发挥.', '97', '90', 'images/m4.png', 'images/g4.png', 'images/g4.png', 'images/g4.png', null, null, '8');
INSERT INTO `cake` VALUES ('8', '忌廉巴夫', '0', '底层是一圈淡紫色的花边，如一道道美丽的波纹，上层排列着三朵粉红色的花朵，娇艳欲滴，一只浑身雪白的公鸡昂首啼鸣，旁边“生日快乐”四个字闪烁着快乐的光泽', '105', '100', 'images/m5.png', 'images/g6.png', 'images/g6.png', 'images/g6.png', null, null, '9');
INSERT INTO `cake` VALUES ('9', '戚风蛋糕', '0', '粉红色的生日蛋糕，来自大自然的鲜明而清新的粉红色, 涂抹在可爱的几朵粉色的玫瑰花上，还有灿烂的蝴蝶轻轻驻足。不是童话,却胜似童话。真漂亮。讨好味觉的艺术得到了淋漓尽致的发挥', '96', '88', 'images/m6.png', 'images/g7.png', 'images/g7.png', 'images/g7.png', null, null, '7');
INSERT INTO `cake` VALUES ('10', '慕斯', '0', '入口时嫩嫩的，香气扑鼻，滑滑的栗子顺着奶油一下子就吞了进去，甜丝丝的奶油丝毫不滑腻，微微的甜，谁尝了，都绝对会忍不住吃上第二口', '92', '88', 'images/m6.png', 'images/g7.png', 'images/g7.png', 'images/g7.png', null, null, '7');
INSERT INTO `cake` VALUES ('11', '香草布丁', '0', '把盒子拿开，哇，好漂亮的生日蛋糕啊！中间一条蛇懒洋洋地趴在蛋糕中央，黄皮肤，黑点点，黄黑相间。这条蛇高兴地吐着舌头，好像在祝我生日快乐。蛋糕的右半圈有几个红红的草莓，有半个的，也有整个的，多引人注目呀！哟，那边的花儿笑红了脸。蛋糕的周围还绕着一圈白色和粉色的花边，可美了', '45', '39', 'images/m4.png', 'images/s1.png', 'images/s2.png', 'images/s3.png', null, null, '8');
INSERT INTO `cake` VALUES ('12', '焦糖炖蛋', '0', '奶油恋上芝士,香浓的爱意沉浸在芝士的丝滑里,却因同根生而被命运阻隔,于是这份爱恋少了些许甜腻,多了一丝酸楚.幸好,有相思豆的铺撒,让原本凄凉的爱情多了无限温暖', '56', '50', 'images/m7.png', 'images/g3.png', 'images/g3.png', 'images/g3.png', null, null, '10');
INSERT INTO `cake` VALUES ('13', '薄荷雪拔', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '158', '150', 'images/m7.png', 'images/g3.png', 'images/g3.png', 'images/g3.png', null, null, '10');
INSERT INTO `cake` VALUES ('14', '可可芭娜娜', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '176', '169', 'images/m5.png', 'images/g6.png', 'images/g6.png', 'images/g6.png', null, null, '9');
INSERT INTO `cake` VALUES ('15', '笑口早', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '63', '59', 'images/m8.png', 'images/2.png', 'images/2.png', 'images/2.png', null, null, '11');
INSERT INTO `cake` VALUES ('16', '沙华莲', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '85', '79', 'images/m5.png', 'images/g6.png', 'images/g6.png', 'images/g6.png', null, null, '9');
INSERT INTO `cake` VALUES ('17', '糯米糍', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '78', '69', 'images/m1.png', 'images/g6.png', 'images/g6.png', 'images/g6.png', null, null, '4');
INSERT INTO `cake` VALUES ('18', '棉花冰糕', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '56', '49', 'images/m2.png', 'images/g2.png', 'images/g2.png', 'images/g2.png', null, null, '5');
INSERT INTO `cake` VALUES ('19', '华夫饼', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '135', '129', 'images/m2.png', 'images/g2.png', 'images/g2.png', 'images/g2.png', null, null, '5');
INSERT INTO `cake` VALUES ('20', '和风抹茶', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '201', '199', 'images/m3.png', 'images/g9.png', 'images/g9.png', 'images/g9.png', null, null, '6');
INSERT INTO `cake` VALUES ('21', '蔓越莓芝士派', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '99', '89', 'images/m3.png', 'images/g9.png', 'images/g9.png', 'images/g9.png', null, null, '6');
INSERT INTO `cake` VALUES ('22', '纯色相思', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '88', '79', 'images/m2.png', 'images/g10.png', 'images/g10.png', 'images/g10.png', null, null, '5');
INSERT INTO `cake` VALUES ('25', '仙度瑞拉', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '99', '89', 'images/m2.png', 'images/g7.png', 'images/g7.png', 'images/g7.png', null, null, '5');
INSERT INTO `cake` VALUES ('26', '异域慕斯', '0', '油香浓烈、口感深香有回味,吃在口中香软诱人,自有一种奇特风味,令人一品难忘。', '188', '158', 'images/m2.png', 'images/g4.png', 'images/g4.png', 'images/g4.png', null, null, '5');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) DEFAULT NULL,
  `commenttime` date NOT NULL,
  `cakeid` int(11) DEFAULT NULL,
  `usermail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FK_Reference_11` (`usermail`),
  KEY `FK_Reference_4` (`cakeid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '好吃', '2018-10-19', '1', '1434');
INSERT INTO `comment` VALUES ('2', '很好吃', '2018-10-20', '2', '1434');

-- ----------------------------
-- Table structure for `orderlist`
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `usermail` varchar(50) DEFAULT NULL,
  `ordertime` date NOT NULL,
  `addr` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FK_Reference_6` (`usermail`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('2', '15648795', '2018-10-22', '河北师大', '15264895712', '4');
INSERT INTO `orderlist` VALUES ('3', '1546', '2018-10-22', '河北师大', '152275678956', '5');
INSERT INTO `orderlist` VALUES ('1', '1434119041', '2018-10-22', '河北师大', '152275678956', '4');

-- ----------------------------
-- Table structure for `ordermanage`
-- ----------------------------
DROP TABLE IF EXISTS `ordermanage`;
CREATE TABLE `ordermanage` (
  `omid` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) DEFAULT NULL,
  `cakeid` int(11) DEFAULT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`omid`),
  KEY `FK_Reference_2` (`orderid`),
  KEY `FK_Reference_7` (`cakeid`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordermanage
-- ----------------------------
INSERT INTO `ordermanage` VALUES ('8', '3', '1', '1');
INSERT INTO `ordermanage` VALUES ('12', '3', '12', '1');
INSERT INTO `ordermanage` VALUES ('11', '3', '6', '1');
INSERT INTO `ordermanage` VALUES ('10', '3', '5', '3');
INSERT INTO `ordermanage` VALUES ('9', '3', '4', '1');
INSERT INTO `ordermanage` VALUES ('7', '2', '12', '1');
INSERT INTO `ordermanage` VALUES ('6', '2', '6', '1');
INSERT INTO `ordermanage` VALUES ('5', '2', '5', '3');
INSERT INTO `ordermanage` VALUES ('4', '2', '1', '1');
INSERT INTO `ordermanage` VALUES ('3', '1', '6', '1');
INSERT INTO `ordermanage` VALUES ('2', '1', '5', '1');
INSERT INTO `ordermanage` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) DEFAULT NULL,
  `fatypeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`typeid`),
  KEY `FK_Reference_10` (`fatypeid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '水果', '0');
INSERT INTO `type` VALUES ('2', '口味', '0');
INSERT INTO `type` VALUES ('3', '重量', '0');
INSERT INTO `type` VALUES ('4', '草莓', '1');
INSERT INTO `type` VALUES ('5', '蓝莓', '1');
INSERT INTO `type` VALUES ('6', '芒果', '1');
INSERT INTO `type` VALUES ('7', '香蕉', '1');
INSERT INTO `type` VALUES ('8', '巧克力', '2');
INSERT INTO `type` VALUES ('9', '抹茶', '2');
INSERT INTO `type` VALUES ('10', '1KG', '3');
INSERT INTO `type` VALUES ('11', '2KG', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `usermail` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `userfaname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `registertime` date NOT NULL,
  PRIMARY KEY (`usermail`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1529687514@qq.com', '三', '张', '123', '2018-10-15');
INSERT INTO `user` VALUES ('1465893245@qq.com', '四', '李', '456', '2018-03-16');
INSERT INTO `user` VALUES ('1434', '五', '王', '789', '2018-10-17');
INSERT INTO `user` VALUES ('145789', 'yeah', 'liu', '123', '2018-10-17');
INSERT INTO `user` VALUES ('912@qq.com', '幂', '杨', '123', '2018-10-17');
INSERT INTO `user` VALUES ('510@', '恩齐', '曹', '123', '2018-10-17');
