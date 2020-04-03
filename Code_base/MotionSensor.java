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

    public String getStatusLocation(){
        return locationInHouse;
    }
    public Boolean getAlarmStatus() { return alarmStatus;}
}
