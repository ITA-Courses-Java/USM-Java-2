package com.example.jdbcExample;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest extends Assert {

	private Student o = new Student(1, "first_name", "last_name");

	@Test
	public void testgetId(){
		
		assertEquals("Test getId:", 1, o.getId());
		
	}
	
	@Test
	public void testgetFirst_name(){
		
		assertEquals("Test getFirst_name:", "first_name", o.getFirst_name());
		
	}

	@Test
	public void testgetLast_name(){

		assertEquals("Test getLast_name:", "last_name", o.getLast_name());
		
	}

	@Test
	public void testsetId(){
		
		o.setId(1);
		assertEquals("Test setId:", 1, o.getId());
		
	}
	
	@Test
	public void testsetFirst_name(){
		
		o.setFirst_name("first_name");
		assertEquals("Test setFirst_name:", "first_name", o.getFirst_name());
		
	}
	
	@Test
	public void testsetLast_name(){
		
		o.setLast_name("last_name");
		assertEquals("Test setLast_name:", "last_name", o.getLast_name());
		
	}
	
}
