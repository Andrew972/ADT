package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Home_Alarm {
    private Status mode;
    private CODectector COD;
    private MotionSensor motion;
    private SmokeAlarm smokeAlarm;
    private WindowDoorSensor windowSensor, doorSensor;
    Scanner input = new Scanner(System.in);
    private ArrayList<CODectector> list_of_carbon_sensors = new ArrayList<CODectector>();
    private ArrayList<MotionSensor> list_of_motion_sensors = new ArrayList<MotionSensor>();
    private ArrayList<WindowDoorSensor> list_of_doorOrwindow_sensors = new ArrayList<>();
    private ArrayList<SmokeAlarm> list_of_smoke_sensors = new ArrayList<SmokeAlarm>();
    public Home_Alarm(){
        /** By default, status is set to SAFE. I think that we should set
         * it a default/pre-setup state, but this is a design choice by the previous
         * group. We need to setup the alarm system initially. We've created 3 packages
         * or options for setup */
        System.out.println("Welcome to your Home Alarm System.");


    }

    void homeSetup(){
        System.out.println("Let's setup your Home System?");

        System.out.println("What tier of System will you setup?");
        System.out.println("choose: 1 for Studio setup, 2 for Apartment setup, 3 for House setup");
        int setup_selection = input.nextInt();
        switch(setup_selection){
            case 1:
                studio_package_setup();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("This will be a custom setup");

        }


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
     *  if getAlarmStatus returns true, then the sensor IS triggered triggered
     *  if thegetAlarmStatus returns false, then the sensor is NOT triggered and mode should
     *  change from SAFE to WARNING
     */
    void checkCODetector(CODectector sensor){
        sensor.checkStatus();
        sensor.getStatusLocation();
        // to test
        if(sensor.checkStatus() == true){
            setModeWarning();
            System.out.println("Carbon sensor firing in " + sensor.getStatusLocation());
        }
//        System.out.println(sensor.checkStatus().toString());
//        System.out.println(sensor.getStatusLocation());
    }
    void checkWindowDoorSensor(WindowDoorSensor sensor){
        sensor.checkStatus();
        sensor.getStatusLocation();
        if(sensor.checkStatus() == true){
            setModeWarning();
            System.out.println("Window/Door sensor firing in " + sensor.getStatusLocation());
        }
        // to test
//        System.out.println(sensor.checkStatus().toString());
//        System.out.println(sensor.getStatusLocation());
    }
    void checkSmokeAlarm(SmokeAlarm sensor){
        sensor.checkStatus();
        sensor.getStatusLocation();
        if(sensor.checkStatus() == true){
            setModeWarning();
            System.out.println("Smoke sensor firing in " + sensor.getStatusLocation());
        }
        // to test
//        System.out.println(sensor.checkStatus().toString());
//        System.out.println(sensor.getStatusLocation());
    }
    void checkMotionSensor(MotionSensor sensor){
        sensor.checkStatus();
        sensor.getStatusLocation();
        if(sensor.checkStatus() == true){
            setModeWarning();
            System.out.println("Motion Sensor firing in " + sensor.getStatusLocation());
        }
        // to test
//        System.out.println(sensor.checkStatus().toString());
//        System.out.println(sensor.getStatusLocation());
    }

    void getStatusLocation(){

    }

    void sendStatusLocation(){

    }


    void actionNeeded(){
        for(CODectector COD:list_of_carbon_sensors)
            checkCODetector(COD);

        for(SmokeAlarm smokeAlarm: list_of_smoke_sensors)
            checkSmokeAlarm(smokeAlarm);

        for(WindowDoorSensor alarSensor: list_of_doorOrwindow_sensors)
            checkWindowDoorSensor(windowSensor);

        for(MotionSensor motionSensor: list_of_motion_sensors)
            checkMotionSensor(motion);
//        checkCODetector(COD);
//        checkWindowDoorSensor(windowSensor);
//        checkWindowDoorSensor(doorSensor);
//        checkSmokeAlarm(smokeAlarm);
//        checkMotionSensor(motion);
    }

    void studio_package_setup(){
        System.out.println("STUDIO PACKAGE setup:");
        System.out.println("You get one of each sensor");
        System.out.println("---------------------------------------------------------");

        System.out.println("Where would you like to place your carbon Sensor?");
        String carbon_location = input.next();


        System.out.println("Where would you like to place your motion Sensor?");
        String motion_sensor = input.next();


        System.out.println("Where would you like to place your window Sensor?");
        String window_sensor = input.next();

        System.out.println("Where would you like to place your door Sensor?");
        String door_sensor = input.next();

        System.out.println("Where would you like to place your smoke Sensor?");
        String smoke_sensor = input.next();

        COD = new CODectector(carbon_location);
        list_of_carbon_sensors.add(COD);
        motion = new MotionSensor(motion_sensor);
        list_of_motion_sensors.add(motion);
        windowSensor = new WindowDoorSensor(window_sensor);
        list_of_doorOrwindow_sensors.add(windowSensor);
        doorSensor = new WindowDoorSensor(door_sensor);
        list_of_doorOrwindow_sensors.add(doorSensor);
        smokeAlarm = new SmokeAlarm(smoke_sensor);
        list_of_smoke_sensors.add(smokeAlarm);

    }

    void apartment_package(){
        System.out.println("Apartment Package setup:");
        System.out.println("You get 2 carbon sensors");
        System.out.println("You get 1 smoke sensor");
        System.out.println("You get 2 window sensors");
        System.out.println("You get 2 door sensors");
        System.out.println("You get 1 motion sensor");
        System.out.println("---------------------------------------------------------");

    }
    /**
     * Testing instantiation of Home_Alarm
     * Entered dummy values for creating CODetector in constructor.
     * -- For future you will need to enter these manually upon setup
     *  
     * */
    public static void main(String[] args) {

        Home_Alarm test = new Home_Alarm();

        test.homeSetup();

        while(true){
            test.actionNeeded();
        }





    }


}
