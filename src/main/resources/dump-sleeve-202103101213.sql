-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: sleeve
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `start_time` timestamp NOT NULL COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL COMMENT '活动结束时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `online` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '记录当前活动是否上线',
  `entrance_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '活动入口图',
  `internal_top_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '活动内部顶图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '当前记录逻辑删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='活动表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'a-2','夏日好礼送不停','2020-07-26 13:50:55','2020-11-23 13:50:55','限服装、鞋、文具等商品',1,'http://i2.sleeve.7yue.pro/m14.png',NULL,'2020-07-26 12:34:58','2020-10-31 02:01:18',NULL);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_category`
--

DROP TABLE IF EXISTS `activity_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int unsigned NOT NULL,
  `category_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='activity和category的关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_category`
--

LOCK TABLES `activity_category` WRITE;
/*!40000 ALTER TABLE `activity_category` DISABLE KEYS */;
INSERT INTO `activity_category` VALUES (1,1,10);
/*!40000 ALTER TABLE `activity_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_coupon`
--

DROP TABLE IF EXISTS `activity_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_coupon` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int unsigned NOT NULL,
  `coupon_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='activity与coupon表的关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_coupon`
--

LOCK TABLES `activity_coupon` WRITE;
/*!40000 ALTER TABLE `activity_coupon` DISABLE KEYS */;
INSERT INTO `activity_coupon` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5);
/*!40000 ALTER TABLE `activity_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'banner名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'banner标题',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'banner更新时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '当前记录逻辑删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='存储电商业务中，banner的数据表，例如：轮播图业务等';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (1,'b-1','首页顶部主Banner ','首页顶部','http://qocfrob1z.hn-bkt.clouddn.com/08f9c63bb44b4294999f035b7ebbe6c4.png','2020-07-04 11:37:55','2021-01-19 12:16:19',NULL),(2,'b-2','热销商品Banner','热销','http://i1.sleeve.talelin.com/assets/c086f193-5857-4652-a956-3e4ff9e3bdac.png','2020-07-04 11:42:33','2021-01-19 12:15:52',NULL),(6,'null','测试描述啊','测试','http://localhost:5000/assets/2021/01/27/463d3596dff348bdb6568cb1c842bcd1.jpg','2020-11-21 13:59:15','2021-02-11 12:16:16','2021-02-11 12:16:16'),(9,'111','22222','111','http://qocfrob1z.hn-bkt.clouddn.com/1570527117308-c7131366-f7d1-49de-b874-ddf2384e3937.png','2020-11-21 14:03:00','2021-02-11 02:49:44',NULL),(11,'b-3','这是一个测试title这公司是一个何使的公司啊水水水水方法是读书的地方发士大夫似的是的打发手动阀','这是一个测试','1122.png','2020-11-21 14:10:57','2021-02-09 08:47:44',NULL),(18,'测试banner','添加测试banner数据','123','','2021-02-10 09:15:08','2021-02-12 11:05:56',NULL),(19,'测试数据1','111222','111','','2021-02-10 09:21:12','2021-02-12 11:24:54','2021-02-12 11:24:54'),(20,'测试数据2','测试数据222','222','','2021-02-10 09:23:28','2021-02-12 11:05:56',NULL),(25,'测试数据3','测试数据222','333','http://localhost:5000/assets/2021/01/27/ba380ac73e1d4ed095ea20119b2696eb.jpeg','2021-02-10 09:30:48','2021-02-13 03:08:17',NULL),(27,'测试数据4','测试数据222','333','http://localhost:5000/assets/2021/01/27/ba380ac73e1d4ed095ea20119b2696eb.jpeg','2021-02-10 09:33:18','2021-02-13 03:08:17',NULL),(30,'测试数据5','测试数据222','333','http://localhost:5000/assets/2021/01/27/ba380ac73e1d4ed095ea20119b2696eb.jpeg','2021-02-10 09:45:47','2021-03-09 03:18:08','2021-03-09 03:18:08'),(32,'测试数据6','测试数据555','5555','','2021-02-10 09:52:05','2021-03-09 03:03:59','2021-03-09 03:03:59'),(38,'测试8','测试888','888','','2021-02-12 10:41:15','2021-02-23 08:16:01','2021-02-23 08:16:01'),(39,'测试9','测试999','999','','2021-02-12 10:42:38','2021-02-13 06:07:38','2021-02-13 06:07:38'),(40,'测试10','测试1010','1010','http://qocfrob1z.hn-bkt.clouddn.com/cc0449c751c7421791e6aed7c5b8093d.png','2021-02-12 10:43:52','2021-02-13 06:03:42',NULL),(42,'测试11','测试1111','110000','http://qocfrob1z.hn-bkt.clouddn.com/08f9c63bb44b4294999f035b7ebbe6c4.png','2021-02-13 08:39:52','2021-03-09 03:02:37','2021-03-09 03:02:37'),(43,'','钱钱钱钱钱','','http://qocfrob1z.hn-bkt.clouddn.com/d05d16dd612747d4ab21887554fa2706.png','2021-02-22 08:35:10','2021-02-23 08:15:54','2021-02-23 08:15:54');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner_item`
--

DROP TABLE IF EXISTS `banner_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner_item` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '当前item属于那种类型，例如：spu商品、theme主题',
  `keyword` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '当前banner_item的业务标识\r\n是spu,就设置为spu_id;\r\n是theme,就设置为theme_id;',
  `type` smallint unsigned NOT NULL DEFAULT '0' COMMENT 'item的类型 1:Spu ; 2:theme ; 3:spu_list ',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'item图片',
  `banner_id` int unsigned NOT NULL COMMENT '关联banner表的id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '当前记录逻辑删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner_item`
--

LOCK TABLES `banner_item` WRITE;
/*!40000 ALTER TABLE `banner_item` DISABLE KEYS */;
INSERT INTO `banner_item` VALUES (1,'每周上新111','主题','22',2,'http://i1.sleeve.talelin.com/assets/b64affa6-3563-4031-ac98-e199887a78f0.png',1,'2020-07-04 11:53:38','2021-02-09 03:12:56',NULL),(2,'alway','商品','23',1,'http://i1.sleeve.talelin.com/assets/702f2ce9-5729-4aa4-aeb3-921513327747.png',1,'2020-07-04 11:55:34','2021-02-23 09:44:10',NULL),(3,'show','商品','24',1,'http://i1.sleeve.talelin.com/assets/b8e510a1-8340-43c2-a4b0-0e56a40256f9.png',1,'2020-07-04 11:57:08','2021-02-23 09:44:27','2021-02-23 09:44:27'),(4,'left','商品','',1,'http://i1.sleeve.talelin.com/549e1185-c7e2-4a1f-9646-074ce4a64f5f.png',2,'2020-07-04 12:02:37','2021-02-09 01:04:38',NULL),(5,'right-top','商品','26',1,'http://i1.sleeve.talelin.com/fb683a8c-4c59-49aa-bca1-a6e654f780fa.png',2,'2020-07-04 12:03:32','2021-02-09 00:58:26',NULL),(6,'right-bottom','商品','27',1,'http://i1.sleeve.talelin.com/2c9d4333-9ba9-45fe-b3b0-537fbb961f44.png',2,'2020-07-04 12:04:36','2021-02-09 00:59:43',NULL),(18,'测试111','商品','111',0,'http://localhost:5000/assets/2021/01/27/b897c178d5f744c2b1deb71ea93b57b0.png',1,'2021-02-09 03:13:21','2021-02-23 09:44:23','2021-02-23 09:44:23');
/*!40000 ALTER TABLE `banner_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner_item_type`
--

DROP TABLE IF EXISTS `banner_item_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner_item_type` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `banner_item_type_un` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='banner_item可选类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner_item_type`
--

LOCK TABLES `banner_item_type` WRITE;
/*!40000 ALTER TABLE `banner_item_type` DISABLE KEYS */;
INSERT INTO `banner_item_type` VALUES (2,'主题'),(1,'商品'),(3,'商品列表');
/*!40000 ALTER TABLE `banner_item_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `summary` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'深入理解计算机系统','Randal E.Bryant','从程序员的视角，看计算机系统！\n本书适用于那些想要写出更快、更可靠程序的程序员。通过掌握程序是如何映射到系统上，以及程序是如何执行的，读者能够更好的理解程序的行为为什么是这样的，以及效率低下是如何造成的。','https://img3.doubanio.com/lpic/s1470003.jpg','2020-11-03 22:09:46.020','2020-11-03 22:09:46.020',NULL),(2,'C程序设计语言','（美）Brian W. Kernighan','在计算机发展的历史上，没有哪一种程序设计语言像C语言这样应用广泛。本书原著即为C语言的设计者之一Dennis M.Ritchie和著名计算机科学家Brian W.Kernighan合著的一本介绍C语言的权威经典著作。','https://img3.doubanio.com/lpic/s1106934.jpg','2020-11-03 22:09:46.030','2020-11-03 22:09:46.030',NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_root` tinyint NOT NULL DEFAULT '0' COMMENT '当前分类是否为根节点',
  `online` tinyint NOT NULL DEFAULT '0' COMMENT '"1"上架，"0"下架',
  `parent_id` tinyint unsigned DEFAULT NULL COMMENT '当前类别的父节点',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `level` tinyint unsigned NOT NULL COMMENT '当前类别的级别',
  `idx` tinyint unsigned DEFAULT NULL COMMENT '当前类别的索引',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL,
  `grid_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '首页分类小图标',
  `is_grid` tinyint NOT NULL DEFAULT '0' COMMENT '判断是否为分类六宫格的标识，"1":属于，"0"不属于',
  `grid_online` tinyint DEFAULT '0' COMMENT '当前六宫格上下线的标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'箱包','品质点亮生活，回归自然，追求个性',1,1,NULL,'http://qocfrob1z.hn-bkt.clouddn.com/cc0449c751c7421791e6aed7c5b8093d.png',1,1,'2020-07-12 12:56:00','2021-03-08 11:28:24',NULL,'http://i1.sleeve.talelin.com/grid/bag.png',1,1),(2,'服装','品质服装，秋冬上新',1,1,NULL,'http://i1.sleeve.talelin.com/3a0f7b5b-2b3e-4b39-911f-1e3581fd443c.png',1,2,'2020-07-12 12:56:41','2021-03-01 09:21:55',NULL,'http://i1.sleeve.talelin.com/grid/clothing.png',1,1),(3,'图书文娱','繁忙的工作之余，也有一丝丝休闲生活',1,0,NULL,'http://i1.sleeve.talelin.com/8df9b366-cf85-48a1-beac-ba75f3ae557c.png',1,3,'2020-07-12 12:57:09','2021-03-01 09:21:23',NULL,'http://i1.sleeve.talelin.com/grid/book.png',1,1),(4,'鞋靴','诚意手作，每一双都很衬你！',1,1,NULL,'http://i1.sleeve.talelin.com/660e352a-0c45-4ae5-b397-91abf84046ca.png',1,4,'2020-07-12 12:57:47','2021-03-01 09:21:55',NULL,'http://i1.sleeve.talelin.com/grid/shoes.png',1,1),(5,'饰品','坚韧无畏，精彩我的时光',1,1,NULL,'http://i1.sleeve.talelin.com/39a8c403-ccd4-4835-96c8-a1efe3224758.png',1,5,'2020-07-12 12:58:16','2021-03-01 09:21:55',NULL,'http://i1.sleeve.talelin.com/grid/jewelry.png',1,1),(6,'居家','家是生活的港湾，只为品质生活',1,1,NULL,'http://i1.sleeve.talelin.com/0e598247-9f65-43ec-9e59-04f5d060e783.png',1,6,'2020-07-12 12:58:38','2021-03-01 09:21:55',NULL,'http://i1.sleeve.talelin.com/grid/furniture.png',1,1),(7,'手包','男士手拿信封小皮包，休闲潮牌！！',0,1,1,'http://i1.sleeve.talelin.com/d3184f0b-6e87-4020-a0fe-3f8a8e47c2dc.png',2,NULL,'2020-07-12 12:59:41','2021-02-22 11:24:12',NULL,NULL,0,0),(8,'旅行包','手提轻便，适合出差旅游，短途旅行',0,1,1,'http://i1.sleeve.talelin.com/3d3c0ed9-8cd8-4fcb-a479-8988205d4430.png',2,NULL,'2020-07-12 13:00:04','2021-02-21 08:34:47',NULL,NULL,0,0),(9,'单肩包',NULL,0,1,1,'http://i1.sleeve.talelin.com/028aff3c-b870-4b74-9ca8-18efbd1434bd.png',2,NULL,'2020-07-12 13:00:30','2021-02-21 02:12:33',NULL,NULL,0,0),(10,'文具',NULL,0,1,3,'http://i1.sleeve.7yue.pro/38d85ced-0b46-492f-a5ec-c7912a5e5151.png',2,NULL,'2020-07-12 13:01:53','2020-08-22 07:24:43',NULL,NULL,0,0),(11,'衬衫',NULL,0,1,2,'http://i1.sleeve.talelin.com/1af7bd2d-f2f9-4bdc-b4f3-0ea653d3d41b.png',2,NULL,'2020-07-12 13:02:28','2021-02-21 02:15:07',NULL,NULL,0,0),(12,'T恤',NULL,0,1,2,'http://i1.sleeve.talelin.com/695f4d75-96e7-48c1-92f0-10bf70ed28ff.png',2,NULL,'2020-07-12 13:03:17','2021-02-21 02:15:20',NULL,NULL,0,0),(13,'牛仔裤',NULL,0,1,2,'http://i1.sleeve.talelin.com/8043ea5e-47a7-47d8-9121-c21b5cc70a02.png',2,NULL,'2020-07-12 13:05:55','2021-02-21 02:15:38',NULL,NULL,0,0),(14,'针织衫',NULL,0,1,2,'http://i1.sleeve.talelin.com/bee0cc22-d3e2-4065-890b-d835d2c8e1ff.png',2,NULL,'2020-07-12 13:06:24','2021-02-21 02:29:35',NULL,NULL,0,0),(15,'连衣裙',NULL,0,1,2,'http://i1.sleeve.talelin.com/45d6e9db-ca81-452f-ab45-dbf75098e55d.png',2,NULL,'2020-07-12 13:06:49','2021-02-21 02:15:52',NULL,NULL,0,0),(16,'风衣',NULL,0,1,2,'http://i1.sleeve.talelin.com/bee0cc22-d3e2-4065-890b-d835d2c8e1ff.png',2,NULL,'2020-07-12 13:07:59','2021-02-21 02:16:04',NULL,NULL,0,0),(17,'帆布鞋',NULL,0,1,4,'http://i1.sleeve.talelin.com/e2872156-a803-4c89-a442-868380d9b3f7.png',2,NULL,'2020-07-12 13:09:21','2021-02-21 02:07:28',NULL,NULL,0,0),(18,'休闲鞋',NULL,0,1,4,'http://i1.sleeve.talelin.com/c160007c-054a-46b5-802c-3f64ccd9e77b.png',2,NULL,'2020-07-12 13:09:45','2021-02-21 02:07:46',NULL,NULL,0,0),(19,'凉鞋',NULL,0,1,4,'http://i1.sleeve.talelin.com/dd3fdf3d-ddc1-4c22-b37f-1f1ac66575f9.png',2,NULL,'2020-07-12 13:10:08','2021-02-21 02:08:05',NULL,NULL,0,0),(20,'高跟鞋',NULL,0,1,4,'http://i1.sleeve.talelin.com/22d7c81f-3a87-40f5-af79-548223c6ca31.png',2,NULL,'2020-07-12 13:10:35','2021-02-21 02:08:24',NULL,NULL,0,0),(21,'马丁靴',NULL,0,1,4,'D:\\project\\Wechat\\11111.png',2,NULL,'2020-07-12 13:10:58','2020-10-31 08:12:50',NULL,NULL,0,0),(22,'手表',NULL,0,1,5,'https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3566225750,3945252064&fm=26&gp=0.jpg',2,NULL,'2020-07-12 13:11:55','2020-07-18 08:01:24',NULL,NULL,0,0),(23,'太阳镜',NULL,0,1,5,'http://i1.sleeve.7yue.pro/spu/mojing1/sku1.png',2,NULL,'2020-07-12 13:12:23','2020-08-22 10:19:09',NULL,NULL,0,0),(24,'腰带',NULL,0,1,5,'http://i1.sleeve.7yue.pro/9b6a2f1d-b192-4eed-87fe-2d82456dd5a1.png',2,NULL,'2020-07-12 13:12:46','2020-08-22 07:26:22',NULL,NULL,0,0),(25,'戒指',NULL,0,1,5,NULL,2,NULL,'2020-07-12 13:13:34','2020-07-12 13:13:34',NULL,NULL,0,0),(26,'收纳',NULL,0,1,6,'http://i1.sleeve.7yue.pro/6de8e5af-9cb9-4c45-8091-978d03d81719.png',2,NULL,'2020-07-12 13:14:51','2020-08-22 07:23:13',NULL,NULL,0,0),(27,'毛巾',NULL,0,1,6,'http://i1.sleeve.7yue.pro/ac6ca5db-6651-4c6b-9bcc-fbebe2b3b666.png',2,NULL,'2020-07-12 13:15:09','2020-08-22 07:23:13',NULL,NULL,0,0),(28,'四件套',NULL,0,1,6,'http://i1.sleeve.7yue.pro/b64141e6-ca1e-4961-b1b5-87f05bdd4be4.png',2,NULL,'2020-07-12 13:15:25','2020-08-22 07:23:13',NULL,NULL,0,0),(29,'台灯',NULL,0,1,6,'http://i1.sleeve.7yue.pro/29e0d772-8854-481b-9d3a-bc248fd6e77d.png',2,NULL,'2020-07-12 13:15:51','2020-08-22 07:23:13',NULL,NULL,0,0),(30,'家具',NULL,0,1,6,'http://i1.sleeve.7yue.pro/225ca12f-9248-4708-9917-05b8dddec06d.png',2,NULL,'2020-07-12 13:16:07','2020-08-22 07:23:13',NULL,NULL,0,0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `start_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '优惠券可以使用的开始时间',
  `end_time` timestamp NOT NULL COMMENT '优惠券允许使用的结束时间',
  `full_money` decimal(10,2) DEFAULT NULL COMMENT '满多少金额可以使用',
  `minus` decimal(10,2) DEFAULT NULL COMMENT '满减金额',
  `rate` decimal(10,2) DEFAULT NULL COMMENT '折扣率',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '记录哪些商品可以使用当前优惠券',
  `whole_store` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '记录当前优惠券是否为全场通用券，"1"为通用',
  `type` tinyint unsigned NOT NULL COMMENT '当前优惠券的类型',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '对当前优惠券的描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  `activity_id` int unsigned DEFAULT NULL COMMENT 'activity表的关联id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='优惠券表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'无门槛减0.1券','2020-07-26 13:50:55','2021-11-23 13:50:55',NULL,0.10,NULL,'全场无门槛立减',1,3,NULL,'2020-07-26 13:12:18','2021-01-31 11:02:47',NULL,1),(2,'满500减100券','2020-07-26 13:50:55','2020-10-13 13:50:55',500.00,100.00,NULL,'限服装、居家、文具使用',0,1,NULL,'2020-07-26 13:23:49','2020-10-31 07:34:48',NULL,1),(3,'满1000减200券','2020-07-26 13:50:55','2020-10-26 13:50:55',1000.00,200.00,NULL,'限包包、饰品使用',0,1,NULL,'2020-07-28 13:48:54','2020-10-31 02:48:15',NULL,1),(4,'满100打9.9折','2020-07-26 13:50:55','2020-11-26 13:50:55',100.00,NULL,0.99,'全场通用券',1,2,NULL,'2020-07-30 12:39:13','2020-10-31 02:01:40',NULL,1),(5,'满500打9.5折','2020-07-26 13:50:55','2020-11-26 13:50:55',500.00,NULL,0.95,'限服装使用',0,2,NULL,'2020-10-15 14:03:26','2020-10-31 02:01:40',NULL,1);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon_category`
--

DROP TABLE IF EXISTS `coupon_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon_category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `coupon_id` int unsigned NOT NULL,
  `category_id` int unsigned NOT NULL COMMENT '当前spu所属二级分类id',
  `root_category_id` int unsigned NOT NULL COMMENT 'spu所属一级分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='coupon与category关联表，如果category_id=0,那么证明是全场通用券，否则为有使用限制的优惠券';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon_category`
--

LOCK TABLES `coupon_category` WRITE;
/*!40000 ALTER TABLE `coupon_category` DISABLE KEYS */;
INSERT INTO `coupon_category` VALUES (1,1,0,1),(2,1,0,2),(3,1,0,3),(4,1,0,4),(5,1,0,5),(6,1,0,6),(7,2,11,2),(8,2,12,2),(9,2,13,2),(10,2,14,2),(11,2,15,2),(12,2,16,2),(13,2,26,6),(14,2,27,6),(15,2,28,6),(16,2,29,6),(17,2,30,6),(18,2,10,3),(19,3,7,1),(20,3,8,1),(21,3,9,1),(22,3,22,5),(23,3,23,5),(24,3,24,5),(25,3,25,5),(26,4,0,1),(27,4,0,2),(28,4,0,3),(29,4,0,4),(30,4,0,5),(31,4,0,6),(32,5,11,2),(33,5,12,2),(34,5,13,2),(35,5,14,2),(36,5,15,2),(37,5,16,2);
/*!40000 ALTER TABLE `coupon_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fail_msg`
--

DROP TABLE IF EXISTS `fail_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fail_msg` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `key_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '每条消息的key',
  `message` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息内容',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对于生产者发送当前这条消息失败原因的描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `failmsg_un` (`key_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2279 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='rocketmq生产者发送失败的消息，会插入到当前表中';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fail_msg`
--

LOCK TABLES `fail_msg` WRITE;
/*!40000 ALTER TABLE `fail_msg` DISABLE KEYS */;
INSERT INTO `fail_msg` VALUES (2,'40','4:40:2','MQ客户端发送消息异常','2020-09-19 08:34:04','2020-09-19 09:50:18','2020-09-19 09:50:18'),(73,'43','4:43:-1','MQ客户端发送消息异常','2020-10-19 14:11:36','2020-10-19 14:11:36',NULL),(74,'44','4:44:5','MQ客户端发送消息异常','2020-10-19 14:19:44','2020-10-19 14:19:44',NULL),(75,'45','4:45:1','MQ客户端发送消息异常','2020-10-20 13:44:22','2020-10-20 13:44:22',NULL),(132,'46','4:46:4','MQ客户端发送消息异常','2020-10-21 13:33:02','2020-10-21 13:33:02',NULL),(151,'47','4:47:1','MQ客户端发送消息异常','2020-10-22 14:10:34','2020-10-22 14:10:34',NULL),(152,'48','4:48:-1','MQ客户端发送消息异常','2020-10-22 14:12:52','2020-10-22 14:12:52',NULL);
/*!40000 ALTER TABLE `fail_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_file`
--

DROP TABLE IF EXISTS `lin_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_file` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `path` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(10) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'LOCAL' COMMENT 'LOCAL 本地，REMOTE 远程',
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `extension` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `size` int DEFAULT NULL,
  `md5` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'md5值，防止上传重复文件',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `md5_del` (`md5`,`delete_time`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='存储图片地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_file`
--

LOCK TABLES `lin_file` WRITE;
/*!40000 ALTER TABLE `lin_file` DISABLE KEYS */;
INSERT INTO `lin_file` VALUES (17,'http://qocfrob1z.hn-bkt.clouddn.com/3f3afc6862794538bf3fa2380150740d.png','REMOTE','3f3afc6862794538bf3fa2380150740d.png','.png',39861,'2903dd6a185d508ab65585b444e1681f','2021-02-12 18:40:59.646','2021-02-12 18:40:59.646',NULL),(18,'http://qocfrob1z.hn-bkt.clouddn.com/1c99b8cb1370484d98b3846f104b0420.png','REMOTE','1c99b8cb1370484d98b3846f104b0420.png','.png',57374,'956d5553e17014e107edc44e963fa1b7','2021-02-12 18:42:27.094','2021-02-12 18:42:27.094',NULL),(19,'http://qocfrob1z.hn-bkt.clouddn.com/cc0449c751c7421791e6aed7c5b8093d.png','REMOTE','cc0449c751c7421791e6aed7c5b8093d.png','.png',90961,'c28eb26b9bcd2d14d1968b08c5b384e1','2021-02-12 18:43:29.402','2021-02-12 18:43:29.402',NULL),(20,'http://qocfrob1z.hn-bkt.clouddn.com/b9568163c1ca47fb93fd179b2dc9eeac.png','REMOTE','b9568163c1ca47fb93fd179b2dc9eeac.png','.png',94068,'8bcbde44d50ff414a7af93b68e8de541','2021-02-12 18:44:19.474','2021-02-12 18:44:19.474',NULL),(21,'http://qocfrob1z.hn-bkt.clouddn.com/08f9c63bb44b4294999f035b7ebbe6c4.png','REMOTE','08f9c63bb44b4294999f035b7ebbe6c4.png','.png',7628,'4bdf6b3e6e5754b2d06edebe10bf3194','2021-02-12 18:45:42.286','2021-02-12 18:45:42.286',NULL),(24,'http://qocfrob1z.hn-bkt.clouddn.com/d05d16dd612747d4ab21887554fa2706.png','REMOTE','d05d16dd612747d4ab21887554fa2706.png','.png',88442,'38b8bf53dc5f75c0b1a8cc736b50e181','2021-02-13 16:43:55.310','2021-02-13 16:43:55.310',NULL),(25,'http://qocfrob1z.hn-bkt.clouddn.com/06c12ffc93b847bd90b7a59519cb0eeb.png','REMOTE','06c12ffc93b847bd90b7a59519cb0eeb.png','.png',9265,'6cd88bf627d75724ecf844193ea9eee6','2021-02-22 19:25:18.069','2021-02-22 19:25:18.069',NULL);
/*!40000 ALTER TABLE `lin_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_group`
--

DROP TABLE IF EXISTS `lin_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_group` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL COMMENT '分组名称，例如：搬砖者',
  `info` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组信息：例如：搬砖的人',
  `level` tinyint NOT NULL DEFAULT '3' COMMENT '分组级别 1：root 2：guest 3：user  root（root、guest分组只能存在一个)',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_del` (`name`,`delete_time`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_group`
--

LOCK TABLES `lin_group` WRITE;
/*!40000 ALTER TABLE `lin_group` DISABLE KEYS */;
INSERT INTO `lin_group` VALUES (1,'root','超级用户组',1,'2020-11-03 22:09:46.039','2020-11-03 22:09:46.039',NULL),(2,'guest','游客组',2,'2020-11-03 22:09:46.042','2020-11-03 22:09:46.042',NULL),(3,'Banner管理员','管理当前系统中的banner模块',3,'2021-02-10 13:42:13.090','2021-02-10 13:42:13.090',NULL),(4,'分类管理员','负责商品分类的管理',3,'2021-02-23 16:10:44.111','2021-02-23 16:10:44.111',NULL),(5,'六宫格管理员','负责六宫格的管理',3,'2021-03-09 11:45:41.004','2021-03-09 11:45:41.004',NULL),(6,'规格管理员','负责规格名及规格值的管理',3,'2021-03-09 11:46:21.522','2021-03-09 11:46:21.522',NULL);
/*!40000 ALTER TABLE `lin_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_group_permission`
--

DROP TABLE IF EXISTS `lin_group_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_group_permission` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `group_id` int unsigned NOT NULL COMMENT '分组id',
  `permission_id` int unsigned NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `group_id_permission_id` (`group_id`,`permission_id`) USING BTREE COMMENT '联合索引'
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户组权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_group_permission`
--

LOCK TABLES `lin_group_permission` WRITE;
/*!40000 ALTER TABLE `lin_group_permission` DISABLE KEYS */;
INSERT INTO `lin_group_permission` VALUES (2,3,5),(3,3,6),(4,3,7),(5,3,8),(6,4,15),(7,4,16),(8,4,17),(9,4,18),(10,5,21),(11,5,22),(12,5,23),(13,5,24),(18,6,9),(19,6,10),(20,6,11),(14,6,12),(15,6,13),(16,6,14),(21,6,19),(17,6,20);
/*!40000 ALTER TABLE `lin_group_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_log`
--

DROP TABLE IF EXISTS `lin_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `message` varchar(450) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_id` int unsigned NOT NULL,
  `username` varchar(24) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status_code` int DEFAULT NULL,
  `method` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `path` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `permission` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='行为日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_log`
--

LOCK TABLES `lin_log` WRITE;
/*!40000 ALTER TABLE `lin_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `lin_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_permission`
--

DROP TABLE IF EXISTS `lin_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_permission` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称，例如：访问首页',
  `module` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限所属模块，例如：人员管理',
  `mount` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0：关闭 1：开启',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_permission`
--

LOCK TABLES `lin_permission` WRITE;
/*!40000 ALTER TABLE `lin_permission` DISABLE KEYS */;
INSERT INTO `lin_permission` VALUES (1,'查询所有日志','日志',1,'2020-11-03 22:11:52.201','2020-11-03 22:11:52.201',NULL),(2,'搜索日志','日志',1,'2020-11-03 22:11:52.212','2020-11-03 22:11:52.212',NULL),(3,'删除图书','图书',1,'2020-11-03 22:11:52.222','2020-11-03 22:11:52.222',NULL),(4,'查询日志记录的用户','日志',1,'2020-11-03 22:11:52.237','2020-11-03 22:11:52.237',NULL),(5,'创建Banner','Banner',0,'2021-01-25 21:13:06.138','2021-03-09 11:36:00.488',NULL),(6,'更新Banner','Banner',0,'2021-01-25 21:13:06.151','2021-03-09 11:36:00.495',NULL),(7,'查询Banner','Banner',0,'2021-01-25 21:13:06.155','2021-03-09 11:36:00.500',NULL),(8,'删除Banner','Banner',0,'2021-01-25 21:13:06.159','2021-03-09 11:36:00.503',NULL),(9,'创建规格','规格名',0,'2021-01-25 21:14:57.537','2021-03-09 11:51:15.374',NULL),(10,'更新规格','规格名',0,'2021-01-25 21:14:57.543','2021-03-09 11:51:15.384',NULL),(11,'删除规格','规格名',0,'2021-01-25 21:14:57.548','2021-03-09 11:51:15.387',NULL),(12,'创建规格值','规格值',0,'2021-01-25 21:15:53.996','2021-03-09 11:36:00.514',NULL),(13,'更新规格值','规格值',0,'2021-01-25 21:15:54.001','2021-03-09 11:36:00.517',NULL),(14,'删除规格值','规格值',0,'2021-01-25 21:15:54.005','2021-03-09 11:36:00.519',NULL),(15,'创建分类','分类',0,'2021-02-10 21:20:29.489','2021-03-09 11:36:00.522',NULL),(16,'更新分类','分类',0,'2021-02-10 21:20:47.651','2021-03-09 11:36:00.524',NULL),(17,'删除分类','分类',0,'2021-02-10 21:21:05.713','2021-03-09 11:36:00.527',NULL),(18,'查询分类','分类',0,'2021-02-10 21:21:25.075','2021-03-09 11:36:00.530',NULL),(19,'查询规格','规格名',0,'2021-03-02 17:18:20.638','2021-03-09 11:51:15.390',NULL),(20,'查询规格值','规格值',0,'2021-03-02 17:18:48.139','2021-03-09 11:36:00.540',NULL),(21,'创建Grid','六宫格',0,'2021-03-09 11:40:39.410','2021-03-09 11:40:39.410',NULL),(22,'更新Grid','六宫格',0,'2021-03-09 11:40:39.418','2021-03-09 11:40:39.418',NULL),(23,'查询Grid','六宫格',0,'2021-03-09 11:40:39.421','2021-03-09 11:40:39.421',NULL),(24,'删除Grid','六宫格',0,'2021-03-09 11:40:39.426','2021-03-09 11:40:39.426',NULL),(25,'查询SPU','SPU',0,'2021-03-09 11:42:11.859','2021-03-09 11:42:11.859',NULL),(26,'更新SPU','SPU',0,'2021-03-09 11:42:11.865','2021-03-09 11:42:11.865',NULL),(27,'创建SPU','SPU',0,'2021-03-09 11:42:11.869','2021-03-09 11:42:11.869',NULL),(28,'删除SPU','SPU',0,'2021-03-09 11:42:11.873','2021-03-09 11:42:11.873',NULL);
/*!40000 ALTER TABLE `lin_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_user`
--

DROP TABLE IF EXISTS `lin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(24) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名，唯一',
  `nickname` varchar(24) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像url',
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_del` (`username`,`delete_time`),
  UNIQUE KEY `email_del` (`email`,`delete_time`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_user`
--

LOCK TABLES `lin_user` WRITE;
/*!40000 ALTER TABLE `lin_user` DISABLE KEYS */;
INSERT INTO `lin_user` VALUES (1,'root','root',NULL,NULL,'2020-11-03 22:09:46.032','2020-11-03 22:09:46.032',NULL),(2,'chen','chen',NULL,'chenguiquan1997@sina.com','2021-01-11 11:19:37.254','2021-02-10 13:45:08.970',NULL),(3,'test','teest',NULL,'test@sina.com','2021-01-26 16:30:26.640','2021-02-10 13:45:08.976',NULL),(4,'banner','banner',NULL,'banner@sina.com','2021-02-10 13:43:41.704','2021-02-10 13:43:41.704',NULL),(5,'category','category',NULL,'category@sina.com','2021-02-23 16:11:38.672','2021-02-23 16:11:38.672',NULL),(6,'grid',NULL,NULL,'grid@sina.com','2021-03-09 11:47:15.014','2021-03-09 11:47:15.014',NULL),(7,'spec','spec',NULL,'spec@sina.com','2021-03-09 11:49:06.523','2021-03-09 11:49:06.523',NULL);
/*!40000 ALTER TABLE `lin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_user_group`
--

DROP TABLE IF EXISTS `lin_user_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_user_group` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  `group_id` int unsigned NOT NULL COMMENT '分组id',
  PRIMARY KEY (`id`),
  KEY `user_id_group_id` (`user_id`,`group_id`) USING BTREE COMMENT '联合索引'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户-组关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_user_group`
--

LOCK TABLES `lin_user_group` WRITE;
/*!40000 ALTER TABLE `lin_user_group` DISABLE KEYS */;
INSERT INTO `lin_user_group` VALUES (1,1,1),(2,2,2),(3,3,2),(4,4,3),(5,5,4),(8,6,4),(7,6,5),(9,7,6);
/*!40000 ALTER TABLE `lin_user_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_user_identity`
--

DROP TABLE IF EXISTS `lin_user_identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lin_user_identity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  `identity_type` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `identifier` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `credential` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `delete_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息校验表，例如存储密码等';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_user_identity`
--

LOCK TABLES `lin_user_identity` WRITE;
/*!40000 ALTER TABLE `lin_user_identity` DISABLE KEYS */;
INSERT INTO `lin_user_identity` VALUES (1,1,'USERNAME_PASSWORD','root','pbkdf2sha256:64000:18:24:n:yUnDokcNRbwILZllmUOItIyo9MnI00QW:6ZcPf+sfzyoygOU8h/GSoirF','2020-11-03 22:09:46.035','2020-11-03 22:09:46.035',NULL),(2,2,'USERNAME_PASSWORD','chen','pbkdf2sha256:64000:18:24:n:Wo5hBLmg+kLK62hx8M3QQXulYFfWtUbS:1iZdhpIt14rWaLQpShR3MElV','2021-01-11 11:19:37.488','2021-01-11 11:19:37.488',NULL),(3,3,'USERNAME_PASSWORD','test','pbkdf2sha256:64000:18:24:n:bAnZYOIByiaOLlmys19Tq0v/0h/s6zB+:lSG6KtylrAIoMFNHoqBkjPRu','2021-01-26 16:30:26.841','2021-01-26 16:30:26.841',NULL),(4,4,'USERNAME_PASSWORD','banner','pbkdf2sha256:64000:18:24:n:88MBQgRjte0xwzv/uJTHAiFzTFqLxbcQ:7/zoC214aFTYERBYlcM784qI','2021-02-10 13:43:41.916','2021-02-10 13:43:41.916',NULL),(5,5,'USERNAME_PASSWORD','category','pbkdf2sha256:64000:18:24:n:EmhOF6lyTn1oFHl7whINx9kapoudTvwN:UUbOKzd6diLu22IRMq8R53sA','2021-02-23 16:11:38.877','2021-02-23 16:11:38.877',NULL),(6,6,'USERNAME_PASSWORD','grid','pbkdf2sha256:64000:18:24:n:6IioKAHhm7c84HoE+c/0au3cJoKbZsA+:5viSnRlCj4Sf9D5Qq5bWgLUZ','2021-03-09 11:47:15.196','2021-03-09 11:47:15.196',NULL),(7,7,'USERNAME_PASSWORD','spec','pbkdf2sha256:64000:18:24:n:cclLZwcyyOAdeV+EXpLXVoaA5Y4VbZxt:wftTtVx54s79X1EIYBqnvHKS','2021-03-09 11:49:06.727','2021-03-09 11:49:06.727',NULL);
/*!40000 ALTER TABLE `lin_user_identity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务订单号',
  `user_id` int unsigned NOT NULL COMMENT '关联的订单id',
  `total_count` int unsigned NOT NULL DEFAULT '0' COMMENT '当前订单所包含商品的数量',
  `total_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '当前订单应付的总价格',
  `final_total_price` decimal(10,2) DEFAULT NULL COMMENT '当前订单实付金额',
  `snap_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单概要图片',
  `snap_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '订单概要title',
  `snap_items` json DEFAULT NULL,
  `snap_address` json DEFAULT NULL,
  `prepay_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用于微信支付',
  `status` int unsigned NOT NULL DEFAULT '1' COMMENT '订单状态 1：待支付，2：已支付，3：已发货，4：已完成，5：已取消',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  `expire_time` timestamp NULL DEFAULT NULL COMMENT '订单过期时间',
  `placed_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_un` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,'200820215706242869',4,6,466.56,466.46,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 6, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 466.56, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-08-20 13:57:06','2020-08-23 08:50:39',NULL,'2020-08-20 14:12:06','2020-08-20 13:57:06'),(4,'200820223750119893',4,6,466.56,466.46,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 6, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 466.56, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-08-20 14:37:50','2020-08-23 08:50:39',NULL,'2020-08-20 14:52:51','2020-08-20 14:37:51'),(5,'200820223902547067',4,6,466.56,466.56,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 6, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 466.56, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,3,'2020-08-20 14:39:02','2020-10-27 12:27:32',NULL,'2020-08-20 14:54:02','2020-08-20 14:39:02'),(6,'200820224119802092',4,6,466.56,466.46,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 6, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 466.56, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,3,'2020-08-20 14:41:19','2020-10-27 12:27:32',NULL,'2020-08-20 14:56:20','2020-08-20 14:41:20'),(8,'200820224123619880',4,6,466.56,466.46,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 6, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 466.56, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,4,'2020-08-20 14:41:23','2020-10-27 12:27:32',NULL,'2020-08-20 14:56:24','2020-08-20 14:41:24'),(13,'200820225304813495',4,6,466.56,466.46,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 6, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 466.56, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-08-20 14:53:04','2020-08-20 14:53:04',NULL,'2020-08-20 15:08:05','2020-08-20 14:53:05'),(14,'200821203117287513',4,9,606.04,506.04,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 5, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 295.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,4,'2020-08-21 12:31:17','2020-10-27 12:27:32',NULL,'2020-08-21 12:46:17','2020-08-21 12:31:17'),(15,'200821203914978192',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-08-21 12:39:14','2020-08-23 03:29:55',NULL,'2020-08-25 12:54:15','2020-08-21 12:39:15'),(16,'200821205310356423',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,3,'2020-08-21 12:53:10','2020-10-27 12:27:32',NULL,'2020-08-21 13:08:10','2020-08-21 12:53:10'),(17,'2009062058389766153',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-06 12:58:38','2020-09-06 12:58:38',NULL,'2020-09-06 13:58:38','2020-09-06 12:58:38'),(18,'2009072209082719173',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-07 14:09:08','2020-09-07 14:09:08',NULL,'2020-09-07 15:09:09','2020-09-07 14:09:09'),(19,'2009072213321955576',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-07 14:13:32','2020-10-27 12:35:58',NULL,'2020-10-27 14:33:33','2020-09-07 14:13:33'),(20,'2009072215468124005',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,3,'2020-09-07 14:15:46','2020-10-27 12:27:32',NULL,'2020-09-07 14:35:47','2020-09-07 14:15:47'),(21,'2009072216433018839',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-07 14:16:43','2020-09-07 14:16:43',NULL,'2020-09-07 14:36:44','2020-09-07 14:16:44'),(22,'2009072218031216929',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-07 14:18:03','2020-09-07 14:18:03',NULL,'2020-09-07 14:38:04','2020-09-07 14:18:04'),(23,'2009072220015640001',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-07 14:20:01','2020-09-07 14:20:01',NULL,'2020-09-07 14:40:01','2020-09-07 14:20:01'),(24,'2009072224453486223',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,3,'2020-09-07 14:24:45','2020-10-27 12:27:32',NULL,'2020-09-07 14:44:46','2020-09-07 14:24:46'),(25,'2009081937085622668',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-09-08 11:37:08','2020-09-08 11:37:08',NULL,'2020-09-08 11:57:08','2020-09-08 11:37:08'),(26,'2009092015505121392',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-09 12:15:50','2020-09-09 12:16:10',NULL,'2020-09-09 12:35:50','2020-09-09 12:15:50'),(27,'2009092018214989313',4,23,1722.04,1722.04,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 4, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 311.04, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-09 12:18:21','2020-09-09 12:18:41',NULL,'2020-09-09 12:38:22','2020-09-09 12:18:22'),(28,'2009092228487291605',4,25,1858.80,1858.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-09 14:28:49','2020-09-09 14:29:09',NULL,'2020-09-09 14:48:49','2020-09-09 14:28:49'),(29,'2009102212057260642',4,25,1858.80,1858.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-10 14:12:05','2020-09-10 14:12:25',NULL,'2020-09-10 14:12:25','2020-09-10 14:12:05'),(30,'2009102214514010169',4,25,1858.80,1858.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,4,'2020-09-10 14:14:51','2020-10-27 12:27:32',NULL,'2020-09-10 14:24:52','2020-09-10 14:14:52'),(31,'2009112048371462505',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-11 12:48:37','2020-09-11 12:58:37',NULL,'2020-09-11 12:58:37','2020-09-11 12:48:37'),(32,'2009172205353726531',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-17 14:05:35','2020-09-17 14:21:47',NULL,'2020-09-17 14:06:35','2020-09-17 14:05:35'),(33,'2009172228554125627',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,4,'2020-09-17 14:28:55','2020-10-27 12:27:32',NULL,'2020-09-17 14:29:56','2020-09-17 14:28:56'),(38,'2009191029061014240',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-19 02:29:06','2020-09-19 02:31:06',NULL,'2020-09-19 02:30:06','2020-09-19 02:29:06'),(40,'2009191446248957705',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-19 06:46:24','2020-09-19 09:50:15',NULL,'2020-09-19 06:47:25','2020-09-19 06:46:25'),(41,'2009191803168168053',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-09-19 10:03:16','2020-09-19 10:03:35',NULL,'2020-09-19 10:04:16','2020-09-19 10:03:16'),(42,'2009191823475744065',4,25,1858.80,1758.80,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 5, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 388.8, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·灌篮高手\", \"spu_id\": 1, \"final_price\": 590.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 10, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 880.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"397号\", \"mobile\": \"020-811\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-09-19 10:23:47','2020-09-19 10:24:48',NULL,'2020-09-19 10:24:48','2020-09-19 10:23:48'),(43,'2010192211366119535',4,7,587.00,587.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 6, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 528.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-19 14:11:36','2020-10-19 14:11:36',NULL,'2020-10-19 14:12:37','2020-10-19 14:11:37'),(44,'2010192219444942014',4,7,587.00,557.65,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 6, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 528.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,4,'2020-10-19 14:19:44','2020-10-27 12:27:32',NULL,'2020-10-19 14:20:44','2020-10-19 14:19:44'),(45,'2010202144225420660',4,7,587.00,509.23,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 6, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 528.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-20 13:44:22','2020-10-20 13:44:22',NULL,'2020-10-20 13:45:22','2020-10-20 13:44:22'),(46,'2010212133022378606',4,7,587.00,581.13,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 6, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 528.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-21 13:33:02','2020-10-21 13:33:02',NULL,'2020-10-21 13:34:02','2020-10-21 13:33:02'),(47,'2010222210343749396',4,7,587.00,509.23,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 6, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 528.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-22 14:10:34','2020-10-22 14:10:34',NULL,'2020-10-22 14:11:34','2020-10-22 14:10:34'),(48,'2010222212522410217',4,7,587.00,587.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 6, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 528.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-22 14:12:52','2020-10-22 14:12:52',NULL,'2020-10-22 14:13:53','2020-10-22 14:12:53'),(49,'2010222217425779237',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-22 14:17:42','2020-10-22 14:17:42',NULL,'2020-10-22 14:18:42','2020-10-22 14:17:42'),(50,'2010240934155191328',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 01:34:15','2020-10-24 01:34:15',NULL,'2020-10-24 01:35:15','2020-10-24 01:34:15'),(51,'2010240935058237381',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 01:35:05','2020-10-24 01:35:05',NULL,'2020-10-24 01:36:05','2020-10-24 01:35:05'),(52,'2010240956094434679',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 01:56:09','2020-10-24 01:56:09',NULL,'2020-10-24 01:57:09','2020-10-24 01:56:09'),(53,'2010240956441064977',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 01:56:44','2020-10-24 01:56:44',NULL,'2020-10-24 01:57:45','2020-10-24 01:56:45'),(54,'2010240958308968832',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 01:58:30','2020-10-24 01:58:30',NULL,'2020-10-24 01:59:30','2020-10-24 01:58:30'),(55,'2010240958477468006',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 01:58:47','2020-10-24 01:58:47',NULL,'2020-10-24 01:59:47','2020-10-24 01:58:47'),(56,'2010241000494967592',5,26,1600.52,1600.52,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 2, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 155.52, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 15, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 885.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 8, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 472.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"杭州市\", \"county\": \"滨江区\", \"detail\": \"伟业路高新软件园\", \"mobile\": \"18804626698\", \"province\": \"浙江省\", \"user_name\": \"ChenGuiquan\", \"postal_code\": \"310051\", \"national_code\": \"330108\"}',NULL,1,'2020-10-24 02:00:49','2020-10-24 02:00:49',NULL,'2020-10-24 02:01:50','2020-10-24 02:00:50'),(57,'2010241005428945864',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:05:42','2020-10-24 02:05:42',NULL,'2020-10-24 02:06:43','2020-10-24 02:05:43'),(58,'2010241005533598062',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:05:53','2020-10-24 02:05:53',NULL,'2020-10-24 02:06:54','2020-10-24 02:05:54'),(59,'2010241016066059410',4,2,147.00,147.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 88.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:16:06','2020-10-24 02:16:06',NULL,'2020-10-24 02:17:06','2020-10-24 02:16:06'),(60,'2010241026409996125',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:26:40','2020-10-24 02:26:40',NULL,'2020-10-24 02:27:41','2020-10-24 02:26:41'),(61,'2010241031363984229',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:31:36','2020-10-24 02:31:36',NULL,'2020-10-24 02:32:37','2020-10-24 02:31:37'),(62,'2010241044031840443',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:44:03','2020-10-24 02:44:03',NULL,'2020-10-24 02:45:03','2020-10-24 02:44:03'),(63,'2010241048039960729',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:48:03','2020-10-24 02:48:03',NULL,'2020-10-24 02:49:04','2020-10-24 02:48:04'),(64,'2010241049043594654',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:49:04','2020-10-24 02:49:04',NULL,'2020-10-24 02:50:05','2020-10-24 02:49:05'),(65,'2010241049483831863',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:49:48','2020-10-24 02:49:48',NULL,'2020-10-24 02:50:48','2020-10-24 02:49:48'),(66,'2010241051561348805',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:51:56','2020-10-24 02:51:56',NULL,'2020-10-24 02:52:57','2020-10-24 02:51:57'),(67,'2010241052365390200',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:52:36','2020-10-24 02:52:36',NULL,'2020-10-24 02:53:37','2020-10-24 02:52:37'),(68,'2010241054093169184',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:54:09','2020-10-24 02:54:09',NULL,'2020-10-24 02:55:09','2020-10-24 02:54:09'),(69,'2010241055478953092',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:55:47','2020-10-24 02:55:47',NULL,'2020-10-24 02:56:48','2020-10-24 02:55:48'),(70,'2010241057171438138',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 02:57:17','2020-10-24 02:57:17',NULL,'2020-10-24 02:58:17','2020-10-24 02:57:17'),(71,'2010241106341089412',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:06:34','2020-10-24 03:06:34',NULL,'2020-10-24 03:07:34','2020-10-24 03:06:34'),(72,'2010241107186700342',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:07:18','2020-10-24 03:07:18',NULL,'2020-10-24 03:08:19','2020-10-24 03:07:19'),(73,'2010241108069390917',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:08:06','2020-10-24 03:08:06',NULL,'2020-10-24 03:09:07','2020-10-24 03:08:07'),(74,'2010241108589538136',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:08:58','2020-10-24 03:08:58',NULL,'2020-10-24 03:09:58','2020-10-24 03:08:58'),(75,'2010241146574538668',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:46:57','2020-10-24 03:46:57',NULL,'2020-10-24 03:47:58','2020-10-24 03:46:58'),(76,'2010241147164375328',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:47:16','2020-10-24 03:47:16',NULL,'2020-10-24 03:48:16','2020-10-24 03:47:16'),(77,'2010241148343098542',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2020-10-24 03:48:34','2020-10-24 03:48:34',NULL,'2020-10-24 03:49:34','2020-10-24 03:48:34'),(78,'2010241618386397921',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-10-24 08:18:38','2020-10-24 08:19:38',NULL,'2020-10-24 08:19:38','2020-10-24 08:18:38'),(79,'2010250931283674767',4,3,233.28,233.28,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 3, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 233.28, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-10-25 01:31:28','2020-10-25 01:32:28',NULL,'2020-10-25 01:32:29','2020-10-25 01:31:29'),(80,'2010310951229172829',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-10-31 01:51:22','2020-10-31 01:52:22',NULL,'2020-10-31 01:52:23','2020-10-31 01:51:23'),(81,'2010311646158035306',4,9,531.00,504.45,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-10-31 08:46:15','2020-10-31 08:47:16',NULL,'2020-10-31 08:47:16','2020-10-31 08:46:16'),(82,'2010311725339304871',4,9,531.00,531.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-10-31 09:25:33','2020-10-31 09:26:33',NULL,'2020-10-31 09:26:34','2020-10-31 09:25:34'),(83,'2010311732269482556',4,9,531.00,531.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 9, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 531.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-10-31 09:32:26','2020-10-31 09:32:26',NULL,'2020-10-31 09:33:26','2020-10-31 09:32:26'),(84,'2010311739113788494',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-10-31 09:39:11','2020-10-31 09:39:11',NULL,'2020-10-31 09:40:11','2020-10-31 09:39:11'),(85,'2010311740088787507',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-10-31 09:40:08','2020-10-31 09:40:09',NULL,'2020-10-31 09:41:09','2020-10-31 09:40:09'),(86,'2011011054255504604',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 02:54:25','2020-11-01 02:54:25',NULL,'2020-11-01 02:55:26','2020-11-01 02:54:26'),(87,'2011011054588899771',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 02:54:58','2020-11-01 02:54:58',NULL,'2020-11-01 02:55:59','2020-11-01 02:54:59'),(88,'2011011055122770281',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 02:55:12','2020-11-01 02:55:12',NULL,'2020-11-01 02:56:12','2020-11-01 02:55:12'),(89,'2011011057049654515',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 02:57:04','2020-11-01 02:57:04',NULL,'2020-11-01 03:02:05','2020-11-01 02:57:05'),(90,'2011011107263021674',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:07:26','2020-11-01 03:12:26',NULL,'2020-11-01 03:12:27','2020-11-01 03:07:27'),(91,'2011011111533908892',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:11:53','2020-11-01 03:16:54',NULL,'2020-11-01 03:16:54','2020-11-01 03:11:54'),(92,'2011011112042755825',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:12:04','2020-11-01 03:17:04',NULL,'2020-11-01 03:17:05','2020-11-01 03:12:05'),(93,'2011011112102857578',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:12:10','2020-11-01 03:17:10',NULL,'2020-11-01 03:17:10','2020-11-01 03:12:10'),(94,'2011011112101600345',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:12:10','2020-11-01 03:17:10',NULL,'2020-11-01 03:17:10','2020-11-01 03:12:10'),(95,'2011011112191697410',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:12:19','2020-11-01 03:17:20',NULL,'2020-11-01 03:17:20','2020-11-01 03:12:20'),(96,'2011011112207252394',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:12:20','2020-11-01 03:17:20',NULL,'2020-11-01 03:17:20','2020-11-01 03:12:20'),(97,'2011011118236742253',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:18:23','2020-11-01 03:23:23',NULL,'2020-11-01 03:23:24','2020-11-01 03:18:24'),(98,'2011011157303254242',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:57:30','2020-11-01 04:02:30',NULL,'2020-11-01 04:02:30','2020-11-01 03:57:30'),(99,'2011011159512593020',4,4,294.00,294.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 2, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 176.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 2, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 118.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 03:59:51','2020-11-01 04:04:51',NULL,'2020-11-01 04:04:51','2020-11-01 03:59:51'),(100,'2011011235514071693',4,4,294.00,294.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士','[{\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 2, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 176.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 2, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 118.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 04:35:51','2020-11-01 04:35:54',NULL,'2020-11-01 04:40:51','2020-11-01 04:35:51'),(101,'2011011236355113091',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 04:36:35','2020-11-01 04:41:35',NULL,'2020-11-01 04:41:36','2020-11-01 04:36:36'),(102,'2011011236516932119',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 04:36:51','2020-11-01 04:41:51',NULL,'2020-11-01 04:41:51','2020-11-01 04:36:51'),(103,'2011011238363849751',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-11-01 04:38:36','2020-11-01 04:43:36',NULL,'2020-11-01 04:43:36','2020-11-01 04:38:36'),(104,'2011011239175132440',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 04:39:17','2020-11-01 04:39:18',NULL,'2020-11-01 04:44:18','2020-11-01 04:39:18'),(105,'2011011510111474961',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-11-01 07:10:11','2020-11-01 07:10:13',NULL,'2020-11-01 07:15:11','2020-11-01 07:10:11'),(106,'2012061021465419515',4,6,449.52,449.52,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠','[{\"id\": 1, \"img\": \"http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png\", \"count\": 2, \"title\": \"金属灰·七龙珠\", \"spu_id\": 1, \"final_price\": 155.52, \"spec_values\": [\"金属灰\", \"七龙珠\", \"小号 S\"], \"single_price\": 77.76}, {\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 3, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 2, \"title\": \"青芒色·圣斗士\", \"spu_id\": 1, \"final_price\": 176.0, \"spec_values\": [\"青芒色\", \"圣斗士\", \"大号  L\"], \"single_price\": 88.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2020-12-06 02:21:46','2020-12-06 02:22:09',NULL,'2020-12-06 02:26:47','2020-12-06 02:21:47'),(107,'2012061023284881098',4,2,118.00,118.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}, {\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,5,'2020-12-06 02:23:28','2020-12-06 02:28:28',NULL,'2020-12-06 02:28:28','2020-12-06 02:23:28'),(108,'2101311904044546537',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2021-01-31 11:04:04','2021-01-31 11:04:35',NULL,'2021-01-31 11:09:05','2021-01-31 11:04:05'),(109,'2101311904084771704',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...','[{\"id\": 2, \"img\": \"http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png\", \"count\": 1, \"title\": \"青芒色·灌篮高手谢谢谢谢谢谢撒发撒士大夫撒旦...\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"青芒色\", \"灌篮高手\", \"中号 M\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2021-01-31 11:04:08','2021-01-31 11:04:08',NULL,'2021-01-31 11:09:09','2021-01-31 11:04:09'),(110,'2102231116457294910',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png','橘黄色·七龙珠','[{\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,2,'2021-02-23 03:16:45','2021-02-23 03:17:02',NULL,'2021-02-23 03:21:45','2021-02-23 03:16:45'),(111,'2102231116534918163',4,1,59.00,59.00,'http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png','橘黄色·七龙珠','[{\"id\": 4, \"img\": \"http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png\", \"count\": 1, \"title\": \"橘黄色·七龙珠\", \"spu_id\": 1, \"final_price\": 59.0, \"spec_values\": [\"橘黄色\", \"七龙珠\", \"小号 S\"], \"single_price\": 59.0}]','{\"city\": \"广州市\", \"county\": \"海珠区\", \"detail\": \"新港中路397号\", \"mobile\": \"020-81167888\", \"province\": \"广东省\", \"user_name\": \"张三\", \"postal_code\": \"510000\", \"national_code\": \"510000\"}',NULL,1,'2021-02-23 03:16:53','2021-02-23 03:16:53',NULL,'2021-02-23 03:21:54','2021-02-23 03:16:54');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku`
--

DROP TABLE IF EXISTS `sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sku` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `price` decimal(10,2) NOT NULL COMMENT '当前单品的常规价格',
  `discount_price` decimal(10,2) DEFAULT NULL COMMENT '当前单品的折扣价格',
  `online` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '"1"代表上架，"2"代表下架',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `spu_id` int unsigned NOT NULL COMMENT '关联的spu表id',
  `specs` json DEFAULT NULL COMMENT '当前sku规格',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `stock` int unsigned DEFAULT '0' COMMENT 'sku库存',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除',
  `category_id` int unsigned DEFAULT NULL COMMENT '当前sku所属的分类Id',
  `root_category_id` int unsigned DEFAULT NULL COMMENT '当前sku所属的root分类Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='单品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku`
--

LOCK TABLES `sku` WRITE;
/*!40000 ALTER TABLE `sku` DISABLE KEYS */;
INSERT INTO `sku` VALUES (1,77.76,NULL,1,'http://i1.sleeve.7yue.pro/assets/2d22ffec-b1c1-43e0-ad21-25aa5c26ab34.png','金属灰·七龙珠',1,'[{\"key\": \"颜色\", \"value\": \"金属灰\", \"key_id\": 1, \"value_id\": 1}, {\"key\": \"图案\", \"value\": \"七龙珠\", \"key_id\": 2, \"value_id\": 4}, {\"key\": \"尺码\", \"value\": \"小号 S\", \"key_id\": 3, \"value_id\": 7}]','1$1-1#2-4#3-7',16,'2020-07-10 13:28:37','2020-12-06 02:21:46',NULL,14,2),(2,66.00,59.00,1,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·灌篮高手',1,'[{\"key\": \"颜色\", \"value\": \"青芒色\", \"key_id\": 1, \"value_id\": 2}, {\"key\": \"图案\", \"value\": \"灌篮高手\", \"key_id\": 2, \"value_id\": 5}, {\"key\": \"尺码\", \"value\": \"中号 M\", \"key_id\": 3, \"value_id\": 8}]','1$1-2#2-5#3-8',532,'2020-07-10 13:31:46','2021-03-10 03:17:42',NULL,14,2),(3,88.00,NULL,1,'http://i1.sleeve.7yue.pro/assets/c6b52c90-5b10-4823-baef-6c37d3d3532f.png','青芒色·圣斗士',1,'[{\"key\": \"颜色\", \"value\": \"青芒色\", \"key_id\": 1, \"value_id\": 2}, {\"key\": \"图案\", \"value\": \"圣斗士\", \"key_id\": 2, \"value_id\": 6}, {\"key\": \"尺码\", \"value\": \"大号  L\", \"key_id\": 3, \"value_id\": 9}]','1$1-2#2-6#3-9',16,'2020-07-10 13:33:08','2020-12-06 02:21:46',NULL,14,2),(4,77.00,59.00,1,'http://i1.sleeve.7yue.pro/assets/09f32ac8-1af4-4424-b221-44b10bd0986e.png','橘黄色·七龙珠',1,'[{\"key\": \"颜色\", \"value\": \"橘黄色\", \"key_id\": 1, \"value_id\": 3}, {\"key\": \"图案\", \"value\": \"七龙珠\", \"key_id\": 2, \"value_id\": 4}, {\"key\": \"尺码\", \"value\": \"小号 S\", \"key_id\": 3, \"value_id\": 7}]','1$1-3#2-4#3-7',15,'2020-07-10 13:35:12','2021-02-23 03:16:53',NULL,14,2);
/*!40000 ALTER TABLE `sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku_spec`
--

DROP TABLE IF EXISTS `sku_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sku_spec` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` int unsigned NOT NULL COMMENT 'spu表id',
  `sku_id` int unsigned NOT NULL COMMENT 'sku表id',
  `key_id` int unsigned NOT NULL COMMENT 'spec_key表id',
  `value_id` int unsigned NOT NULL COMMENT 'spec_value表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='单品和规格的关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku_spec`
--

LOCK TABLES `sku_spec` WRITE;
/*!40000 ALTER TABLE `sku_spec` DISABLE KEYS */;
INSERT INTO `sku_spec` VALUES (1,1,1,1,1),(2,1,1,1,2),(3,1,1,1,3),(4,1,1,1,4);
/*!40000 ALTER TABLE `sku_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spec_key`
--

DROP TABLE IF EXISTS `spec_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spec_key` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名',
  `unit` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '规格单位',
  `standard` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否为标准规格 0：非标，1：标准',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='当前表记录的是所有的规格名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spec_key`
--

LOCK TABLES `spec_key` WRITE;
/*!40000 ALTER TABLE `spec_key` DISABLE KEYS */;
INSERT INTO `spec_key` VALUES (1,'颜色','',0,'通用规格','2020-07-15 13:01:01','2021-03-09 03:34:29',NULL),(2,'图案',NULL,0,'通用规格','2020-07-15 13:01:20','2021-03-02 08:32:43',NULL),(3,'尺码','码',1,'通用规格','2020-07-15 13:01:49','2021-03-02 08:32:43',NULL),(4,'数量','个',1,'通用规格','2020-11-30 12:06:48','2021-03-09 03:34:29',NULL),(10,'尺寸','英寸',1,'通用规格','2021-03-01 13:15:28','2021-03-09 03:34:29',NULL),(14,'尺寸(非标)','米',0,'一般用于衡量家居的长度','2021-03-02 06:17:41','2021-03-09 03:34:29',NULL),(15,'高度',NULL,0,'一般用于衡量家居的相对高低','2021-03-02 06:18:19','2021-03-09 03:33:21',NULL),(16,'口味',NULL,0,'用于食品规格','2021-03-02 06:21:53','2021-03-09 03:33:21',NULL),(17,'版本',NULL,0,'用于电子产品','2021-03-02 06:22:47','2021-03-02 08:31:35',NULL),(18,'净含量','ml',1,'用于美妆品容积度量','2021-03-02 06:23:08','2021-03-09 03:27:59',NULL),(19,'型号',NULL,0,NULL,'2021-03-02 06:26:14','2021-03-09 03:27:59',NULL),(20,'测','厘米',0,'xxx','2021-03-07 08:16:52','2021-03-09 03:27:59',NULL),(21,'测试规格','1',1,'测试','2021-03-08 11:12:00','2021-03-09 03:27:59',NULL),(22,'测试规格1',NULL,0,NULL,'2021-03-08 11:13:26','2021-03-09 03:34:29',NULL),(23,'猜测是',NULL,0,NULL,'2021-03-08 11:14:54','2021-03-09 03:34:29',NULL);
/*!40000 ALTER TABLE `spec_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spec_value`
--

DROP TABLE IF EXISTS `spec_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spec_value` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格值',
  `key_id` int unsigned NOT NULL COMMENT '规格名id',
  `extend` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '当前规格值的扩展说明',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='当前表记录规格值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spec_value`
--

LOCK TABLES `spec_value` WRITE;
/*!40000 ALTER TABLE `spec_value` DISABLE KEYS */;
INSERT INTO `spec_value` VALUES (1,'金属灰',1,'','2020-07-15 13:02:28','2021-03-09 02:20:09','2021-03-09 02:20:10'),(2,'青芒色',1,'青色偏绿','2020-07-15 13:02:41','2021-03-09 06:53:13',NULL),(3,'橘黄色',1,NULL,'2020-07-15 13:02:53','2020-07-15 13:02:53',NULL),(4,'七龙珠',2,NULL,'2020-07-15 13:03:24','2020-07-15 13:03:24',NULL),(5,'灌篮高手',2,NULL,'2020-07-15 13:03:35','2020-07-15 13:03:35',NULL),(6,'圣斗士',2,NULL,'2020-07-15 13:03:54','2020-07-15 13:03:54',NULL),(7,'小号 S',3,NULL,'2020-07-15 13:04:17','2020-07-15 13:04:17',NULL),(8,'中号 M',3,NULL,'2020-07-15 13:04:29','2020-07-15 13:04:29',NULL),(9,'大号 L',3,NULL,'2020-07-15 13:04:45','2020-07-15 13:04:45',NULL),(10,'一盒30个',4,NULL,'2020-11-30 12:12:39','2020-11-30 12:12:39',NULL),(11,'一盒50个',4,NULL,'2020-11-30 12:12:50','2020-11-30 12:12:50',NULL),(12,'青蓝色',1,NULL,'2021-03-02 13:33:43','2021-03-02 13:33:43',NULL),(13,'藏青色',1,NULL,'2021-03-02 13:33:53','2021-03-02 13:33:53',NULL),(14,'深白色',1,NULL,'2021-03-02 13:34:07','2021-03-02 13:34:07',NULL),(15,'少女粉',1,NULL,'2021-03-02 13:34:48','2021-03-02 13:34:48',NULL),(16,'黑色',1,NULL,'2021-03-02 13:34:57','2021-03-02 13:34:57',NULL),(17,'墨绿色',1,NULL,'2021-03-02 13:35:07','2021-03-02 13:35:07',NULL),(18,'银色',1,NULL,'2021-03-02 13:35:24','2021-03-02 13:35:24',NULL),(19,'金色',1,NULL,'2021-03-02 13:35:33','2021-03-02 13:35:33',NULL);
/*!40000 ALTER TABLE `spec_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu`
--

DROP TABLE IF EXISTS `spu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spu` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '当前spu的主标题',
  `subtitle` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '当前spu的副标题',
  `online` tinyint NOT NULL DEFAULT '1' COMMENT '"1"商品上架，"2"商品下架',
  `price` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文本类型价格，有时spu的价格需要填写一个范围',
  `sketch_spec_id` int DEFAULT NULL COMMENT '可视化规格',
  `default_sku_id` int DEFAULT NULL COMMENT '前端默认显示的一组sku',
  `discount_price` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '折扣价',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'spu描述',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'spu图片',
  `is_best` tinyint DEFAULT '0',
  `spu_theme_img` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `for_theme_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  `category_id` int unsigned DEFAULT NULL COMMENT '当前商品所属分类',
  `root_category_id` int unsigned DEFAULT NULL COMMENT '商品的根分类',
  `tags` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu`
--

LOCK TABLES `spu` WRITE;
/*!40000 ALTER TABLE `spu` DISABLE KEYS */;
INSERT INTO `spu` VALUES (1,'自营针织衫','宽松百搭、秋冬新款薄针织衫。瓜瓜设计，3件包邮',1,'77.00',1,2,'62.00',NULL,'http://i1.sleeve.talelin.com/assets/ecf8d824-19d4-4db2-a5da-872ab014fecd.png',1,NULL,'http://i1.sleeve.talelin.com/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png','2020-07-06 13:52:25','2021-03-10 04:03:32',NULL,14,2,'秋日冬款$浪漫满屋'),(2,'纯色牛仔裤','秋冬新款，做一个Cool Boy。修身不掉色，商场同款。',1,'199.00',1,NULL,'',NULL,'http://i2.sleeve.7yue.pro/n11.png',0,NULL,'http://i1.sleeve.7yue.pro/assets/702f2ce9-5729-4aa4-aeb3-921513327747.png','2020-07-08 13:41:55','2020-12-06 06:00:49',NULL,13,2,'纯色$包邮'),(3,'碳素墨水','虽然我们早已不再使用钢笔书写，但钢笔在纸上划过的笔触永远是键盘无法替代的。一只钢笔+一瓶墨水在一个安静的午后，写写内心的故事。',0,'80.00',NULL,NULL,'69.00',NULL,'http://i1.sleeve.talelin.com/assets/0bb351c7-4dba-4403-8d4e-f98a2f440098.png',0,NULL,'http://i1.sleeve.talelin.com/assets/0bb351c7-4dba-4403-8d4e-f98a2f440098.png','2020-07-08 13:44:52','2020-11-02 12:41:40',NULL,10,3,'蓝黑'),(4,'多彩别针、回形针','每盒70个，可爱多彩',1,'24',NULL,NULL,'19.90',NULL,'http://i1.sleeve.talelin.com/huixingzhen1/s1.png',0,NULL,'http://i1.sleeve.talelin.com/huixingzhen1/s1.png','2020-07-08 13:47:22','2020-11-02 12:45:02',NULL,10,3,'三色可选'),(5,'抹茶小橡皮','小作文写错了，用它擦一擦',1,'29.99',1,NULL,'17.00',NULL,'http://i1.sleeve.talelin.com/assets/a4a2f520-d37a-4385-aabf-44b8c9226466.png',0,NULL,'http://i1.sleeve.talelin.com/assets/a4a2f520-d37a-4385-aabf-44b8c9226466.png','2020-07-08 13:52:08','2020-11-02 12:37:57',NULL,10,3,'泉韵推荐'),(6,'Ins 复古小夹子（Mini)','静静的，享受时光的流逝',1,'19.9',NULL,NULL,NULL,NULL,'http://i1.sleeve.talelin.com/jiazi1/sp1.png',0,NULL,'http://i1.sleeve.talelin.com/jiazi1/sp4.png','2020-07-18 11:21:49','2020-11-02 12:46:06',NULL,10,3,NULL),(7,'Ins复古金色落地灯','Instagram复古台灯，就在此刻回到过去，找寻逝去的记忆',1,'999',NULL,NULL,NULL,NULL,'http://i1.sleeve.talelin.com/assets/52281130-032b-4d53-a9b1-59aa9da5eb96.png',0,NULL,'http://i1.sleeve.talelin.com/assets/9a28998f-78d2-4413-9cf7-49983c6ad75d.png','2020-07-18 11:28:24','2020-11-02 12:47:02',NULL,29,6,'Ins$复古流行'),(8,'Sleeve羊绒毛衣','Sleeve风袖当季经典款，细腻柔软羊绒，亲肤级粘胶，修身不紧身。',1,'199',1,NULL,'189',NULL,'http://i1.sleeve.talelin.com/yifu1/s2.png',1,NULL,'http://i1.sleeve.talelin.com/yifu1/s4.png','2020-08-22 10:35:57','2020-11-02 12:47:35',NULL,14,2,'细腻柔软$薄而有型$精致优雅');
/*!40000 ALTER TABLE `spu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_detail_img`
--

DROP TABLE IF EXISTS `spu_detail_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spu_detail_img` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片url地址',
  `spu_id` int unsigned NOT NULL COMMENT '关联spu表中的id',
  `index` int unsigned NOT NULL COMMENT '图片的排放顺序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '当前记录逻辑删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品详情图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_detail_img`
--

LOCK TABLES `spu_detail_img` WRITE;
/*!40000 ALTER TABLE `spu_detail_img` DISABLE KEYS */;
INSERT INTO `spu_detail_img` VALUES (1,'http://i2.sleeve.7yue.pro/n4.png',1,1,'2020-07-10 13:37:04','2020-07-10 13:37:04',NULL),(2,'http://i1.sleeve.7yue.pro/detail/1/1.png',1,1,'2020-08-22 10:39:53','2020-12-06 10:45:19',NULL),(3,'http://i1.sleeve.7yue.pro/detail/1/2.png',1,2,'2020-08-22 10:40:12','2020-12-06 10:45:19',NULL),(4,'http://i1.sleeve.7yue.pro/detail/1/3.png',1,3,'2020-08-22 10:40:28','2020-12-06 10:45:19',NULL),(5,'http://i1.sleeve.7yue.pro/detail/1/4.png',1,4,'2020-08-22 10:40:48','2020-12-06 10:45:19',NULL),(6,'http://i1.sleeve.7yue.pro/detail/1/5.png',1,5,'2020-08-22 10:41:06','2020-12-06 10:45:19',NULL);
/*!40000 ALTER TABLE `spu_detail_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_img`
--

DROP TABLE IF EXISTS `spu_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spu_img` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `spu_id` int unsigned NOT NULL COMMENT '关联spu表的id字段',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除记录的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_img`
--

LOCK TABLES `spu_img` WRITE;
/*!40000 ALTER TABLE `spu_img` DISABLE KEYS */;
INSERT INTO `spu_img` VALUES (1,'http://i1.sleeve.7yue.pro/assets/5605cd6c-f869-46db-afe6-755b61a0122a.png',1,'2020-07-10 13:36:22','2020-07-10 13:36:22',NULL),(2,'http://i1.sleeve.7yue.pro/assets/ecf8d824-19d4-4db2-a5da-872ab014fecd.png',1,'2020-08-22 06:19:09','2020-08-22 06:19:09',NULL),(3,'http://i1.sleeve.7yue.pro/assets/8451cebd-5a8d-4758-bb2a-652e026a7c00.png',1,'2020-08-22 06:19:42','2020-08-22 06:19:42',NULL),(4,'http://i2.sleeve.7yue.pro/n13.png',2,'2020-08-22 06:20:42','2020-08-22 06:20:42',NULL),(5,'http://i2.sleeve.7yue.pro/n12.png',2,'2020-08-22 06:21:07','2020-08-22 06:21:07',NULL),(6,'http://i2.sleeve.7yue.pro/n11.png',2,'2020-08-22 06:21:27','2020-08-22 06:21:27',NULL),(7,'http://i2.sleeve.7yue.pro/m24.png',3,'2020-08-22 06:22:04','2020-08-22 06:22:04',NULL),(8,'http://i2.sleeve.7yue.pro/m25.png',3,'2020-08-22 06:22:25','2020-08-22 06:22:25',NULL),(9,'http://i2.sleeve.7yue.pro/m28.png',4,'2020-08-22 06:24:03','2020-08-22 06:24:03',NULL),(10,'http://i2.sleeve.7yue.pro/m27.png',4,'2020-08-22 06:24:25','2020-08-22 06:24:25',NULL),(11,'http://i2.sleeve.7yue.pro/m17.png',5,'2020-08-22 06:25:55','2020-08-22 06:25:55',NULL),(12,'http://i2.sleeve.7yue.pro/m18.png',5,'2020-08-22 06:26:03','2020-08-22 06:26:21',NULL),(13,'http://i2.sleeve.7yue.pro/m23.png',6,'2020-08-22 06:27:05','2020-08-22 06:27:05',NULL),(14,'http://i2.sleeve.7yue.pro/m22.png',6,'2020-08-22 06:27:22','2020-08-22 06:27:22',NULL),(15,'http://i2.sleeve.7yue.pro/a9.png',7,'2020-08-22 06:28:28','2020-08-22 06:28:28',NULL),(16,'http://i1.sleeve.7yue.pro/yifu1/s2.png',8,'2020-08-22 10:38:14','2020-08-22 10:38:14',NULL),(17,'http://i1.sleeve.7yue.pro/yifu1/s1.png',8,'2020-08-22 10:38:43','2020-08-22 10:38:43',NULL),(18,'http://i1.sleeve.7yue.pro/yifu1/s3.png',8,'2020-08-22 10:38:59','2020-08-22 10:38:59',NULL),(19,'http://i1.sleeve.7yue.pro/yifu1/s4.png',8,'2020-08-22 10:39:12','2020-08-22 10:39:12',NULL),(20,'http://i1.sleeve.7yue.pro/assets/a4a2f520-d37a-4385-aabf-44b8c9226466.png',5,'2020-08-22 12:46:44','2020-08-22 12:46:44',NULL);
/*!40000 ALTER TABLE `spu_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_key`
--

DROP TABLE IF EXISTS `spu_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spu_key` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` int unsigned NOT NULL COMMENT 'spu表id',
  `spec_key_id` int unsigned NOT NULL COMMENT 'spec_key表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu表与spec_key（规格表）的关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_key`
--

LOCK TABLES `spu_key` WRITE;
/*!40000 ALTER TABLE `spu_key` DISABLE KEYS */;
INSERT INTO `spu_key` VALUES (1,1,1),(2,1,2),(3,1,3);
/*!40000 ALTER TABLE `spu_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_tag`
--

DROP TABLE IF EXISTS `spu_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spu_tag` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` int unsigned NOT NULL COMMENT 'spu表id',
  `tag_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'tag表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu---tag 关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_tag`
--

LOCK TABLES `spu_tag` WRITE;
/*!40000 ALTER TABLE `spu_tag` DISABLE KEYS */;
INSERT INTO `spu_tag` VALUES (1,1,'1'),(2,1,'2');
/*!40000 ALTER TABLE `spu_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '中文限制6个，英文限制12个',
  `highlight` tinyint NOT NULL DEFAULT '0' COMMENT '当前标签是否高亮',
  `type` tinyint NOT NULL DEFAULT '1' COMMENT '当前标签类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '记录逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu标签表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'包邮',1,1,'2020-07-06 13:56:22','2020-07-06 13:56:22',NULL),(2,'热门',1,1,'2020-07-06 13:56:36','2020-07-06 13:56:36',NULL);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theme` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '唯一业务识别的标记',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '对当前主题的描述',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '当前Theme的标题',
  `tpl_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '当前主题使用的模板名',
  `entrance_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Theme入口图片',
  `title_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '进入主题页面后，顶部显示的图片',
  `internal_top_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '顶部查看更多的图片',
  `online` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '"1"上架，"2"下架',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除时间',
  `extend` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='主题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'t-1','秋天是金色的。麦穗是金色的，秋阳是金色的。虽然冬快至，但宜人的温度总是让我们心情愉快#我们为您精选了一系列秋冬折扣商品，慢慢挑选吧~','清凉一夏，折扣季','templete-1','http://i1.sleeve.talelin.com/1d6519ba-30cf-46bd-a8be-956999a3b445.png',NULL,'http://i1.sleeve.talelin.com/assets/922dd4fc-07a5-425f-8a4a-5e9b2cd884c0.png',1,'2020-07-17 12:44:24','2020-07-17 12:44:24',NULL,NULL),(2,'t-2','风袖`每周上新`活动#每周都有一款折扣商品，每周都有适合你的唯一专属#有Ins复古风装饰；金属CD唱片夹；每周来逛逛，找到你所喜爱的东西','每周上新','templete-2',NULL,'http://i1.sleeve.talelin.com/assets/9766e5c4-a099-456b-95b7-f7c1b087fed9.png','http://i1.sleeve.talelin.com/m1.png',1,'2020-07-18 11:04:29','2020-07-18 11:04:29',NULL,NULL),(3,'t-3','总是有种意犹未尽的感觉，但人们对于复古风格从来不缺乏新锐设计。越是长大，越是喜欢怀旧。','风袖甄选','templete-3','http://i1.sleeve.talelin.com/e684c6c6-a4c1-42e3-a12d-80e42217a842.png',NULL,'http://i1.sleeve.talelin.com/assets/31cbd4c1-23fc-41d0-b456-46fd24f61413.png',1,'2020-07-18 11:10:27','2020-07-18 11:10:27',NULL,NULL),(4,'t-4','帅点才有女朋友','时尚穿搭','templete-4','http://i1.sleeve.talelin.com/assets/a32d19c9-bc2a-4966-8f10-b2eb7c6eeeaa.png',NULL,'http://i1.sleeve.talelin.com/0e7a3b2b-9ef2-4787-a691-f101a4704d52.png',1,'2020-07-18 11:12:51','2020-07-18 11:12:51',NULL,NULL);
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme_spu`
--

DROP TABLE IF EXISTS `theme_spu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theme_spu` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `theme_id` int unsigned NOT NULL COMMENT 'theme表id',
  `spu_id` int unsigned NOT NULL COMMENT 'spu表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='theme---spu关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme_spu`
--

LOCK TABLES `theme_spu` WRITE;
/*!40000 ALTER TABLE `theme_spu` DISABLE KEYS */;
INSERT INTO `theme_spu` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,2,1),(6,2,5),(7,2,6),(8,2,7),(9,3,1),(10,3,2),(11,3,3),(12,3,4),(13,3,5),(14,3,6),(15,4,2),(16,4,3),(17,4,4),(18,4,5),(19,4,6),(20,4,7),(21,1,5),(22,1,6),(23,1,7),(24,2,4),(25,2,3);
/*!40000 ALTER TABLE `theme_spu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户在当前小程序中的唯一标识',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` timestamp NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_un` (`openid`),
  KEY `user_openid_idx` (`openid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,NULL,NULL,'oWknc4rAd_62XmD_axIM-HdbuqHM',NULL,NULL,'2020-08-02 07:51:17','2020-08-02 07:51:17',NULL),(5,NULL,NULL,'oWknc4sHvpRFc9LZa7uuw3CZ-pEc',NULL,NULL,'2020-10-24 01:59:57','2020-10-24 01:59:57',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_coupon`
--

DROP TABLE IF EXISTS `user_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_coupon` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `coupon_id` int unsigned NOT NULL,
  `status` int unsigned NOT NULL DEFAULT '0' COMMENT '1：已领取，未使用；2：已领取，已使用；3：已过期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户领取当前优惠券的时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_id` int unsigned DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='user与coupon的关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_coupon`
--

LOCK TABLES `user_coupon` WRITE;
/*!40000 ALTER TABLE `user_coupon` DISABLE KEYS */;
INSERT INTO `user_coupon` VALUES (4,4,2,1,'2020-08-02 08:05:11','2020-10-22 13:13:17',NULL),(5,4,3,1,'2020-08-02 08:05:22','2020-10-22 13:13:17',NULL),(6,4,4,1,'2020-08-03 13:28:42','2020-10-22 13:13:17',NULL),(15,4,5,1,'2020-10-15 14:30:47','2020-10-31 08:47:16',NULL),(16,4,1,2,'2020-10-15 14:34:15','2020-10-22 14:10:34',47);
/*!40000 ALTER TABLE `user_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sleeve'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-10 12:13:54
