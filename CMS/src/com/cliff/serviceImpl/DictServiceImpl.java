package com.cliff.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliff.dao.DictMapper;
import com.cliff.pojo.Dict;
import com.cliff.service.DictService;

@Service("dictService")
public class DictServiceImpl implements DictService{

	@Autowired
	private DictMapper dictMapper;
	
	public List<Dict> findDictByTypeCode(String typecode) {
		return dictMapper.selectDictByTypeCode(typecode);
		
	}

}
