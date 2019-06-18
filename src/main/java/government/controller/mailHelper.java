package government.controller;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import government.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class mailHelper {
	public static void sendMailToUser(User user, String password) throws MessagingException {
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", true);
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", "smtp.mailgun.org");
			prop.put("mail.smtp.port", "587");

			Session session = Session.getInstance(prop, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("postmaster@mg.zwemkampwzv.nl'", System.getenv("SMTP_PASSWORD"));
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Luxemburg-no-reply@goverment.com"));
			message.setRecipients(
					Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Account");

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent("username: " + user.getEmail() + "wachtwoord: " + password, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);


			message.setContent(multipart);


			Transport.send(message);
	}

	public static JsonNode sendMailToUserMailGun(User user, String password) throws UnirestException {
		HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "mg.zwemkampwzv.nl" + "/messages")
				.basicAuth("api",System.getenv("SMTP_PASSWORD") )
				.field("from", "postmaster@mg.zwemkampwzv.nl")
				.field("to", user.getEmail())
				.field("subject", "Account creation")
				.field("text", "username: " + user.getEmail() + "wachtwoord: " + password)
				.asJson();
		return request.getBody();
	}
}
