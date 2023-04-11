package tech.halfwit.subnetcalculator;

import java.nio.ByteBuffer;

public class NetAddress {
    private final byte[] byteAddress;
    private final String address;

    /**
     * Creates a new NetAddress from String
     * @param byteAddress  IPv4 Address as a byte array
     */
    public NetAddress(byte[] byteAddress) {
        this.byteAddress = byteAddress;
        this.address =  (this.byteAddress[0] & 0xFF) + "." + (this.byteAddress[1] & 0xFF) + "." + (this.byteAddress[2] & 0xFF) + "." + (this.byteAddress[3] & 0xFF);
    }

    public NetAddress(int intAddress) {
        this.byteAddress = ByteBuffer.allocate(4).putInt(intAddress).array();
        this.address =  (this.byteAddress[0] & 0xFF) + "." + (this.byteAddress[1] & 0xFF) + "." + (this.byteAddress[2] & 0xFF) + "." + (this.byteAddress[3] & 0xFF);
    }

    public String getAddress() {
        return address;
    }

    public byte[] getByteAddress() {
        return new byte[] {byteAddress[0],byteAddress[1],byteAddress[2],byteAddress[3]};
    }

    @Override
    public String toString() {
        return address;
    }
}
