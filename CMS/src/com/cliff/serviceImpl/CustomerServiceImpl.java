package com.cliff.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliff.common.utils.Page;
import com.cliff.dao.CustomerMapper;
import com.cliff.pojo.Customer;
import com.cliff.pojo.User;
import com.cliff.service.CustomerService;



@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> findCustomerList(int page, int rows, String custName, String custSource, String custIndustry,
			String custLevel,HttpSession session) {
		Customer customer = new Customer();
		if(StringUtils.isNotBlank(custName)) {
			customer.setCust_name(custName.trim());
		}
		if(StringUtils.isNotBlank(custSource)) {
			customer.setCust_source(custSource);
		}
		if(StringUtils.isNotBlank(custIndustry)) {
			customer.setCust_industry(custIndustry);
		}
		if(StringUtils.isNotBlank(custLevel)) {
			customer.setCust_level(custLevel);
		}
		User user = (User) session.getAttribute("USER_SESSION");
		customer.setCust_user_id(user.getUser_id());
		customer.setStart((page-1)*rows);
		customer.setRows(rows);
		List<Customer> customers = customerMapper.selectCustomerList(customer);
		int count = customerMapper.selectCustomerListCount(customer);
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}

	@Override
	public int createCustomer(Customer customer) {
		return customerMapper.createCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerMapper.getCustomerById(id);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return customerMapper.updateCustomer(customer);
	}

	@Override
	public int deleteCustomer(int id) {
		return customerMapper.deleteCustomer(id);
	}
}
