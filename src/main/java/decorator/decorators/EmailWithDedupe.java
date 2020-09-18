package decorator.decorators;

import decorator.IEmailService;

import java.util.HashSet;
import java.util.Set;

/**
 * Don't send duplicate mails.
 */
public class EmailWithDedupe extends EmailDecorator {
    Set<String> cache = new HashSet<>();
    public EmailWithDedupe(IEmailService emailService) {
        super(emailService);
    }

    @Override
    public void setEmail(String content) {
        if (!cache.contains(content)) {
            super.setEmail(content);
            cache.add(content);
        }
    }
}
