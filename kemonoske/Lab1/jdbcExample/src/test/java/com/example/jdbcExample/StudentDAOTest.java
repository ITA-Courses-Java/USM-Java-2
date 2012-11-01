package com.example.jdbcExample;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class StudentDAOTest extends Assert {

	@Test
	public void testStudendDao() {
		
		try {
			StudentDAO sd = new StudentDAO();
			assertNotNull("Conection test:", sd.getCon());
			assertNotNull("Content test:", sd.listStudents());
		} catch (ClassNotFoundException e) {
			assertEquals("ClassNotFondException test:", e instanceof ClassNotFoundException);
		} catch (SQLException e) {
			assertEquals("SQLException test:", e instanceof SQLException);
		} catch (Throwable e) {
			assertTrue("Exception not catched:", false);
		}
		
		
	}
	
	
}
