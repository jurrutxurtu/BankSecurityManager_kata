package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SecurityManager {
    public static void createUser() {
    	  SecurityManager securityManager = new SecurityManager();
    	  securityManager.createUserNotStatically();
    }
    
    public void createUserNotStatically(){
    	 BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

         String username = null;
         String fullName = null;
         String password = null;
         String confirmPassword = null;
         try {
        	 HashMap<String,String> inputData = readInputData(buffer);
             username = inputData.get("username");
             fullName = inputData.get("fullName");
             password = inputData.get("password");
             confirmPassword = inputData.get("confirmPassword");
         } catch (IOException e) {
             e.printStackTrace();
         }

         if (!checkPasswordConfirmation(password, confirmPassword)) {
             System.out.println("The passwords don't match");
             return;
         }

         if (checkPasswordLengthBelow8(password)) {
             System.out.println("Password must be at least 8 characters in length");
             return;
         }

         // Encrypt the password (just reverse it, should be secure)
         String encryptedPassword = new StringBuilder(password).reverse().toString();

         System.out.println(
             String.format(
             "Saving Details for User (%s, %s, %s)\n",
             username,
             fullName,
             encryptedPassword)
         );
     }
    
    protected HashMap<String,String> readInputData(BufferedReader buffer) throws IOException{
    	HashMap<String,String> inputMap = new HashMap<String, String>();
    	System.out.println("Enter a username");
        inputMap.put("username", buffer.readLine());
        System.out.println("Enter your full name");
        inputMap.put("fullName", buffer.readLine());
        System.out.println("Enter your password");
        inputMap.put("password", buffer.readLine());
        System.out.println("Re-enter your password");
        inputMap.put("confirmPassword", buffer.readLine());
        return inputMap;
    }

	protected boolean checkPasswordLengthBelow8(String password) {
		return password.length() < 8;
	}

	protected boolean checkPasswordConfirmation(String password,
			String confirmPassword) {
		return password.equals(confirmPassword);
	}
}
