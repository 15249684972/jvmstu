package cn.wk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.wk.model.Customer;

@Service
public interface CustomerService {

	/**
	 * 添加
	 * @return 
	 * @throws Throwable 
	 */
	Customer insertCustomer(Customer customer) throws Throwable;

	/**
	 * 删除
	 */
	void deleteCustomer(Long id);

	/**
	 * 修改
	 */
	void updateStudent(Customer customer);

	/**
	 * 查询
	 */
	List<Customer> getCustomer();

	/**
	 * 查询单个
	 */
	Customer getCustomerById(Long id);

}
