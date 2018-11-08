package com.cliff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cliff.common.utils.Page;
import com.cliff.pojo.Customer;
import com.cliff.pojo.Dict;
import com.cliff.pojo.User;
import com.cliff.service.CustomerService;
import com.cliff.service.DictService;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DictService dictService;
	//客户来源 002
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	//客户行业 001
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	//客户级别 006
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	//客户列表
	@RequestMapping("/customerManager/list")
	public String list(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows,
			String custName,String custSource,String custIndustry,String custLevel,Model model,HttpSession session) {
		//System.out.println("从前端接收的custName参数： "+custName);
		//条件查询所有客户
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel, session);
		model.addAttribute("page", customers);
		//客户来源
		List<Dict> fromType = dictService.findDictByTypeCode(FROM_TYPE);
		//客户所属行业
		List<Dict> industryType = dictService.findDictByTypeCode(INDUSTRY_TYPE);
		//客户所属级别
		List<Dict> levelType = dictService.findDictByTypeCode(LEVEL_TYPE);
		//添加参数
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "customerManager";
	}
	
	
	//添加客户
	@RequestMapping("/customerManager/create")
	@ResponseBody
	public String createCustomer(Customer customer, HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
		customer.setCust_user_id(user.getUser_id());
		customer.setCust_create_id(user.getUser_id());		
		customer.setCust_createtime(new Date());
		int rows = customerService.createCustomer(customer);
		if(rows > 0) {
			return "OK";
		}else {
			return "FALL";
		}
	}
	
	//根据id获取客户信息
	@GetMapping("/customerManager/getCustomerById")
	@ResponseBody
	public Customer getCustomerById(int id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	
	//修改客户信息
	@RequestMapping("/customerManager/update")
	@ResponseBody
	public String updateCustomer(Customer customer) {
		int rows = customerService.updateCustomer(customer);
		if(rows > 0) {
			return "OK";
		}else {
			return "FALL";
		}
	}
	
	//删除客户信息
	@RequestMapping("/customerManager/deleteById")
	@ResponseBody
	public String deleteCustomer(int id) {
		int rows = customerService.deleteCustomer(id);
		if(rows > 0) {
			return "OK";
		}else {
			return "FALL";
		}
	}
	
}
