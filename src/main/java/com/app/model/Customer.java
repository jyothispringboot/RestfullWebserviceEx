package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@ Data
@Entity
@Table(name="customertab")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="c_id")
	private Integer cid;
	@Column(name="customer_Name")
	private String ename;
	@Column(name="service_ID")
	private String serviceId;
	@Column(name="customer_mode")
	private String mode;

}
