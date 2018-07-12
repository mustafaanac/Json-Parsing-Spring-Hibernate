package com.dovizparser.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="dovizkuru")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Kurlar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="buying")
	private double buying;
	
	@Column(name="selling")
	private double selling;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBuying() {
		return buying;
	}

	public void setBuying(double buying) {
		this.buying = buying;
	}

	public double getSelling() {
		return selling;
	}

	public void setSelling(double selling) {
		this.selling = selling;
	}

	@Override
	public String toString() {
		return "Kurlar [id=" + id + ", name=" + name + ", buying=" + buying + ", selling=" + selling + "]";
	}
	

	
}
