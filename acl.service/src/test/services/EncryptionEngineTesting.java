package services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import authentication.EncryptionEngine;

public class EncryptionEngineTesting {
	
	EncryptionEngine encryptionEngine = new EncryptionEngine();
	
	@Test
	public void encryption_function_test() {
		String actual = encryptionEngine.encryptWithMD5("Hello");
		String expected = "8b1a9953c4611296a827abf8c4784d7";
		assertEquals(expected, actual);
	}
}
