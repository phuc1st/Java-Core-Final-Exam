package pattern.decorator_pattern;

public class MilkTeaNormal implements MilkTea{
    @Override
    public int bill(){
        return 20;
    }
    @Override
    public String description() {
        return "MilkTea";
    }
}
