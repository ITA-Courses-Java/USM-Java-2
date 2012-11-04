package com.example.jdbcExample;

public class Student {

	private int id = 0;
	private String first_name = null;
	private String last_name = null;

	public Student(int id, String first_name, String last_name) {
		setId(id);
		setFirst_name(first_name);
		setLast_name(last_name);
	}
	
	public Student(String first_name, String last_name) {
		setId(id);
		setFirst_name(first_name);
		setLast_name(last_name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
