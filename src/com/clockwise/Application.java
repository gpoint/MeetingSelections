/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.clockwise;

import com.clockwise.meeting.TimeSlotCluster;
import java.util.List;

/**
 *
 * @author king
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // TODO test the code
        Integer[][] meetings = {{71, 61, 26}, {72, 75, 76}, {73, 54, 64, 10, 68}, {88, 56, 69}, {71, 17, 8}, {18}, {40, 17, 66, 47, 13}, {40, 62, 52, 88}, {11, 79, 36, 58, 15}, {17, 67}, {33}, {38}, {3, 4, 5, 55, 59, 60, 61, 82, 18, 85, 26, 48, 50}, {17, 84}, {74, 83, 43}, {71, 89, 27}, {11, 79, 46, 58}, {34, 33}, {71, 75, 35}, {66, 14}, {72, 33}, {75, 76}, {19, 77, 27}, {40, 72, 75, 44, 7, 35, 20}, {18, 34}, {71, 17, 33, 67}, {29, 86, 65, 78, 87, 22, 23, 47, 16, 28}, {38, 37, 27}, {30, 18, 6, 52, 85, 55}, {79, 28, 58}, {17, 88, 69}, {76, 23}, {39, 32, 75}, {29, 86, 65, 78, 87, 22, 47, 23, 16, 28}, {11, 79, 58}, {21, 88, 51}, {38}, {61, 88}, {3, 18}, {39, 0, 24, 23}, {33, 70}, {42, 75, 7, 35, 20, 37, 80}, {38, 1, 49}, {31, 12, 88}, {39, 40, 43}, {33, 56}, {33, 25}, {33}, {2, 56}, {52, 85}, {52, 9, 45, 57}, {53, 33}, {66, 27}, {63, 88}, {81, 41, 42, 7, 20}};

        List<Integer[]> selectedMeetings = TimeSlotCluster.selectMeetings(meetings);

        selectedMeetings.forEach((meeting) -> {
            System.out.print("[");
            for (Integer attendee : meeting) {
                System.out.print(attendee + ",");
            }
            System.out.println("]");
        });

    }

}
