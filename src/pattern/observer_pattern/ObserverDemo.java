package pattern.observer_pattern;

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        DisplayObserver phoneDisplay = new PhoneDisplay();
        DisplayObserver windowDisplay = new WindowDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(windowDisplay);

        weatherStation.setData(25, 60, 1012);
    }
}
