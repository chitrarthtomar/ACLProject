package authentication;

import java.util.Date;
import java.util.HashMap;

public class TokenAuthentication {
	private static HashMap<String, Long > tokens = new HashMap<>();
	private EncryptionEngine encryptionEngine;
	
	public String addToken(String uName) {
		String token = encryptionEngine.encryptWithMD5(uName);
		Date date = new Date();
		tokens.put(token , date.getTime());
		return token;
	}
	
	public boolean checkToken(String token) {
		if(!tokens.containsKey(token)){
			return false;
		}
		else {
			if((tokens.get(token)-(new Date()).getTime())>60000) {
				tokens.remove(token);
				return false;
			}
			else
				return true;
		}
	}
	
	public void deleteToken(String token) {
		tokens.remove(token);
	}
}
