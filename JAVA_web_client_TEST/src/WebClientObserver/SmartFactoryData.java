package WebClientObserver;

import java.util.ArrayList;
import java.util.List;

public class SmartFactoryData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float photo_resistor;
    private int count;

    public SmartFactoryData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(temperature, photo_resistor, count);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float photo_resistor, int count){
        this.temperature = temperature;
        this.photo_resistor = photo_resistor;
        this.count = count;
        measurementsChanged();
    }
}
