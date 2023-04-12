package tech.halfwit.subnetcalculator;

import java.util.ArrayList;

import static tech.halfwit.subnetcalculator.HelperFunctions.*;

public class SubnetCalculator {
    ArrayList<Subnet> subnets;
    public SubnetCalculator(ArrayList<String> names, ArrayList<Integer> cidrs, byte[] startAddress) {
        subnets = new ArrayList<>();
        subnets.add(new Subnet(names.get(0), new NetAddress(startAddress), cidrs.get(1)));
        for (int i = 1; i < names.size(); i++) {
            subnets.add(new Subnet(names.get(i), subnets.get(i-1).getBroadcastAddr().incrementOne(), cidrs.get(i)));
        }
    }

    public ArrayList<Subnet> getSubnets() {
        return subnets;
    }
}
