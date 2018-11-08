package com.cliff.service;

import javax.servlet.http.HttpSession;

import com.cliff.common.utils.Page;
import com.cliff.pojo.Customer;

public interface CustomerService {
	public Page<Customer> findCustomerList(int page,int rows,String custName,String custSource,String custIndustry,String custLevel,HttpSession session);

	public int createCustomer(Customer customer);
	
	public Customer getCustomerById(int id);

	public int updateCustomer(Customer customer);
	
	public int deleteCustomer(int id);
}
