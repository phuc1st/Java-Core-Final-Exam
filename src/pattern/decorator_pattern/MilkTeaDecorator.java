package pattern.decorator_pattern;

public abstract class MilkTeaDecorator implements MilkTea{
    private MilkTea wrapped;

    public MilkTeaDecorator(MilkTea wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public int bill() {
        return wrapped.bill();
    }
    @Override
    public String description() {
        return wrapped.description();
    }
}
