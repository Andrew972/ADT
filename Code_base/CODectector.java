package com.company;

public class CODectector implements SensorInter {

    private Boolean alarmStatus;
    private String  locationInHouse;

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
        return this.locationInHouse;
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
            int temp = (int) ((Math.random() * 100));
            return temp;

    }


}
