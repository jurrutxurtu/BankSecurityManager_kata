package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class SecurityManagerStub extends SecurityManager{
	
	private boolean passwordConfirmed = true;
	private boolean passwordLengthBelow8 = true;
	private String userName;
	private String userFullName;
	private String password;
	private String confirmationPassword;
	
	public SecurityManagerStub(String userName, String userFullName, String password, String confirmationPassword){
		this.userName = userName;
		this.userFullName = userFullName;
		this.password = password;
		this.confirmationPassword = confirmationPassword;
	}
	
	@Override
	protected boolean checkPasswordConfirmation(String password,
			String confirmPassword) {
		return passwordConfirmed;
	}
	
	@Override
	protected boolean checkPasswordLengthBelow8(String password) {
		return passwordLengthBelow8;
	}
	
	@Override
	protected HashMap<String,String> readInputData(BufferedReader buffer) throws IOException{
    	HashMap<String,String> inputMap = new HashMap<String, String>();
    	System.out.println("Enter a username");
        inputMap.put("username", userName);
        System.out.println("Enter your full name");
        inputMap.put("fullName", userFullName);
        System.out.println("Enter your password");
        inputMap.put("password",password);
        System.out.println("Re-enter your password");
        inputMap.put("confirmPassword", confirmationPassword);
        return inputMap;
    }
	
	
	

	public boolean isPasswordConfirmed() {
		return passwordConfirmed;
	}

	public void setPasswordConfirmed(boolean passwordConfirmed) {
		this.passwordConfirmed = passwordConfirmed;
	}

	public boolean isPasswordLengthBelow8() {
		return passwordLengthBelow8;
	}

	public void setPasswordLengthBelow8(boolean passwordLengthBelow8) {
		this.passwordLengthBelow8 = passwordLengthBelow8;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
	
}
