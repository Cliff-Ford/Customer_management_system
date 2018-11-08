package com.cliff.dao;

import java.util.List;

import com.cliff.pojo.Customer;


public interface CustomerMapper {
	//客户列表
	public List<Customer> selectCustomerList(Customer customer);
	//客户数
	public int selectCustomerListCount(Customer customer);
	public int createCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(int id);
}
