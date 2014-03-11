package johanna.hirvonen;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail extends Thread{

private static String SMPT_HOSTNAME = "smtp.gmail.com";
private static String USERNAME = "johannahirvonen86@gmail.com";
private static String PASSWORD = "Matteus6:33";
private Session session;
private String subject;

@Override
public synchronized void run() {
    Properties props = new Properties();
    props.put("mail.from","johannahirvonen86@gmail.com");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    
    props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");

    session = Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(USERNAME, PASSWORD);
        }
    });
    
    
    
    try {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("johannahirvonen86@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("johannahirvonen86@gmail.com"));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText("Someone has pushed a button!");
        Transport.send(msg);
     } catch (MessagingException mex) {
        mex.printStackTrace();
     }
    }

public void setMessage(String s){
	subject = s;
}
}