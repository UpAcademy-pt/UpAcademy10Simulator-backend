package simSalProject.Utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class SendMail {

		public static void sendMail(String email, String randomPassword) throws IOException {
		    Email from = new Email("simuladorsalaria@gmail.com");
		    String subject = "Sending with Twilio SendGrid is Fun";
		    Email to = new Email(email);
		    Content content = new Content("text/plain", "and easy to do anywhere, even with Java. A sua password é: " + randomPassword);
		    Mail mail = new Mail(from, subject, to, content);

		    SendGrid sg = new SendGrid(System.getProperty("SGKey"));
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
		  }
		  
		public static String createRandom() {
			
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 8;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedPassword = buffer.toString();
		    return generatedPassword;
		}
		
		 
		  
}

