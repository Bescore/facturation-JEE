package modele;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void envoi(String mailTo,String message) {
		final String mailFrom = "cdatest21260@gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		// SMTP Host
		props.put("mail.smtp.socketFactory.port", "465");
		// SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL
		//Factory Class;
		props.put("mail.smtp.auth", "true"); // Enabling
		//SMTP Authentication;
		props.put("mail.smtp.port", "465"); // SMTP Port
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("cdatest21260@gmail.com", "ggkffuadscvtjyww");
			}
		});
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailFrom));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
			msg.setSubject("Merci de votre confiance");
			msg.setContent(""+message+"","text/html;charset=utf-8");
			Transport.send(msg);
			System.out.println("mail envoyé ");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("message non envoyé il y a une erreur");
		}

	}
}
