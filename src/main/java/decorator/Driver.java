package decorator;

import decorator.decorators.EmailDecorator;
import decorator.decorators.EmailRetryConfig;
import decorator.decorators.EmailWithDedupe;
import decorator.decorators.EmailWithRetry;

/**
 * Idea from @link{https://dzone.com/articles/is-inheritance-dead}
 * @see <a href="https://dzone.com/articles/is-inheritance-dead">Idea take from here</a>
 */
public class Driver {
    public static void main(String args[]) {
        new Driver().run();
    }

    public void run() {
        IEmailService emailService = getRetryableAndCacheAbleService();
        emailService.setEmail("Abhay Kumar Decorator Email");
        emailService.setEmail("Abhay Kumar Decorator Email");
    }

    IEmailService getRetryableAndCacheAbleService() {
        EmailRetryConfig retryConfig = EmailRetryConfig.builder().retryCount(3).build();
        IEmailService emailService = new EmailService();
        IEmailService retryableAndCachableService =
                new EmailWithDedupe(new EmailWithRetry(new EmailDecorator(emailService), retryConfig));
        return retryableAndCachableService;
    }
}
