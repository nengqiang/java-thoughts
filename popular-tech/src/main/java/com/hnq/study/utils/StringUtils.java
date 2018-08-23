package com.hnq.study.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * @author henengqiang
 * @date 2018/8/22
 */
public class StringUtils {

    /**
     * SHA256算法加密（生成电子签名）
     * @param input 输入字符串
     * @return      加密后的字符串
     */
    public static String sha256(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashes = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (Byte hash : hashes) {
                String hex = Integer.toHexString(0xff & hash);
                if (hex.length() == 1) {
                    hexString.append("0");
                } else {
                    hexString.append(hex);
                }
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

}
