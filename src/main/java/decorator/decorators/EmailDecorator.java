package decorator.decorators;

import decorator.IEmailService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailDecorator implements IEmailService {
    private final IEmailService emailService;

    @Override
    public void setEmail(String content) {
        emailService.setEmail(content);
    }
}
