package com.hnq.study.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author henengqiang
 * @date 2018/8/25
 */
public class GetIp {

    public static void main(String[] args) {
        try {
            InetAddress myAddress = InetAddress.getLocalHost();
            System.out.println("MyName: " + myAddress.getHostName());
            System.out.println("IpAddress: " + Arrays.toString(myAddress.getAddress()));
            System.out.println("IpAddress: " + myAddress.getHostAddress());
            System.out.println("IpAddress: " + myAddress.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
