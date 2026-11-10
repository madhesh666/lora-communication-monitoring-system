
package com.lora.monitoring;

import java.util.Scanner;

public class LoRaApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LoRaMonitor monitor = new LoRaMonitor();

        System.out.println("==================================");
        System.out.println("  LoRa COMMUNICATION MONITORING");
        System.out.println("==================================");

        System.out.print("Enter Node ID: ");
        String nodeId = scanner.nextLine();

        System.out.print("Enter RSSI (dBm): ");
        double rssi = scanner.nextDouble();

        System.out.print("Enter SNR (dB): ");
        double snr = scanner.nextDouble();

        System.out.print("Enter Transmitted Packets: ");
        int transmitted = scanner.nextInt();

        System.out.print("Enter Received Packets: ");
        int received = scanner.nextInt();

        if (transmitted <= 0 || received < 0
                || received > transmitted) {
            System.out.println("Invalid packet values!");
            scanner.close();
            return;
        }

        LoRaNode node = new LoRaNode(
            nodeId, rssi, snr, transmitted, received
        );

        monitor.displayNode(node);

        scanner.close();
    }
}
