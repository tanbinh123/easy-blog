CREATE TABLE `java-public`.b_info (
	id int NOT NULL COMMENT 'ID',
	create_time varchar(50) NOT NULL COMMENT '启动日期',
	view_num int NOT NULL COMMENT '浏览次数'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `java-public`.b_user (
	id varchar(100) NOT NULL COMMENT '用户ID',
	username varchar(50) NOT NULl COMMENT '登陆账号',
	password varchar(50) NOT NULl COMMENT '登陆密码',
	nickname varchar(50) NOT NULl COMMENT '昵称',
	avatar varchar(200) DEFAULT NULL COMMENT '头像',
	email varchar(20) DEFAULT NULL COMMENT '邮箱',
	phone varchar(20) DEFAULT NULL COMMENT '电话',
	introduction varchar(200) DEFAULT NULL COMMENT '简介',
	roles varchar(10) NOT NULL COMMENT '角色',
	perms varchar(10) NOT NULL COMMENT '权限',
	create_time varchar(50) NOT NULL COMMENT '创建日期',
	update_time varchar(50) NOT NULL COMMENT '更新日期'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `java-public`.b_article (
	id varchar(100) NOT NULL COMMENT '文章ID',
	title varchar(200) NOT NULL COMMENT '标题',
	reading int DEFAULT 0 COMMENT '阅读量',
	label varchar(50) DEFAULT NULL COMMENT '标签',
	cover_img varchar(200) NOT NULl COMMENT '封面图',
	content text DEFAULT NULL COMMENT '内容',
	readable varchar(10) DEFAULT 'Y' COMMENT '可读',
	author varchar(20) DEFAULT NULL COMMENT '作者',
	create_time varchar(50) DEFAULT NULL COMMENT '发布日期',
	update_time varchar(50) NOT NULL COMMENT '更新日期'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `java-public`.b_label (
	id varchar(100) NOT NULL COMMENT '分类ID',
	label varchar(200) NOT NULL COMMENT '标签名',
	create_time varchar(50) DEFAULT NULL COMMENT '创建日期',
	update_time varchar(50) NOT NULL COMMENT '更新日期'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;



-- 查询 b_info
SELECT * FROM b_info i;

-- 查询用户表 b_user
SELECT * FROM b_user u;
-- 插入用户信息
INSERT INTO b_user VALUES ('28bf2e57-72a7-4b52-9171-ff4e98fc5f31','yccztt','e10adc3949ba59abbe56e057f20f883e','yccztt',NULL,NULL,NULL,NULL,'admin','all','2021-06-14 16:30','2021-06-14 16:30');
-- 修改用户信息
UPDATE b_user SET avatar = 'http://localhost:8081/upload/avatar/avatar.jpg' WHERE id = '28bf2e57-72a7-4b52-9171-ff4e98fc5f31';

-- 查询文章
SELECT * FROM b_article a;
-- 插入文章
INSERT INTO b_article VALUES ('3e8367537d6d4d1c9f3b1a62eed34ca7','test',0,'test','http://localhost:8081/upload/blog/2021-06-19/dark_deer.png','<h1>test</h1>','Y','yccztt','2021-06-19 17:32','2021-06-19 17:32');

-- 查询标签
SELECT * FROM b_label b;
-- 插入标签
INSERT INTO b_label VALUES ('2d78c9670a244394ae4859ef105d944a','vue','2021-07-04 16:17','2021-07-04 16:17');