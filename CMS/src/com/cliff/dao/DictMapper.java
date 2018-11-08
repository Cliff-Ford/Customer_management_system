package com.cliff.dao;

import java.util.List;

import com.cliff.pojo.Dict;

public interface DictMapper {
	//根据类别代码查询数据字典
	public List<Dict> selectDictByTypeCode(String typecode);
}
