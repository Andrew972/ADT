package com.company;

public class Home_Alarm {
    private Status mode;
    public CODectector test = new CODectector("kitchen", true);
    public Home_Alarm(){
        /** By default, status is set to SAFE. I think that we should set
         * it a default/pre-setup state, but this is a design choice by the previous
         * group. MUST REVISIT LATER (C.ING*/
        this.mode = Status.SAFE;

    }

    /**
     * These set method will set the status:mode to
     * Safe, Guard, Warning, or Emergency
     * Created an enumerator to hold these mode settings
     * */

    public void setModeSafe(){
        mode = Status.SAFE; }
    public void setModeGuard(){
        mode = Status.GUARD; }
    public void setModeWarning(){
        mode = Status.WARNING; }
    public void setModeEmergency(){
        mode = Status.EMERGENCY; }

    /** These check methods will display the Location of the sensor,
     *  and return the boolean value of the alarm status
     */
    void checkCODetector(CODectector sensor){
        sensor.getAlarmStatus();
        sensor.getStatusLocation();
        // to test
        System.out.println(sensor.getAlarmStatus().toString());
        System.out.println(sensor.getStatusLocation().toString());
    }
    void checkWindowDoorSensor(WindowDoorSensor sensor){
        sensor.getAlarmStatus();
        sensor.getStatusLocation();
    }
    void checkSmokeAlarm(SmokeAlarm sensor){
        sensor.getAlarmStatus();
        sensor.getStatusLocation();
    }
    void checkMotionSensor(MotionSensor sensor){
        sensor.getAlarmStatus();
        sensor.getStatusLocation();
    }

    void getStatusLocation(){}

    void sendStatusLocation(){}


    void actionNeeded(){
        checkCODetector(test);
        /**
         * testing checkCODetector with dummy test value kitchen
         * */
//        checkWindowDoorSensor();
//        checkSmokeAlarm();
//        checkMotionSensor();
    }

    /**
     * Testing instantiation of Home_Alarm
     * Entered dummy values for creating CODetector in constructor.
     * -- For future you will need to enter these manually upon setup
     *  
     * */
    public static void main(String[] args) {

        Home_Alarm test1 = new Home_Alarm();
        test1.setModeSafe();
        test1.actionNeeded();


    }


}
