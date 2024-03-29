package cn.wk;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.wk.service","cn.wk.controller","cn.wk.config"})
public class HibernateApplication {
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}
	
	@Bean
	public Redisson redisson(){
		Config config=new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
		return (Redisson)Redisson.create(config);
	}
}
