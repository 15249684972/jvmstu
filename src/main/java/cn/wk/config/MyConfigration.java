package cn.wk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.wk.model.Customer;

@Configuration
public class MyConfigration {

	@Bean
    public Customer getCustomer() {
		Customer customer=new Customer();
		customer.setCust_level("6666");
        return customer;
    }
}
