package com.company;

public interface SensorInter {

    void  setLocation(String location);
    void  setAlarmStatus(Boolean flag);
    String getStatusLocation();
    Boolean checkStatus();

}
