CREATE TABLE t_user(  -- 用户信息表
	pk_userId INT PRIMARY KEY AUTO_INCREMENT,
	u_name VARCHAR(20),
	u_pwd INT,
	u_money DOUBLE
);
  
  
CREATE TABLE t_Info( -- 交易信息表

	pk_infoId INT PRIMARY KEY AUTO_INCREMENT,
	tr_time DATETIME, -- 交易时间
	tr_content VARCHAR(20), -- 交易内容
	fk_userId INT,
	FOREIGN KEY(fk_userId) REFERENCES t_user(pk_id)	
);



-- FOREIGN KEY(fk_manId) REFERENCES t_man(pk_id) -- 外键约束
