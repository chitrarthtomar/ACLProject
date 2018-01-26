package authentication;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

public class TokenAuthentication {
	private static HashMap<String, Long > tokens= new HashMap<>();
	EncryptionEngine encryptionEngine = new EncryptionEngine();
	
	public String addToken(String uName) {
		String token = encryptionEngine.encryptWithMD5(uName);
		if(tokens.containsKey(token)){
			deleteToken(token);
		}
		Date date = new Date();
		System.out.println(token+date.getTime());
		tokens.put(token , date.getTime());
		return token;
	}
	
	public boolean checkToken(String token) {
		if(!tokens.containsKey(token)){
			return false;
		}
		else {
			if(((new Date()).getTime())-tokens.get(token)>60000) {
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
