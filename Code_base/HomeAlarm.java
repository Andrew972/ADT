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
   
   public void stimulateSuccessfulArm(){
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
   }

   public boolean setARM(){
       if (readSensorData() == SysMode.SAFE){

       }
       else if(readSensorData() == SysMode.WARNING){

       }
       else{

       }
       return false;
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
}