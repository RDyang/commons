package com.rdyang.mall.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.entity.Stock;
import com.rdyang.mall.manager.service.StockService;
import com.rdyang.springmvc.base.BaseController;

@Controller
@RequestMapping("/manager/stock")
public class StockController extends BaseController {

	@Autowired
	private StockService stockService;

	@RequestMapping("/showStock")
	public ModelAndView show(@ModelAttribute("stock") Stock stock) {
		Map<String, Object> params = setConditions(stock);
		Pagination<Stock> findStock = stockService.findStock(pageIndex,
				pageSize, params);
		Map<String, Pagination<Stock>> model = new HashMap<>();
		log.info(findStock.toString());
		model.put("stock", findStock);
		return new ModelAndView("store", model);
	}

}
