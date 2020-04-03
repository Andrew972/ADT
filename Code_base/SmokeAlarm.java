package com.company;

public class SmokeAlarm implements SensorInter{
    Boolean alarmStatus;
    String locationInHouse;


    public SmokeAlarm(){
        locationInHouse = "unknown";
        alarmStatus = false;
    }
    public SmokeAlarm(String location){
        this.locationInHouse = location;
        this.alarmStatus = false;
    }

    public SmokeAlarm(String location, Boolean alarm){
        this.locationInHouse = location;
        this.alarmStatus = alarm;
    }

    public void setLocation(String location){
        this.locationInHouse = location;
    }

    @Override
    public void setAlarmStatus(Boolean flag){
        this.alarmStatus = flag;
    }

    public String getStatusLocation(){
        return locationInHouse;
    }

    public Boolean getAlarmStatus() { return alarmStatus;}


}
