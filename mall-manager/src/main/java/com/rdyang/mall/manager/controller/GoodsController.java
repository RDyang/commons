package com.rdyang.mall.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.entity.Goods;
import com.rdyang.mall.manager.service.GoodsService;
import com.rdyang.springmvc.base.BaseController;

@Controller
@RequestMapping("/manager/goods")
public class GoodsController extends BaseController {
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/showGoods")
	public ModelAndView show(@ModelAttribute("goods") Goods goods) {
		Map<String, Object> params = setConditions(goods);
		Pagination<Goods> find = goodsService.findGoods(pageIndex,
				pageSize, params);
		Map<String, Pagination<Goods>> model = new HashMap<>();
		log.info(find.toString());
		model.put("goods", find);
		return new ModelAndView("goods", model);
	}
}
