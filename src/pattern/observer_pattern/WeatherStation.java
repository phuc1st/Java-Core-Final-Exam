package pattern.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<DisplayObserver> observers = new ArrayList<>();
    private WeatherData data;

    public void addObserver(DisplayObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DisplayObserver observer) {
        observers.remove(observer);
    }

    public void setData(int temp, int humidity, int pressure) {
        this.data = new WeatherData(temp, humidity, pressure);
        notifyObservers();
    }

    private void notifyObservers() {
        for (DisplayObserver observer : observers) {
            observer.update(data);
        }
    }
}
