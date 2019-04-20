import java.util.List;
import java.util.ArrayList;

public class WeatherData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temp;
    private float humidity;
    private float pressure;

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for(Observer o: this.observers) {
            o.update(this.temp, this.humidity, this.pressure);
        }
    }

    public void measurementChanged() {
        notifyObservers();
    }

    public void setMeasurement(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}