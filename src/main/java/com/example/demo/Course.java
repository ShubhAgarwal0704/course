package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	private int id;
	private String name;
	private String hod;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String name, String hod) {
		super();
		this.id = id;
		this.name = name;
		this.hod = hod;
	}

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

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	@Override
	public String toString() {
		return "Course [id = " + id + ", name = " + name + ", Hod Name = " + hod + "]";
	}
}