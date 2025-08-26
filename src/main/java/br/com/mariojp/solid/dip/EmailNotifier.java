package br.com.mariojp.solid.dip;

public class EmailNotifier {
    private final MailSender mailSender;

    // Construtor recebe a abstração (Inversão de Dependência)
    public EmailNotifier(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void welcome(User user) {
        mailSender.send(user.email(), "Bem-vindo", "Olá " + user.name());
    }
}
