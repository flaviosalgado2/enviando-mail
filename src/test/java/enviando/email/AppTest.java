package enviando.email;

import org.junit.jupiter.api.Test;

public class AppTest {

	@Test
	public void testEmail() throws Exception {
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		stringBuilderTextoEmail.append("<h1>Olá!</h1>");
		stringBuilderTextoEmail.append("<p>Vc está recebendo uma e-mail de teste de envio de e-mail com a Linguagem JAVA</p>");
		stringBuilderTextoEmail.append("<p>Clique no link abaixo para acessar o site da SEDUC</p>");
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"http://www.seduc.pa.gov.br/\">Portal SEDUC</a>");
		
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("flaviosalgado2@gmail.com", "Flavio Programador",
				"Envio de e-mail com JAVA", stringBuilderTextoEmail.toString());

		//true - html
		//false - texto comum
		enviaEmail.enviarEmail(true);
	}
}
