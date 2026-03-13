package pattern.decorator_pattern;

import java.util.Arrays;

public class DecoratorDemo {
    public static void main(String[] args) {
//// 1. Chỉ gửi tin thuần
//        Notifier stack = new PlainTextNotifier();
//
//        // 2. Muốn gửi tin có log? Bọc nó lại!
//        stack = new LoggingDecorator(stack);
//
//        // 3. Muốn vừa log vừa mã hóa? Tiếp tục bọc!
//        stack = new EncryptionDecorator(stack);
//
//        // Chạy thử
//        stack.send("Hello World");
//        System.out.println( stack instanceof LoggingDecorator);

        MilkTea milkTea = new SugarDecorator(
                new PearlDecorator(
                        new MilkTeaNormal(), 5), 2);

        System.out.println("Thành phần: " + milkTea.description());
        System.out.println("Giá: " + milkTea.bill() + " VND");
    }
}
