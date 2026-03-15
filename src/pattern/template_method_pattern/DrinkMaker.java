package pattern.template_method_pattern;

public abstract class DrinkMaker {
    // Template Method
    public final void makeDrink() {
        boilWater();
        pourInCup();
        brew();
        addItem();
    }

    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    protected abstract void brew();
    protected abstract void addItem();
}
