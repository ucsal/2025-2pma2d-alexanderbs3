package br.com.mariojp.solid.dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailNotifierTest {
    @Test
    void dry_run_should_not_touch_smtp() {
        // Given - configurar o ambiente para DRY_RUN
        System.setProperty("DRY_RUN", "true");
        System.clearProperty("SMTP_AVAILABLE"); // SMTP indisponível

        // When - criar o notifier usando a factory (seguindo DIP)
        var mailSender = MailSenderFactory.create(); // Criará NoOpMailSender
        var notifier = new EmailNotifier(mailSender);

        // Then - deve funcionar sem lançar exceção
        assertDoesNotThrow(() -> notifier.welcome(new User("Ana", "ana@example.com")),
                "Após refatoração (DIP), DRY_RUN deve evitar SMTP real");

        // Cleanup
        System.clearProperty("DRY_RUN");
    }
}