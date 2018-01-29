package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import authentication.TokenAuthentication;

public class TokenAuthenticationTest {
	
	TokenAuthentication tokenAuthentication = new TokenAuthentication();
	
	@Test
	public void is_new_token_adding_for_new_user() {
		String token1 = tokenAuthentication.addToken("testing1", "admin");
		String token2 = tokenAuthentication.addToken("testing2", "user");
		assertNotEquals(token1, token2);
	}
	@Test
	public void is_delete_token_working() {
		String token1 = tokenAuthentication.addToken("testing", "admin");
		boolean ispresent = tokenAuthentication.checkToken(token1);
		assertEquals(true, ispresent);
		tokenAuthentication.deleteToken(token1);
		ispresent = tokenAuthentication.checkToken(token1);
		assertEquals(false, ispresent);
	}
	
	
	@Test
	public void is_token_admin_check_working() {
		String token1 = tokenAuthentication.addToken("testing", "admin");
		boolean isadmin = tokenAuthentication.checkAdmin(token1);
		assertNotEquals(false, isadmin);
	}
}
