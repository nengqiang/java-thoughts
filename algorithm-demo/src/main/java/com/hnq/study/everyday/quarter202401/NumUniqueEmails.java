package com.hnq.study.everyday.quarter202401;

import java.util.HashSet;
import java.util.Set;

/**
 * 独特的电子邮件地址
 *
 * @author henengqiang
 * @date 2024/3/21
 * @see <a href="https://leetcode.cn/problems/unique-email-addresses/">链接</a>
 */
public class NumUniqueEmails {

    public static void main(String[] args) {
        NumUniqueEmails n = new NumUniqueEmails();
        String[] em1 = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(n.numUniqueEmails(em1));
        String[] em2 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(n.numUniqueEmails(em2));
    }

    public int numUniqueEmails(String[] emails) {
        // 27ms
        Set<String> addr = new HashSet<>();
        for (String email : emails) {
            String[] tmp = email.split("@");
            String l1 = tmp[0].replaceAll("\\.", "");
            String l2 = l1.substring(0, l1.indexOf("+") > 0 ? l1.indexOf("+") : l1.length());
            addr.add(l2 + "@" + tmp[1]);
        }
        return addr.size();
    }

    public int numUniqueEmails2(String[] emails) {
        // 9ms
        Set<String> emailSet = new HashSet<String>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0]; // 去掉本地名第一个加号之后的部分
            local = local.replace(".", ""); // 去掉本地名中所有的句点
            emailSet.add(local + email.substring(i));
        }
        return emailSet.size();
    }

}
