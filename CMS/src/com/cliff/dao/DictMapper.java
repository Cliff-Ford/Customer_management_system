package com.cliff.dao;

import java.util.List;

import com.cliff.pojo.Dict;

public interface DictMapper {
	//�����������ѯ�����ֵ�
	public List<Dict> selectDictByTypeCode(String typecode);
}
