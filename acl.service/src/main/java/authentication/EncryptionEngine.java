package authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EncryptionEngine {
	private static final Logger logger = Logger.getLogger(EncryptionEngine.class);

	public String encryptWithMD5(String pass) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.fatal("Alogithm Exception: " + e);
		}
		return null;

	}
}