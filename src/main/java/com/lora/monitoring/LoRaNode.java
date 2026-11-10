
package com.lora.monitoring;

public class LoRaNode {

    private String nodeId;
    private double rssi;
    private double snr;
    private int transmittedPackets;
    private int receivedPackets;

    public LoRaNode(String nodeId, double rssi, double snr,
                    int transmittedPackets, int receivedPackets) {
        this.nodeId = nodeId;
        this.rssi = rssi;
        this.snr = snr;
        this.transmittedPackets = transmittedPackets;
        this.receivedPackets = receivedPackets;
    }

    public String getNodeId() {
        return nodeId;
    }

    public double getRssi() {
        return rssi;
    }

    public double getSnr() {
        return snr;
    }

    public int getTransmittedPackets() {
        return transmittedPackets;
    }

    public int getReceivedPackets() {
        return receivedPackets;
    }

    public int getLostPackets() {
        return transmittedPackets - receivedPackets;
    }

    public double getPacketDeliveryPercentage() {
        if (transmittedPackets <= 0) return 0;
        return (receivedPackets * 100.0) / transmittedPackets;
    }
}
