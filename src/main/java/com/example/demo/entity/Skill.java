package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)

	private Student stu;


	public Student getStu() {
		return stu;
	}
//SpringBootDockerDemoSpringBootDocke


	public Skill(Integer id, String name, Student stu) {
		super();
		this.id = id;
		this.name = name;
		this.stu = stu;
	}




	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}




	public void setStu(Student stu) {
		this.stu = stu;
	}




	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}


	

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




	 

}
