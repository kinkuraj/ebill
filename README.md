# ebill
Electricity bill calculator.

MyEB@Home
- The objective here is to demonstrate an EB charge calculator
for a typical home with many electrical appliances. (Device)
The classes involved is listed below.
1) Device : Base class which contains the attributes
- state ---> ON/OFF
- watts ---> The electrical wattage of the device.
- A function setState() to set ON or OFF
- A function getState() to return the current state.
2) Home : class that holds a list of Rooms.
3) Room : base class that holds a list of Devices.
- All the below classes are minimally required.
- Other classes can be demonstrated as well.
Class Kitchen inherits Room
Class Hall inherits Room
Class Bedroom inherits Room
Class Toilet inherits Room
Class StudyRoom inherits Room
4) Other classes for a wide variety of electrical
appliances seen in a typical home.
- All the below classes are minimally required.
- Other classes can be demonstrated as well.
Class Fan inherits Device
Class Bulb inherits Device
Class TubeLight inherits Device
Class TV inherits Device
Class Fridge inherits Device
Class Mixie inherits Device
Class Oven inherits Device
Class WaterHeater inherits Device
5) All Devices can be turned ON at any time
and remain in that state until it is turned OFF
and vice-versa.Except Fridge and WaterHeater which have automatic cut-off.
That is, if they are turned ON for X minutes continuously,
they will get turned OFF automatically.
- Note: Here 'X' is settable.
6) Class Device maintains how long it has been in ON state
and also provides functions as below
- getUsage() : returns total minutes it was in ON state.
- getWattage() : returns the device's stipulated wattage.
7) Use of Threads/Timers to simulate Electricity usage.
8) Use of Random to add randomness in behavior to simulate
real time electricity usage of the home.
9) Class Tariff : maintains the tariff for electricity
consumption based on kwH (unit)
eg. Rs.6/kwH and if a home consumes
totally 100 kwH (or 100 units) then the
bill will be Rs.600/-
- provides a convenient API getBill(X units)
which calculates the amount of the bill appropriately.
10) Class Home should have a function generateReport()
which shows a formatted usage and cost for all Rooms.
eg.
Hall:
Total consumption : 20 units
Total cost : Rs. 120/-
Kitchen:
Total consumption : 50 units
Total cost : Rs. 300/-
...
11) Home is the main class and can be used for User interaction
as well,
eg. It can list out the rooms and given the
option for user to turn ON/OFF
a particular device in a particular room.
Note : This is in addition to the random simulation
as mentioned above.
A simple textual UI can be employed.
Java Swing GUI with creativity will be credited higher.
- Objective is to see efficient class structure/design
- constructors, functions semantics, inheritance
function overriding and proper use of logical operators
- utilized Threads/Timers properly.
