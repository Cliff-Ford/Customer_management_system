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
	//�ͻ���Դ 002
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	//�ͻ���ҵ 001
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	//�ͻ����� 006
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	//�ͻ��б�
	@RequestMapping("/customerManager/list")
	public String list(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows,
			String custName,String custSource,String custIndustry,String custLevel,Model model,HttpSession session) {
		//System.out.println("��ǰ�˽��յ�custName������ "+custName);
		//������ѯ���пͻ�
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel, session);
		model.addAttribute("page", customers);
		//�ͻ���Դ
		List<Dict> fromType = dictService.findDictByTypeCode(FROM_TYPE);
		//�ͻ�������ҵ
		List<Dict> industryType = dictService.findDictByTypeCode(INDUSTRY_TYPE);
		//�ͻ���������
		List<Dict> levelType = dictService.findDictByTypeCode(LEVEL_TYPE);
		//���Ӳ���
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "customerManager";
	}
	
	
	//���ӿͻ�
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
	
	//����id��ȡ�ͻ���Ϣ
	@GetMapping("/customerManager/getCustomerById")
	@ResponseBody
	public Customer getCustomerById(int id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	
	//�޸Ŀͻ���Ϣ
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
	
	//ɾ���ͻ���Ϣ
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