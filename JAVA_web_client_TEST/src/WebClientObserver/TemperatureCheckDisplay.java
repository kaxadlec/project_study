package WebClientObserver;

public class TemperatureCheckDisplay implements Observer, DisplayElement {
    private float refTemperature;
    private SmartFactoryData data;
    private float lastTemperature;

    private float currentTemperature = 18;

    public TemperatureCheckDisplay(SmartFactoryData data) {
        this.data = data;
        data.registerObserver(this);
    }

    @Override
    public void update(float temperature, float photo_resistor, int count) {
        lastTemperature = currentTemperature;
        currentTemperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Current temperature: " + currentTemperature + "  Reference temperature: 20~25 ");
        if(currentTemperature>=20 && currentTemperature <=25){
            System.out.println("The current temperature is appropriate.");
        }
        else{
            System.out.println("Temperature adjustment is required.");
        }

    }


}
