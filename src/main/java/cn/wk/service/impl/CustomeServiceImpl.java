package cn.wk.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wk.mapper.CustomerMapper;
import cn.wk.model.Customer;
import cn.wk.service.CustomerService;

@Service
public class CustomeServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;
	
	@Transactional
	@Override
	public Customer insertCustomer(Customer customer) throws Throwable {
		Customer save = customerMapper.save(customer);
		if(save==null){
			return null;
		}
		if(true){
			throw new RuntimeException("事务回滚，插入失败");
		}
//		if(true){
//			throw new Error("Error测试");
//		}
		return save;
	}

	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteById(id);

	}

	@Override
	public void updateStudent(Customer customer) {
		customerMapper.save(customer);
	}

	@Override
	public List<Customer> getCustomer() {
		customerMapper.findAll();
		return (List<Customer>)customerMapper.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		Optional<Customer> optCustomer = customerMapper.findById(id);
		if(optCustomer.isPresent()==false){
			return null;
		}
		return optCustomer.get();
	}

}
