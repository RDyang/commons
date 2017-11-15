package com.rdyang.mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdyang.springmvc.base.BaseController;

@Controller
@RequestMapping("/manager/stock")
public class LoginController extends BaseController{

	@RequestMapping("/login")
	public String Login(){
		return "home";
	}
}
