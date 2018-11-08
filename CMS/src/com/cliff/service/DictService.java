package com.cliff.service;

import java.util.List;

import com.cliff.pojo.Dict;

public interface DictService {
	//根据类别代码查询数据字典
	public List<Dict> findDictByTypeCode(String typecode);
}
