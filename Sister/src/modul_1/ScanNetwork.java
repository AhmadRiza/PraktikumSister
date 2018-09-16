/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_1;

import java.net.InetAddress;

/**
 *
 * @author riza
 */
public class ScanNetwork {

    private static void scanNeighborIP(String localIP, int timeout) {
        int result = 0;
        try {
            String mSubnet = parseSubnet(localIP);
            String currentHost;
            InetAddress curAddress;
            for (int i = 1; i < 256; i++) {
                currentHost = mSubnet + i;
                curAddress = InetAddress.getByName(currentHost);

                if (curAddress.isReachable(timeout)) {
                    System.out.printf("%s is online\n", curAddress);
                    result++;
                }
            }
            System.out.printf("Found %d result \n", result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String parseSubnet(String ip) {
        String[] splitter = ip.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splitter.length - 1; i++) {
            builder.append(splitter[i]).append(".");
        }
        return builder.toString();
    }

    private static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        scanNeighborIP("192.168.71.26", 300);

    }

}
