package com.ecut.teachingevalutionsystem.controller;

import com.ecut.teachingevalutionsystem.orm.entity.District;
import com.ecut.teachingevalutionsystem.service.DistrictService;
import com.ecut.teachingevalutionsystem.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController {

	@Autowired
	private DistrictService districtService;
	
	@GetMapping("/")
	public JsonResult<List<District>> getByParent(String parent) {
		List<District> data = districtService.getByParent(parent);
		return new JsonResult<>(2000, data);
	}
	@GetMapping("/type")
	public JsonResult<List<District>> getByType(String type) {
		List<District> data = districtService.getByType(type);
		return new JsonResult<>(2000, data);
	}

}







