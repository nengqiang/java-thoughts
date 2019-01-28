package com.hnq.study.classicquestions;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import sun.jvm.hotspot.utilities.Interval;

import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example, Given [1, 3], [2, 6], [8, 10], [15, 18], return [1, 6], [8, 10], [15, 18]
 *
 * @author henengqiang
 * @date 2019/01/28
 */
public class MergeIntervals {

    private static final List<int[]> LIST =
        Lists.newArrayList(new int[] {1, 3}, new int[] {2, 6}, new int[] {8, 10}, new int[] {15, 18});

    public static void main(String[] args) {
        List<Interval> intervals = Lists.newArrayList();
        for (int[] ints : LIST) {
            Interval interval = new Interval(ints[0], ints[1]);
            intervals.add(interval);
        }
        System.out.println("Before merge: \n" + intervals);
        System.out.println("After merge: ");
        System.out.println(merge(intervals));
    }

    /*
     * The key to solve this problem is defining a Comparator first to sort the array list of intervals.
     */

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = Lists.newArrayList();

        if (CollectionUtils.isEmpty(intervals)) {
            return result;
        }

        intervals.sort((o1, o2) -> {
            if (o1.getLowEndpoint() != o2.getLowEndpoint()) {
                return (Integer)o1.getLowEndpoint() - (Integer)o2.getLowEndpoint();
            } else {
                return (Integer)o1.getHighEndpoint() - (Integer)o2.getHighEndpoint();
            }
        });

        Interval pre = intervals.get(0);
        for (Interval interval : intervals) {
            if ((Integer)interval.getLowEndpoint() > (Integer)pre.getHighEndpoint()) {
                result.add(pre);
                pre = interval;
            } else {
                pre = new Interval(pre.getLowEndpoint(),
                    Math.max((Integer)pre.getHighEndpoint(), (Integer)interval.getHighEndpoint()));
            }
        }
        result.add(pre);
        return result;
    }

}
