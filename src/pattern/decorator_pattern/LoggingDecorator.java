package pattern.decorator_pattern;

public class LoggingDecorator extends NotifierDecorator{

    public LoggingDecorator(Notifier wrapped) {
        super(wrapped);
    }
    @Override
    public void send(String message){
        System.out.println("Bắt đầu ghi log");
        super.send(message);
    }
}
