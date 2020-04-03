package com.company;

public class WindowDoorSensor implements SensorInter {
    Boolean alarmStatus;
    String locationInHouse;


    public WindowDoorSensor(){
        locationInHouse = "unknown";
        alarmStatus = false;
    }

    public WindowDoorSensor(String location){
        this.locationInHouse = location;
        this.alarmStatus = false;
    }

    public WindowDoorSensor(String location, Boolean alarm){
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
