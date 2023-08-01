package WebClientObserver;

public class ObjectCountDisplay implements Observer, DisplayElement {
    private SmartFactoryData data;
    private int count;
    public ObjectCountDisplay(SmartFactoryData data) {
        this.data = data;
        data.registerObserver(this);
    }

    public void update(float temperature, float photo_resistor, int count){
        this.count = count;
        display();
    }

    public void display() {
        System.out.println("object count: " + count);
    }


}
