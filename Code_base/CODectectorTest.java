package com.company;

import static org.junit.jupiter.api.Assertions.*;

class CODectectorTest {

    @org.junit.jupiter.api.Test
    void getStatusLocation() {
        CODectector COD = new CODectector("TestKitchen");
        assertEquals("TestKitchen", COD.getStatusLocation(), "PASS");
    }

    @org.junit.jupiter.api.Test
    protected void checkStatus() {
        CODectector COD = new CODectector("TestLivingroom");
        assertEquals(false, COD.checkStatus(),"EXPECTED");
    }
}