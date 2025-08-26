package br.com.mariojp.solid.dip;

public class NoOpMailSender implements MailSender {
    @Override
    public void send(String to, String subject, String body) {
        System.out.println("[DRY_RUN] Email simulado:");
        System.out.println("  Para: " + to);
        System.out.println("  Assunto: " + subject);
        System.out.println("  Corpo: " + body);
    }
}
