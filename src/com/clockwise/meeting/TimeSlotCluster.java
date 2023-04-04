/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clockwise.meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author king
 */
public class TimeSlotCluster {

    public static MeetingMeta getMeetingMeta(Integer[] meeting, Integer[][] meetings) {

        Set<Integer> setOfAttendees = new HashSet<>();

        setOfAttendees.addAll(Arrays.asList(meeting));

        List<Integer> indexesOfMeetingsWithNoMemebersInvolved = new ArrayList<>();

        for (int i = 0; i < meetings.length; i++) {
            Integer[] otherMeeting = meetings[i];

            if (Arrays.equals(otherMeeting, meeting)) {
                continue;
            }
            boolean duplicateIndexExists = false;

            Set checkSet = new HashSet<>();

            checkSet.addAll(setOfAttendees);

            for (Integer attendee : otherMeeting) {

                boolean duplicateIndex = checkSet.add(attendee);

                if (!duplicateIndex) {
                    duplicateIndexExists = true;
                    continue;
                }
            }

            if (!duplicateIndexExists) {
                indexesOfMeetingsWithNoMemebersInvolved.add(i);
            } else {
                setOfAttendees = checkSet;
            }
        }

        MeetingMeta meetingMeta = new MeetingMeta(setOfAttendees.size(), indexesOfMeetingsWithNoMemebersInvolved);

        return meetingMeta;
    }

    public static List<Integer[]> selectMeetings(Integer[][] meetings) {
        for (Integer[] meeting : meetings) {
            Arrays.sort(meeting);
        }

        Integer maxAttendees = 0;

        MeetingMeta meetingMeta = new MeetingMeta();

        Integer index = -1;

        for (int i = 0; i < meetings.length; i++) {
            MeetingMeta meetingMeta1 = getMeetingMeta(meetings[i], meetings);

            if (meetingMeta1.getTotalAttendees() > maxAttendees) {
                maxAttendees = meetingMeta1.getTotalAttendees();

                meetingMeta = meetingMeta1;

                index = i;
            }
        }

        List<Integer[]> selectedMeetings = new ArrayList<>();

        selectedMeetings.add(meetings[index]);

        meetingMeta.getIndexesOfMeetingsWithNoMemebersInvolved().forEach((i) -> selectedMeetings.add(meetings[i]));

        return selectedMeetings;
    }

    private static class MeetingMeta {

        private final Integer totalAttendees;
        private final List<Integer> indexesOfMeetingsWithNoMemebersInvolved;

        public Integer getTotalAttendees() {
            return totalAttendees;
        }

        public List<Integer> getIndexesOfMeetingsWithNoMemebersInvolved() {
            return indexesOfMeetingsWithNoMemebersInvolved;
        }

        protected MeetingMeta() {
            this.totalAttendees = 0;
            this.indexesOfMeetingsWithNoMemebersInvolved = new ArrayList<>();
        }

        public MeetingMeta(Integer totalAttendees, List<Integer> indexesOfMeetingsWithNoMemebersInvolved) {
            this.totalAttendees = totalAttendees;
            this.indexesOfMeetingsWithNoMemebersInvolved = indexesOfMeetingsWithNoMemebersInvolved;
        }

    }
}
