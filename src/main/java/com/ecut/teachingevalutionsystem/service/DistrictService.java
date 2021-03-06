package com.ecut.teachingevalutionsystem.service;

import com.ecut.teachingevalutionsystem.orm.entity.District;
import com.ecut.teachingevalutionsystem.orm.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理省/市/区数据的业务层实现类
 */
@Service
public class DistrictService {
	
	@Autowired
	private DistrictMapper districtMapper;

	public District getByCode(String code) {
		return districtMapper.findByCode(code);
	}
	
	public List<District> getByParent(String parent) {
		List<District> list = districtMapper.findByParent(parent);
		for (District item : list) {
			item.setId(null);
			item.setParent(null);
		}
		return list;
	}
	public List<District> getByType(String type) {
		List<District> list = districtMapper.findByType(type);
		for (District item : list) {
			item.setId(null);
			item.setParent(null);
		}
		return list;
	}

}





