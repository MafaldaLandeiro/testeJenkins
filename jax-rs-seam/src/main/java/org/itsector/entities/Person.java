package org.itsector.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person entity
 * 
 * @author E455 - nuno.neves@itsector.pt
 */
@Entity
@Table(name = "PERSON")
public class Person {

	//**********
	//*	ATTRS
	//**********
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 255, nullable = true)
	private String name;
	
	@Column(name = "age", nullable = true)
	private Integer age;

	//**********
	//*	GETS / SETS
	//**********
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
