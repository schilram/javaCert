package ch.zhaw.javacert.uebungen;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * @author rschilling
 */
public class IpAddress {

    private static final Integer MIN_SUBNET_BITS = 0;
    private static final Integer MAX_SUBNET_BITS_IPV4 = 32;
    private static final Integer MAX_SUBNET_BITS_IPV6 = 64;

    private static final Integer IP_V4 = 4;
    private static final Integer IP_V6 = 6;

    private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])(\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])){3}$");

    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static final boolean isIpAddress(final String input) {
        return isIpv4Address(input) || isIpv6Address(input);
    }

    public static final boolean isIpv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    public static final boolean isIpv6Address(final String input) {
        return isIpv6StdAddress(input) || isIpv6HexCompressedAddress(input);
    }

    public static final boolean isIpv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    public static final boolean isIpv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    public static final boolean isValidIpAndSubnet(final String ipAddress, final Integer subnet) {
        if (subnet == null) {
            return false;
        }

        final int ipVersion = getIpVersion(ipAddress);

        if (ipVersion == IP_V4) {
            return isValidIpv4Subnet(subnet);
        } else if (ipVersion == IP_V6) {
            return isValidIpv6Subnet(subnet);
        }
        return false;
    }

    public static final int getIpVersion(final String input) {
        if (input == null) {
            return -1;
        }
        if (isIpv4Address(input)) {
            return IP_V4;
        }
        if (isIpv6Address(input)) {
            return IP_V6;
        } else {
            return -1;
        }
    }

    public static final boolean isValidIpv4Subnet(final Integer subnet) {
        if (subnet >= MIN_SUBNET_BITS && subnet <= MAX_SUBNET_BITS_IPV4) {
            return true;
        }
        return false;
    }

    public static final boolean isValidIpv6Subnet(final Integer subnet) {
        if (subnet >= MIN_SUBNET_BITS  && subnet <= MAX_SUBNET_BITS_IPV6) {
            return true;
        }
        return false;
    }

    /**
     * returns the integer value of a numeric IPv4 TCP/IP address
     *
     * @param ipAddress String
     * @return int
     */
    public static final long numericIpv4AddressToLong(final String ipAddress) {

        //  Check if the string is valid IP V4 Address
        if (!isIpv4Address(ipAddress)) {
            return -1;
        }

        final StringTokenizer tokens = new StringTokenizer(ipAddress, ".");
        long ipInt = 0;

        while (tokens.hasMoreTokens()) {
            // Get the current token and convert to an integer value
            final String token = tokens.nextToken();
            final int tokenValue = Integer.valueOf(token).intValue();
            //  Add to the integer address
            ipInt = (ipInt << 8) + tokenValue;
        }

        //  Return the integer value of the IPv4 address
        return ipInt;
    }

    /**
     * returns the integer value of a subentmask given as number of bits ((2^subnetmask) -1)
     * eg.: 1->1, 2->3, 3->7, 4->15, 5->31, ..., 24->16777215, ...
     *
     * @param subnetmaskBits int
     * @return Long
     */
    public static final long subnetBitsToLongBitmask(final int subnetmaskBits) {

        long LongSubnetmask = 0;

        for (int i = 0; i < subnetmaskBits; i++) {
            LongSubnetmask = (LongSubnetmask << 1) + 1;
        }
        for (int i = subnetmaskBits; i < 32; i++) {
            LongSubnetmask = (LongSubnetmask << 1) + 0;
        }

        return LongSubnetmask;
    }

    /**
     * returns TRUE if the given IP Address with the Subnetmask is a Network Address
     *
     * @param ipAddress
     * @param subnetmask
     * @return true if its a Network Address
     */
    public static final Boolean isIpv4AddrNetworkAddr(final String ipAddress, final int subnetmask) {

        final long ip = IpAddress.numericIpv4AddressToLong(ipAddress);
        final long sn = IpAddress.subnetBitsToLongBitmask(subnetmask);

        final String ipBinaryString = Long.toBinaryString(ip);

        String zeros = "";
        for (int i = 0; i < Long.numberOfTrailingZeros(sn); i++) {
            zeros = zeros + 0;
        }

        if (ipBinaryString.endsWith(zeros)) {
            return true;
        }

        return false;

    }

    /**
     * returns TRUE if the given IP Address with the Subnetmask is a Broadcast Address
     *
     * @param ipAddress
     * @param subnetmask
     * @return true if its a Broadcast Address
     */
    public static final Boolean isIpv4AddrBroadcastAddr(final String ipAddress, final int subnetmask) {

        final long ip = IpAddress.numericIpv4AddressToLong(ipAddress);
        final long sn = IpAddress.subnetBitsToLongBitmask(subnetmask);

        final String ipBinaryString = Long.toBinaryString(ip);

        String ones = "";
        for (int i = 0; i < Long.numberOfTrailingZeros(sn); i++) {
            ones = ones + 1;
        }

        if (ipBinaryString.endsWith(ones)) {
            return true;
        }

        return false;

    }

    /**
     * Checks if two IP Addresses with a given subnet mask are in the same subnet
     *
     * @param ipAddress1
     * @param ipAddress2
     * @param subnetmask
     * @return true if both ip addresses are in the same subnet
     */
    public static final Boolean areIpv4AddrInSameSubnet(final String ipAddress1, final String ipAddress2, final int subnetmask) {

        final String ip1 = Long.toBinaryString(IpAddress.numericIpv4AddressToLong(ipAddress1));
        final String ip2 = Long.toBinaryString(IpAddress.numericIpv4AddressToLong(ipAddress2));

        final long sn = IpAddress.subnetBitsToLongBitmask(subnetmask);

        final int subnetZeros = Long.numberOfTrailingZeros(sn);

        final String ip1NetworkPart = ip1.substring(0, ip1.length() - subnetZeros);
        final String ip2NetworkPart = ip2.substring(0, ip2.length() - subnetZeros);

        if (ip1NetworkPart.equals(ip2NetworkPart)) {
            return true;
        }

        return false;
    }
}
