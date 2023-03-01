package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import java.util.*;

import com.lintcode.common.Interval;

import org.junit.Before;
import org.junit.Test;

public class Code919_MeetingRoomsIITest {
    private Code919_MeetingRoomsII target;
    @Before
    public void setup() {
        this.target = new Code919_MeetingRoomsII();
    }

    @Test
    public void testMinMeetingRooms2() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        int result = target.minMeetingRooms2(intervals);
        assertEquals(2, result);
    }
}
