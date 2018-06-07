/*
Date: 2016-06-01 23:44:23
*/

SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Records of i_user 用户名和密码一样
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


#https://raw.githubusercontent.com/loureirorg/city-state/master/lib/db/GeoLite2-City-Locations-en.csv


-- ----------------------------
-- Records of i_commonConfig
-- ----------------------------
INSERT INTO i_commonconfig ( env, cKey, cValue) VALUES ( 'dev', 'rootHttpPath', 'http://localhost/');
INSERT INTO i_commonconfig ( env, cKey, cValue) VALUES ( 'dev', 'rootFilePath', 'd:/');