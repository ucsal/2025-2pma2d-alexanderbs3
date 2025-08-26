package br.com.mariojp.solid.dip;

public class MailSenderFactory {
    public static MailSender create() {
        boolean isDryRun = "true".equalsIgnoreCase(System.getProperty("DRY_RUN"));

        if (isDryRun) {
            return new NoOpMailSender();
        } else {
            return new SmtpMailSender();
        }
    }
}
