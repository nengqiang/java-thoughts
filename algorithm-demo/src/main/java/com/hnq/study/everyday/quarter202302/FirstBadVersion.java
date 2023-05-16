package com.hnq.study.everyday.quarter202302;

import com.hnq.study.everyday.VersionControl;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 *
 * 示例 1：
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5)-> true
 * 调用 isBadVersion(4)-> true
 * 所以，4 是第一个错误的版本。
 * <p>
 *
 * 示例 2：
 * 输入：n = 1, bad = 1
 * 输出：1
 * <p>
 *
 * 提示：
 * 1 <= bad <= n <= 2^31 - 1
 * <p>
 *
 * @author henengqiang
 * @date 2023/5/16
 * @see <a href="https://leetcode.cn/problems/first-bad-version">链接</a>
 */
public class FirstBadVersion extends VersionControl {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    private static int firstBadVersion(int n) {
        // 16 ms
        if (n == 1) {
            return 1;
        }
        return bad(1, n);
    }

    private static int bad(int start, int end) {
        if (end - start == 1) {
            return isBadVersion(start) ? start : end;
        }
        // 这种求中值避免int溢出
        int p = start + (end - start) / 2;
        if (p <= 0) {
            return p;
        }
        boolean bad = isBadVersion(p);
        if (bad) {
            return bad(start, p);
        }
        return bad(p, end);
    }

    private static int firstBadVersion2(int n) {
        // 14ms
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
