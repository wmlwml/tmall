/*
 Navicat Premium Data Transfer

 Source Server         : 千锋本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : tmall_ssm

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 11/02/2020 13:40:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roles` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', 'administrator');
INSERT INTO `admin` VALUES (2, '111', '698d51a19d8a121ce581499d7b701668', '111');
INSERT INTO `admin` VALUES (3, 'laoyan', '123456', 'administrator');
INSERT INTO `admin` VALUES (4, 'leilei', '123456', 'administrator');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `checked` int(11) NULL DEFAULT NULL COMMENT '是否选择,1=已勾选,0=未勾选',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `price` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (138, 3, 8, 2, NULL, NULL, NULL, NULL);
INSERT INTO `cart` VALUES (154, 3, 23, 6, NULL, NULL, NULL, NULL);
INSERT INTO `cart` VALUES (155, 3, 16, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类的名字',
  `state` int(2) NOT NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '女装 /内衣', 0);
INSERT INTO `category` VALUES (2, '男装 /运动户外', 1);
INSERT INTO `category` VALUES (3, '女鞋 /男鞋 /箱包', 1);
INSERT INTO `category` VALUES (4, '美妆 /个人护理', 1);
INSERT INTO `category` VALUES (5, '腕表 /眼镜 /珠宝饰品', 1);
INSERT INTO `category` VALUES (6, '手机 /数码 /电脑办公', 1);
INSERT INTO `category` VALUES (7, '母婴玩具', 1);
INSERT INTO `category` VALUES (8, '零食 /茶酒 /进口食品', 1);
INSERT INTO `category` VALUES (9, '生鲜水果', 1);
INSERT INTO `category` VALUES (10, '大家电 /生活电器', 1);
INSERT INTO `category` VALUES (11, '家具建材', 1);
INSERT INTO `category` VALUES (12, '汽车 /配件 /用品', 1);
INSERT INTO `category` VALUES (13, '家纺 /家饰 /鲜花', 1);
INSERT INTO `category` VALUES (14, '医药保健', 1);
INSERT INTO `category` VALUES (15, '厨具 /收纳 /宠物', 1);
INSERT INTO `category` VALUES (16, '图书音像', 1);
INSERT INTO `category` VALUES (18, '测试1', 1);
INSERT INTO `category` VALUES (20, '测试3', 0);

-- ----------------------------
-- Table structure for mmall_order
-- ----------------------------
DROP TABLE IF EXISTS `mmall_order`;
CREATE TABLE `mmall_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '订单商品id',
  `payment` decimal(20, 2) NULL DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是元',
  `status` int(10) NULL DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime(0) NULL DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_no_index`(`order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mmall_order
-- ----------------------------
INSERT INTO `mmall_order` VALUES (103, 1491753014256, 1, 25, 13998.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-09 23:50:14', '2017-04-09 23:50:14');
INSERT INTO `mmall_order` VALUES (104, 1491830695216, 1, 26, 13998.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-10 21:24:55', '2017-04-10 21:24:55');
INSERT INTO `mmall_order` VALUES (105, 1492089528889, 1, 29, 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:18:48', '2017-04-13 21:18:48');
INSERT INTO `mmall_order` VALUES (106, 1492090946105, 1, 29, 27894.00, 1, 0, 20, '2017-04-13 21:42:40', NULL, NULL, NULL, '2017-04-13 21:42:26', '2017-04-13 21:42:41');
INSERT INTO `mmall_order` VALUES (107, 1492091003128, 1, 29, 8597.00, 1, 0, 20, '2017-04-13 21:43:38', NULL, NULL, NULL, '2017-04-13 21:43:23', '2017-04-13 21:43:38');
INSERT INTO `mmall_order` VALUES (108, 1492091051313, 1, 29, 1999.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:11', '2017-04-13 21:44:11');
INSERT INTO `mmall_order` VALUES (109, 1492091061513, 1, 29, 6598.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:21', '2017-04-13 21:44:21');
INSERT INTO `mmall_order` VALUES (110, 1492091069563, 1, 29, 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:29', '2017-04-13 21:44:29');
INSERT INTO `mmall_order` VALUES (111, 1492091076073, 1, 29, 4299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:36', '2017-04-13 21:44:36');
INSERT INTO `mmall_order` VALUES (112, 1492091083720, 1, 29, 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:43', '2017-04-13 21:44:43');
INSERT INTO `mmall_order` VALUES (113, 1492091089794, 1, 29, 6999.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:49', '2017-04-13 21:44:49');
INSERT INTO `mmall_order` VALUES (114, 1492091096400, 1, 29, 6598.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:44:56', '2017-04-13 21:44:56');
INSERT INTO `mmall_order` VALUES (115, 1492091102371, 1, 29, 3299.00, 1, 0, 10, NULL, NULL, NULL, NULL, '2017-04-13 21:45:02', '2017-04-13 21:45:02');
INSERT INTO `mmall_order` VALUES (116, 1492091110004, 1, 29, 8598.00, 1, 0, 40, '2017-04-13 21:55:16', '2017-04-13 21:55:31', NULL, NULL, '2017-04-13 21:45:09', '2017-04-13 21:55:31');
INSERT INTO `mmall_order` VALUES (117, 1492091141269, 1, 29, 22894.00, 1, 0, 20, '2017-04-13 21:46:06', NULL, NULL, NULL, '2017-04-13 21:45:41', '2017-04-13 21:46:07');

-- ----------------------------
-- Table structure for mmall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mmall_order_item`;
CREATE TABLE `mmall_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) NULL DEFAULT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片地址',
  `current_unit_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '商品数量',
  `total_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_no_index`(`order_no`) USING BTREE,
  INDEX `order_no_user_id_index`(`user_id`, `order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 135 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mmall_order_item
-- ----------------------------
INSERT INTO `mmall_order_item` VALUES (113, 1, 1491753014256, 26, 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 2, 13998.00, '2017-04-09 23:50:14', '2017-04-09 23:50:14');
INSERT INTO `mmall_order_item` VALUES (114, 1, 1491830695216, 26, 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 2, 13998.00, '2017-04-10 21:24:55', '2017-04-10 21:24:55');
INSERT INTO `mmall_order_item` VALUES (115, 1, 1492089528889, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:18:48', '2017-04-13 21:18:48');
INSERT INTO `mmall_order_item` VALUES (116, 1, 1492090946105, 29, 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 2, 8598.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES (117, 1, 1492090946105, 28, '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 1, 1999.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES (118, 1, 1492090946105, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES (119, 1, 1492090946105, 26, 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 2, 13998.00, '2017-04-13 21:42:26', '2017-04-13 21:42:26');
INSERT INTO `mmall_order_item` VALUES (120, 1, 1492091003128, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 2, 6598.00, '2017-04-13 21:43:23', '2017-04-13 21:43:23');
INSERT INTO `mmall_order_item` VALUES (121, 1, 1492091003128, 28, '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 1, 1999.00, '2017-04-13 21:43:23', '2017-04-13 21:43:23');
INSERT INTO `mmall_order_item` VALUES (122, 1, 1492091051313, 28, '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 1, 1999.00, '2017-04-13 21:44:11', '2017-04-13 21:44:11');
INSERT INTO `mmall_order_item` VALUES (123, 1, 1492091061513, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 2, 6598.00, '2017-04-13 21:44:21', '2017-04-13 21:44:21');
INSERT INTO `mmall_order_item` VALUES (124, 1, 1492091069563, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:44:29', '2017-04-13 21:44:29');
INSERT INTO `mmall_order_item` VALUES (125, 1, 1492091076073, 29, 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 1, 4299.00, '2017-04-13 21:44:36', '2017-04-13 21:44:36');
INSERT INTO `mmall_order_item` VALUES (126, 1, 1492091083720, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:44:43', '2017-04-13 21:44:43');
INSERT INTO `mmall_order_item` VALUES (127, 1, 1492091089794, 26, 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 1, 6999.00, '2017-04-13 21:44:49', '2017-04-13 21:44:49');
INSERT INTO `mmall_order_item` VALUES (128, 1, 1492091096400, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 2, 6598.00, '2017-04-13 21:44:56', '2017-04-13 21:44:56');
INSERT INTO `mmall_order_item` VALUES (129, 1, 1492091102371, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:45:02', '2017-04-13 21:45:02');
INSERT INTO `mmall_order_item` VALUES (130, 1, 1492091110004, 29, 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 2, 8598.00, '2017-04-13 21:45:09', '2017-04-13 21:45:09');
INSERT INTO `mmall_order_item` VALUES (131, 1, 1492091141269, 26, 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', 6999.00, 1, 6999.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');
INSERT INTO `mmall_order_item` VALUES (132, 1, 1492091141269, 27, 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', 'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg', 3299.00, 1, 3299.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');
INSERT INTO `mmall_order_item` VALUES (133, 1, 1492091141269, 29, 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg', 4299.00, 2, 8598.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');
INSERT INTO `mmall_order_item` VALUES (134, 1, 1492091141269, 28, '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg', 1999.00, 2, 3998.00, '2017-04-13 21:45:41', '2017-04-13 21:45:41');

-- ----------------------------
-- Table structure for mmall_shipping
-- ----------------------------
DROP TABLE IF EXISTS `mmall_shipping`;
CREATE TABLE `mmall_shipping`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货固定电话',
  `receiver_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货移动电话',
  `receiver_province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mmall_shipping
-- ----------------------------
INSERT INTO `mmall_shipping` VALUES (4, 13, 'geely', '010', '18688888888', '北京', '北京市', '海淀区', '中关村', '100000', '2017-01-22 14:26:25', '2017-01-22 14:26:25');
INSERT INTO `mmall_shipping` VALUES (7, 17, 'Rosen', '13800138000', '13800138000', '北京', '北京', NULL, '中关村', '100000', '2017-03-29 12:11:01', '2017-03-29 12:11:01');
INSERT INTO `mmall_shipping` VALUES (29, 1, '吉利', '13800138000', '13800138000', '北京', '北京', '海淀区', '海淀区中关村', '100000', '2017-04-09 18:33:32', '2017-04-09 18:33:32');

-- ----------------------------
-- Table structure for order_
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `order_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编(快递单号)',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `user_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户备注的信息',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `pay_date` datetime(0) NULL DEFAULT NULL COMMENT '订单支付时间',
  `delivery_date` datetime(0) NULL DEFAULT NULL COMMENT '发货日期',
  `confirm_date` datetime(0) NULL DEFAULT NULL COMMENT '确认收货日期',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '对应的用户id',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES (1, '123456', '地球村', '', '人生若只如初见', '', '', '1996-11-30 00:00:00', '2018-04-29 00:00:00', '2018-04-29 00:00:00', '2018-04-29 00:00:00', 1, '1');
INSERT INTO `order_` VALUES (10, '20180506143826504', '123123', '', '呵呵', '12345678910', '', '2018-05-06 00:00:00', '2018-05-06 00:00:00', NULL, NULL, 1, '1');
INSERT INTO `order_` VALUES (11, '20180507092435428', '详细地址', '34532645654664', '我没有三颗心脏', '12345678910', '卖家留言', '2018-05-07 00:00:00', '2018-05-07 00:00:00', '2020-02-03 22:29:42', NULL, 1, '3');
INSERT INTO `order_` VALUES (12, '20180507180327444', '123', '234523543265436', '我没有三颗心脏', '12345678910', '', '2018-05-07 00:00:00', '2018-05-07 00:00:00', '2020-02-03 22:29:49', '2018-05-07 00:00:00', 1, '3');
INSERT INTO `order_` VALUES (13, '20180507205110309', '', '', '神经病', '', '', '2018-05-07 00:00:00', '2018-05-07 20:51:56', NULL, NULL, 1, '3');
INSERT INTO `order_` VALUES (14, '20180716093257383', '', '', '精神病', '', '', '2018-07-16 00:00:00', '2018-07-16 09:32:59', NULL, NULL, 4, '4');
INSERT INTO `order_` VALUES (16, '6371df13d6ba494e90530a2e1d3f4632', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 01:08:08', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (17, '1b790de19fcf4e63bff8b001d194784a', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 01:13:28', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (18, '92bb0ab08d2940b5ad338ba5cdd0a663', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 01:53:56', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (19, 'c534d9000fdd4e0fa3c2f20fe209a031', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 02:19:00', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (20, 'e9d6be41b8a24480ab4490817759b1df', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 12:27:49', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (21, 'fec7f67c2b5c4efd9632e5fb72e0fe71', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 13:11:13', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (22, 'c624ed5ceae04d5e9aceca0f43d784eb', '地球村 潘多拉街道 天星66号 江湖第一高收', '234233425432554', 'admin', '111@121', NULL, '2020-02-02 00:00:00', NULL, '2020-02-03 22:28:54', NULL, 3, '3');
INSERT INTO `order_` VALUES (23, '34a21c74c1cc4788bb2c7f85882f3845', '地球村 潘多拉街道 天星66号 江湖第一高收', '354342656547', 'admin', '111@121', NULL, '2020-02-02 00:00:00', NULL, '2020-02-03 22:29:23', NULL, 3, '3');
INSERT INTO `order_` VALUES (24, '060eed59d0224217a5edc6cf58e56851', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 14:16:32', '2020-02-02 14:16:39', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (25, '5e5501a561f140caa84e07daf93ae842', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 20:42:06', '2020-02-02 20:46:03', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (26, '3d39ae0e22bb4a89a1796f59e22818bd', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 20:56:31', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (27, 'b183e85fea244c3bbf0978ad60a10b7b', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 21:20:55', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (28, '8ebd72dc39964098ab0eb20e3a6ed156', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 23:03:15', NULL, NULL, NULL, 3, '1');
INSERT INTO `order_` VALUES (29, '3e52acdbe551475686acb1bd6ff77085', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 23:33:24', '2020-02-02 23:36:08', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (30, '755dcead828c4bd2aeea45e070e734d3', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-02 23:47:08', '2020-02-02 23:47:13', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (31, '9e5df92e459b43539489ce459e341789', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'admin', '111@121', NULL, '2020-02-03 14:52:08', '2020-02-03 14:52:22', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (32, '4fbc506a35d94625bf29fb4491b14bed', '地球村 潘多拉街道 天星66号 江湖第一高收', '1213812138', 'admin', '111@121', NULL, '2020-02-03 00:00:00', '2020-02-03 00:00:00', '2020-02-03 22:27:21', NULL, 3, '3');
INSERT INTO `order_` VALUES (33, 'cabc0f1d55e24c849cf54e983c963949', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'leilei', '111@121', NULL, '2020-02-03 23:47:50', '2020-02-03 23:48:34', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (34, 'fab3c89b107847a59ea45d33110be1b7', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'leilei', '111@121', NULL, '2020-02-04 00:07:26', '2020-02-04 00:07:39', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (35, '82e7a01f3b794a828a9f35f9a0798976', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'leilei', '111@121', NULL, '2020-02-04 02:19:15', '2020-02-04 02:19:22', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (36, 'ef703ae9bc9b46b7a425f4e685cc8be6', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'leilei', '111@121', NULL, '2020-02-04 02:19:55', '2020-02-04 02:20:06', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (37, '41d2c2231cd6428e845fff70ad140c0f', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'leilei', '111@121', NULL, '2020-02-04 13:46:02', '2020-02-04 13:46:40', NULL, NULL, 3, '2');
INSERT INTO `order_` VALUES (38, '04ca8db2ba5b43e99cc91667809f8e67', '地球村 潘多拉街道 天星66号 江湖第一高收', NULL, 'leilei', '111@121', NULL, '2020-02-04 14:40:13', '2020-02-04 14:40:21', NULL, NULL, 3, '2');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应产品id',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '对应订单id',
  `user_id` int(11) NOT NULL COMMENT '对应用户id',
  `number` int(11) NULL DEFAULT NULL COMMENT '对应产品购买的数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_item_product`(`product_id`) USING BTREE,
  INDEX `fk_order_item_order`(`order_id`) USING BTREE,
  INDEX `fk_order_item_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`order_id`) REFERENCES `order_` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_item_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_item_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (14, 5, 11, 1, 1);
INSERT INTO `order_item` VALUES (15, 6, 11, 1, 1);
INSERT INTO `order_item` VALUES (16, 4, NULL, 1, 5);
INSERT INTO `order_item` VALUES (17, 4, 12, 1, 1);
INSERT INTO `order_item` VALUES (18, 8, 13, 1, 1);
INSERT INTO `order_item` VALUES (19, 5, 14, 4, 1);
INSERT INTO `order_item` VALUES (20, 4, NULL, 3, 2);
INSERT INTO `order_item` VALUES (21, 4, NULL, 3, 1);
INSERT INTO `order_item` VALUES (22, 4, 16, 3, 2);
INSERT INTO `order_item` VALUES (23, 6, 17, 3, 5);
INSERT INTO `order_item` VALUES (24, 7, 18, 3, 1);
INSERT INTO `order_item` VALUES (25, 10, 19, 3, 6);
INSERT INTO `order_item` VALUES (26, 8, 20, 3, 1);
INSERT INTO `order_item` VALUES (27, 1, 21, 3, 4);
INSERT INTO `order_item` VALUES (28, 5, 21, 3, 3);
INSERT INTO `order_item` VALUES (29, 6, 22, 3, 4);
INSERT INTO `order_item` VALUES (30, 4, 23, 3, 1);
INSERT INTO `order_item` VALUES (31, 4, 24, 3, 2);
INSERT INTO `order_item` VALUES (32, 6, 25, 3, 3);
INSERT INTO `order_item` VALUES (33, 7, 26, 3, 5);
INSERT INTO `order_item` VALUES (34, 5, 27, 3, 3);
INSERT INTO `order_item` VALUES (35, 22, 28, 3, 1);
INSERT INTO `order_item` VALUES (36, 16, 29, 3, 1);
INSERT INTO `order_item` VALUES (37, 19, 30, 3, 4);
INSERT INTO `order_item` VALUES (38, 23, 31, 3, 1);
INSERT INTO `order_item` VALUES (39, 16, 32, 3, 1);
INSERT INTO `order_item` VALUES (40, 17, 33, 3, 4);
INSERT INTO `order_item` VALUES (41, 6, 34, 3, 1);
INSERT INTO `order_item` VALUES (42, 7, 35, 3, 5);
INSERT INTO `order_item` VALUES (43, 18, 36, 3, 4);
INSERT INTO `order_item` VALUES (44, 16, 37, 3, 1);
INSERT INTO `order_item` VALUES (45, 11, 38, 3, 93);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品的名称',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小标题',
  `price` float NULL DEFAULT NULL COMMENT '价格',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '对应的分类id',
  `state` int(255) NOT NULL DEFAULT 1 COMMENT '状态',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_product_category`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '男装 袋装圆领T恤', '初上市价格39元', 39, 107769, 9999, 1, 0, '1');
INSERT INTO `product` VALUES (2, '测试1', '34', 34, 107769, 9999, 2, 0, '2');
INSERT INTO `product` VALUES (4, '男装 袋装圆领T恤(短袖) 404133 优衣库UNIQLO', '初上市价格39元', 39, 107769, 9999, 3, 1, '4');
INSERT INTO `product` VALUES (5, '复古连衣裙2018春夏新款女装休闲宽松韩版气质圆领中袖丝麻连衣裙', '丝麻面料 做工精细 气质优雅', 368, 1151, 9996, 1, 1, '5');
INSERT INTO `product` VALUES (6, '【满400减40】ONLY夏新喇叭长袖高腰碎花连衣裙女|117207510', '纯色内衬 镂空设计7天降退差价', 224.5, 947, 9998, 1, 1, '6');
INSERT INTO `product` VALUES (7, '夏季2018新款短袖男士t恤韩版宽松ulzzang百搭潮流半袖七分袖上衣', '2件装79元！收藏加购优先发货！', 79, 9548, 9994, 1, 1, '7');
INSERT INTO `product` VALUES (8, '唐狮春秋季牛仔外套男牛仔衣夹克韩版潮流修身帅气情侣装男生外套', '潮流多色，热卖上万件', 534, 4909, 6786, 1, 1, '8');
INSERT INTO `product` VALUES (10, '唐狮春秋季牛仔外套男牛仔衣夹克韩版潮流修身帅气情侣装男生外套', '潮流多色，热卖上万件', 655, 4909, 9999, 1, 1, '10');
INSERT INTO `product` VALUES (11, '产品8', '', 56745, 5002, 45671, 1, 1, '11');
INSERT INTO `product` VALUES (16, '产品13', '', 56756, 4912, 9996, 1, 1, '16');
INSERT INTO `product` VALUES (17, '产品14', '', 576, 4913, 563, 3, 1, '17');
INSERT INTO `product` VALUES (18, '产品15', '', 16, 4913, 9995, 1, 1, '18');
INSERT INTO `product` VALUES (19, '产品16', '初上市价格39元', 78, 4913, 9995, 3, 1, '19');
INSERT INTO `product` VALUES (20, '产品17', '', 16987, 4909, 9999, 1, 1, '20');
INSERT INTO `product` VALUES (21, '产品18', '', 999, 490, 998, 3, 1, '21');
INSERT INTO `product` VALUES (22, '产品19', '', 349, 499, 998, 3, 1, '22');
INSERT INTO `product` VALUES (23, '产品20', '', 4, 500, 9899, 3, 1, '23');

-- ----------------------------
-- Table structure for product_image
-- ----------------------------
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE `product_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id 图片id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '对应的产品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_product_image_product`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_image
-- ----------------------------
INSERT INTO `product_image` VALUES (11, 4);
INSERT INTO `product_image` VALUES (12, 4);
INSERT INTO `product_image` VALUES (13, 4);
INSERT INTO `product_image` VALUES (14, 4);
INSERT INTO `product_image` VALUES (15, 4);
INSERT INTO `product_image` VALUES (16, 5);
INSERT INTO `product_image` VALUES (17, 5);
INSERT INTO `product_image` VALUES (18, 5);
INSERT INTO `product_image` VALUES (19, 5);
INSERT INTO `product_image` VALUES (20, 5);
INSERT INTO `product_image` VALUES (21, 6);
INSERT INTO `product_image` VALUES (22, 6);
INSERT INTO `product_image` VALUES (23, 6);
INSERT INTO `product_image` VALUES (24, 6);
INSERT INTO `product_image` VALUES (25, 6);
INSERT INTO `product_image` VALUES (26, 7);
INSERT INTO `product_image` VALUES (27, 7);
INSERT INTO `product_image` VALUES (28, 7);
INSERT INTO `product_image` VALUES (29, 7);
INSERT INTO `product_image` VALUES (30, 7);
INSERT INTO `product_image` VALUES (31, 8);
INSERT INTO `product_image` VALUES (32, 8);
INSERT INTO `product_image` VALUES (33, 8);
INSERT INTO `product_image` VALUES (34, 8);
INSERT INTO `product_image` VALUES (35, 8);
INSERT INTO `product_image` VALUES (36, 9);
INSERT INTO `product_image` VALUES (37, 9);
INSERT INTO `product_image` VALUES (38, 9);
INSERT INTO `product_image` VALUES (39, 9);
INSERT INTO `product_image` VALUES (40, 9);
INSERT INTO `product_image` VALUES (41, 10);
INSERT INTO `product_image` VALUES (42, 10);
INSERT INTO `product_image` VALUES (43, 10);
INSERT INTO `product_image` VALUES (44, 10);
INSERT INTO `product_image` VALUES (45, 10);
INSERT INTO `product_image` VALUES (46, 11);
INSERT INTO `product_image` VALUES (47, 11);
INSERT INTO `product_image` VALUES (48, 11);
INSERT INTO `product_image` VALUES (49, 11);
INSERT INTO `product_image` VALUES (50, 11);
INSERT INTO `product_image` VALUES (51, 12);
INSERT INTO `product_image` VALUES (52, 12);
INSERT INTO `product_image` VALUES (53, 12);
INSERT INTO `product_image` VALUES (54, 12);
INSERT INTO `product_image` VALUES (55, 12);
INSERT INTO `product_image` VALUES (56, 13);
INSERT INTO `product_image` VALUES (57, 13);
INSERT INTO `product_image` VALUES (58, 13);
INSERT INTO `product_image` VALUES (59, 13);
INSERT INTO `product_image` VALUES (60, 13);
INSERT INTO `product_image` VALUES (61, 14);
INSERT INTO `product_image` VALUES (62, 14);
INSERT INTO `product_image` VALUES (63, 14);
INSERT INTO `product_image` VALUES (64, 14);
INSERT INTO `product_image` VALUES (65, 14);
INSERT INTO `product_image` VALUES (66, 15);
INSERT INTO `product_image` VALUES (67, 15);
INSERT INTO `product_image` VALUES (68, 15);
INSERT INTO `product_image` VALUES (69, 15);
INSERT INTO `product_image` VALUES (70, 15);
INSERT INTO `product_image` VALUES (71, 16);
INSERT INTO `product_image` VALUES (72, 16);
INSERT INTO `product_image` VALUES (73, 16);
INSERT INTO `product_image` VALUES (74, 16);
INSERT INTO `product_image` VALUES (75, 16);
INSERT INTO `product_image` VALUES (76, 17);
INSERT INTO `product_image` VALUES (77, 17);
INSERT INTO `product_image` VALUES (78, 17);
INSERT INTO `product_image` VALUES (79, 17);
INSERT INTO `product_image` VALUES (80, 17);
INSERT INTO `product_image` VALUES (81, 18);
INSERT INTO `product_image` VALUES (82, 18);
INSERT INTO `product_image` VALUES (83, 18);
INSERT INTO `product_image` VALUES (84, 18);
INSERT INTO `product_image` VALUES (85, 18);
INSERT INTO `product_image` VALUES (86, 19);
INSERT INTO `product_image` VALUES (87, 19);
INSERT INTO `product_image` VALUES (88, 19);
INSERT INTO `product_image` VALUES (89, 19);
INSERT INTO `product_image` VALUES (90, 19);
INSERT INTO `product_image` VALUES (91, 20);
INSERT INTO `product_image` VALUES (92, 20);
INSERT INTO `product_image` VALUES (93, 20);
INSERT INTO `product_image` VALUES (94, 20);
INSERT INTO `product_image` VALUES (95, 20);

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `category_id` int(11) NOT NULL COMMENT '对应的分类id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_property_category`(`category_id`) USING BTREE,
  CONSTRAINT `fk_property_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES (1, '尺寸', 1);
INSERT INTO `property` VALUES (2, '厚薄', 1);
INSERT INTO `property` VALUES (3, '材质成分', 1);
INSERT INTO `property` VALUES (4, '货号', 1);
INSERT INTO `property` VALUES (5, '基础风格', 1);
INSERT INTO `property` VALUES (6, '品牌1', 1);
INSERT INTO `property` VALUES (8, '测试1', 1);
INSERT INTO `property` VALUES (9, '测试12', 4);
INSERT INTO `property` VALUES (10, '品牌', 2);

-- ----------------------------
-- Table structure for property_value
-- ----------------------------
DROP TABLE IF EXISTS `property_value`;
CREATE TABLE `property_value`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应产品id',
  `property_id` int(11) NOT NULL COMMENT '对应属性id',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体的属性值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_property_value_property`(`property_id`) USING BTREE,
  INDEX `fk_property_value_product`(`product_id`) USING BTREE,
  CONSTRAINT `fk_property_value_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_property_value_property` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of property_value
-- ----------------------------
INSERT INTO `property_value` VALUES (1, 4, 1, 'L M XL XLL2');
INSERT INTO `property_value` VALUES (2, 4, 2, '常规');
INSERT INTO `property_value` VALUES (3, 4, 3, '棉66% 聚酯纤维34%');
INSERT INTO `property_value` VALUES (4, 4, 4, 'UQ404133000');
INSERT INTO `property_value` VALUES (5, 4, 5, '其他');
INSERT INTO `property_value` VALUES (6, 4, 6, 'Uniqlo/优衣库');

-- ----------------------------
-- Table structure for referal_link
-- ----------------------------
DROP TABLE IF EXISTS `referal_link`;
CREATE TABLE `referal_link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '超链显示的文字',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '超链的地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of referal_link
-- ----------------------------
INSERT INTO `referal_link` VALUES (1, '天猫会员', '#nowhere');
INSERT INTO `referal_link` VALUES (2, '电器城', '#nowhere');
INSERT INTO `referal_link` VALUES (3, '喵鲜生', '#nowhere');
INSERT INTO `referal_link` VALUES (4, '医药馆', '#nowhere');
INSERT INTO `referal_link` VALUES (5, '营业厅', '#nowhere');
INSERT INTO `referal_link` VALUES (6, '魅力惠', '#nowhere');
INSERT INTO `referal_link` VALUES (7, '飞猪旅游', '#nowhere');
INSERT INTO `referal_link` VALUES (8, '苏宁易购', '#nowhere');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `user_id` int(11) NOT NULL COMMENT '对应的用户id',
  `product_id` int(11) NOT NULL COMMENT '对应的产品id',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_review_product`(`product_id`) USING BTREE,
  INDEX `fk_review_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_review_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_review_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (2, '这款短袖T恤不错哦，没想到买的号码挺准。上身效果好看，特别时尚休闲。和图片上的一样，没色差，衣服料子很好，没线头，布料是棉的，摸起来舒服，比想象的要厚实。朋友们都说好看，款式简洁大方。真的是超级赞，以后就认准这家啦，有想买的亲赶快下手哦。我是这的老顾客了，这家产品确实一直棒棒的哦。', 1, 4, '2018-05-02 10:24:02');
INSERT INTO `review` VALUES (3, '比较轻薄，质量蛮好的，穿起来还是比较舒适，很合身，价格也实惠！', 1, 4, '2018-05-02 10:42:07');
INSERT INTO `review` VALUES (6, '上身效果很好', 3, 6, '2018-05-07 10:49:09');
INSERT INTO `review` VALUES (7, '评价一个', 1, 6, '2018-05-07 11:01:06');
INSERT INTO `review` VALUES (8, 'qw54e5qwe4qw6eq4eqewq', 1, 4, '2018-05-07 18:05:09');
INSERT INTO `review` VALUES (9, '当评价完成之后，可以看到其他用户的评价信息', 1, 4, '2018-05-07 20:59:49');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `state` int(2) NOT NULL DEFAULT 1 COMMENT '用户状态',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '我没有三颗心脏', '123', 0, '111@121');
INSERT INTO `user` VALUES (2, '我没有三颗心脏1', '123', 1, '111@121');
INSERT INTO `user` VALUES (3, 'leilei', '123456', 1, '111@121');
INSERT INTO `user` VALUES (4, '我没有三颗心脏123', '123', 0, '111@121');
INSERT INTO `user` VALUES (7, '测试1', '1', 1, '1571064747@qq.com');
INSERT INTO `user` VALUES (8, 'admin2', '123456', 1, 'soulmate.leilei@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
