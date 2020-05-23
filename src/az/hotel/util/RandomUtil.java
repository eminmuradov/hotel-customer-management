package az.hotel.util;

import java.util.UUID;

public class RandomUtil {
    public static String generateRandomPassword(){
       String password= UUID.randomUUID().toString();
      return  password.substring(password.length()-10);
    }
}
