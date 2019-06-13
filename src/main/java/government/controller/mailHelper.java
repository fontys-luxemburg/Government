package government.controller;

import government.dto.UserDto;
import government.model.Credentials;
import government.model.User;
import org.apache.commons.lang.RandomStringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class mailHelper {
    public static void sendMailToUser(User user,String password) {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", false);
            prop.put("mail.smtp.starttls.enable", "false");
            prop.put("mail.smtp.host", "localhost");
            prop.put("mail.smtp.port", "25");
            Session session = Session.getInstance(prop);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Luxemburg-no-reply@goverment.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
            message.setSubject("Account");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("username: "+user.getEmail()+"wachtwoord: "+password, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);


            message.setContent(multipart);


            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
