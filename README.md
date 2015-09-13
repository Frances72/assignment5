# RideMate #
*TP2 Project_Frances.Anderson_2015*

## RideMate ##
Ridemate is a system designed to monitor **RFID chip** readings received by a **chip reader** as the chip swipes past the reader.

The **Reader** creates an instance of a Reading which records the following:

- chip number
- reader identification (there will be several)
- time stamp of swipe

A **Ride** is made up of the Readings taken from the start Reader, Readers across the route, upto the finish Reader.
The Ride record stores the ride date, chip owner's name, distance covered and time taken to complete the course.

**Sectors** are the static entities which represent the areas between two consecutive Readers.
In order to create the Sector times (time taken to pass between two consecutive readers) the function must establish which sector the rider has completed and the time taken between the two readers.
This record is stored as an object to be reused throughout the program.

**Displaying** the cyclist's statistics is a class to be called from a User Interface.
The total distance, total ride time and sector times are displayed for the rider once the ride is complete.

The instance of a ride is created when the first reading is created, the end when the reading from the final reader is received.

Thereafter, the ride statistics can be calculated and displayed.

## *RideMade UML Diagram:* ##












![](http://4.bp.blogspot.com/-NubHwVoAUYU/VVipgThflmI/AAAAAAAAAMo/WjmdvrzgPig/s1600/RideMate_UML_Diagram2.jpg)