package com.hnq.study.everyday.quarter202303;

/**
 * 递枕头
 * <p>
 * n 个人站成一排，按从 1 到 n 编号。
 * <p>
 * 最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。
 * 一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
 * <p>
 * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
 * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
 * <p>
 *
 * 示例 1：
 * 输入：n = 4, time = 5
 * 输出：2
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
 * 5 秒后，枕头传递到第 2 个人手中。
 * <p>
 *
 * 示例 2：
 * 输入：n = 3, time = 2
 * 输出：3
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 。
 * 2 秒后，枕头传递到第 3 个人手中。
 * <p>
 *
 * 提示：
 * 2 <= n <= 1000
 * 1 <= time <= 1000
 *
 * @author henengqiang
 * @date 2023/9/26
 * @see <a href="https://leetcode.cn/problems/pass-the-pillow/?envType=daily-question&envId=2023-09-26">链接</a>
 */
public class PassThePillow {

    public static void main(String[] args) {
        PassThePillow p = new PassThePillow();
        System.out.println(p.passThePillow2(4, 8));
        System.out.println(p.passThePillow2(18, 38));
        System.out.println(p.passThePillow2(4, 2));
        System.out.println(p.passThePillow2(2, 1));
        System.out.println(p.passThePillow2(2, 2));
        System.out.println(p.passThePillow2(4, 3));
        System.out.println(p.passThePillow2(4, 6));
        System.out.println(p.passThePillow2(4, 5));
        System.out.println(p.passThePillow2(3, 2));
    }

    public int passThePillow(int n, int time) {
        // 0ms
        if (time < n) {
            return time + 1;
        }
        if (n == 2) {
            return time % 2 == 0 ? 1 : 2;
        }

        int k = n - 1;
        int p = time / k, q = time % k;
        if (q == 0) {
            return p % 2 == 0 ? 1 : n;
        } else {
            return (p + 1) % 2 == 0 ? n - q : q + 1;
        }
    }

    /**
     * 我们注意到每经过 2 x (n - 1) 的时间，枕头会被传递回起点，所以我们可以直接用 time 对 2 x (n - 1) 取模求余数。
     *
     * 如果 time < n，枕头没有传递到队尾，传递到 time + 1 。
     * 如果 time ≥ n，枕头已经传递过队尾，传递到 n − (time − (n − 1)) = n × 2 − time − 1 。
     */
    public int passThePillow2(int n, int time) {
        // 0ms
        time %= (n - 1) * 2;
        return time < n ? time + 1 : n * 2 - time - 1;
    }

}
