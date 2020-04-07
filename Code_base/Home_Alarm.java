package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Home_Alarm {
    Status mode;
    private CODectector COD;
    private MotionSensor motion;
    private SmokeAlarm smokeAlarm;
    private WindowDoorSensor windowSensor, doorSensor;
    private ArrayList<CODectector> list_of_carbon_sensors = new ArrayList<CODectector>();
    private ArrayList<MotionSensor> list_of_motion_sensors = new ArrayList<MotionSensor>();
    private ArrayList<WindowDoorSensor> list_of_doorOrwindow_sensors = new ArrayList<>();
    private ArrayList<SmokeAlarm> list_of_smoke_sensors = new ArrayList<SmokeAlarm>();
    private ArrayList<String> list_of_actions = new ArrayList<String>();
    Scanner input = new Scanner(System.in);



    public Home_Alarm(){
        /** By default, status is set to SAFE. I think that we should set
         * it a default/pre-setup state, but this is a design choice by the previous
         * group. We need to setup the alarm system initially. We've created 3 packages
         * or options for setup */
        System.out.println("Welcome to your Home Alarm System.");
        setModeSafe();
        System.out.println("Would you like to setup the system? y/n:");
        String answer = input.next();
        if(answer.toLowerCase().charAt(0)=='y')
            homeSetup();
        if(answer.toLowerCase().charAt(0) == 'n')
            actionMonitor();

    }

    public Home_Alarm(String a, String b, String c, String d, String e){
        COD = new CODectector(a);
        list_of_carbon_sensors.add(COD);
        motion = new MotionSensor(b);
        list_of_motion_sensors.add(motion);
        windowSensor = new WindowDoorSensor(c);
        list_of_doorOrwindow_sensors.add(windowSensor);
        doorSensor = new WindowDoorSensor(d);
        list_of_doorOrwindow_sensors.add(doorSensor);
        smokeAlarm = new SmokeAlarm(e);
        list_of_smoke_sensors.add(smokeAlarm);
        setModeSafe();
        turnOnSystem();
        sendStatusLocation();
        turnOffSystem();
    }





    void turnOnSystem(){
        if(mode == Status.SAFE){
            setModeGuard();
            actionMonitor();
        } else if (mode == Status.WARNING){
            warning_report();
            //if problem is fixed then setModeGuard()
        } else if(mode == Status.GUARD){
            System.out.println("System is already engaged");
        }



    }

    void turnOffSystem(){
        if(mode == Status.GUARD){
            setModeSafe();
            actionMonitor();
            sendStatusLocation();
        }

    }




    private void homeSetup(){
        System.out.println("Let's setup your Home System?");

        System.out.println("What tier of System will you setup?");
        System.out.println("choose: 1 for Studio setup, 2 for Apartment setup, 3 for House setup");
        int setup_selection = input.nextInt();
        switch(setup_selection){
            case 1:
                studio_package_setup();
                break;
            case 2:
                apartment_package_setup();
                break;
            case 3:
                house_package_setup();
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


    private void checkCODetector(CODectector sensor){
        sensor.checkStatus();
        if(sensor.checkStatus() == true && mode == Status.SAFE) {
            setModeWarning();
            list_of_actions.add(mode +":CO2DETECTOR:" +sensor.getStatusLocation());
        }else if (sensor.checkStatus() == true && mode == Status.WARNING){
            setModeEmergency();
            list_of_actions.add(mode +":CO2DETECTOR:" +sensor.getStatusLocation());
        }else{
            setModeSafe();
            list_of_actions.add(mode +":CO2DETECTOR:" +sensor.getStatusLocation());

        }
    }

    private void checkSmokeAlarm(SmokeAlarm sensor){
        sensor.checkStatus();
        if(sensor.checkStatus() == true && mode == Status.SAFE){
            setModeWarning();
            list_of_actions.add(mode +":SMOKEALARM:" +sensor.getStatusLocation());
        }else if(sensor.checkStatus() == true && mode == Status.WARNING){
            setModeEmergency();
            list_of_actions.add(mode +":SMOKEALARM:" +sensor.getStatusLocation());
        }else{
            setModeSafe();
            list_of_actions.add(mode +":SMOKEALARM:" +sensor.getStatusLocation());

        }
    }
    private void checkWindowDoorSensor(WindowDoorSensor sensor){
        sensor.checkStatus();
        if(sensor.checkStatus() == true && mode == Status.SAFE) {
            setModeWarning();
            list_of_actions.add(mode +":WINDOW/DOOR:" +sensor.getStatusLocation());
        }else if(sensor.checkStatus() == true && mode == Status.WARNING){
            setModeEmergency();
            list_of_actions.add(mode +":WINDOW/DOOR:" +sensor.getStatusLocation());
        }else if(sensor.checkStatus() == true && mode == Status.GUARD){
            setModeEmergency();
            list_of_actions.add(mode +":WINDOW/DOOR:" +sensor.getStatusLocation());
        }

    }

    private void checkMotionSensor(MotionSensor sensor){
        sensor.checkStatus();
        if(sensor.checkStatus() == true && mode == Status.SAFE){
            setModeSafe();
            list_of_actions.add(mode +":MOTION:" +sensor.locationInHouse);
        }else if(sensor.checkStatus() == true && mode == Status.GUARD){
            setModeEmergency();
            list_of_actions.add(mode +":MOTION:" +sensor.locationInHouse);
        }



    }


    public void sendStatusLocation(){
        warning_report();
        emergency_report();
    }
    void warning_report(){
        int count = 1;
        for (String WarningReport : list_of_actions) {
            String[] actions = WarningReport.split(":");
            if(actions[0].equals( "WARNING")) {
                System.out.println(WarningReport + " " +  count );
                count++;
            }
        }
//        System.out.println(list_of_warning_status_location_updates.size());
    }
    void emergency_report(){
        int count = 1;
        for (String EmergencyReport : list_of_actions) {
            String[] actions = EmergencyReport.split(":");
            if(actions[0].equals("EMERGENCY")){
                System.out.println(EmergencyReport + " " + count);
                count++;
            }

        }

    }

    private void actionMonitor(){
        for(int i = 0; i < 125; i++) {
            for (CODectector COD : list_of_carbon_sensors) {
                checkCODetector(COD);
            }
            for (SmokeAlarm smokeAlarm : list_of_smoke_sensors) {
                checkSmokeAlarm(smokeAlarm);
            }
            for (WindowDoorSensor windowSensor : list_of_doorOrwindow_sensors) {
                checkWindowDoorSensor(windowSensor);
            }
            for (MotionSensor motionSensor : list_of_motion_sensors) {
                checkMotionSensor(motionSensor);
            }
        }
    }

    /**
    * These are standard packages to illustrate a range of sensors.
    * and the capturing of the data from the sensors and then giving feedback.
    * */
    private void studio_package_setup(){
        System.out.println("STUDIO PACKAGE setup:");
        System.out.println("You get one of each sensor");
        System.out.println("---------------------------------------------------------");

        System.out.println("Where would you like to place your carbon Sensor?");
        String carbon_location = input.next();
        input.nextLine();


        System.out.println("Where would you like to place your motion Sensor?");
        String motion_sensor = input.next();
        input.nextLine();

        System.out.println("Where would you like to place your window Sensor?");
        String window_sensor = input.next();
        input.nextLine();

        System.out.println("Where would you like to place your door Sensor?");
        String door_sensor = input.next();
        input.nextLine();

        System.out.println("Where would you like to place your smoke Sensor?");
        String smoke_sensor = input.next();
        input.nextLine();

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

    private void apartment_package_setup(){
        System.out.println("Apartment Package setup:");
        System.out.println("You get 2 carbon sensors");
        System.out.println("You get 1 smoke sensor");
        System.out.println("You get 2 window sensors");
        System.out.println("You get 2 door sensors");
        System.out.println("You get 1 motion sensor");
        System.out.println("---------------------------------------------------------");

        for(int i = 1; i < 3; i++){ // 2 carbon sensor
            System.out.println("Enter location for carbon sensor number " + i +":");
            String carbon_location = input.next();
            COD = new CODectector(carbon_location);
            list_of_carbon_sensors.add(COD);
            input.nextLine();
        }

        for(int i = 1; i < 2; i++){ // 1 smoke sensor
            System.out.println("Enter location for smoke sensor number " + i +":");
            String smoke_sensor = input.next();
            smokeAlarm = new SmokeAlarm(smoke_sensor);
            list_of_smoke_sensors.add(smokeAlarm);
            input.nextLine();
        }

        for(int i = 1; i < 3; i++){ // 2 window sensor
            System.out.println("Enter location for window sensor number " + i +":");
            String window_sensor = input.next();
            windowSensor = new WindowDoorSensor(window_sensor);
            list_of_doorOrwindow_sensors.add(windowSensor);
            input.nextLine();
        }

        for(int i = 1; i < 3; i++){ // 2 door sensor
            System.out.println("Enter location for door sensor number " + i +":");
            String door_sensor = input.next();
            doorSensor = new WindowDoorSensor(door_sensor);
            list_of_doorOrwindow_sensors.add(doorSensor);
            input.nextLine();
        }

        for(int i = 1; i < 2; i++){ // 1 motion sensor
            System.out.println("Enter location for motion sensor number " + i +":");
            String motion_sensor = input.next();
            motion = new MotionSensor(motion_sensor);
            list_of_motion_sensors.add(motion);
            input.nextLine();
        }


    }

    private void house_package_setup(){
        System.out.println("House Package setup:");
        System.out.println("You get 4 carbon sensors");
        System.out.println("You get 2 smoke sensor");
        System.out.println("You get 8 window sensors");
        System.out.println("You get 4 door sensors");
        System.out.println("You get 3 motion sensor");
        System.out.println("---------------------------------------------------------");

        for(int i = 1; i < 5; i++){ // 4 carbon sensor
            System.out.println("Enter location for carbon sensor number " + i +":");
            String carbon_location = input.next();
            COD = new CODectector(carbon_location);
            list_of_carbon_sensors.add(COD);
            input.nextLine();
        }

        for(int i = 1; i < 3; i++){ // 2 smoke sensor
            System.out.println("Enter location for smoke sensor number " + i +":");
            String smoke_sensor = input.next();
            smokeAlarm = new SmokeAlarm(smoke_sensor);
            list_of_smoke_sensors.add(smokeAlarm);
            input.nextLine();
        }

        for(int i = 1; i < 9; i++){ // 8 window sensor
            System.out.println("Enter location for window sensor number " + i +":");
            String window_sensor = input.next();
            windowSensor = new WindowDoorSensor(window_sensor);
            list_of_doorOrwindow_sensors.add(windowSensor);
            input.nextLine();
        }

        for(int i = 1; i < 5; i++){ // 4 door sensor
            System.out.println("Enter location for door sensor number " + i +":");
            String door_sensor = input.next();
            doorSensor = new WindowDoorSensor(door_sensor);
            list_of_doorOrwindow_sensors.add(doorSensor);
            input.nextLine();
        }

        for(int i = 1; i < 4; i++){ // 3 motion sensor
            System.out.println("Enter location for motion sensor number " + i +":");
            String motion_sensor = input.next();
            motion = new MotionSensor(motion_sensor);
            list_of_motion_sensors.add(motion);
            input.nextLine();
        }


    }
    /**
     * Testing instantiation of Home_Alarm
     * Entered dummy values for creating CODetector in constructor.
     * -- For future you will need to enter these manually upon setup
     *  
     * */


    public static void main(String[] args) {

        new Home_Alarm("LivingRoom","FrontDoor","LivingRoom","Bedroom","Kitchen");







    }


}