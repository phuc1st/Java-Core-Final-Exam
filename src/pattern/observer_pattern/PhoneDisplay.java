package pattern.observer_pattern;

public class PhoneDisplay implements DisplayObserver {
    @Override
    public void update(WeatherData data) {
        System.out.println("PhoneDisplay - Temp: " + data.getTemp());
    }
}
