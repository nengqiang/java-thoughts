package com.hnq.study.everyday;

import com.google.common.collect.Lists;

/**
 * @author henengqiang
 * @date 2023/5/16
 */
public class VersionControl {
    public static boolean isBadVersion(int version) {
        return Lists.newArrayList(4, 5).contains(version);
    }
}
