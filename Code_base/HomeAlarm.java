package com.company;

import java.util.ArrayList;

public class HomeAlarm {

    int Alarm_System_number;
    Home_Alarm[] Region_list;

    HomeAlarm(){
        Region_list = new Home_Alarm[100];
    }

    void homeAlarm_setup(){
        Home_Alarm test = new Home_Alarm("LivingRoom","FrontDoor","LivingRoom","Bedroom","Kitchen");
    }

    /** loop actions five times: 5 minutes to simulate actionmonitor */
    void homeAlarm_fiveMinuteSimulation(){

    }


    String fire_simulation(String x, int number){
        String Sim_message = Region_list[number].simulation(x);
        Region_list[number].setModeSafe();
        return Sim_message;
    }
    public static void main(String[] args) {


        Home_Alarm test = new Home_Alarm("LivingRoom","FrontDoor","LivingRoom","Bedroom","Kitchen");
//        test.printfilteredList();
//        test.sendStatusLocation();

        /**
         test.monitorMessage(); //returns an arrayList of the filtered list
         test.printfilteredList(); //prints unique list
         */
        System.out.println(test.simulation("Fire")); /** Simulation method*/
        System.out.println("----"+test.getMode());






    }

}
