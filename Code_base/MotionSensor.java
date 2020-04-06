package com.company;

public class MotionSensor implements SensorInter{
    Boolean alarmStatus;
    String locationInHouse;


    public MotionSensor(){
        locationInHouse = "unknown";
        alarmStatus = false;
    }
    public MotionSensor(String location){
        this.locationInHouse = location;
        this.alarmStatus = false;
    }
    public MotionSensor(String location, Boolean alarm){
        this.locationInHouse = location;
        this.alarmStatus = alarm;
    }

    public void setLocation(String location){
        this.locationInHouse = location;
    }

    @Override
    public void setAlarmStatus(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }
    public Boolean checkStatus() {
        int testNumber = generateRandNum();
        if (testNumber == 5) {
            alarmStatus = true;
        }

        if(alarmStatus == true) {
            alarmStatus = false; //reset alarm, we've already recorded it was triggered
            return true;
        }
        else {
            return false;
        }
    }

    private int generateRandNum() {
        int temp = (int) ((Math.random() * 25));
        return temp;

    }
    public String getStatusLocation(){
        return locationInHouse;
    }
//    public Boolean getAlarmStatus() { return alarmStatus;}
}
