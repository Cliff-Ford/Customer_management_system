package com.cliff.service;

import java.util.List;

import com.cliff.pojo.Dict;

public interface DictService {
	//�����������ѯ�����ֵ�
	public List<Dict> findDictByTypeCode(String typecode);
}
