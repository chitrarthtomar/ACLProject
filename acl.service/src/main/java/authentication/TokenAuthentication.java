package authentication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import controllers.GroupController;

public class TokenAuthentication {
	private static HashMap<String, Long> tokens = new HashMap<>();
	private static HashMap<String, String> userAuthorization = new HashMap<>();
	private static final Logger logger = Logger.getLogger(GroupController.class);
	EncryptionEngine encryptionEngine = new EncryptionEngine();

	public String addToken(String uName, String uRole) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String token = encryptionEngine.encryptWithMD5(uName + timeStamp);
		if (tokens.containsKey(token))
			deleteToken(token);
		Date date = new Date();
		tokens.put(token, date.getTime());
		userAuthorization.put(token, uRole);
		return token;
	}

	public boolean checkAdmin(String token) {
		logger.info("Verifying if admin is making the request");
		return userAuthorization.get(token).equals("admin");
	}

	public boolean checkToken(String token) {
		logger.info("Verifying token");
		if (!tokens.containsKey(token)) {
			return false;
		} else {
			if (((new Date()).getTime()) - tokens.get(token) > 20*60*1000) {
				tokens.remove(token);
				return false;
			} else
				return true;
		}
	}

	public void deleteToken(String token) {
		logger.info("Deleting token");
		tokens.remove(token);
		userAuthorization.remove(token);
	}
}
