# Test Plan Outline for Software Enginerring Project - ADT
## IEEE TEST PLAN TEMPLATE

Table of Contents

* [Test Plan Identifier](#1-test-plan-identifier)
* [References](#2-references) 
* [Introduction](#3-introduction) 
* [Test Items](#4-test-items-functions) 
* [Software Risk Issues](#5-software-risk-issues)
* [Features to be Tested](#6-features-to-be-tested) 
* [Features not to be Tested](#7-features-not-to-be-tested) 
* [Approach](#8-approach) 
	* 8.1 [Test Tools](#18-test-tools)
	* 8.2 [Measures and Metrics](#measures-and-metrics)
* [Item Pass/Fail Criteria](#9-criteria) 
* [Glossary](#10-glossary) 


## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
| Andrew | 4/9/2020 |  document template |    1       |
| Andrew | 4/10/2020 |  911-dispatch and Monitor class tests  |   1      |
| Fatemeh | 4/10/2020 | ClientDB and NewsFeed class tests |    1       |
|         |           |                |           |

## 1. TEST PLAN IDENTIFIER 
HSSP-TPT1.0

## 2. REFERENCES 

* BKJ Home Alarm and Security System Requirements Doc
* Use Case Description SE Proj
* UML Project Design 
* Design Spec Document 

## 3. INTRODUCTION 
This is the master test plan for the Home Security Service Program project. This test will establish the relationships between modules that are affected by internal and external processes. The primary focus is confirming the communication between all modules, and all modules display the necessary information to the console.

This project will have seven layers of testing: Unit, Storing, accepting, generating, alarming, integration, and authenticating. The details of each will be further explained in the level specific plans of the document.
The estimated time for this project is to be finished by May 7th, giving time for delays in the project.

## 4. TEST ITEMS FUNCTIONS
The following is a list of the items to be tested:

* Home Alarm
* Monitor
* Fire Station
* Police Station
* Hospital
* Dispatch
* News Feed
* Story
* CO Detector
* Client
* Client DB
* Motion Sensor
* Smoke Alarm
* Window/Door Sensor

## 5. SOFTWARE RISK ISSUES

* Platform of the phone that the mobile app will be uploaded to.
* Backup and recovery of user data.
* Database security and access.
* Updated version of phone’s OS.
* Ability to incorporate new and improved tools and modules into downloaded items. 

## 6. FEATURES TO BE TESTED 

* Sign in
* Sign up
* Pick home alarm system
* View news
* Check sensors
* Emergency scenarios
* Seting system to safe or armed
* Monitor retrieving user information

## 7. FEATURES NOT TO BE TESTED 

* Generating of new news for newsfeed

## 8. APPROACH (STRATEGY)
The testing of the home alarm system will be unit, storing, accepting, generating, alarming, integration, and authenticating levels. All of the testing will be done by the project members themselves. 

UNIT testing will be done for each module individually as well as the system as a whole. 

STORING testing will be done when the member signs in. The member’s personal information along with their username and password will be stored in order for them to sign in at a later time. The home alarm system the user has purchased will also be stored, and accessible and linked for later use.  

ACCEPTING testing will be done when the member signs up and signs in. When the member signs up, there must be a way to accept the member’s personal information. When the member  selects their home alarm system, there must be acceptance of their choice.  When the member signs in, there must be a way to accept their username and password.

GENERATING testing will be done when the member selects to view news. A random story is generated and displayed to the user. When the member selects to generate an emergency scenario, ETA’s will be generated from the stations. When the member selects what home alarm system they want to purchase, that system may be generated depending on which option they select. When the member selects to see their sensor status, a random number will be generated and displayed.

ALARMING testing will be done when the sensor generates a number that triggers the alarm. This alarm testing is done either by a request from the member, or a call from the monitor. 

INTEGRATION testing will be done as the member is testing various functionalities of the system. All of the modules are integrated. For example, testing a simulation is the integration between the sensor, home alarm, monitor, dispatch, and the stations. Because of this, all the systems can be tested and the communication can be observed for the system as a whole.

AUTHENTICATING testing will be done at the time of sign in. The member will sign in and be authenticated via username and password.   

### 8.1 Test Tools
The only test tools that will be used is Junit.

### 8.2 Measures and Metrics
Information will be gathered during all levels of testing and the module defects will be determined by the project team members.

## 9 ITEM PASS/FAIL CRITERIA
The test process will be complete once all the modules are tested individually as well as in the system, and there are no errors. At this point, the GUI process will commence.  

## 10 TEST DELIVERABLES 

* Test plan
* Test cases
* Unit test plans
* Storing test plans
* Accepting test plans
* Generating test plans
* Alarming test plans
* Integration test plans
* Authenticating test plans

## 11 GLOSSARY 
ETA - Estimated Time of Arrival 

