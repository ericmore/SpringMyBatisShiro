/*
Date: 2016-06-01 23:44:23
*/

SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Records of i_user 用户名和密码一样
-- ----------------------------
INSERT INTO ipan.i_user (id, personalID, username, password, firstName, middleName, lastName, role, code, referID, email, privateEmail, sex, age, mobile, country, state, city, street, position, company, experience, createTime, updateTime, status) VALUES (2, '', '', '7694f4a66316e53c8cdd9d9954bd611d', 'q', '', 'q', 'admin', 'i8000101', '1', '', null, '', 22, '', null, null, null, '', '', '', 0, '2018-06-16 17:43:28', '2018-06-16 17:43:28', 'active');
INSERT INTO ipan.i_user (id, personalID, username, password, firstName, middleName, lastName, role, code, referID, email, privateEmail, sex, age, mobile, country, state, city, street, position, company, experience, createTime, updateTime, status) VALUES (4, '', '', '7694f4a66316e53c8cdd9d9954bd611d', 'q', '', '', 'agent', 'i8000113', 'i8000110', 'q.@ipanproperty.com', null, '', 22, '', null, null, null, '', '', '', 0, '2018-06-16 17:56:05', '2018-06-16 20:59:36', 'active');
INSERT INTO ipan.i_user (id, personalID, username, password, firstName, middleName, lastName, role, code, referID, email, privateEmail, sex, age, mobile, country, state, city, street, position, company, experience, createTime, updateTime, status) VALUES (5, '', '', '7694f4a66316e53c8cdd9d9954bd611d', 'q', '', 'q', 'agent', 'i8000111', '1', '', null, '', 22, '', null, null, null, '', '', '', 0, '2018-06-16 17:57:07', '2018-06-16 19:04:37', 'active');
INSERT INTO ipan.i_user (id, personalID, username, password, firstName, middleName, lastName, role, code, referID, email, privateEmail, sex, age, mobile, country, state, city, street, position, company, experience, createTime, updateTime, status) VALUES (6, '', '', '7694f4a66316e53c8cdd9d9954bd611d', 'q', '', 'pendName', 'agent', 'i8000110', 'i8000101', '', 'q', '', 22, '', null, null, null, '', '', '', 0, '2018-06-16 18:00:01', '2018-06-16 18:00:01', 'pending');
INSERT INTO ipan.i_user (id, personalID, username, password, firstName, middleName, lastName, role, code, referID, email, privateEmail, sex, age, mobile, country, state, city, street, position, company, experience, createTime, updateTime, status) VALUES (7, '', '', '7694f4a66316e53c8cdd9d9954bd611d', 'q', '', 'q', 'customer', 'i8000201', '1', '', null, '', 22, '', null, null, null, '', '', '', 0, '2018-06-16 17:43:28', '2018-06-16 17:43:28', 'active');
-- ----------------------------
-- Records of i_content
-- ----------------------------
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (1, 'user_guide', null, '', null, null, '2018-06-08 20:41:09', '2018-06-17 20:04:41');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (2, 'training_module', null, '', null, null, '2018-06-08 20:41:09', '2018-06-17 20:04:41');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (3, 'user_agreement', null, '', null, null, '2018-06-08 20:41:09', '2018-06-17 20:04:41');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (4, 'agent_resources_instructions', null, '', null, null, '2018-06-09 20:35:27', '2018-06-09 20:42:27');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (5, 'expression_of_interest', null, '', null, null, '2018-06-09 20:35:27', '2018-06-09 20:42:27');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (6, 'contract_of_sale', null, '', null, null, '2018-06-09 20:35:27', '2018-06-09 20:42:27');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (7, 'deposit_form', null, '', null, null, '2018-06-09 20:35:27', '2018-06-09 20:42:27');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (8, 'solicitor_contract', null, '', null, null, '2018-06-09 20:35:27', '2018-06-09 20:42:27');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (9, 'management_agreement', null, '', null, null, '2018-06-09 20:35:27', '2018-06-09 20:42:27');
INSERT INTO ipan.i_content (id, module, title, content1, content2, content3, createTime, updateTime) VALUES (10, 'FQAs', null, '', null, null, '2018-06-09 20:46:16', '2018-06-13 22:55:34');