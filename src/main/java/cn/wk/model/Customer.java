package cn.wk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "cust_id",columnDefinition = "bigint(20) COMMENT '客户编号(主键)'")
	private Long cust_id;
	@Column(name = "cust_name", nullable = false, columnDefinition = "VARCHAR(32) COMMENT '客户名称(公司名称)'")
	private String cust_name;
	@Column(name = "cust_source", nullable = true, columnDefinition = "VARCHAR(32) COMMENT '客户信息来源'")
	private String cust_source;
	@Column(name = "cust_industry", nullable = true, columnDefinition = "VARCHAR(32) COMMENT '客户所属行业'")
	private String cust_industry;
	@Column(name = "cust_level", nullable = true, columnDefinition = "VARCHAR(32) COMMENT '客户级别'")
	private String cust_level;
	@Column(name = "cust_phone", nullable = true, columnDefinition = "VARCHAR(32) COMMENT '固定电话'")
	private String cust_phone;
	@Column(name = "cust_mobile", nullable = true, columnDefinition = "VARCHAR(32) COMMENT '移动电话'")
	private String cust_mobile;

}
