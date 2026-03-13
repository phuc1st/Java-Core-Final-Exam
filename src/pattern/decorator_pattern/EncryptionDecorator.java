package pattern.decorator_pattern;

public class EncryptionDecorator extends NotifierDecorator{
    public EncryptionDecorator(Notifier notifier) { super(notifier); }

    @Override
    public void send(String message) {
        System.out.println("Bắt đầu encrypted");
        String encrypted = "ENCRYPTED(" + message + ")";
        super.send(encrypted);
    }
}
