package WebClientObserver;

public class FactoryInfoDisplay implements Observer, DisplayElement{
    private float temperature;
    private float photo_resistor;
    private int count;
    private SmartFactoryData data;


    public FactoryInfoDisplay(SmartFactoryData data){
        this.data = data;
        data.registerObserver(this);
    }

    public void update(float temperature, float photo_resistor, int count){
        this.temperature = temperature;
        this.photo_resistor = photo_resistor;
        this.count = count;
        display();
    }

    public void display(){
        System.out.println("\nFactoryInfo-> " + "온도: " + temperature + "   조도 센서값: "  + photo_resistor + "   물체인식횟수: " + count);
    }
}