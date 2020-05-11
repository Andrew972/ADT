public class Sensor {
    protected Boolean alarmStatus;
    protected sensorType type;
    protected int serialID;
    private static int x = 90008;
    
    public Sensor(sensorType kindOfSensor){
        type = kindOfSensor;
        alarmStatus = false;
        serialID = serialNumberGenerator();
    }
    public boolean Alert(){
        return alarmStatus;
    }
    private static int serialNumberGenerator(){
        return x++;
    }

    public int getSerialID(){
        return this.serialID;
    }

    public sensorType getType(){
        return type;
    }
    public String toString(){
        return "ID = " + getSerialID() + " type = " + getType();
    } 
}