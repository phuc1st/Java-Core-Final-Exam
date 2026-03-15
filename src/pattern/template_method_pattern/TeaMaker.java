package pattern.template_method_pattern;

public class TeaMaker extends DrinkMaker {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea...");
    }

    @Override
    protected void addItem() {
        System.out.println("Adding lemon...");
    }
}
