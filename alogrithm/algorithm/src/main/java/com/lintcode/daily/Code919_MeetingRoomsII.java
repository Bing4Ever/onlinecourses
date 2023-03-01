package com.lintcode.daily;

import java.util.*;

import com.lintcode.common.Interval;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.)
 * <p>https://www.lintcode.com/problem/919/</p>
 */
public class Code919_MeetingRoomsII {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        if (intervals.size() == 1) {
            return 1;
        }

        Collections.sort(intervals, (a,b) -> (a.start - b.start));

        List<Interval> list = new ArrayList<>(); 
        for (Interval interval: intervals) {
            if (list.isEmpty()) {
                list.add(interval);   
            } else {
                for (Interval e : list) {
                    if (interval.start >= e.end) {
                        e.end = interval.end; 
                        interval.start = e.start;
                        list.remove(e);
                        break;
                    }
                }
                list.add(interval);                 
            }            
        }
        return list.size();
    }

    public int minMeetingRooms2(List<Interval> intervals) {
        int[] num = new int[1010100];
        int max = 0;
        for (Interval interval: intervals) {
            num[interval.start]+=1;
            num[interval.end]-=1;
            max = Math.max(max, interval.end);
        }
        int ans = num[0];
        for( int i=1; i<=max;i++) {
            num[i]+=num[i-1];
            ans =Math.max(ans, num[i]);
        }
        return ans;
    }
}
