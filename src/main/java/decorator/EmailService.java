package decorator;

public class EmailService implements IEmailService {
    @Override
    public void setEmail(String content) {
        System.out.println("Email sent " + content);
    }
}
