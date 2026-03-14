package pattern.observer_pattern;

public class WindowDisplay implements DisplayObserver {
    @Override
    public void update(WeatherData data) {
        System.out.println("WindowDisplay - Temp: " + data.getTemp() +
                ", Humidity: " + data.getHumidity() +
                ", Pressure: " + data.getPressure());
    }
}
