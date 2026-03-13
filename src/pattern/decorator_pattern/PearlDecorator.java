package pattern.decorator_pattern;

public class PearlDecorator extends MilkTeaDecorator{
    private int price;
    public PearlDecorator(MilkTea wrapped, int price) {
        super(wrapped);
        this.price = price;
    }

    @Override
    public int bill(){
        return super.bill() + price;
    }
    @Override
    public String description() {
        return super.description() + " + Pearl";
    }

}
