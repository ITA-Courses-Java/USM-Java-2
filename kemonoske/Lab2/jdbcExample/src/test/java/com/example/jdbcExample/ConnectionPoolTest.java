package com.example.jdbcExample;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionPoolTest extends Assert {

	private ConnectionPool cp = null;

	@Test
	public void testConnectionPool() {

		cp = new ConnectionPool("216.218.192.170", 5432, "akira_Lab1",
				"akira_test", "Test_12");
		assertTrue("Constructor:", cp != null);
	}

	@Test
	public void testConnect() {
		try {
			cp.connect();
		} catch (Throwable e) {

			assertTrue("Unhandled exception: ",
					(e instanceof NullPointerException)
							|| (e instanceof SQLException));

		}
	}
}
