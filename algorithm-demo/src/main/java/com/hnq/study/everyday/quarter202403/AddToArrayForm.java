package com.hnq.study.everyday.quarter202403;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author henengqiang
 * @date 2024/9/30
 */
public class AddToArrayForm {

    public static void main(String[] args) {
        AddToArrayForm a = new AddToArrayForm();
        int[] a1 = {1, 2, 0, 0};
        System.out.println(a.addToArrayForm(a1, 34));
        int[] a2 = {2, 7, 4};
        System.out.println(a.addToArrayForm(a2, 181));
        int[] a3 = {2, 1, 5};
        System.out.println(a.addToArrayForm(a3, 806));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int len = num.length;
        int x = 0;
        if (len <= 6) {
            for (int j : num) {
                x *= 10;
                x += j;
            }
            int tmp = x + k;
            while (tmp > 0) {
                ans.add(0, tmp % 10);
                tmp /= 10;
            }
        } else {
            for (int i = len - 6; i < len; i++) {
                x *= 10;
                x += num[i];
            }
            int tmp = x + k;
            while (tmp > 0) {
                ans.add(0, tmp % 10);
                tmp /= 10;
            }
            for (int i = len - 6 - 1; i > 0; i--) {
                ans.add(0, num[i]);
            }
        }
        return ans;
    }

    /**
     * 逐位相加
     */
    public List<Integer> addToArrayForm2(int[] num, int k) {
        // 4ms
        List<Integer> ans = new ArrayList<>();
        int n = num.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum >= 10) {
                k++;
                sum -= 10;
            }
            ans.add(sum);
        }
        for(; k > 0; k /= 10) {
            ans.add(k % 10);
        }
        Collections.reverse(ans);
        return ans;
    }

}
