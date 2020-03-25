package cn.wk.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.wk.model.Customer;


public interface CustomerMapper extends CrudRepository<Customer,Long>{

}
