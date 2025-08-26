import br.com.mariojp.solid.dip.*;

public class Main {
	public static void main(String[] args) {
        System.setProperty("DRY_RUN", "true"); // modo de teste

        // Cria o notifier usando a factory
        var mailSender = MailSenderFactory.create();
        var notifier = new EmailNotifier(mailSender);

        // Agora funciona sem lançar exceção
        notifier.welcome(new User("Ana", "ana@example.com"));
        System.out.println("Processo concluído!");
    }
}