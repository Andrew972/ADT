import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*; 

import junit.*;

public class HomeAlarmTest { 
    @Test
    public void InitialValuesTest(){
        Message inputInformation = new Message();
        inputInformation.addContent("package", "studio");
        inputInformation.addContent("Door", "Close");
        inputInformation.addContent("Window", "Close");

        HomeAlarm testObj = new HomeAlarm(inputInformation);

        assertEquals("studio", testObj.getPackageType(),"Should say " + inputInformation.get("package"));
        assertEquals(SysMode.SAFE, testObj.getMode(),"Should say safe");

        Message actual =  testObj.interpertSensorData();
        assertTrue(actual.equals(inputInformation), "Sensors should say closed door and window");
    }

    @Test
    public void DemoUnsuccessfulArm(){
        Message inputInformation = new Message();
        inputInformation.addContent("package", "studio");

        HomeAlarm testObj = new HomeAlarm(inputInformation);
        Message actual = testObj.stimulateUnsuccessfulArm();

        Message expected = new Message();
        expected.addContent("Window", "Open");
        expected.addContent("Door", "Open");

        assertTrue(actual.equals(expected), "Windows or door should be open");
        assertEquals(SysMode.WARNING, testObj.getMode(),"System should be in WARNING mode");
    }

    @Test
    public void DemoSuccessfulArm(){
        Message inputInformation = new Message();
        inputInformation.addContent("package", "studio");

        HomeAlarm testObj = new HomeAlarm(inputInformation);
        Message actual = testObj.stimulateSuccessfulArm();

        Message expected = new Message();
        expected.addContent("Window", "Close");
        expected.addContent("Door", "Close");

        assertTrue(actual.equals(expected), "Windows or door should be close");
        assertEquals(SysMode.ARM, testObj.getMode(),"System should be in ARM mode");
    }
}