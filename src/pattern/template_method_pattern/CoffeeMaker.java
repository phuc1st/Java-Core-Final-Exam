package pattern.template_method_pattern;

public class CoffeeMaker extends DrinkMaker {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter...");
    }

    @Override
    protected void addItem() {
        System.out.println("Adding sugar...");
    }
}
