
public class WindowSensor extends Sensor{

    public WindowSensor(){
        super(sensorType.WINDOW);
    }
    public WindowSensor(sensorType w){
        super(w);
        alarmStatus = false;
    }
    
    //can be used for 2 things
    // 1) user's can use it when they want to close the door or open it
    // 2) system can feed data to sensor to stimulate sensor physically working 
    public void check(boolean isOpen){
        alarmStatus = isOpen;
        if(alarmStatus){
            alarmStatus = true;
            Alert();
        }  
    }
}
