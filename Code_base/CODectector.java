package com.company;

public class CODectector implements SensorInter {

    Boolean alarmStatus;
    String  locationInHouse;

    public CODectector(){
        locationInHouse = "unknown";
        alarmStatus = false;
    }
    public CODectector(String location){
        this.locationInHouse = location;
        this.alarmStatus = false;
    }
    public CODectector(String location, Boolean alarm){
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
