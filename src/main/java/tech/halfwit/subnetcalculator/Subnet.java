package tech.halfwit.subnetcalculator;

import java.nio.ByteBuffer;

public class Subnet {
    private String name;
    private int cidr;
    private long hosts;

    private int subnetClass;
    private int subnetMaskHost;

    private int subnetMaskNet;

    private NetAddress subnetMask;
    private NetAddress networkAddr;
    private NetAddress firstUsableAddr;
    private NetAddress lastUsableAddr;
    private NetAddress broadcastAddr;

    public Subnet(String name, NetAddress networkAddr, int cidr) {
        this.name = name;
        this.networkAddr = networkAddr;
        this.cidr = cidr;
        subnetMaskNet = (0xFFFFFFFF << (32 -cidr));
        subnetMask = new NetAddress(ByteBuffer.allocate(4).putInt(subnetMaskNet).array());
        subnetMaskHost = (0xFFFFFFFF >>> cidr);
        hosts = subnetMaskHost + 1;
        this.calculate();
        /*
        byte[] firstAddr = networkAddr.getByteAddress();
        byte[] lastAddr = networkAddr.getByteAddress();
        byte[] broadAddr = networkAddr.getByteAddress();

        long lastOctet = (firstAddr[3] & 0xFF) + 1L;
        firstAddr[3] = (byte) lastOctet;
        firstUsableAddr = new NetAddress(firstAddr);

        lastOctet = (broadAddr[3] & 0xFF) + (long)hosts;
        broadAddr[3] = (byte) lastOctet;
        broadcastAddr = new NetAddress(broadAddr);

        lastOctet -= 1;
        lastAddr[3] = (byte) lastOctet;
        lastUsableAddr = new NetAddress(lastAddr);

        System.out.println("Network: " + this.networkAddr);
        System.out.println("First usable: " + firstUsableAddr);
        System.out.println("Last usable: " + lastUsableAddr);
        System.out.println("Broadcast: " + broadcastAddr);
         */
    }

    public Subnet(String name, NetAddress networkAddr, NetAddress subnetMask) {

    }

    private void calculate() {
        int networkAddress = ByteBuffer.wrap(networkAddr.getByteAddress()).getInt();
        long hostPortion = networkAddress & subnetMaskHost;
        long netPortion = networkAddress & subnetMaskNet;
        firstUsableAddr = new NetAddress((int)(netPortion | (hostPortion + 1)));
        broadcastAddr = new NetAddress((int)(netPortion | (hostPortion + subnetMaskHost)));
        lastUsableAddr = new NetAddress((int)(netPortion | (hostPortion + subnetMaskHost - 1)));
        System.out.println("Network: " + this.networkAddr);
        System.out.println("First usable: " + firstUsableAddr);
        System.out.println("Last usable: " + lastUsableAddr);
        System.out.println("Broadcast: " + broadcastAddr);
    }
}
