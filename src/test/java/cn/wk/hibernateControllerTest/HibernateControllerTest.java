package cn.wk.hibernateControllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.wk.HibernateApplication;
import cn.wk.model.Customer;
import cn.wk.service.CustomerService;

@RunWith(SpringRunner.class)
@TestConfiguration
@SpringBootTest(classes = HibernateApplication.class)
public class HibernateControllerTest {

	@Autowired
	CustomerService customerService;

	@Test
	public void save() throws Throwable {
		Customer customer = new Customer();
		// customer.setCust_id(1l);
		customer.setCust_name("东东");
		customer.setCust_source("小红本");
		customerService.insertCustomer(customer);

	}
}
