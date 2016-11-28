package bank;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.acl.LastOwnerException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SecurityManagerTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private SecurityManagerStub securityManager;

	@Before
	public void setUpStreams() {
		
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void  wrongConfirmationPasswordTest(){
		securityManager = new SecurityManagerStub("Gibran","Jon","abc","cba");
		securityManager.setPasswordConfirmed(false);
		
		System.setOut(new PrintStream(outContent));
		securityManager.createUserNotStatically();
		System.out.println(outContent.toString());
		assertEquals("The passwords don't match", outContent.toString().substring(outContent.toString().trim().lastIndexOf("\n")).trim());
	}
}
