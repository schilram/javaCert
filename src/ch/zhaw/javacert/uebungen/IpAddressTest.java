package ch.zhaw.javacert.uebungen;

/**
 * @author rschilling
 */
public class IpAddressTest {
    public static void main(final String args[]) {
        String ip1 = "10.10.10.0";
        String ip2 = "10.10.10.2";
        String ip3 = "10.10.10.255";
        int sn1 = 24;

        long lip1 = IpAddress.numericIpv4AddressToLong(ip1);

        long l = IpAddress.subnetBitsToLongBitmask(sn1);

        boolean b1a = IpAddress.isIpv4AddrNetworkAddr(ip1, sn1);
        boolean b1b = IpAddress.isIpv4AddrBroadcastAddr(ip1, sn1);
        boolean b2a = IpAddress.isIpv4AddrNetworkAddr(ip2, sn1);
        boolean b2b = IpAddress.isIpv4AddrBroadcastAddr(ip2, sn1);
        boolean b3a = IpAddress.isIpv4AddrNetworkAddr(ip3, sn1);
        boolean b3b = IpAddress.isIpv4AddrBroadcastAddr(ip3, sn1);

        boolean b = IpAddress.areIpv4AddrInSameSubnet(ip1, ip2, sn1);



    }
}
