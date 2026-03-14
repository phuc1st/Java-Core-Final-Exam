package pattern.observer_pattern;

public class WeatherData {
    private int temp;
    private int humidity;
    private int pressure;

    public WeatherData(int temp, int humidity, int pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public int getTemp() { return temp; }
    public int getHumidity() { return humidity; }
    public int getPressure() { return pressure; }
}
