import java.util.ArrayList;

public class HomeAlarm {
    private COSensor COSensor;
    private ArrayList<WindowSensor> WindowSensors;
    private WindowSensor frontDoor;
    private ArrayList<COSensor> SmokeSensors;

    private String packageType;
    private SysMode systemMode;

    public HomeAlarm(Message info){
        WindowSensors = new ArrayList<>();
        SmokeSensors = new ArrayList<>();
        packageType = info.get("package");
        systemMode = SysMode.SAFE;

        //Every pacakge has exactly 1 CO and Door sensor. Smoke and Window sensors vary based on number of rooms
        COSensor = new COSensor();
        frontDoor = new WindowSensor(sensorType.DOOR);

        packageSetUp(info);
    }

    private void packageSetUp(Message info){
        if( info.get("package").equals("studio") ){
            SmokeSensors.add(new COSensor(sensorType.SMOKE));
            WindowSensors.add(new WindowSensor());
        }
        else{
            for(int i = 0; i < Integer.parseInt(info.get("rooms")); i++){
                SmokeSensors.add(new COSensor(sensorType.SMOKE));
                WindowSensors.add(new WindowSensor());
            }
        }        
    }

    public boolean setARM(){
        return readSensorData() == SysMode.SAFE;
    }

    public boolean setDISARM(){
        return systemMode == SysMode.DISARM;
    }

    public Message interpertSensorData(){
        Message info = new Message();
        if(readSensorData() == SysMode.EMERGENCY){
            for(var sensor: SmokeSensors){
                if(sensor.Alert()) info.addContent("Smoke", "Dangerous levels"); 
            }

            //Adding a note to in case the loop ran and is statement did not run
            if(info.get("Smoke").equals("NA")) info.addContent("Smoke", "Normal levels");

            if(COSensor.Alert()) info.addContent("CO", "Dangerous levels");
            else info.addContent("CO", "Normal levels");

            return info;
        }

        for(var sensor: WindowSensors){
            if(sensor.Alert()) info.addContent("Window", "Open"); 
        }
        if(info.get("Window").equals("NA")) info.addContent("Window", "Close");

        if(frontDoor.Alert()) info.addContent("Door", "Open");
        else info.addContent("Door", "Close");

        return info;
    }

    private SysMode readSensorData(){
        //check for emergency
        for(var sensor: SmokeSensors){
            if(sensor.Alert()) return SysMode.EMERGENCY;
        }
        if(COSensor.Alert()){
            return SysMode.EMERGENCY;
        }

        //check for warning
        for(var sensor: WindowSensors){
            if(sensor.Alert()) return SysMode.WARNING;
        }
        if(frontDoor.Alert()){
            return SysMode.WARNING;
        }
        return SysMode.SAFE;
    }

    public SysMode getMode(){
        return systemMode;
    }

    public void lockDoor(){
        frontDoor.check(false);
    } 

    public String getPackageType(){
        return this.packageType;
    }

    public Message stimulateUnsuccessfulArm(){
        //feed good data to all sensors so no Alarms are created
        for(int i = 0; i < WindowSensors.size(); i++){
            SmokeSensors.get(i).measureCOLevel(67);
            WindowSensors.get(i).check(true);;
        }
        COSensor.measureCOLevel(50);
        frontDoor.check(true);

        //If system is in 
        systemMode = SysMode.WARNING; 
        return interpertSensorData();
    }
   
    public Message stimulateSuccessfulArm(){
        //feed good data to all sensors so no Alarms are created
        for(int i = 0; i < WindowSensors.size(); i++){
            SmokeSensors.get(i).measureCOLevel(50);
            WindowSensors.get(i).check(false);;
        }
        COSensor.measureCOLevel(50);
        frontDoor.check(false);

        //Try to switch the mode of system
        if(setARM()){
            systemMode = SysMode.ARM;
        }
        return interpertSensorData();
    }

    public Message stimulateFire(){
        //feed good data to all sensors so no Alarms are created
        for(int i = 0; i < WindowSensors.size(); i++){
            SmokeSensors.get(i).measureCOLevel(230);
            WindowSensors.get(i).check(false);;
        }
        COSensor.measureCOLevel(50);
        frontDoor.check(false);

        //Try to switch the mode of system
        systemMode = SysMode.EMERGENCY;
        return interpertSensorData();
    }

    public Message stimulateCO(){
        //feed good data to all sensors so no Alarms are created
        for(int i = 0; i < WindowSensors.size(); i++){
            SmokeSensors.get(i).measureCOLevel(60);
            WindowSensors.get(i).check(false);;
        }
        COSensor.measureCOLevel(150);
        frontDoor.check(false);

        //Try to switch the mode of system
        systemMode = SysMode.EMERGENCY;
        return interpertSensorData();
    }

    public Message stimulateRubbery(){
        //feed good data to all sensors so no Alarms are created
        for(int i = 0; i < WindowSensors.size(); i++){
            SmokeSensors.get(i).measureCOLevel(60);
            WindowSensors.get(i).check(true);;
        }
        COSensor.measureCOLevel(90);
        frontDoor.check(false);

        //Try to switch the mode of system
        systemMode = SysMode.EMERGENCY;
        return interpertSensorData();
    } 
}