package authentication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class TokenAuthentication {
 private static HashMap<String, Long > tokens= new HashMap<>();
 private static HashMap<String, String > userAuthorization= new HashMap<>();
 EncryptionEngine encryptionEngine = new EncryptionEngine();
 
 public String addToken(String uName, String uRole) {
  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  String token = encryptionEngine.encryptWithMD5(uName+timeStamp);
  if(tokens.containsKey(token)){
   deleteToken(token);
   
  }
  Date date = new Date();
  tokens.put(token , date.getTime());
  userAuthorization.put(token, uRole);
  return token;
 }
 
 public boolean checkAdmin(String token) {
  return userAuthorization.get(token)=="admin";
 }
 
 public boolean checkToken(String token) {
  if(!tokens.containsKey(token)){
   return false;
  }
  else {
   if(((new Date()).getTime())-tokens.get(token)>600000) {
    tokens.remove(token);
    return false;
   }
   else
    return true;
  }
 }
 
 public void deleteToken(String token) {
  tokens.remove(token);
  userAuthorization.remove(token);
 }
}
