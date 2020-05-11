public class COSensor extends Sensor{
    private int threshold;

    public COSensor(){
        super(sensorType.CO);
        threshold = 100;
    }

    public COSensor(sensorType type){
        super(type);
        threshold = 100;
    }

    public void measureCOLevel(int reading){
        if (reading >= threshold){
            Alert();
        }
    }

    public boolean Alert(){
        alarmStatus = true;
        return alarmStatus;
    }
}