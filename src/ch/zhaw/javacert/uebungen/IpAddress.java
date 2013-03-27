package ch.zhaw.javacert.uebungen;

import java.lang.Integer;import java.lang.String;import java.util.regex.Pattern;

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

    public static boolean isIpAddress(final String input) {
        return isIpv4Address(input) || isIpv6Address(input);
    }

    public static boolean isIpv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    public static boolean isIpv6Address(final String input) {
        return isIpv6StdAddress(input) || isIpv6HexCompressedAddress(input);
    }

    public static boolean isIpv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    public static boolean isIpv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    public static boolean isValidIpAndSubnet(final String ipAddress, final Integer subnet) {
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

    public static int getIpVersion(final String input) {
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

    public static boolean isValidIpv4Subnet(final Integer subnet) {
        if (subnet >= MIN_SUBNET_BITS && subnet <= MAX_SUBNET_BITS_IPV4) {
            return true;
        }
        return false;
    }

    public static boolean isValidIpv6Subnet(final Integer subnet) {
        if (subnet >= MIN_SUBNET_BITS  && subnet <= MAX_SUBNET_BITS_IPV6) {
            return true;
        }
        return false;
    }

}
