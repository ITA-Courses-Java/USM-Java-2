package com.mycompany.app.my_app;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void testTrim() {
		App testing = new App();
		assertEquals("Result","Ice cream",testing.trim("                 Ice cream           "));
	}

}

