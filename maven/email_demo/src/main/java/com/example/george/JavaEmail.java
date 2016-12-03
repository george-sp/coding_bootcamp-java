package com.example.george;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	String propertyFile = "config.properties";

	String emailHost = "smtp.gmail.com";
	// gmail's smtp port
	String emailPort = "587";
	// your gmail id
	String fromUser;
	String fromUserEmailPassword;
	String[] toEmails = { "spiridakis.grg@gmail.com" };

	public JavaEmail() {
		this.fromUser = getPropertyValue(propertyFile, "email");
		this.fromUserEmailPassword = getPropertyValue(propertyFile, "password");
	}

	public void setMailServerProperties() {
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
	}

	public void createEmailMessage(String emailSubject, String emailBody) throws AddressException, MessagingException {
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}
		emailMessage.setSubject(emailSubject);
		// for a html email
		emailMessage.setContent(emailBody, "text/html");
		// emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
	}

	/**
	 * Returns the value of the specified key from a defined properties file.
	 * 
	 * @param fileName
	 *            the resource name
	 * @param key
	 *            the property key
	 * @return the property value of the specified key
	 */
	public static String getPropertyValue(String fileName, String key) {
		String propertyValue = "";
		// Create an empty property list
		Properties properties = new Properties();
		try (InputStream is = JavaEmail.class.getClassLoader().getResourceAsStream(fileName)) {
			// Read a property list from the specified input stream
			properties.load(is);
			// Search for the property with the specified key in this property
			// list
			propertyValue = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;
	}
}