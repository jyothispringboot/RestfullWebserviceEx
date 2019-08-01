package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@ Data
@Entity
@Table(name="Itemtab")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="item_code")
	private String code;
	@Column(name="item_cost")
	private Double cost;

}
