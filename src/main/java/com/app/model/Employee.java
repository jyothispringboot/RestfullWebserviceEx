package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@ Data
@Entity
@Table(name="Employeetab")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="e_id")
	private Integer eid;
	@Column(name="e_name")
	private String ename;
	@Column(name="e_sal")
	private Double esal;
	

}
