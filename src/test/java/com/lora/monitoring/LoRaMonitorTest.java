
package com.lora.monitoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoRaMonitorTest {

    LoRaMonitor monitor = new LoRaMonitor();

    @Test
    void testGoodLink() {
        LoRaNode node =
            new LoRaNode("LORA-01", -75, 10, 100, 98);

        assertEquals("GOOD", monitor.classifyLink(node));
    }

    @Test
    void testModerateLink() {
        LoRaNode node =
            new LoRaNode("LORA-02", -100, 4, 100, 80);

        assertEquals("MODERATE", monitor.classifyLink(node));
    }

    @Test
    void testPoorLink() {
        LoRaNode node =
            new LoRaNode("LORA-03", -120, -3, 100, 55);

        assertEquals("POOR", monitor.classifyLink(node));
    }

    @Test
    void testPacketLoss() {
        LoRaNode node =
            new LoRaNode("LORA-01", -75, 10, 100, 98);

        assertEquals(2, node.getLostPackets());
    }

    @Test
    void testPacketDeliveryRatio() {
        LoRaNode node =
            new LoRaNode("LORA-01", -75, 10, 100, 98);

        assertEquals(98.0,
            node.getPacketDeliveryPercentage(), 0.01);
    }
}
