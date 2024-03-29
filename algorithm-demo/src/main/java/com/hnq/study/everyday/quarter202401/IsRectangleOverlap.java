package com.hnq.study.everyday.quarter202401;

/**
 * 矩形重叠
 * <p>
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 * <p>
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * <p>
 *
 *
 * 示例 1：
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * <p>
 *
 * 示例 2：
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * <p>
 *
 * 示例 3：
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 * <p>
 *
 * 提示：
 * rect1.length == 4
 * rect2.length == 4
 * -10^9 <= rec1[i], rec2[i] <= 10^9
 * rec1 和 rec2 表示一个面积不为零的有效矩形
 *
 * @author henengqiang
 * @date 2024/2/1
 * @see <a href="https://leetcode.cn/problems/rectangle-overlap/">链接</a>
 */
public class IsRectangleOverlap {

    public static void main(String[] args) {
        IsRectangleOverlap i = new IsRectangleOverlap();
        System.out.println(i.isRectangleOverlap2(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
        System.out.println(i.isRectangleOverlap2(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(i.isRectangleOverlap2(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(i.isRectangleOverlap2(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3}));
    }

    /**
     * 检查位置
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 0ms
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }
        return !(rec1[2] <= rec2[0]     // left
                || rec1[3] <= rec2[1]   // bottom
                || rec1[0] >= rec2[2]   // right
                || rec1[1] >= rec2[3]   // top
        );
    }

    /**
     * 检查区域
     */
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        // 0ms
        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
                && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }

}
