/*
Date: 2016-06-01 23:44:23
*/

SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Records of t_user 用户名和密码一样
-- ----------------------------
INSERT INTO `i_user` VALUES ('1', '3000000001', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'ad',
                             'mi', 'n', 'admin', '', '000', 'admin@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');
INSERT INTO `i_user` VALUES ('2', '3000000002', 'admin1', 'e00cf25ad42683b3df678c61f42c6bda', 'ad',
                             'mi', 'n', 'admin', '', '001', 'admin@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');
INSERT INTO `i_user` VALUES ('3', '3000000003', 'admin2', 'c84258e9c39059a89ab77d846ddab909', 'ad',
                             'mi', 'n', 'admin', '', '002', 'admin@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');

INSERT INTO `i_user` VALUES ('4', '4000000001', 'agent', 'b33aed8f3134996703dc39f9a7c95783', 'ad',
                             'mi', 'n', 'agent', '', '003', 'agent@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');
INSERT INTO `i_user` VALUES ('5', '4000000002', 'agent1', '83a87fd756ab57199c0bb6d5e11168cb', 'ad',
                             'mi', 'n', 'agent', '', '004', 'agent@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');
INSERT INTO `i_user` VALUES ('6', '4000000003', 'agent2', 'b1a4a6b01cc297d4677c4ca6656e14d7', 'ad',
                             'mi', 'n', 'agent', '', '005', 'agent@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');

INSERT INTO `i_user` VALUES ('7', '5000000001', 'customer', '91ec1f9324753048c0096d036a694f86', 'ad',
                             'mi', 'n', 'customer', '', '006', 'customer@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');
INSERT INTO `i_user` VALUES ('8', '5000000002', 'customer1', 'ffbc4675f864e0e9aab8bdf7a0437010', 'ad',
                             'mi', 'n', 'customer', '', '007', 'customer@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');
INSERT INTO `i_user` VALUES ('9', '5000000003', 'customer2', '5ce4d191fd14ac85a1469fb8c29b7a7b', 'ad',
                             'mi', 'n', 'customer', '', '008', 'customer@126.com', 'male', 19, '189776655',
                             'Australia', 'Queensland', 'Brisbane', 'street', 'add', 'company1', 12, now(), now(),'active');


-- ----------------------------
-- Records of t_region
-- ----------------------------
INSERT INTO `i_region` VALUES ('1', '00000000', 'Australia', '0', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('2', '10000000', 'Queensland', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('10', '20000000', 'Brisbane', '10000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('11', '20000001', 'Fitzroy', '10000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('12', '20000002', 'Bowman', '10000000', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('3', '10000001', 'New South Wales', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('13', '30000000', 'Sydney', '10000001', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('14', '30000001', 'Balgowlah', '10000001', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('15', '30000002', 'Bombala', '10000001', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('16', '30000003', 'Burwood', '10000001', '0', '2018-06-02 23:35:38');


INSERT INTO `i_region` VALUES ('4', '10000002', 'Victoria', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('17', '40000000', 'Ballarat', '10000002', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('18', '40000001', 'Bendigo', '10000002', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('19', '40000002', 'Melbourne', '10000002', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('5', '10000003', 'South Australia', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('20', '50000000', 'Adelaide', '10000003', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('21', '50000001', 'Renmark', '10000003', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('6', '10000004', 'Western Australia', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('22', '60000000', 'Albany', '10000004', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('23', '60000001', 'Bassendean', '10000004', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('7', '10000005', 'Tasmania', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('24', '70000000', 'Hobart', '10000005', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('25', '70000001', 'Brighton', '10000005', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('8', '10000006', 'Capital Territory', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('26', '80000000', 'Canberra', '10000006', '0', '2018-06-02 23:35:38');

INSERT INTO `i_region` VALUES ('9', '10000007', 'Northern Territory', '00000000', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('27', '90000000', 'Alpurrurulam', '10000007', '0', '2018-06-02 23:35:38');
INSERT INTO `i_region` VALUES ('28', '90000001', 'Darwin', '10000007', '0', '2018-06-02 23:35:38');