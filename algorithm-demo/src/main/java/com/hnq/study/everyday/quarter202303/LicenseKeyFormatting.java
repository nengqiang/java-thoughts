package com.hnq.study.everyday.quarter202303;

/**
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * <p>
 * 我们想要重新格式化字符串s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。
 * 此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 * <p>
 * 返回 重新格式化的许可密钥 。
 * <p>
 * 
 * 示例 1：
 * 输入：S = "5F3Z-2e-9-w", k = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *     注意，两个额外的破折号需要删掉。
 *
 * <p>
 * 示例 2：
 * 输入：S = "2-5g-3-J", k = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 * <p>
 * 提示:
 * 1 <= s.length <= 10^5
 * s只包含字母、数字和破折号'-'.
 * 1 <= k <= 10^4
 * 
 * @author henengqiang
 * @date 2023/7/14
 * @see <a href="https://leetcode.cn/problems/license-key-formatting">链接</a>
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting l = new LicenseKeyFormatting();
        System.out.println(l.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(l.licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(l.licenseKeyFormatting("aaaa", 2));
        System.out.println(l.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(l.licenseKeyFormatting("2-5g-3-J", 2));

    }

    public String licenseKeyFormatting(String s, int k) {
        // 67ms
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                sb.insert(0, (char) (c - 32));
            } else {
                sb.insert(0, c);
            }
            cnt++;
            if (i > 0 && cnt >= k) {
                sb.insert(0, '-');
                cnt = 0;
            }
        }
        String res = sb.toString();
        return res.startsWith("-") ? res.replaceFirst("-", "") : res;
    }

    public String licenseKeyFormatting2(String s, int k) {
        // 9ms
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }

}
