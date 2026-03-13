package pattern.decorator_pattern;

public class PlainTextNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Gửi tin nhắn: " + message);
    }
}
