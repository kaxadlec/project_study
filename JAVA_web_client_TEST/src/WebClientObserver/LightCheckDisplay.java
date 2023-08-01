package WebClientObserver;

public class LightCheckDisplay implements Observer, DisplayElement {
    private float refLight;
    private SmartFactoryData data;
    private float lastLight;

    private float currentLight = 1500;

    public LightCheckDisplay(SmartFactoryData data) {
        this.data = data;
        data.registerObserver(this);
    }

    @Override
    public void update(float temperature, float photo_resistor, int count) {
        lastLight= currentLight;
        currentLight = photo_resistor;
        display();
    }

    public void display() {
        System.out.println("Current photo resistor value: " + currentLight + "  Reference photo resistor value: 1000~1500");
        if(currentLight>=1000 && currentLight <= 1500){
            System.out.println("The current light is appropriate.");
        }
        else{
            System.out.println("Light adjustment is required.");
        }

    }
}
