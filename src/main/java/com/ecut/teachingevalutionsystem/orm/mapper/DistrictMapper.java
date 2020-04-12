package com.ecut.teachingevalutionsystem.orm.mapper;

import com.ecut.teachingevalutionsystem.orm.entity.District;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理省/市/区数据的持久层接口
 */
public interface DistrictMapper {
	
	/**
	 * 根据省/市/区的代号查询详情
	 * @param code 省/市/区的代号
	 * @return 省/市/区的详情
	 */
	District findByCode(String code);

	District findByName(String name);

	/**
	 * 获取列表
	 * @param parent 父级单位的代号
	 * @return 列表
	 */
	List<District> findByParent(String parent);

	/**
	 * 获取列表
	 * @param type 查询的类型
	 * @return 全列表
	 */
	List<District> findByType(String type);

}






