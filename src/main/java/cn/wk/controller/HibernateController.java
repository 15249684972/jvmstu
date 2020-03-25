package cn.wk.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wk.model.Customer;
import cn.wk.service.CustomerService;

@Controller
public class HibernateController {

	@Autowired
	CustomerService customerService;

	@Autowired
	Customer customer;
	
	int i=0;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public Customer test() {
		
		return customer;
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	@ResponseBody
	public String test2() {
		int j=0;
		if(j==0){
			j=j+1;
		}
		i=i+1;
		return Integer.toString(i)+Integer.toString(j);
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> insert() {
		int code = 0;
		String msg = null;
		Customer customer = new Customer();
		customer.setCust_name("东东");
		customer.setCust_source("小红本");
		Customer cus;
		try {
			cus = customerService.insertCustomer(customer);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			code = 500;
			msg = e.getMessage();
		}
		HashMap<String, Object> msgMap = new HashMap<>();
		msgMap.put("code", code);
		msgMap.put("msg", msg);
		return msgMap;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@RequestMapping("delete")
	public void delete(Long id) {

	}

	/**
	 * 更新
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping("updata")
	public String updata(Customer customer) {

		return "SUCCESS";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@RequestMapping("getCustomer")
	public List<Customer> getCustomer() {

		return null;
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getCustomerById")
	public Customer getCustomerById(Long id) {

		return null;
	}

}
