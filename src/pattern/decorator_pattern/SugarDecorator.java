package pattern.decorator_pattern;

public class SugarDecorator extends MilkTeaDecorator{
    private int price;
    public SugarDecorator(MilkTea wrapped, int price) {
        super(wrapped);
        this.price = price;
    }

    @Override
    public int bill(){
        return super.bill() + price;
    }
    @Override
    public String description() {
        return super.description() + " + Sugar";
    }
}
