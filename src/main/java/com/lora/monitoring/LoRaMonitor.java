
package com.lora.monitoring;

public class LoRaMonitor {

    public String classifyLink(LoRaNode node) {

        double rssi = node.getRssi();
        double snr = node.getSnr();
        double pdr = node.getPacketDeliveryPercentage();

        if (rssi >= -90 && snr >= 7 && pdr >= 90) {
            return "GOOD";
        } else if (rssi >= -110 && snr >= 0 && pdr >= 70) {
            return "MODERATE";
        } else {
            return "POOR";
        }
    }

    public String getCommunicationStatus(LoRaNode node) {
        return node.getReceivedPackets() > 0 ? "ACTIVE" : "INACTIVE";
    }

    public void displayNode(LoRaNode node) {

        System.out.println("\n===== LoRa Node Report =====");
        System.out.println("Node ID: " + node.getNodeId());
        System.out.println("RSSI: " + node.getRssi() + " dBm");
        System.out.println("SNR: " + node.getSnr() + " dB");
        System.out.println("Transmitted: " + node.getTransmittedPackets());
        System.out.println("Received: " + node.getReceivedPackets());
        System.out.println("Lost: " + node.getLostPackets());
        System.out.printf("PDR: %.2f%%%n",
                node.getPacketDeliveryPercentage());
        System.out.println("Communication: "
                + getCommunicationStatus(node));
        System.out.println("Link Quality: " + classifyLink(node));
    }
}
