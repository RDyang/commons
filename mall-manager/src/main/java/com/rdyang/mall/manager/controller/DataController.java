package com.rdyang.mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.springmvc.base.BaseController;
import com.rdyang.springmvc.base.SpringContextHolder;

@Controller
@RequestMapping("/manager")
public class DataController extends BaseController {

	@RequestMapping("/queryData")
	@ResponseBody
	public Pagination<?> queryData(@RequestParam("uri")String uri){
		Object bean = SpringContextHolder.getBean(uri);
		return null;
	}
	
}
