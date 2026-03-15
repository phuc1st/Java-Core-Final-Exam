package pattern.template_method_pattern;

public class Main {
    public static void main(String[] args) {
        DrinkMaker tea = new TeaMaker();
        tea.makeDrink();
        System.out.println();
        DrinkMaker coffee = new CoffeeMaker();
        coffee.makeDrink();
    }
}
