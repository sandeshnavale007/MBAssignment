-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mbassignment
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Aurangabad','Aurangabad',NULL,'Sandesh','Navale','8899889988','2021-04-04 16:06:54'),(2,'new aurangabad','Aurangabad','2021-04-04 16:07:13','Bunty','Navale','8888888888','2021-04-04 16:07:13');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8),(8),(8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,NULL,'sunday','2021-04-04 15:26:45','2021-12-31 05:30:00','sandesh@gmail.com','sandesh','navale','sandesh','2021-04-04 15:26:45'),(5,NULL,'sunday','2021-04-04 16:05:25','2021-12-31 05:30:00','bunty@gmail.com','bunty','navale','sandesh','2021-04-04 16:05:25');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stripe_payment_response`
--

DROP TABLE IF EXISTS `stripe_payment_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stripe_payment_response` (
  `id` int NOT NULL,
  `amount` bigint DEFAULT NULL,
  `charge` longtext,
  `created_date` datetime DEFAULT NULL,
  `cust_id` varchar(255) DEFAULT NULL,
  `manager_id` bigint DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `subscription_id` bigint DEFAULT NULL,
  `sucess` varchar(255) DEFAULT NULL,
  `tranasction_id` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stripe_payment_response`
--

LOCK TABLES `stripe_payment_response` WRITE;
/*!40000 ALTER TABLE `stripe_payment_response` DISABLE KEYS */;
INSERT INTO `stripe_payment_response` VALUES (2,20000,'{\"amount\":20000,\"amount_refunded\":0,\"balance_transaction\":{\"id\":\"txn_1IcSiKSGQDLKU2L0ioB0oZQY\"},\"billing_details\":{\"address\":{},\"name\":\"sandesh@gmail.com\"},\"captured\":true,\"created\":1617530272,\"currency\":\"inr\",\"fraud_details\":{},\"id\":\"ch_1IcSiKSGQDLKU2L0ZdaV9Vjd\",\"livemode\":false,\"metadata\":{},\"object\":\"charge\",\"outcome\":{\"network_status\":\"approved_by_network\",\"risk_level\":\"normal\",\"risk_score\":41,\"seller_message\":\"Payment complete.\",\"type\":\"authorized\"},\"paid\":true,\"payment_method\":\"card_1IcSiGSGQDLKU2L0mdd2WSaD\",\"payment_method_details\":{\"card\":{\"brand\":\"visa\",\"checks\":{\"cvc_check\":\"pass\"},\"country\":\"US\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"last4\":\"4242\"},\"type\":\"card\"},\"receipt_url\":\"https://pay.stripe.com/receipts/acct_1Iaed1SGQDLKU2L0/ch_1IcSiKSGQDLKU2L0ZdaV9Vjd/rcpt_JEwbiZjicUJ1piY6NsFWPOi1kRw8Nop\",\"refunded\":false,\"refunds\":{\"object\":\"list\",\"data\":[],\"hasMore\":false,\"totalCount\":0,\"url\":\"/v1/charges/ch_1IcSiKSGQDLKU2L0ZdaV9Vjd/refunds\"},\"source\":{\"brand\":\"Visa\",\"country\":\"US\",\"cvc_check\":\"pass\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"id\":\"card_1IcSiGSGQDLKU2L0mdd2WSaD\",\"last4\":\"4242\",\"metadata\":{},\"name\":\"sandesh@gmail.com\",\"object\":\"card\"},\"status\":\"succeeded\"}','2021-04-04 15:27:53','ch_1IcSiKSGQDLKU2L0ZdaV9Vjd',1,_binary '\0',2,'succeeded','txn_1IcSiKSGQDLKU2L0ioB0oZQY','2021-04-04 16:04:06'),(3,10000,'{\"amount\":10000,\"amount_refunded\":0,\"balance_transaction\":{\"id\":\"txn_1IcSipSGQDLKU2L0XGJBdevZ\"},\"billing_details\":{\"address\":{},\"name\":\"sandesh@gmail.com\"},\"captured\":true,\"created\":1617530302,\"currency\":\"inr\",\"fraud_details\":{},\"id\":\"ch_1IcSioSGQDLKU2L0Datd9egQ\",\"livemode\":false,\"metadata\":{},\"object\":\"charge\",\"outcome\":{\"network_status\":\"approved_by_network\",\"risk_level\":\"normal\",\"risk_score\":51,\"seller_message\":\"Payment complete.\",\"type\":\"authorized\"},\"paid\":true,\"payment_method\":\"card_1IcSikSGQDLKU2L0nhDMZJdJ\",\"payment_method_details\":{\"card\":{\"brand\":\"visa\",\"checks\":{\"cvc_check\":\"pass\"},\"country\":\"US\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"last4\":\"4242\"},\"type\":\"card\"},\"receipt_url\":\"https://pay.stripe.com/receipts/acct_1Iaed1SGQDLKU2L0/ch_1IcSioSGQDLKU2L0Datd9egQ/rcpt_JEwcMKcIXOshMNOklF5OrMk9qwZ9VuE\",\"refunded\":false,\"refunds\":{\"object\":\"list\",\"data\":[],\"hasMore\":false,\"totalCount\":0,\"url\":\"/v1/charges/ch_1IcSioSGQDLKU2L0Datd9egQ/refunds\"},\"source\":{\"brand\":\"Visa\",\"country\":\"US\",\"cvc_check\":\"pass\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"id\":\"card_1IcSikSGQDLKU2L0nhDMZJdJ\",\"last4\":\"4242\",\"metadata\":{},\"name\":\"sandesh@gmail.com\",\"object\":\"card\"},\"status\":\"succeeded\"}','2021-04-04 15:28:23','ch_1IcSioSGQDLKU2L0Datd9egQ',1,_binary '\0',1,'succeeded','txn_1IcSipSGQDLKU2L0XGJBdevZ','2021-04-04 16:04:13'),(4,20000,'{\"amount\":20000,\"amount_refunded\":0,\"balance_transaction\":{\"id\":\"txn_1IcT8wSGQDLKU2L0XBbKWSaw\"},\"billing_details\":{\"address\":{},\"name\":\"sandesh.navale@sundaymobility.com\"},\"captured\":true,\"created\":1617531921,\"currency\":\"inr\",\"fraud_details\":{},\"id\":\"ch_1IcT8vSGQDLKU2L0UKMVLYQB\",\"livemode\":false,\"metadata\":{},\"object\":\"charge\",\"outcome\":{\"network_status\":\"approved_by_network\",\"risk_level\":\"normal\",\"risk_score\":4,\"seller_message\":\"Payment complete.\",\"type\":\"authorized\"},\"paid\":true,\"payment_method\":\"card_1IcT8qSGQDLKU2L0lV4xnD1m\",\"payment_method_details\":{\"card\":{\"brand\":\"visa\",\"checks\":{\"cvc_check\":\"pass\"},\"country\":\"US\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"last4\":\"4242\"},\"type\":\"card\"},\"receipt_url\":\"https://pay.stripe.com/receipts/acct_1Iaed1SGQDLKU2L0/ch_1IcT8vSGQDLKU2L0UKMVLYQB/rcpt_JEx3vMuLhekTymNiVAEdmgn8Xq0DM2f\",\"refunded\":false,\"refunds\":{\"object\":\"list\",\"data\":[],\"hasMore\":false,\"totalCount\":0,\"url\":\"/v1/charges/ch_1IcT8vSGQDLKU2L0UKMVLYQB/refunds\"},\"source\":{\"brand\":\"Visa\",\"country\":\"US\",\"cvc_check\":\"pass\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"id\":\"card_1IcT8qSGQDLKU2L0lV4xnD1m\",\"last4\":\"4242\",\"metadata\":{},\"name\":\"sandesh.navale@sundaymobility.com\",\"object\":\"card\"},\"status\":\"succeeded\"}','2021-04-04 15:55:22','ch_1IcT8vSGQDLKU2L0UKMVLYQB',1,_binary '',3,'succeeded','txn_1IcT8wSGQDLKU2L0XBbKWSaw','2021-04-04 15:55:22'),(6,20000,'{\"amount\":20000,\"amount_refunded\":0,\"balance_transaction\":{\"id\":\"txn_1IcTJYSGQDLKU2L09Cag6Gy2\"},\"billing_details\":{\"address\":{},\"name\":\"bunty@gmail.com\"},\"captured\":true,\"created\":1617532580,\"currency\":\"inr\",\"fraud_details\":{},\"id\":\"ch_1IcTJYSGQDLKU2L0y3HkzCZH\",\"livemode\":false,\"metadata\":{},\"object\":\"charge\",\"outcome\":{\"network_status\":\"approved_by_network\",\"risk_level\":\"normal\",\"risk_score\":57,\"seller_message\":\"Payment complete.\",\"type\":\"authorized\"},\"paid\":true,\"payment_method\":\"card_1IcTJUSGQDLKU2L0NOnu40d0\",\"payment_method_details\":{\"card\":{\"brand\":\"visa\",\"checks\":{\"cvc_check\":\"pass\"},\"country\":\"US\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"last4\":\"4242\"},\"type\":\"card\"},\"receipt_url\":\"https://pay.stripe.com/receipts/acct_1Iaed1SGQDLKU2L0/ch_1IcTJYSGQDLKU2L0y3HkzCZH/rcpt_JExEs4FDwFEN5wjA4qeePPGWHozNZL8\",\"refunded\":false,\"refunds\":{\"object\":\"list\",\"data\":[],\"hasMore\":false,\"totalCount\":0,\"url\":\"/v1/charges/ch_1IcTJYSGQDLKU2L0y3HkzCZH/refunds\"},\"source\":{\"brand\":\"Visa\",\"country\":\"US\",\"cvc_check\":\"pass\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"id\":\"card_1IcTJUSGQDLKU2L0NOnu40d0\",\"last4\":\"4242\",\"metadata\":{},\"name\":\"bunty@gmail.com\",\"object\":\"card\"},\"status\":\"succeeded\"}','2021-04-04 16:06:20','ch_1IcTJYSGQDLKU2L0y3HkzCZH',5,_binary '\0',2,'succeeded','txn_1IcTJYSGQDLKU2L09Cag6Gy2','2021-04-04 16:07:18'),(7,10000,'{\"amount\":10000,\"amount_refunded\":0,\"balance_transaction\":{\"id\":\"txn_1IcTKySGQDLKU2L08EVl6Bf8\"},\"billing_details\":{\"address\":{},\"name\":\"s@s.com\"},\"captured\":true,\"created\":1617532668,\"currency\":\"inr\",\"fraud_details\":{},\"id\":\"ch_1IcTKySGQDLKU2L0wR07xtT1\",\"livemode\":false,\"metadata\":{},\"object\":\"charge\",\"outcome\":{\"network_status\":\"approved_by_network\",\"risk_level\":\"normal\",\"risk_score\":59,\"seller_message\":\"Payment complete.\",\"type\":\"authorized\"},\"paid\":true,\"payment_method\":\"card_1IcTKuSGQDLKU2L0Rpy42tsF\",\"payment_method_details\":{\"card\":{\"brand\":\"visa\",\"checks\":{\"cvc_check\":\"pass\"},\"country\":\"US\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"last4\":\"4242\"},\"type\":\"card\"},\"receipt_url\":\"https://pay.stripe.com/receipts/acct_1Iaed1SGQDLKU2L0/ch_1IcTKySGQDLKU2L0wR07xtT1/rcpt_JExFQwiiKZStrSYz6zLMofuvl7vuKa7\",\"refunded\":false,\"refunds\":{\"object\":\"list\",\"data\":[],\"hasMore\":false,\"totalCount\":0,\"url\":\"/v1/charges/ch_1IcTKySGQDLKU2L0wR07xtT1/refunds\"},\"source\":{\"brand\":\"Visa\",\"country\":\"US\",\"cvc_check\":\"pass\",\"exp_month\":2,\"exp_year\":2023,\"fingerprint\":\"7T1MWjIFt2TfpiUy\",\"funding\":\"credit\",\"id\":\"card_1IcTKuSGQDLKU2L0Rpy42tsF\",\"last4\":\"4242\",\"metadata\":{},\"name\":\"s@s.com\",\"object\":\"card\"},\"status\":\"succeeded\"}','2021-04-04 16:07:48','ch_1IcTKySGQDLKU2L0wR07xtT1',5,_binary '',1,'succeeded','txn_1IcTKySGQDLKU2L08EVl6Bf8','2021-04-04 16:07:48');
/*!40000 ALTER TABLE `stripe_payment_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `amount` double NOT NULL,
  `desc1` varchar(255) DEFAULT NULL,
  `desc2` varchar(255) DEFAULT NULL,
  `desc3` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,'Silver',100,'Desc1','Desc2','Desc3','Description'),(2,'Gold',200,'Desc1	','Desc2','Desc3','Description'),(3,'Platinum',300,'Desc1	','Desc2','Desc3','Description');
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-04 16:37:35
