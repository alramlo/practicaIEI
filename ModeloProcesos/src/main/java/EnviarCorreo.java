import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.activiti.engine.delegate.DelegateExecution;

public class EnviarCorreo implements org.activiti.engine.delegate.JavaDelegate{

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		enviar(arg0);
		
	}
	
	
	public void enviar(DelegateExecution arg0){
		
	
	final String username = "soyprogramadordejava@gmail.com"; // desde donde se
			// envía
	final String password = "iei2014iei"; // el password de Gmail.
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	Session session = Session.getInstance(props,
	new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(username, password);
	}
	});
	try {
	
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress("soyprogramadordejava@gmail.com"));
	message.setRecipients(Message.RecipientType.BCC,
	
	InternetAddress.parse(arg0.getVariable("email").toString())); // a quién
					// se envía.
	message.setSubject("Pedido enviado");
	message.setText(arg0.getVariable("motivo").toString());
	Transport.send(message);
	} catch (MessagingException e) {
	throw new RuntimeException(e);
	}
		}
}
