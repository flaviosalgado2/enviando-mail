package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {

	private String userName = "flavio.salgado@seduc.pa.gov.br";
	private String senha = "tec$161090";

	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";

	// contrutor da classe
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}

	public void enviarEmail(boolean envioHtml) {

		try {

			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			Session session = Session.getInstance(properties, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}

			});

			// emails destinos
			Address[] toUser = InternetAddress.parse(listaDestinatarios);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, nomeRemetente));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assuntoEmail);

			if (envioHtml) {
				message.setContent(textoEmail, "text/html; charset=utf-8");
			} else {
				message.setText(textoEmail);
			}

			Transport.send(message);

			System.out.println(senha);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
