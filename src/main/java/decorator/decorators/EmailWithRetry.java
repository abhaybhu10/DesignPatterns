package decorator.decorators;

import decorator.IEmailService;

public class EmailWithRetry extends EmailDecorator {
    private final EmailRetryConfig retryConfig;

    public EmailWithRetry(IEmailService emailService, EmailRetryConfig config) {
        super(emailService);
        retryConfig = config;
    }

    @Override
    public void setEmail(String content) {
        for(int i=0;i<retryConfig.getRetryCount();i++) {
            try {
                super.setEmail(content);
                break;
            } catch (Exception e) {
                //Anti pattern. Don't swallow exception in production otherwise oncall will take print out of your code
                //beat you to death.
                System.out.println(1000);
            }
        }
    }
}
