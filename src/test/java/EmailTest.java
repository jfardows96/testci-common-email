package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import java.util.Date;
import javax.mail.internet.MimeMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	
	private static final String[] TEST_EMAILS = { "abbccc@.com", "a.b@c.org", "jjjjk@b.com"};
	private static final String TEST_EMAILS2 =  "Jannatul@gmail.com";
        private static String header = "check";
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception{
		
		email = new EmailConcrete();
	}
	 @After
	 public void tearDownEmailTest() throws Exception{
		 
	 }
	 
	 @Test
	 public void testAddBcc() throws Exception{
		 
		 
		 email.addBcc(TEST_EMAILS);
		 assertEquals(3, email.getBccAddresses().size());
	 }
	 
	 @Test
	public void testAddCc() throws Exception{
		email.addCc(TEST_EMAILS2);
		assertEquals(1, email.getCcAddresses().size());
	}
	
	 @Test
	public void testAddHeader() throws Exception{
		email.addHeader(header, "check");
		
		assertEquals(1, email.headers.size());
	}
       @Test
	public void testAddReplyTo() throws Exception{
		
		email.addReplyTo(TEST_EMAILS2, "Jannatul");
		assertEquals(1, email.getReplyToAddresses().size());
	}
	
	@Test
	public void testgetSocketConnectionTimeout() throws Exception{
		
		email.socketConnectionTimeout = 6000;
		assertEquals(6000, email.getSocketConnectionTimeout());
	}

	 @Test 
	public void testgetHostName() throws Exception{
		email.setHostName("localhost");
		
		assertEquals("localhost",email.getHostName());
	}
	
	@Test 
	public void    testnullgetHostName() throws Exception{
		email.setHostName(null);
		
		assertEquals(null,email.getHostName());
	}
      @Test
	public void testgetSentDate() throws Exception{
		
		Date dtTest = Calendar.getInstance().getTime();
		email.setSentDate(dtTest);
		
		assertEquals(dtTest, email.getSentDate());
	}
	@Test 
	public void testgetMailSession() throws Exception{
		email.getMailSession();
		assertEquals(0,email.getMailSession());
		
	}
	@Test
	public void testbuildMimeMessage() throws Exception{
		
		email.setHostName("localhost");
		email.setSmtpPort(9090);
		email.setFrom("assf@gmail.com");
		email.addTo("ddjl@yahoo.com");
		email.setSubject("aSubject");
		final String headerValue= "22939u9   388338    39399333434";
		email.addHeader("jskjdk", headerValue);
		email.content = "content";
		email.buildMimeMessage();
		MimeMessage msg = email.getMimeMessage();

		String conT = msg.getContent().toString();
		assertEquals("content",conT);	
		
	}
	@Test
	public void testSetFrom() throws Exception{
			
			email.setFrom("jan@gmail.com");
			assertEquals("jan@gmail.com",email.getFromAddress().toString());
	}


}



