package com.cliff.dao;

import java.util.List;

import com.cliff.pojo.Customer;


public interface CustomerMapper {
	//�ͻ��б�
	public List<Customer> selectCustomerList(Customer customer);
	//�ͻ���
	public int selectCustomerListCount(Customer customer);
	public int createCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(int id);
}
