package WebClientObserver;

public class SmartFactory {
    public static void main(String[] args) {
        SmartFactoryData data = new SmartFactoryData();

        FactoryInfoDisplay infoDisplay = new FactoryInfoDisplay(data);
        TemperatureCheckDisplay temperatureCheckDisplay = new TemperatureCheckDisplay(data);
        LightCheckDisplay lightCheckDisplay = new LightCheckDisplay(data);
        ObjectCountDisplay countDisplay = new ObjectCountDisplay(data);

        data.setMeasurements(34, 1200, 30);
        data.setMeasurements(22, 600, 22);

    }
}
