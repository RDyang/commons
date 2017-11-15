package com.rdyang.mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rdyang.mall.manager.entity.Menu;
import com.rdyang.mall.manager.service.MenuService;
import com.rdyang.springmvc.base.BaseController;

@Controller
@RequestMapping(value="/manager/menu")
public class MenuController extends BaseController {
	
	@Autowired
	private MenuService menuService;

	@RequestMapping(value="/showMenu")
	@ResponseBody
	public List<Menu> initNavi(@RequestParam(value="id",required=false,defaultValue="0") Integer parentId){
		List<Menu> menus = menuService.findMenuByParentId(parentId);
		return menus;
	}
}
