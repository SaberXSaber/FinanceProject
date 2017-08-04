CREATE TABLE `fund` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `fundCode` varchar(50) DEFAULT '' COMMENT '基金代码',
  `fundName` varchar(200) DEFAULT NULL COMMENT '基金简称',
  `detailedUrl` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `dailyValue` double(20,4) DEFAULT NULL COMMENT '日增长值',
  `dailyRate` double(20,4) DEFAULT NULL COMMENT '日增率',
  `estimateValue` double(20,4) DEFAULT NULL COMMENT '净值估算',
  `unitValue` double(20,4) DEFAULT NULL COMMENT '单位净值',
  `cumulativeValue` double(20,4) DEFAULT NULL COMMENT '累计净值',
  `oneMonth` double(20,4) DEFAULT NULL COMMENT '近1月涨幅',
  `threeMonth` double(20,4) DEFAULT NULL COMMENT '近3月涨幅',
  `sixMonth` double(20,4) DEFAULT NULL COMMENT '近6月涨幅',
  `oneYear` double(20,4) DEFAULT NULL COMMENT '近1年涨幅',
  `threeYear` double(20,4) DEFAULT NULL COMMENT '近3年涨幅',
  `always` double(20,4) DEFAULT NULL COMMENT '成立来涨幅',
  `fundScale` double(20,4) DEFAULT NULL COMMENT '基金规模(亿)',
  `fundManager` varchar(50) DEFAULT NULL COMMENT '基金经理',
  `manager` varchar(50) DEFAULT NULL COMMENT '管理人',
  `fundRating` varchar(50) DEFAULT NULL COMMENT '基金评级',
  `poundage` varchar(50) DEFAULT NULL COMMENT '手续费',
  `applyState` varchar(50) DEFAULT NULL COMMENT '状态',
  `redeemState` varchar(50) DEFAULT NULL COMMENT '赎回状态',
  `bulidDate` datetime DEFAULT NULL COMMENT '成立日',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `sharestest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sharesCode` varchar(50) DEFAULT NULL COMMENT '股票代码',
  `sharesName` varchar(50) DEFAULT NULL COMMENT '股票名称',
  `latestPrice` double(50,4) DEFAULT NULL COMMENT '最新价',
  `rose` double(50,4) DEFAULT NULL COMMENT '涨跌幅',
  `netWorth` double(50,4) DEFAULT NULL COMMENT '占净值',
  `ratio` double(50,4) DEFAULT NULL COMMENT '持仓占比',
  `holdingShares` int(11) DEFAULT NULL COMMENT '持股数（万股）',
  `marketValue` double(50,4) DEFAULT NULL COMMENT '持仓市值',
  `fundId` int(11) DEFAULT NULL COMMENT '基金来源',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6194 DEFAULT CHARSET=utf8;