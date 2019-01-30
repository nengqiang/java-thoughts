package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Problem:
 *  Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals(merge if necessary).
 *
 * Example 1:
 *  Given intervals [1, 3], [6, 9], insert and merge [2, 5] in as [1, 5], [6, 9].
 *
 * Example 2:
 *  Given [1, 2], [3, 5], [6, 7], [8, 10], [12, 16], insert and merge [4, 9] in as [1, 2], [3, 10], [12, 16].
 *
 * This is because the new interval [4, 9] overlap with [3, 5], [6, 7], [8, 10]
 *
 * @author henengqiang
 * @date 2019/01/30
 */
public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals1 = createNoneOverlappingIntervals(2, 10);
        Interval newInterval1 = createNoneOverlappingIntervals(1, 10).get(0);
        print(intervals1, newInterval1);

        List<Interval> intervals2 = createNoneOverlappingIntervals(5, 20);
        Interval newInterval2 = createNoneOverlappingIntervals(1, 20).get(0);
        print(intervals2, newInterval2);
    }

    private static void print(List<Interval> intervals, Interval newInterval) {
        System.out.println(String.format("Before Merge: intervals: %s, newInterval: %s", intervals, newInterval));
        System.out.println(String.format("After Merge by method A: intervals: %s", insert1(intervals, newInterval)));
        System.out.println(String.format("After Merge by method B: intervals: %s", insert2(intervals, newInterval)));
    }

    /*
     * Analysis
     *  Quickly summarize 3 cases. Whenever there is intersection, created a new interval.
     *
     *                      |---Current---|
     * case1    |---New---|
     * case2                                |---New---|
     * case3                            |---New---|
     *                  |---New---|
     *                          |--New--|
     *                  |----------New------------|
     * ————————————————————————————>
     * min                                                max
     */

    static class Interval {
        private int start;
        private int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString() { return "[" + start + ", " + end + "]"; }
    }

    private static List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = Lists.newArrayList();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                // usage: sort, exchange the small and big intervals
                newInterval = interval;
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        result.add(newInterval);
        return result;
    }

    /**
     * Solution 2 - Binary Search
     * If the intervals list is an ArrayList, we can use binary search to make the best time complexity O(n).
     *
     * @param intervals     Given intervals
     * @param newInterval   Interval to be merged
     * @return              Merge result
     */
    private static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = Lists.newArrayList();

        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        int p = helper(intervals, newInterval);
        result.addAll(intervals.subList(0, p));

        for (int i = p; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }

        result.add(newInterval);
        return result;
    }

    private static int helper(List<Interval> intervals, Interval newInterval) {
        int low = 0;
        int high = intervals.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (newInterval.start <= intervals.get(mid).start) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high == 0 ? 0 : high - 1;
    }

    // --------------------------------------------------------------------------------

    private static List<Interval> createNoneOverlappingIntervals(int size, int bound) {
        List<Interval> intervals = new ArrayList<>(size);
        Random random = new Random();
        // size == 1 is special case
        if (size == 1) {
            int start, end;
            do {
                start = random.nextInt(bound);
                // the end is bigger than start
                end = start + Math.max(1, random.nextInt(bound));
                // exclude bound
            } while (end >= bound);
            intervals.add(new Interval(start, end));
        } else {
            // the smallest step must be 1
            int step = Math.max(1, random.nextInt(bound / size));
            int start, end;
            Interval newInterval;
            for (int i = 0; i < size; i++) {
                boolean isOverlapped;
                do {
                    start = random.nextInt(bound - step);
                    end = start + step;
                    newInterval = new Interval(start, end);
                    isOverlapped = checkIsOverlapped(intervals, newInterval);
                } while (isOverlapped);
                intervals.add(newInterval);
            }
            // sort
            intervals.sort(Comparator.comparingInt(o -> o.start));
        }
        return intervals;
    }

    private static boolean checkIsOverlapped(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            boolean isOverlapped = interval.start >= newInterval.start && interval.start <= newInterval.end
                    || interval.end >= newInterval.start && interval.end <= newInterval.end;
            if (isOverlapped) {
                return true;
            }
        }
        return false;
    }
}
